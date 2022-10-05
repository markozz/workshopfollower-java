package nl.ordina.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import nl.ordina.exceptions.InvalidResponse;
import okhttp3.*;

public class WorkshopFollowerRepository {
    private final String baseurl;
    private final OkHttpClient client = new OkHttpClient();
    private final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ").create();
    public WorkshopFollowerRepository(String baseurl) {
        this.baseurl = baseurl;
    }


    public WorkshopFollower findWorkshopFollower(String id) throws InvalidResponse {
        Request req = new Request.Builder()
                .url(String.format("%s/workshopfollowers/%s", baseurl, id))
                .header("Accept", "application/json")
                .build();
        try(Response res = client.newCall(req).execute()) {
            if(res.code() == 200) {
                ResponseBody body = res.body();
                WorkshopFollower user = gson.fromJson(body.string(), WorkshopFollower.class);
                return user;
            } else {
                throw new InvalidResponse(res.code(), res.body());
            }
        } catch (Exception e) {
            System.err.println("logging error");
            System.err.println(e.getMessage());
        }
        return null;
    }

    public String createWorkshopFollower(WorkshopFollower user) throws InvalidResponse {
        RequestBody body = RequestBody.create(gson.toJson(user), MediaType.get("application/json"));
        Request req = new Request.Builder()
                .url(String.format("%s/workshopfollowers", baseurl))
                .header("Content-Type", "application/json")
                .post(body)
                .build();

        try(Response res = client.newCall(req).execute()) {
            if(res.code() == 201) {
                return res.body().string();
            } else {
                throw new InvalidResponse(res.code(), res.body());
            }
        } catch (Exception e) {
            System.err.println("something went wrong while executing request");
            System.err.println(e.getMessage());
        }
        return null;
    }
}

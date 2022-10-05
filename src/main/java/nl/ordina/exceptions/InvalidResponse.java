package nl.ordina.exceptions;

import okhttp3.ResponseBody;

public class InvalidResponse extends Throwable {
    private final int httpCode;
    private final ResponseBody body;
    public InvalidResponse(int httpCode, ResponseBody body) {
        System.err.println("logging error http code: "+ httpCode);
        this.httpCode = httpCode;
        this.body = body;
    }

    public String getMessage() {
        return "Got HTTP Error: " + httpCode;
    }

    public ResponseBody getBody() {
        return body;
    }

    public int getHttpCode() {
        return httpCode;
    }
}

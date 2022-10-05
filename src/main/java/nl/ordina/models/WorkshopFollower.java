package nl.ordina.models;

import java.util.Date;
import java.util.UUID;

public class WorkshopFollower {

    private final UUID id;
    private final String name;
    private final String email;
    private final Date createdAt;

    public WorkshopFollower(UUID id, String name, String email, Date createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}

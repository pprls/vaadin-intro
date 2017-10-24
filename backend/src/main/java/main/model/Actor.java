package main.model;

import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.TimeBasedGenerator;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;
@Entity
public class Actor {
    @Id
    private UUID id;

    public Actor() {
        TimeBasedGenerator uuidGenerator;
        uuidGenerator = Generators.timeBasedGenerator();

        this.id = uuidGenerator.generate();
    }

    private String username;
    private String password;

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

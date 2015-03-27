package model;

import java.sql.Date;
import java.util.List;

/**
 * Created by shunlin on 3/26/15.
 */
public class Actor {
    private String actorId;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private List<Cast> casts;

    public Actor() {
        super();
    }

    public Actor(String actorId, String firstName, String lastName, Date dateOfBirth) {
        this.actorId = actorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getActorId() {
        return actorId;
    }

    public void setActorId(String actorId) {
        this.actorId = actorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Cast> getCasts() {
        return casts;
    }

    public void setCasts(List<Cast> casts) {
        this.casts = casts;
    }

}

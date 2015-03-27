package dao;

import model.Actor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shunlin on 3/26/15.
 */
public class ActorManager extends Manager {
    public ActorManager() {
        super();
    }

    public void createActor(Actor newActor) {
        String sql = "INSERT INTO Actor (actorId, firstName, lastName, dateOfBirth) VALUES (?, ?, ?, ?)";
        try {
            Connection connection = ds.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, newActor.getActorId());
            statement.setString(2, newActor.getFirstName());
            statement.setString(3, newActor.getLastName());
            statement.setDate(4, newActor.getDateOfBirth());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Actor> readAllActors() {
        List<Actor> actors = new ArrayList<Actor>();
        String sql = "SELECT * from Actor";
        try {
            Connection connection = ds.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet results = statement.executeQuery();
            while(results.next()) {
                Actor actor = new Actor();
                actor.setActorId(results.getString("actorId"));
                actor.setFirstName(results.getString("firstName"));
                actor.setLastName(results.getString("lastName"));
                actor.setDateOfBirth(results.getDate("dateOfBirth"));
                actors.add(actor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actors;
    }

    public Actor readActor(String actorId) {
        Actor actor = new Actor();

        String sql = "SELECT * FROM Actor WHERE actorId = ?";
        try {
            Connection connection = ds.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, actorId);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                actor.setActorId(result.getString("actorId"));
                actor.setFirstName(result.getString("firstName"));
                actor.setLastName(result.getString("lastName"));
                actor.setDateOfBirth(result.getDate("dateOfBirth"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actor;
    }

    public void updateActor(String actorId, Actor actor) {
        String sql = "UPDATE Actor SET firstName = ?, lastName = ?, dateOfBirth = ? where actorId = ?";
        try {
            Connection connection = ds.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, actor.getFirstName());
            statement.setString(2, actor.getLastName());
            statement.setDate(3, actor.getDateOfBirth());
            statement.setString(4, actorId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteActor(String actorId) {
        String sql = "DELETE FROM Actor WHERE actorId = ?";
        try {
            Connection connection = ds.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, actorId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

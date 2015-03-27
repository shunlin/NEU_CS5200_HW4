package dao;

import model.Cast;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shunlin on 3/26/15.
 */
public class CastManager extends Manager {
    public CastManager() {
        super();
    }

    public void createCast(Cast newCast) {
        String sql = "INSERT INTO Cast (characterName, movieId, actorId) VALUES (?, ?, ?)";
        try {
            Connection connection = ds.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, newCast.getCharacterName());
            statement.setString(2, newCast.getMovieId());
            statement.setString(3, newCast.getActorId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Cast> readAllCast() {
        String sql = "SELECT * from Cast";
        List<Cast> casts = new ArrayList<Cast>();
        try {
            Connection connection = ds.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet results = statement.executeQuery();
            while(results.next()) {
                Cast cast = new Cast();
                cast.setCastId(results.getInt("castId"));
                cast.setCharacterName(results.getString("characterName"));
                cast.setMovieId(results.getString("movieId"));
                cast.setActorId(results.getString("actorId"));
                casts.add(cast);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return casts;
    }

    public List<Cast> readAllCastForActor(String actorId) {
        String sql = "SELECT * from Cast WHERE actorId = ?";
        List<Cast> casts = new ArrayList<Cast>();
        try {
            Connection connection = ds.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, actorId);
            ResultSet results = statement.executeQuery();
            while(results.next()) {
                Cast cast = new Cast();
                cast.setCastId(results.getInt("castId"));
                cast.setCharacterName(results.getString("characterName"));
                cast.setMovieId(results.getString("movieId"));
                cast.setActorId(results.getString("actorId"));
                casts.add(cast);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return casts;
    }

    public List<Cast> readAllCastForMovie(String movieId) {
        String sql = "SELECT * from Cast WHERE movieId = ?";
        List<Cast> casts = new ArrayList<Cast>();
        try {
            Connection connection = ds.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, movieId);
            ResultSet results = statement.executeQuery();
            while(results.next()) {
                Cast cast = new Cast();
                cast.setCastId(results.getInt("castId"));
                cast.setCharacterName(results.getString("characterName"));
                cast.setMovieId(results.getString("movieId"));
                cast.setActorId(results.getString("actorId"));
                casts.add(cast);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return casts;
    }

    public Cast readCastForId(int castId) {
        Cast cast = new Cast();

        String sql = "SELECT * FROM Cast WHERE castId = ?";
        try {
            Connection connection = ds.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, castId);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                cast.setCastId(result.getInt("castId"));
                cast.setCharacterName(result.getString("characterName"));
                cast.setMovieId(result.getString("movieId"));
                cast.setActorId(result.getString("actorId"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cast;
    }

    public void updateCast(int castId, Cast newCast) {
        String sql = "UPDATE Cast SET characterName = ?, movieId = ?, actorId = ? where castId = ?";
        try {
            Connection connection = ds.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, newCast.getCharacterName());
            statement.setString(2, newCast.getMovieId());
            statement.setString(3, newCast.getActorId());
            statement.setInt(4, castId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCast(int castId) {
        String sql = "DELETE FROM Cast WHERE castId = ?";
        try {
            Connection connection = ds.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, castId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main (String[] args) {
        CastManager cm = new CastManager();
        Cast cast = new Cast(-1, "John", "C4", "A1");

    }
}

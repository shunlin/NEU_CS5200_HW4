package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Movie;

/**
 * Created by shunlin on 3/26/15.
 */
public class MovieManager extends Manager{

    public MovieManager() {
        super();
    }

    public void createMovie(Movie newMovie) {
        String sql = "INSERT INTO Movie (movieId, title, posterImage, releaseDate) VALUES (?, ?, ?, ?)";
        try {
            Connection connection = ds.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, newMovie.getMovieId());
            statement.setString(2, newMovie.getTitle());
            statement.setString(3, newMovie.getPosterImage());
            statement.setDate(4, newMovie.getReleaseDate());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Movie> readAllMovies() {
        List<Movie> movies = new ArrayList<Movie>();
        String sql = "SELECT * from Movie";
        try {
            Connection connection = ds.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet results = statement.executeQuery();
            while(results.next()) {
                Movie movie = new Movie();
                movie.setMovieId(results.getString("movieId"));
                movie.setTitle(results.getString("title"));
                movie.setPosterImage(results.getString("posterImage"));
                movie.setReleaseDate(results.getDate("releaseDate"));
                movies.add(movie);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return movies;
    }

    public Movie readMovie(String movieId) {
        Movie movie = new Movie();

        String sql = "SELECT * FROM Movie WHERE movieId = ?";
        try {
            Connection connection = ds.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, movieId);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                movie.setMovieId(result.getString("movieId"));
                movie.setTitle(result.getString("title"));
                movie.setPosterImage(result.getString("posterImage"));
                movie.setReleaseDate(result.getDate("releaseDate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movie;
    }

    public void updateMovie(String movieId, Movie movie) {
        String sql = "UPDATE Movie SET title = ?, posterImage = ?, releaseDate = ? where movieId = ?";
        try {
            Connection connection = ds.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, movie.getTitle());
            statement.setString(2, movie.getPosterImage());
            statement.setDate(3, movie.getReleaseDate());
            statement.setString(4, movieId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMovie(String movieId) {
        String sql = "DELETE FROM Movie WHERE movieId = ?";
        try {
            Connection connection = ds.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, movieId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

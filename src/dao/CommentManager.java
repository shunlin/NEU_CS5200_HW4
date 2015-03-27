package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Comment;

/**
 * Created by shunlin on 3/26/15.
 */
public class CommentManager extends Manager {
    public CommentManager() {
        super();
    }

    public void createComment(Comment newComment) {
        String sql = "INSERT INTO Comment (comment, date, username, movieId) VALUES (?, ?, ?, ?)";
        try {
            Connection connection = ds.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, newComment.getComment());
            statement.setDate(2, newComment.getDate());
            statement.setString(3, newComment.getUsername());
            statement.setString(4, newComment.getMovieId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Comment> readAllComments() {
        String sql = "SELECT * from Comment";
        List<Comment> comments = new ArrayList<Comment>();
        try {
            Connection connection = ds.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet results = statement.executeQuery();
            while(results.next()) {
                Comment comment = new Comment();
                comment.setCommentId(results.getInt("commentId"));
                comment.setComment(results.getString("comment"));
                comment.setDate(results.getDate("date"));
                comment.setUsername(results.getString("username"));
                comment.setMovieId(results.getString("movieId"));
                comments.add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }

    public List<Comment> readAllCommentsForUsername(String username) {
        String sql = "SELECT * from Comment WHERE username = ?";
        List<Comment> comments = new ArrayList<Comment>();
        try {
            Connection connection = ds.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet results = statement.executeQuery();
            while(results.next()) {
                Comment comment = new Comment();
                comment.setCommentId(results.getInt("commentId"));
                comment.setComment(results.getString("comment"));
                comment.setDate(results.getDate("date"));
                comment.setUsername(results.getString("username"));
                comment.setMovieId(results.getString("movieId"));
                comments.add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }

    public List<Comment> readAllCommentsForMovie(String movieId) {
        String sql = "SELECT * from Comment WHERE movieId = ?";
        List<Comment> comments = new ArrayList<Comment>();
        try {
            Connection connection = ds.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, movieId);
            ResultSet results = statement.executeQuery();
            while(results.next()) {
                Comment comment = new Comment();
                comment.setCommentId(results.getInt("commentId"));
                comment.setComment(results.getString("comment"));
                comment.setDate(results.getDate("date"));
                comment.setUsername(results.getString("username"));
                comment.setMovieId(results.getString("movieId"));
                comments.add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }

    public Comment readCommentForId(int commentId) {
        Comment comment = new Comment();

        String sql = "SELECT * FROM Comment WHERE commentId = ?";
        try {
            Connection connection = ds.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, commentId);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                comment.setCommentId(result.getInt("commentId"));
                comment.setComment(result.getString("comment"));
                comment.setDate(result.getDate("date"));
                comment.setUsername(result.getString("username"));
                comment.setMovieId(result.getString("movieId"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comment;
    }

    public void updateComment(int commentId, Comment newComment) {
        String sql = "UPDATE Comment SET comment = ?, date = ?, username = ?, movieId = ? where commentId = ?";
        try {
            Connection connection = ds.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, newComment.getComment());
            statement.setDate(2, newComment.getDate());
            statement.setString(3, newComment.getUsername());
            statement.setString(4, newComment.getMovieId());
            statement.setInt(5, commentId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteComment(int commentId) {
        String sql = "DELETE FROM Comment WHERE commentId = ?";
        try {
            Connection connection = ds.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, commentId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

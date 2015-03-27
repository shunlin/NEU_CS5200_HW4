package model;

import java.sql.Date;

/**
 * Created by shunlin on 3/26/15.
 */
public class Comment {
    private int commentId;  // commentId is Integer in database, so the id could be AUTO_INCREMENT.
    private String comment;
    private Date date;
    private String username;
    private String movieId;

    public Comment() {
        super();
    }

    public Comment(int commentId, String comment, Date date, String username, String movieId) {
        this.commentId = commentId;
        this.comment = comment;
        this.date = date;
        this.username = username;
        this.movieId = movieId;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }
}

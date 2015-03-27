package model;

import java.sql.Date;
import java.util.List;

/**
 * Created by shunlin on 3/26/15.
 */
public class Movie {
    private String movieId;
    private String title;
    private String posterImage;
    private Date releaseDate;
    private List<Cast> casts;

    public Movie() {
        super();
    }

    public Movie(String movieId, String title, String posterImage, Date releaseDate) {
        super();
        this.movieId = movieId;
        this.title = title;
        this.posterImage = posterImage;
        this.releaseDate = releaseDate;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosterImage() {
        return posterImage;
    }

    public void setPosterImage(String posterImage) {
        this.posterImage = posterImage;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<Cast> getCasts() {
        return casts;
    }

    public void setCasts(List<Cast> casts) {
        this.casts = casts;
    }
}

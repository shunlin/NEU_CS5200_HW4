package model;

/**
 * Created by shunlin on 3/26/15.
 */
public class Cast {
    private int castId;     // castId is Integer in database, so the id could be AUTO_INCREMENT.
    private String characterName;
    private String movieId;
    private String actorId;

    public Cast() {
        super();
    }

    public Cast(int castId, String characterName, String movieId, String actorId) {
        this.castId = castId;
        this.characterName = characterName;
        this.movieId = movieId;
        this.actorId = actorId;
    }

    public int getCastId() {
        return castId;
    }

    public void setCastId(int castId) {
        this.castId = castId;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getActorId() {
        return actorId;
    }

    public void setActorId(String actorId) {
        this.actorId = actorId;
    }
}

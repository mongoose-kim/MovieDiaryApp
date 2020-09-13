package ddwucom.mobile.finalreport;


import java.io.Serializable;

public class Movie implements Serializable {

    long _id;
    String movieTitle;
    String director;
    String mainActor;
    String genre;
    String nation;

    public Movie(String movieTitle, String director, String mainActor, String genre, String nation) {
        this.movieTitle = movieTitle;
        this.director = director;
        this.mainActor = mainActor;
        this.genre = genre;
        this.nation = nation;
    }

    public Movie(long _id, String movieTitle, String director, String mainActor, String genre, String nation) {
        this._id = _id;
        this.movieTitle = movieTitle;
        this.director = director;
        this.mainActor = mainActor;
        this.genre = genre;
        this.nation = nation;
    }


    public long get_id() {
        return _id;
    }

    public void set_id(long _id) { this._id = _id; }

    public void setAll(String movieTitle, String director, String mainActor, String genre, String nation){
        this.movieTitle = movieTitle;
        this.director = director;
        this.mainActor = mainActor;
        this.genre = genre;
        this.nation = nation;
    }

    public String getMovieTitle() { return movieTitle; }

    public void setMovieTitle(String movieTitle) { this.movieTitle = movieTitle; }

    public String getDirector() { return director; }

    public void setDirector(String director) { this.director = director; }

    public String getMainActor() { return mainActor; }

    public void setMainActor(String mainActor) { this.mainActor = mainActor; }

    public String getGenre() { return genre; }

    public void setGenre(String genre) { this.genre = genre; }

    public String getNation() { return nation; }

    public void setNation(String nation) { this.nation = nation; }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(_id);
        sb.append(".\t\t");
        sb.append(movieTitle);
        sb.append("\t\t\t(");
        sb.append(director);
        sb.append(", ");
        sb.append(mainActor);
        sb.append(", ");
        sb.append(genre);
        sb.append(", ");
        sb.append(nation);
        sb.append(")");
        return sb.toString();
    }
}

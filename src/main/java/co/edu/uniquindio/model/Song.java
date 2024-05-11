package co.edu.uniquindio.model;

public class Song {
    private String code;
    private String songName;
    private Album album;
    //The time is going to be handle in Seconds
    private String time;

    private String url;

    private Genre genre;

    private Author author;

    // Constructor
    public Song(String code, String songName, Album album, String time, String url, Genre genre, Author author) {
        this.code = code;
        this.songName = songName;
        this.album = album;
        this.time = time;
        this.url = url;
        this.genre = genre;
        this.author = author;
    }

    public Song() {
    }

    // Getters y Setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "songName='" + songName + '\'' +
                '}';
    }
}

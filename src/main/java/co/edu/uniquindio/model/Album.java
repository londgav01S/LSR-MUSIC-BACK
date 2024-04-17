package co.edu.uniquindio.model;

import java.util.ArrayList;

public class Album {
    private String albumName;
    private Genre albumGenre;

    private Author albumAuthor;

    private String albumCode;

    private String albumYear;

    private String albumCover;

    private ArrayList<Song> songList;

    public Album(String albumName, Genre albumGenre, Author albumAuthor, String albumYear, String albumCover) {
        this.albumName = albumName;
        this.albumGenre = albumGenre;
        this.albumAuthor = albumAuthor;
        this.albumYear = albumYear;
        this.albumCover = albumCover;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public Genre getAlbumGenre() {
        return albumGenre;
    }

    public void setAlbumGenre(Genre albumGenre) {
        this.albumGenre = albumGenre;
    }

    public Author getAlbumAuthor() {
        return albumAuthor;
    }

    public void setAlbumAuthor(Author albumAuthor) {
        this.albumAuthor = albumAuthor;
    }

    public String getAlbumCode() {
        return albumCode;
    }

    public void setAlbumCode(String albumCode) {
        this.albumCode = albumCode;
    }

    public String getAlbumYear() {
        return albumYear;
    }

    public void setAlbumYear(String albumYear) {
        this.albumYear = albumYear;
    }

    public String getAlbumCover() {
        return albumCover;
    }

    public void setAlbumCover(String albumCover) {
        this.albumCover = albumCover;
    }

    public ArrayList<Song> getSongList() {
        return songList;
    }

    public void setSongList(ArrayList<Song> songList) {
        this.songList = songList;
    }
}

package co.edu.uniquindio.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.EqualsAndHashCode.Include;
import co.edu.uniquindio.*;


@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Entity
@AllArgsConstructor
@Table(name = "song")
public class Song extends Persistence implements Comparable<Song> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;



    @Include
    private String code;
    private String songName;
    private String photoURL;

    //The time is going to be handle in Seconds
    private String time;
    private String url;
    private Genre genre;
    private String author;

<<<<<<< HEAD
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
=======
    @ManyToOne
    private User user;

    public Song() {}


    public boolean verficarOR(String[] words) {
        if(verificarName(words) || verificarArtista(words) || verificarGenero(words)) return true;
        else return false;
    }

    private boolean verificarGenero(String[] words) {
        boolean result = false;
        for(String word : words){
            if(genre.getValue().toLowerCase().contains(word.toLowerCase())) result = true;
        }
        return result;
    }

    private boolean verificarArtista(String[] words) {
        boolean flag = false;
        for(String word : words){
            if(author.toLowerCase().contains(word.toLowerCase())) flag = true;
        }
        return flag;
    }

    private boolean verificarName(String[] words) {
        boolean flag = false;
        for (String word : words) {
            if (songName.toLowerCase().contains(word.toLowerCase())) flag = true;
        }
        return flag;
    }

    public boolean verficarAND(String[] words) {
        if(verificarName(words) && verificarArtista(words) && verificarGenero(words)) return true;
        else return false;
    }

    @Getter
    public enum Genre {
        ROCK("Rock"),POP("Pop"),PUNK("Punk"),REGGAETON("Reggaeton"),ELECTRONIC("Electronic"),
        RAP("Rap"),CLASSIC("Classic"),REGGAE("Reggae"),INDIE("Indie"),OTHER("Other");

        private String value;

        Genre(String value) {
            this.value = value;
        }

        public static Genre genreOf(String value) {
            Genre[] values = values();
            for (Genre genre : values) {
                if (genre.getValue().equals(value))
                    return genre;
            }
            return null;
        }

    }

    @Override
    public int compareTo(Song o) {
        return this.songName.compareTo(o.songName);
    }


>>>>>>> luis
}

package co.edu.uniquindio.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.EqualsAndHashCode.Include;


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

    @ManyToOne
    private Album album;
    //The time is going to be handle in Seconds
    private String time;
    private String url;
    private Genre genre;

    @ManyToOne
    private Author author;

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

    public boolean hasOMatches(Object [] o2){
        Object[] o1 = {songName, album, time, genre, author};
        if(o2==null) return false;
        for(int i=0; i<o1.length; i++){
            if(o2[i]!=null &&o1[i].equals(o2[i])) return true;
        }
        return false;
    }

    public boolean hasYMatches(Object [] o2){
        Object[] o1 = {songName, album, time, genre, author};
        if(o2==null) return false;
        for(int i=0; i<o1.length; i++){
            if(o2[i]!=null && !o1[i].equals(o2[i])) return false;
        }
        return true;
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

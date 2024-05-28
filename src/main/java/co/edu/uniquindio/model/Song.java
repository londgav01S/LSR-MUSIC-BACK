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


}

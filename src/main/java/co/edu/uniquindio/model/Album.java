package co.edu.uniquindio.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class Album {

    private String albumName;
    private Genre albumGenre;

    private Author albumAuthor;

    private String albumCode;

    private String albumYear;

    private String albumCover;

    private ArrayList<Song> songList;


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
}

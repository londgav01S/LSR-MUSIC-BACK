package co.edu.uniquindio.model;


import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;


@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class Song implements Comparable<Song>{

    @Include
    private String code;
    private String songName;
    private Album album;
    //The time is going to be handle in Seconds
    private String time;

    private String url;

    private Genre genre;

    private Author author;

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


}

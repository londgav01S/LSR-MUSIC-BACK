package co.edu.uniquindio.model;

//TODO: revisar el por que el tree no funciona

import co.edu.uniquindio.model.estructurasDeDatos.List.LinkedList;
import co.edu.uniquindio.model.estructurasDeDatos.List.SimpleList;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import java.util.Map;

@Getter
@Setter
@Data
@Component
@Entity
@Table(name = "lsr")
public class LSR extends Persistence {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    /*@Transient
    private Tree<Author> lstAuthors;*/

    @OneToMany(mappedBy = "lsr", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @MapKey(name = "username")
    private Map<String, User> lstUsers;

    @ManyToOne
    private User currentUser;

    public LSR() {
        /*this.lstAuthors = new BinaryTree<>();*/
        this.lstUsers = new java.util.HashMap<>();
    }

    public void login(String username, String password) {
        this.currentUser = lstUsers.getOrDefault(username, null);
    }


    //TODO: revisar
    /*public LinkedList<Song> getUserSongs() {
        return currentUser.getSongs();
    }*/

/*
    public LinkedList<Song> getArtistSongs(String name){
        return lstAuthors.find(createAuxArtist(name)).getSongs();
    }
*/
    //TODO: Finish this.
    /*
    public LinkedList<Song> searchO(String name, String albumName, String cover, Integer year, LocalTime duration, Song.Genre genre, String artistName){
        Object[] o2 = {name, albumName, cover, year, duration, genre, artistName};
        LinkedList<Song> list = new SimpleList<>();

        for(Song s : getLstSongs()) if(s.hasOMatches(o2)) list.addTail(s);
        return list;
    }

    public LinkedList<Song> searchY(String name, String albumName, String cover, Integer year, LocalTime duration, Song.Genre genre, String artistName){
        Object[] o2 = {name, albumName, cover, year, duration, genre, artistName};
        LinkedList<Song> list = new SimpleList<>();

        for(Song s : getLstSongs()) if(s.hasYMatches(o2)) list.addTail(s);
        return list;
    }
*/
/*
    public void addArtist(Author artist) {
        lstAuthors.insert(artist);
    }
*/

    public void addUser(User user) {
        lstUsers.put(user.getUsername(), user);
    }

/*
    public void addSongToArtist(String name, Song song) {
        lstAuthors.find(createAuxArtist(name)).addSong(song);
    }
*/

    public void addSongToUser(String name){
        //TODO
    }

    private Author createAuxArtist(String name) {
        return Author.builder().name(name).build();
    }

    public void addSongToArtist(String name, Song song) {
    }

    public Song searchSongByCode(String code) {
        return null;
    }

/*    private LinkedList<Song> getLstSongs(){
        LinkedList<Song> list = new SimpleList<>();
        for(Author a: lstAuthors){
            list.extend(a.getSongs());
        }
        return list;
    }*/
    //TODO: Fix this. Includes remaking Song and Album
/*
    public void sortSongsByAttribute(ComparatorAttribute attribute){
        this.currentUser.getSongs().sort();
        Comparator<Song> comparator = null;
        switch (attribute){
            case NAME -> {
                comparator = (s1, s2) -> s1.getSongName().compareToIgnoreCase(s2.getSongName());
            }
            case ALBUM_NAME -> {
                comparator = (s1, s2) -> s1.getAlbumName().compareToIgnoreCase(s2.getAlbumName());
            }
            case COVER -> {
                comparator = (s1, s2) -> s1.getCover().compareToIgnoreCase(s2.getCover());
            }
            case YEAR -> {
                comparator = Comparator.comparing(Song::getYear);
            }
            case DURATION -> {
                comparator = Comparator.comparing(Song::getDuration);
            }
            case GENRE -> {
                comparator = Comparator.comparing(Song::getGenre);
            }
            case ARTIST_NAME -> {
                comparator = (s1, s2) -> s1.getArtistName().compareToIgnoreCase(s2.getArtistName());
            }
        }
        if(comparator!=null) this.currentUser.getLstSongs().sort(comparator);
    }

 */

 /*   public Song searchSongByCode(String code){
        for(Song s : getLstSongs())
            if(s.getCode().equals(code))
                return s;
        return null;
    }*/
}

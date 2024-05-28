package co.edu.uniquindio.model;

//TODO: revisar el por que el tree no funciona


import co.edu.uniquindio.model.Exceptions.AuthorException;
import co.edu.uniquindio.model.Exceptions.UsuarioException;
import co.edu.uniquindio.model.estructurasDeDatos.List.LinkedList;
import co.edu.uniquindio.model.estructurasDeDatos.List.SimpleList;
import co.edu.uniquindio.model.estructurasDeDatos.Tree.BinaryTree;
import co.edu.uniquindio.model.estructurasDeDatos.Tree.Tree;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Map;

@Getter
@Setter
@Data
@Component
@Entity
@Table(name = "lsr")
public class LSR extends Persistence {
    @ManyToOne//TODO: This might cause problems idk
    private static LSR instance;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


    @Transient
    private Tree<Author> lstAuthors;

    @OneToMany(mappedBy = "lsr", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @MapKey(name = "username")
    private Map<String, User> lstUsers;

    @ManyToOne
    private User currentUser;

    public LSR() {
        this.lstAuthors = new BinaryTree<Author>();
        this.lstUsers = new java.util.HashMap<>();
    }


    public static synchronized LSR getInstance() {
        if (instance == null) {
            instance = new LSR();
        }
        return instance;
    }

    public void login(String username, String password) {
        this.currentUser = lstUsers.getOrDefault(username, null);
        System.out.println("Usuario actual: " + currentUser.toString());
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

    public void addUser(User user) throws UsuarioException {
        if (lstUsers.containsKey(user.getUsername())){
            throw new UsuarioException("El usuario ya existe");
        }
        else {
            lstUsers.put(user.getUsername(), user);
        }
    }

/*
    public void addSongToArtist(String name, Song song) {
        lstAuthors.find(createAuxArtist(name)).addSong(song);
    }
*/

    public ArrayList<Song> addSongToUser(Song song){
        currentUser.addSong(song);

        return currentUser.getListofSongs();
    }

    private Author createAuxArtist(String name) {
        return Author.builder().name(name).build();
    }

    /**
     * Adds a song to an author's list of songs.
     *
     * @param author the name of the author
     * @param song the Song object to be added
     * @throws AuthorException if the author is not found
     */
    public void addSongToAuthor(String author, Song song) throws AuthorException {
        Author aux = null;
        for (Author a : getLstAuthorsAsList()) {
            if (a.getName().equals(author)) {
                aux = a;
            }
        }
        if (aux != null) {
            song.setAuthor(aux.getName());
            aux.addSong(song);
            System.out.println("Se guardó: " + song.toString() + aux.toString());
        } else {
            throw new AuthorException("Autor no encontrado.");
        }
    }

    public Song searchSongByCode(String code) {
        return null;
    }

    public ArrayList<Author> getLstAuthorsAsList() {
        ArrayList<Author> authorList = new ArrayList<>();
        for (Author author : lstAuthors) {
            authorList.add(author);
        }
        return authorList;
    }

    public ArrayList<Song> getListSongs() {
        ArrayList<Song> canciones = new ArrayList<>();
        for(Author a: getLstAuthorsAsList()){
            for(Song song : a.getListSongs()){
                canciones.add(song);
            }
        }
        return canciones;
    }

    public Song buscarCancion(String song) {
        ArrayList <Song> canciones = getListSongs();
        for(Song s : canciones){
            if(s.getSongName().equals(song)){
                return s;
            }
        }
        return null;
    }

    public void linkSongToAuthor(String author, Song song) {
        for(Author a : getLstAuthorsAsList()){
            if(a.getName().equals(author)){
                a.addSong(song);
            }
        }
    }
}

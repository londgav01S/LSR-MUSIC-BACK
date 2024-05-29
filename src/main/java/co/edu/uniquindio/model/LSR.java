package co.edu.uniquindio.model;



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
import java.util.List;
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

    @Transient
    private User currentUser;

    /**
     * Constructor
     */
    public LSR() {
        this.lstAuthors = new BinaryTree<Author>();
        this.lstUsers = new java.util.HashMap<>();
    }

    /**
     * Metodo para retornar la UNICA instancia del LSR
     * @return UNICA instancia de LSR
     */
    public static synchronized LSR getInstance() {
        if (instance == null) {
            instance = new LSR();
        }
        return instance;
    }

    /**
     * Metodo que va a logear al usuario
     * @param username del usuario que intenta logear
     * @param password del usuario que intenta logear
     */
    public void login(String username, String password) {
        this.currentUser = lstUsers.getOrDefault(username, null);
        System.out.println("Usuario actual: " + currentUser.toString());
    }


    /**
     * El metodo nos agrega un usuario a un Map llamada lstUsers
     * @param user
     * @throws UsuarioException
     */
    public void addUser(User user) throws UsuarioException {
        if (lstUsers.containsKey(user.getUsername())){
            throw new UsuarioException("El usuario ya existe");
        }
        else {
            lstUsers.put(user.getUsername(), user);
        }
    }



    /**
     * Metodo el cual agrega una cancion a un respectivo usuario,
     * ya que a cada usuario le corresponde una lista de canciones
     * @param song
     * @return List <Song> </Song>
     * @throws UsuarioException
     */
    public List<Song> addSongToUser(Song song) throws UsuarioException {
        System.out.println(currentUser.getListofSongs().size());
        if(currentUser.getListofSongs().indexOf(song) >0){
            throw new UsuarioException("La cancion ya existe");
        }else{
            currentUser.addSong(song);
        }

        return currentUser.getListofSongs();
    }

    /**
     * crea una instancia de la clase Author utilizando el patrón de diseño Builder
     * @param name
     * @return Author
     */
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


    /**
     * Metodo que busca una canción dado su codigo
     * @param code
     * @return Song
     */
    public Song searchSongByCode(String code) {
        return null;
    }


    /**
     * Metodo encargado de recorrer un arbol y pasar todos sus datos a un ArrayLList
     * para asi poder guardar en base de datos
     * @return ArrayList <Author> </Author>
     */
    public ArrayList<Author> getLstAuthorsAsList() {
        ArrayList<Author> authorList = new ArrayList<>();
        for (Author author : lstAuthors) {
            authorList.add(author);
        }
        return authorList;
    }

    /**
     *
     * @return ArrayList<Song>
     */
    public ArrayList<Song> getListSongs() {
        ArrayList<Song> canciones = new ArrayList<>();
        for(Author a: getLstAuthorsAsList()){
            for(Song song : a.getListSongs()){
                canciones.add(song);
            }
        }
        return canciones;
    }

    /**
     * Recorre la lista de canciones y devuelve la cancion que coincida con el nombre dado
     * @param song
     * @return Song
     */
    public Song buscarCancion(String song) {
        ArrayList <Song> canciones = getListSongs();
        for(Song s : canciones){
            if(s.getSongName().equals(song)){
                return s;
            }
        }
        return null;
    }

    /**
     * Agrega a una lista de author los que vayan pasando el filtro de busqueda
     * @param author
     * @param song
     */
    public void linkSongToAuthor(String author, Song song) {
        for(Author a : getLstAuthorsAsList()){
            if(a.getName().equals(author)){
                a.addSong(song);
            }
        }
    }
}

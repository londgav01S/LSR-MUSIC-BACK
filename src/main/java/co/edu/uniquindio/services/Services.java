package co.edu.uniquindio.services;

import co.edu.uniquindio.Repositories.AuthorRepository;
import co.edu.uniquindio.Repositories.LsrRepository;
import co.edu.uniquindio.model.Author;
import co.edu.uniquindio.model.Exceptions.AuthorException;
import co.edu.uniquindio.model.Exceptions.UsuarioException;
import co.edu.uniquindio.model.Song;
import co.edu.uniquindio.model.User;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Getter
@Service
public class Services {

    private static Services instance;

    private final LSRService lsrService;

    private static LsrRepository lsrRepository;

    /**
     * Constructo que inyecta la instancia de lsrService.
     * @param lsrService
     */
    @Autowired
    public Services(LSRService lsrService) {
        this.lsrService = lsrService;
    }


    /**
     * Metodo para obtener la unica instancia de Service.
     * @return Instancia UNICA de Services.
     */
    public static Services getInstance() {
        if (instance == null) {
            instance = new Services(new LSRService(lsrRepository));
        }
        return instance;
    }


    /**
     * Metodo intermedio para logear al usuario
     * @param usuario
     * @param contrasena
     * @return Usuario
     */
    public User obtenerUsuario(String usuario, String contrasena) {
        return lsrService.obtenerUsuario(usuario, contrasena);
    }


    /**
     * Metodo intermedio para guardar Usuario en la db
     * @param user
     */
    public void guardarUsuario(User user) {
        lsrService.guardarUsuario(user);
    }


    /**
     * Metodo que llama a otro metodo ubicado en la clase (lsrService) el cual manda el link
     * de la canción encontrada al front para poder reproducirla 
     * @param song
     * @return List <Song> </Song>
     */
    public List<Song> likearCancion(String song) {
        try {
            return lsrService.likearCancion(song);
        } catch (UsuarioException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Invocació de otro metodo (separa responsabilidades) 
     * @param users
     */
    public void recibirUsuarios(List<User> users) {
        lsrService.recibirUsuarios(users);
    }

    /**
     * Metodo creado para generarle un Codigo a cada autor automaticamente
     * @return Siguiente codigo para Author
     */
    public String generateAuthorCode() {
        return lsrService.generateAuthorCode();
    }


    /**
     * Metodo que crea al autor
     *
     * @param author
     */
    public void create(Author author) {
        lsrService.create(author);
    }

    /**
     * invocacion de otro metodo ubicado en lsrService (separar responsabilidades) 
     * @param author
     * @param song
     * @throws AuthorException
     */
    public void addSongToAuthor(String author, Song song) throws AuthorException {
        lsrService.addSongToAuthor(author, song);
    }


    /**
     * invocacion de otro metodo ubicado en lsrService (separar responsabilidades)
     * @param authors
     */
    public void recibirarAutor(List<Author> authors) {
        lsrService.recibirarAutor(authors);
    }

    /**
     * Metodo que retorna todos los autores de LSR
     * @return
     */
    public ArrayList<Author> getAuthors() {
        return lsrService.getAuthors();
    }

    /**
     * Metodo que recibe todas las canciones de la db para setearlas en LSR
     * @param all
     */
    public void recibirCanciones(List<Song> all) {
        lsrService.recibirCanciones(all);
    }


    /**
     * invocacion de otro metodo ubicado en lsrService (separar responsabilidades)
     * @return ArrayList<Song> </Song>
     */
    public ArrayList<Song> getSongs() {
        return lsrService.getSongs();
    }


    /**
     * invocacion de otro metodo ubicado en lsrService (separar responsabilidades)
     * @param query
     * @return ArrayList <Song> </Song>
     */
    public ArrayList<Song> searchSongsOR(String query) {
        return lsrService.searchSongsOR(query);
    }

    /**
     * invocacion de otro metodo ubicado en lsrService (separar responsabilidades)
     * @param query
     * @return ArrayList <Song> </Song>
     */
    public ArrayList<Song> searchSongsAND(String query) {
        return lsrService.searchSongsAND(query);
    }

    /**
     * invocacion de otro metodo ubicado en lsrService (separar responsabilidades)
     * @param query
     * @return ArrayList <Song> </Song>
     */
    public ArrayList<Song> searchSongsANDOR(String query) {
        return lsrService.searchSongsANDOR(query);
    }

    /**
     * invocacion de otro metodo ubicado en lsrService (separar responsabilidad
     * @return User
     */
    public User obtenerUsuarioLog() {
        return lsrService.obtenerUsuarioLog();
    }
}

package co.edu.uniquindio.services;

import co.edu.uniquindio.Repositories.LsrRepository;
import co.edu.uniquindio.model.Author;
import co.edu.uniquindio.model.Exceptions.AuthorException;
import co.edu.uniquindio.model.Exceptions.UsuarioException;
import co.edu.uniquindio.model.LSR;
import co.edu.uniquindio.model.Song;
import co.edu.uniquindio.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class to manage LSR-related operations.
 */
@Service
public class LSRService {
    private final LSR lsr;

    private final LsrRepository lsrRepository;

    /**
     * Constructor to initialize the LSR instance and add a default user with a song.
     */
    @Autowired
    public LSRService(LsrRepository lsrRepository) {
        this.lsrRepository = lsrRepository;
        lsr = LSR.getInstance();

        /*Song song = Song.builder()
                .code("1")
                .songName("La PI canción")
                .album(null)
                .time("74") // Tiempo en segundos
                .url("https://www.youtube.com/watch?v=3HRkKznJoZA&ab_channel=AsapSCIENCE")
                .genre(Song.Genre.POP)
                .author(null)
                .build();*/
    }

    /**
     * Saves a user to the LSR instance.
     *
     * @param user the User object to be saved
     */
    public void guardarUsuario(User user) {
        try {
            lsr.addUser(user);
            System.out.println("Usuario guardado: " + user.toString());
        } catch (UsuarioException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves a user by username and password.
     *
     * @param usuario the username of the user
     * @param contrasena the password of the user
     * @return the User object if the credentials match, null otherwise
     */
    public User obtenerUsuario(String usuario, String contrasena) {
        if (lsr.getLstUsers().get(usuario).getPassword().equals(contrasena)) {
            lsr.login(usuario, contrasena);
            return lsr.getLstUsers().get(usuario);
        } else {
            return null;
        }
    }


    /**
     * Metodo que obtiene el LSR de la base de datos.
     * @param lsr
     * @return LSR
     */
    public LSR almacenarLSR(LSR lsr) {
        return lsrRepository.save(lsr);
    }

    /**
     * Placeholder method to save a song (implementation needed).
     *
     * @param song the Song object to be saved
     */
    public void guardarCancion(Song song) {
        System.out.println("S");
    }

    /**
     * Likes a song and returns the updated list of songs liked by the user.
     *
     * @param song the Song object to be liked
     * @return an ArrayList of Song objects liked by the user
     */
    public List<Song> likearCancion(String song) throws UsuarioException {
        Song song1 = lsr.buscarCancion(song);
        System.out.println("Canción encontrada: " + song1.toString());
        return lsr.addSongToUser(song1);
    }

    /**
     * Generates a unique code for an author.
     *
     * @return the generated author code
     */
    public String generateAuthorCode() {
        return lsr.getLstAuthors().isEmpty() ? "1" : String.valueOf(lsr.getLstAuthors().size());
    }

    /**
     * Creates a new author and adds it to the LSR instance.
     *
     * @param author the Author object to be created
     */
    public void create(Author author) {
        lsr.getLstAuthors().insert(author);
        System.out.println(author.toString());
    }

    /**
     * Retrieves the list of authors.
     *
     * @return an ArrayList of Author objects
     */
    public ArrayList<Author> getAuthors() {
        return lsr.getLstAuthorsAsList();
    }



    /**
     * Retrieves the list of songs.
     *
     * @return an ArrayList of Song objects
     */
    public ArrayList<Song> getSongs() {
        return lsr.getListSongs();
    }

    /**
     * Lógica para el metodo que busca canciones por medio de comparador OR
     * @param query parametros de busqueda
     * @return las canciones que cumplen el criterio.
     */
    public ArrayList<Song> searchSongsOR(String query) {
        String [] words = query.split(" ");
        ArrayList<Song> result = new ArrayList<Song>();
        for (Song s: lsr.getListSongs()){
            if(s.verficarOR(words)){
                result.add(s);
            }
        }
        return result;
    }

    /**
     * Lógica para el metodo que busca canciones por medio de comparador AND
     * @param query parametros de busqueda
     * @return las canciones que cumplen el criterio.
     */
    public ArrayList<Song> searchSongsAND(String query) {
        String [] words = query.split(" ");
        ArrayList<Song> result = new ArrayList<Song>();
        for (Song s: lsr.getListSongs()){
            if(s.verficarAND(words)){
                result.add(s);
            }
        }
        return result;
    }

    /**
     * Lógica para el metodo que busca canciones por medio de comparador AND Y OR
     * @param query parametros de busqueda
     * @return las canciones que cumplen el criterio.
     */
    public ArrayList<Song> searchSongsANDOR(String query) {
        ArrayList<Song> result = new ArrayList<Song>();
        String [] words = query.split(" ");
        Thread t1 = new Thread(() -> {
            for (Song s: lsr.getListSongs()){
                if(s.verficarAND(words)){
                    result.add(s);
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (Song s: lsr.getListSongs()){
                if(s.verficarOR(words)){
                    result.add(s);
                }
            }
        });
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * recorre la lista de usuarios y los agrega a la lista perteneciente a
     * la clase lsr (principal)
     * @param all
     */
    public void recibirUsuarios(List<User> all) {
        for (User user : all) {
            try {
                lsr.addUser(user);
            } catch (UsuarioException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Recorre los authores y los agrega a la lista de authores de la clase lsr (principal)
     * @param all
     */
    public void recibirarAutor(List<Author> all) {
        for (Author author : all) {
            lsr.getLstAuthors().insert(author);
        }
    }

    /**
     * Metodo que va a recibir TODAS las canciones de la db para vincularlas a los artistas
     * @param all Songs from db
     */
    public void recibirCanciones(List<Song> all) {
        for (Song song : all) {
            lsr.linkSongToAuthor(song.getAuthor(), song);
        }
    }

    /**
     * Metodo de lógica para revincular los artistas a sus canciones.
     * @param author dueño de la cancion
     * @param song cancion
     */
    public void addSongToAuthor(String author, Song song) {
        try {
            lsr.addSongToAuthor(author, song);
        } catch (AuthorException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo utilizado para obtener la instancia del usuario que está logeado
     * @return UserLogged
     */
    public User obtenerUsuarioLog() {
        return lsr.getCurrentUser();
    }
}

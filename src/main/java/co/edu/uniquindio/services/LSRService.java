package co.edu.uniquindio.services;

import co.edu.uniquindio.model.Author;
import co.edu.uniquindio.model.Exceptions.AuthorException;
import co.edu.uniquindio.model.Exceptions.UsuarioException;
import co.edu.uniquindio.model.LSR;
import co.edu.uniquindio.model.Song;
import co.edu.uniquindio.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Service class to manage LSR-related operations.
 */
@Service
public class LSRService {
    private final LSR lsr;

    /**
     * Constructor to initialize the LSR instance and add a default user with a song.
     */
    public LSRService() {
        lsr = LSR.getInstance();

        Song song = Song.builder()
                .code("1")
                .songName("La PI canción")
                .album(null)
                .time("74") // Tiempo en segundos
                .url("https://www.youtube.com/watch?v=3HRkKznJoZA&ab_channel=AsapSCIENCE")
                .genre(Song.Genre.POP)
                .author(null)
                .build();
        User user = User.builder()
                .username("admin")
                .password("admin")
                .mail("admin@example.com")
                .build();
        user.addSong(song);
        try {
            lsr.addUser(user);
        } catch (UsuarioException e) {
            throw new RuntimeException(e);
        }
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
    public ArrayList<Song> likearCancion(String song) {
        Song song1 = new Song();
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
     * Adds a song to an author's list of songs.
     *
     * @param author the name of the author
     * @param song the Song object to be added
     * @throws AuthorException if the author is not found
     */
    public void addSongToAuthor(String author, Song song) throws AuthorException {
        Author aux = null;
        for (Author a : lsr.getLstAuthorsAsList()) {
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
     * Retrieves the list of songs.
     *
     * @return an ArrayList of Song objects
     */
    public ArrayList<Song> getSongs() {
        return lsr.getListSongs();
    }
}

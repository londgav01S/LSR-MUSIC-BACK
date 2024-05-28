package co.edu.uniquindio.services;

import co.edu.uniquindio.model.LSR;
import co.edu.uniquindio.model.Song;
import co.edu.uniquindio.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Service class to manage user-related operations.
 */
@Service
public class UserService {
    private final LSRService lsrService;

    /**
     * Constructor to autowire the LSRService dependency.
     *
     * @param lsrService the LSRService instance to be injected
     */
    @Autowired
    public UserService(LSRService lsrService) {
        this.lsrService = lsrService;
    }

    /**
     * Retrieves the list of songs associated with a user.
     *
     * @param usuario the username of the user
     * @param contrasena the password of the user
     * @return an ArrayList of Song objects associated with the user
     */
    public ArrayList<Song> obtenerCancionesUsuarios(String usuario, String contrasena) {
        User user = lsrService.obtenerUsuario(usuario, contrasena);
        return user.getListofSongs();
    }

    /**
     * Saves a new user to the system.
     *
     * @param username the username of the new user
     * @param password the password of the new user
     * @param email the email of the new user
     */
    public void guardarUsuario(String username, String password, String email) {
        User user = User.builder()
                .username(username)
                .password(password)
                .mail(email)
                .build();
        lsrService.guardarUsuario(user);
    }

    /**
     * Likes a song and returns the updated list of songs liked by the user.
     *
     * @param song the song to be liked
     * @return an ArrayList of Song objects liked by the user
     */
    public ArrayList<Song> likearCancion(String song) {
        return lsrService.likearCancion(song);
    }
}

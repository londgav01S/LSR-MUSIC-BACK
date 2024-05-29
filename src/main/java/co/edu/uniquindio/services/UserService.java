package co.edu.uniquindio.services;

import co.edu.uniquindio.Repositories.UserRepository;
import co.edu.uniquindio.model.LSR;
import co.edu.uniquindio.model.Song;
import co.edu.uniquindio.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class to manage user-related operations.
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    private static Services services= Services.getInstance();

    /**
     * Constructor que inyecta la instancia de Userrepository
     * Envia todos los usuarios de la db.
     * @param userRepository
     */
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        mandarUsuarios();
    }

    /**
     * Retrieves the list of songs associated with a user.
     *
     * @param usuario    the username of the user
     * @param contrasena the password of the user
     * @return an ArrayList of Song objects associated with the user
     */
    public List<Song> obtenerCancionesUsuarios(String usuario, String contrasena) {
        User user = services.obtenerUsuario(usuario, contrasena);
        return user.getListofSongs();
    }

    /**
     * Saves a new user to the system.
     *
     * @param username the username of the new user
     * @param password the password of the new user
     * @param email    the email of the new user
     */
    public void guardarUsuario(String username, String password, String email) {
        User user = User.builder()
                .username(username)
                .password(password)
                .mail(email)
                .build();
        userRepository.save(user);
        services.guardarUsuario(user);
    }

    /**
     * Likes a song and returns the updated list of songs liked by the user.
     *
     * @param song the song to be liked
     * @return an ArrayList of Song objects liked by the user
     */
    public List<Song> likearCancion(String song) {
        List<Song> songs = services.likearCancion(song);
        userRepository.save(services.obtenerUsuarioLog());
        return songs;
    }


    public void mandarUsuarios() {
        services.recibirUsuarios(obtenerUsuarios());
    }


    /**
     * metodo que me trae todos los usuarios de la base de datos
     * @return lista de usuarios
     */
    private List<User> obtenerUsuarios(){
        return (userRepository.findAll());
    }
}

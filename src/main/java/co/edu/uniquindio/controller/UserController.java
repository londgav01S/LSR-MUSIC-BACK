package co.edu.uniquindio.controller;


import co.edu.uniquindio.model.Song;
import co.edu.uniquindio.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Controlador REST para manejar las solicitudes relacionadas a User.
 */
@RestController
@RequestMapping("/api/usuarios")
public class UserController {
    private final UserService userService;

    /**
     * Constructor que inyecta la instancia de userService.
     * @param userService
     */
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Metodo que devuelve una Lista de todas la canciones del usuario que se acaba de loggear.
     * @param username del usuario que se loggeó
     * @param password del usuario que se loggeó
     * @return List<Song> Canciones likeadas por el User</Song>
     */
    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Song> getUsers(@RequestParam String username, @RequestParam String password) {
        return userService.obtenerCancionesUsuarios(username, password);
    }

    /**
     * Metodo que va a registrar el usuario en la clase principal LSR
     * @param username del usuario
     * @param password del usuario
     * @param email del usuario
     */
    @PostMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public void registerUser(@RequestParam String username, @RequestParam String password, @RequestParam String email) {
        userService.guardarUsuario(username, password, email);
    }

    /**
     * Metodo que va a agregar una cancion a la lista de
     * @param song
     * @return
     */
    @GetMapping("/likear")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Song> likeSong(@RequestParam String song) {
        System.out.println(song );
        return userService.likearCancion(song);
    }
}

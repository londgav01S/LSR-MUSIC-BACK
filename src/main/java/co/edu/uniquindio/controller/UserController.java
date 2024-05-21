package co.edu.uniquindio.controller;


import co.edu.uniquindio.model.Song;
import co.edu.uniquindio.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/usuarios")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public ArrayList<Song> getUsers(@RequestParam String username, @RequestParam String password) {
        return userService.obtenerCancionesUsuarios(username, password);
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public void registerUser(@RequestParam String username, @RequestParam String password, @RequestParam String email) {
        userService.guardarUsuario(username, password, email);
    }
}

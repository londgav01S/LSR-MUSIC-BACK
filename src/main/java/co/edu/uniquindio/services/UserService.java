package co.edu.uniquindio.services;


import co.edu.uniquindio.model.LSR;
import co.edu.uniquindio.model.Song;
import co.edu.uniquindio.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    private final LSRService lsrService;

    @Autowired
    public UserService(LSRService lsrService) {
        this.lsrService = lsrService;
    }

    public ArrayList<Song> obtenerCancionesUsuarios(String usuario, String contrasena){
        User user = lsrService.obtenerUsuario(usuario,contrasena);
        return user.getListofSongs();
    }

    public void guardarUsuario(String username, String password, String email) {
        User user = User.builder()
                .username(username)
                .password(password)
                .mail(email)
                .build();
        lsrService.guardarUsuario(user);
    }

    public ArrayList<Song> likearCancion( Song song) {
        return lsrService.likearCancion( song);
    }
};

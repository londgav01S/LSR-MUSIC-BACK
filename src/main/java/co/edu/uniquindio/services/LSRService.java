package co.edu.uniquindio.services;


import co.edu.uniquindio.model.LSR;
import co.edu.uniquindio.model.Song;
import co.edu.uniquindio.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LSRService {
    private final LSR lsr;


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
        lsr.addUser(user);
    }
    //TODO: verificar si el usuario ya existe y arrojar exception
    public void guardarUsuario(User user) {
        lsr.addUser(user);
        System.out.println("Usuario guardado: " + user.toString());
    }


    public User obtenerUsuario(String usuario, String contrasena) {
        if(lsr.getLstUsers().get(usuario).getPassword().equals(contrasena)){
            return lsr.getLstUsers().get(usuario);
        }
        else{
            return null;
        }
    }
}

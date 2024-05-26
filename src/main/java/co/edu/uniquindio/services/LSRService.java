package co.edu.uniquindio.services;


import co.edu.uniquindio.model.Author;
import co.edu.uniquindio.model.Exceptions.AuthorException;
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
            lsr.login(usuario, contrasena);
            return lsr.getLstUsers().get(usuario);
        }
        else{
            return null;
        }
    }

    public void guardarCancion(Song song) {
        System.out.println("S");
    }

    public ArrayList<Song> likearCancion( Song song) {
        return lsr.addSongToUser( song);
    }

    public String generateAuthorCode() {
        return lsr.getLstAuthors().isEmpty()?"1":lsr.getLstAuthors().size()+"";
    }

    public void create(Author author) {
        lsr.getLstAuthors().insert(author);
        System.out.println(author.toString());
    }

    public ArrayList<Author> getAuthors() {
        return lsr.getLstAuthorsAsList();
    }

    public void addSongToAuthor(String author, Song song) throws AuthorException {
        Author aux = null;
        for (Author a: lsr.getLstAuthorsAsList()) {
            if (a.getName().equals(author)){
                aux = a;
            }
        }
        if(aux != null){
            song.setAuthor(aux.getName());
            aux.addSong(song);
            System.out.println("Se guardó:" + song.toString() + aux.toString());
        }
        else{
            throw new AuthorException("Autor no encontrado.");
        }
    }

    public ArrayList<Song> getSongs() {
         return lsr.getListSongs();
    }
}

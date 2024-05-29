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


    @Autowired
    public Services(LSRService lsrService) {
        this.lsrService = lsrService;
    }


    public static Services getInstance() {
        if (instance == null) {
            instance = new Services(new LSRService(lsrRepository));
        }
        return instance;
    }


    public User obtenerUsuario(String usuario, String contrasena) {
        return lsrService.obtenerUsuario(usuario, contrasena);
    }

    public void guardarUsuario(User user) {
        lsrService.guardarUsuario(user);
    }

    public List<Song> likearCancion(String song) {
        try {
            return lsrService.likearCancion(song);
        } catch (UsuarioException e) {
            throw new RuntimeException(e);
        }
    }

    public void recibirUsuarios(List<User> users) {
        lsrService.recibirUsuarios(users);
    }

    public String generateAuthorCode() {
        return lsrService.generateAuthorCode();
    }

    public void create(Author author) {
        lsrService.create(author);
    }

    public void addSongToAuthor(String author, Song song) throws AuthorException {
        lsrService.addSongToAuthor(author, song);
    }


    public void recibirarAutor(List<Author> authors) {
        lsrService.recibirarAutor(authors);
    }

    public ArrayList<Author> getAuthors() {
        return lsrService.getAuthors();
    }

    public void recibirCanciones(List<Song> all) {
        lsrService.recibirCanciones(all);
    }

    public ArrayList<Song> getSongs() {
        return lsrService.getSongs();
    }

    public ArrayList<Song> searchSongsOR(String query) {
        return lsrService.searchSongsOR(query);
    }

    public ArrayList<Song> searchSongsAND(String query) {
        return lsrService.searchSongsAND(query);
    }

    public ArrayList<Song> searchSongsANDOR(String query) {
        return lsrService.searchSongsANDOR(query);
    }

    public User obtenerUsuarioLog() {
        return lsrService.obtenerUsuarioLog();
    }
}

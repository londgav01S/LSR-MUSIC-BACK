package co.edu.uniquindio.services;

import co.edu.uniquindio.Repositories.AuthorRepository;
import co.edu.uniquindio.model.Author;
import co.edu.uniquindio.model.Exceptions.AuthorException;
import co.edu.uniquindio.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class to manage author-related operations.
 */
@Service
public class AuthorService {
    private final LSRService lsrService;
    private final AuthorRepository authorRepository;

    /**
     * Constructor to initialize the AuthorService with a reference to the LSRService.
     *
     * @param lsrService the LSRService used to interact with the LSR model
     */
    @Autowired
    public AuthorService(LSRService lsrService, AuthorRepository authorRepository) {
        this.lsrService = lsrService;
        this.authorRepository = authorRepository;
    }

    /**
     * Creates a default author for demonstration purposes.
     */
    public void crearAutor() {
        Author author = Author.builder()
                .code("1")
                .name("Juanes")
                .nationality("")
                .isGroup(false)
                .build();
        // Additional logic can be added here to save the author if needed
    }

    /**
     * Creates a new author and saves it using the LSRService.
     *
     * @param name the name of the author
     * @param nationality the nationality of the author
     * @param isGroup whether the author is a group or not
     * @param photo the URL or path to the author's photo
     */
    public void createAuthor(String name, String nationality, Boolean isGroup, String photo) {
        Author author = Author.builder()
                .code(lsrService.generateAuthorCode())
                .name(name)
                .nationality(nationality)
                .isGroup(isGroup)
                .photo(photo)
                .build();
        authorRepository.save(author);
        lsrService.create(author);
    }

    /**
     * Adds a song to an author's list of songs.
     *
     * @param author the name of the author
     * @param song the Song object to be added
     * @throws RuntimeException if the author is not found
     */
    public void addSongToAuthor(String author, Song song) {
        try {
            lsrService.addSongToAuthor(author, song);
        } catch (AuthorException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves the list of authors.
     *
     * @return an ArrayList of Author objects
     */
    public List<Author> getAuthors() {
        return authorRepository.findAll() ;
    }

    public void agregarAutorToLsr(){
        lsrService.recibirarAutor(getAuthors());
    }
}

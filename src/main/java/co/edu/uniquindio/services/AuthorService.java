package co.edu.uniquindio.services;

import co.edu.uniquindio.model.Author;
import co.edu.uniquindio.model.Exceptions.AuthorException;
import co.edu.uniquindio.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class to manage author-related operations.
 */
@Service
public class AuthorService {
    private final LSRService lsrService;

    /**
     * Constructor to initialize the AuthorService with a reference to the LSRService.
     *
     * @param lsrService the LSRService used to interact with the LSR model
     */
    @Autowired
    public AuthorService(LSRService lsrService) {
        this.lsrService = lsrService;
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
}

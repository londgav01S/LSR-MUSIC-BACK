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
    private final AuthorRepository authorRepository;

    private static Services services= Services.getInstance();


    /**
     * Constructor que inyecta la instancia de authorRepository
     * y tambien manda todos los artistas de la db.
     * @param authorRepository
     */
    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
        agregarAutorToLsr();
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
                .code(services.generateAuthorCode())
                .name(name)
                .nationality(nationality)
                .isGroup(isGroup)
                .photo(photo)
                .build();
        authorRepository.save(author);
        services.create(author);
    }



    /**
     * Retrieves the list of authors.
     *
     * @return an ArrayList of Author objects
     */
    public List<Author> getAuthors() {
        return authorRepository.findAll() ;
    }


    /**
     * Metodo que va a enviar todos los artistas que hay en la base de datos.
     */
    public void agregarAutorToLsr(){
        services.recibirarAutor(getAuthors());
    }
}

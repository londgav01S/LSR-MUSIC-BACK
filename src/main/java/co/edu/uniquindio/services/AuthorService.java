package co.edu.uniquindio.services;



import co.edu.uniquindio.model.Author;
import co.edu.uniquindio.model.Exceptions.AuthorException;
import co.edu.uniquindio.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    private final LSRService lsrService;

    @Autowired
    public AuthorService(LSRService lsrService) {
        this.lsrService = lsrService;
    }

    public void crearAutor(){
        Author author = Author.builder()
                .code("1")
                .name("Juanes")
                .nationality("")
                .isGroup(false)
                .build();
    }

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

    public void addSongToAuthor(String author, Song song) {
        try {
            lsrService.addSongToAuthor(author, song);
        } catch (AuthorException e) {
            throw new RuntimeException(e);
        }
    }
}

package co.edu.uniquindio.controller;

import co.edu.uniquindio.model.Author;
import co.edu.uniquindio.model.Song;
import co.edu.uniquindio.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Clase que contiene una unica instancia de AuthorService
 * Diseñada para que toda la gestion/lógica de Author se maneje aquí
 */
@RestController
@RequestMapping("/api/autores")
public class AuthorController {
    /**
     * Instancia final del AuthorService donde se van a montar la lógica de los Author
     */
    private final AuthorService authorService;

    /**
     * Constructor autowired.
     * @param authorService
     */
    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    /**
     * Metodo que crea el artista con los parametros que me manda el Front mediante REST
     * @param name nombre del artista que se va crear
     * @param nationality nacionalidad del artista que se va a crear
     * @param isGroup boolean de si el Artista es un grupo o no
     * @param photo la URL de la foto del artista
     */
    @PostMapping("/crear")
    @CrossOrigin(origins = "http://localhost:3000")
    public void createAuthor(@RequestParam String name,@RequestParam String
            nationality, @RequestParam Boolean isGroup, @RequestParam String photo) {
        authorService.createAuthor(name,nationality,isGroup,photo);

    }


}

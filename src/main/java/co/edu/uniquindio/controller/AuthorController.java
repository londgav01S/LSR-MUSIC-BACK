package co.edu.uniquindio.controller;

import co.edu.uniquindio.model.Author;
import co.edu.uniquindio.model.Song;
import co.edu.uniquindio.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/autores")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/crear")
    @CrossOrigin(origins = "http://localhost:3000")
    public void createAuthor(@RequestParam String name,@RequestParam String
            nationality, @RequestParam Boolean isGroup, @RequestParam String photo) {
        authorService.createAuthor(name,nationality,isGroup,photo);

    }


}

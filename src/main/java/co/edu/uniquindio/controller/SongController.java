package co.edu.uniquindio.controller;

import co.edu.uniquindio.model.Song;
import co.edu.uniquindio.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para manejar solicitudes relacionadas a Song.
 */
@RestController
@RequestMapping("/api/canciones")
public class SongController {

    private final SongService songService;

    /**
     * Constructor que inyecta la instancia de songService
     * @param songService el Servicio de Song.
     */
    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }


    /**
     * Metodo que recibe una cancion
     * @param song
     */
    /*@PostMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public void receiveSong(@RequestBody Song song){}*/ //TODO: ????


    /**
     * Metodo diseñado para agregar una canción a algún artista previamente creado
     * @param author Nombre del artista que es dueño de la canción a agregar
     * @param song Objeto Song creado y transmitido por medio de JSON con el REST
     */
    @PostMapping("/addSongToAuthor")
    @CrossOrigin(origins = "http://localhost:3000")
    public void addSongToAuthor(@RequestParam String author, @RequestBody Song song){
        System.out.println("recibiendo cancion: "+ song.toString());
        songService.addSongToAuthor(author,song);
    }


}

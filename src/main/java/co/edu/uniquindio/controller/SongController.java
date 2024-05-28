package co.edu.uniquindio.controller;

import co.edu.uniquindio.model.Song;
import co.edu.uniquindio.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/canciones")
public class SongController {

    private final SongService songService;

    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }


    @PostMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public void receiveSong(@RequestBody Song song){}


    @PostMapping("/addSongToAuthor")
    @CrossOrigin(origins = "http://localhost:3000")
    public void addSongToAuthor(@RequestParam String author, @RequestBody Song song){
        System.out.println("recibiendo cancion: "+ song.toString());
        songService.addSongToAuthor(author,song);
    }


}

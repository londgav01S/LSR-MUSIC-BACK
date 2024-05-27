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


    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public Song getSong() {
       return songService.createSong();
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public void receiveSong(@RequestBody Song song) {
        songService.saveSong(song);
    }

    @PostMapping("/delete")
    @CrossOrigin(origins = "http://localhost:3000")
    public void deleteSong(@RequestBody Song song) {
        songService.deleteSong(song);
    }

}

package co.edu.uniquindio.controller;

import co.edu.uniquindio.model.Song;
import co.edu.uniquindio.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SongController {

    private final SongService songService;

    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }


    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public Song getSong() {
       return songService.creteSong();
    }

}

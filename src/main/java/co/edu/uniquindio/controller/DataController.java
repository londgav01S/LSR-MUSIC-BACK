package co.edu.uniquindio.controller;
import co.edu.uniquindio.model.Author;
import co.edu.uniquindio.model.LSR;
import co.edu.uniquindio.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class DataController {

    private final LSR lsr;

    @Autowired
    public DataController(LSR lsr) {
        this.lsr = lsr;
    }


    @PostMapping
    public String createSong(@RequestBody Song song) {
        lsr.addSongToArtist(song.getAuthor().getName(),song);
        return "Song created"+song.getSongName();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Song> getSongById(@PathVariable String code) {
        // Aquí obtienes el objeto Song por su ID (simulado)


        Song song = lsr.searchSongByCode(code);

        return ResponseEntity.ok(song);
    }


    @GetMapping("/song")
    public ResponseEntity<Song> getSong() {  
        Song song = Song.builder()
                .code("1")
                .songName("La PI canción")
                .album(null)
                .time("74") // Tiempo en segundos
                .url("https://www.youtube.com/watch?v=3HRkKznJoZA&ab_channel=AsapSCIENCE")
                .genre(Song.Genre.POP)
                .author(null)
                .build();

        return ResponseEntity.ok(song);
    }


}

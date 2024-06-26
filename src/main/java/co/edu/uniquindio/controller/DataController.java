package co.edu.uniquindio.controller;
import co.edu.uniquindio.model.Author;
import co.edu.uniquindio.model.LSR;
import co.edu.uniquindio.model.Song;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/data")
public class DataController {

    private final LSR lsr;

    @Autowired
    public DataController(LSR lsr) {
        this.lsr = lsr;
    }


    @PostMapping
    public String createSong(@RequestBody Song song) {
        lsr.addSongToArtist(song.getAuthor().getName(), song);
        return "Song created" + song.getSongName();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Song> getSongById(@PathVariable String code) {
        // Aquí obtienes el objeto Song por su ID (simulado)


        Song song = lsr.searchSongByCode(code);

        return ResponseEntity.ok(song);
    }


    
    @GetMapping("/song")
    public ResponseEntity<String> getSong() {
        Song song = Song.builder()
                .code("1")
                .songName("La PI canción")
                .album(null)
                .time("74") // Tiempo en segundos
                .url("https://www.youtube.com/watch?v=3HRkKznJoZA&ab_channel=AsapSCIENCE")
                .genre(Song.Genre.POP)
                .author(null)
                .build();

        ObjectMapper mapper = new ObjectMapper();
        System.out.println("cree el mapper");
        try {
            String json = mapper.writeValueAsString(song);
            System.out.println(json);
            return ResponseEntity.ok(json);
        } catch (JsonProcessingException e) {
            return ResponseEntity.internalServerError().body("Error creating song JSON");
        }
    }


}

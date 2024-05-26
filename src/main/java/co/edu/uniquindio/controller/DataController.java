package co.edu.uniquindio.controller;
import co.edu.uniquindio.model.Author;
import co.edu.uniquindio.model.LSR;
import co.edu.uniquindio.model.Song;
import co.edu.uniquindio.services.DataService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/api/data")
public class DataController {

    private final DataService dataService;

    @Autowired
    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public ArrayList<Author> getAuthors(){
        return dataService.getAuthors();
    }

    @GetMapping("/canciones")
    @CrossOrigin(origins = "http://localhost:3000")
    public ArrayList<Song> getSongs(){
        return dataService.getSongs();
    }

}

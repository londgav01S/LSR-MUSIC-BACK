package co.edu.uniquindio.services;


import co.edu.uniquindio.model.Author;
import co.edu.uniquindio.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DataService {
    private final LSRService lsrService;

    @Autowired
    public DataService(LSRService lsrService) {
        this.lsrService = lsrService;
    }


    public ArrayList<Author> getAuthors() {
        return lsrService.getAuthors();
    }

    public ArrayList<Song> getSongs() {
        return lsrService.getSongs();
    }
}

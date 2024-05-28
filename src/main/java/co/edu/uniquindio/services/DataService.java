package co.edu.uniquindio.services;


import co.edu.uniquindio.model.Author;
import co.edu.uniquindio.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DataService {

    private static Services services= Services.getInstance();

    public ArrayList<Author> getAuthors() {
        return services.getAuthors();
    }

    public ArrayList<Song> getSongs() {
        return services.getSongs();
    }

    public ArrayList<Song> searchSongsOR(String query) {
        return services.searchSongsOR(query);
    }

    public ArrayList<Song> searchSongsAND(String query) {
        return services.searchSongsAND(query);
    }

    public ArrayList<Song> searchSongsANDOR(String query) {
        return services.searchSongsANDOR(query);
    }
}

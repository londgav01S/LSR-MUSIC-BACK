package co.edu.uniquindio.services;


import co.edu.uniquindio.model.Author;
import co.edu.uniquindio.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DataService {

    private static Services services= Services.getInstance();

    /**
     * Metodo intermedio para obtener los autores.
     * @return la lista entera de Autores.
     */
    public ArrayList<Author> getAuthors() {
        return services.getAuthors();
    }

    /**
     * Metodo intermedio para obtener las canciones.
     * @return
     */
    public ArrayList<Song> getSongs() {
        return services.getSongs();
    }

    /**
     * Metodo intermedio para buscar las canciones por metodo OR
     * @param query los parametros de busqueda
     * @return la lista de canciones encontradas.
     */
    public ArrayList<Song> searchSongsOR(String query) {
        return services.searchSongsOR(query);
    }

    /**
     * Metodo intermedio para buscar las canciones por metodo AND
     * @param query los parametros de busqueda
     * @return la lista de canciones encontradas.
     */
    public ArrayList<Song> searchSongsAND(String query) {
        return services.searchSongsAND(query);
    }

    /**
     * Metodo intermedio para buscar las canciones por metodo OR
     * @param query los parametros de busqueda.
     * @return la lista de canciones encontradas.
     */
    public ArrayList<Song> searchSongsANDOR(String query) {
        return services.searchSongsANDOR(query);
    }
}

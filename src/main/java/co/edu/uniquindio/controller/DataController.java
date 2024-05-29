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


/**
 * Controlador REST para manejar solicitudes relacionadas con datos.
 */
@RestController
@RequestMapping("/api/data")
public class DataController {

    private final DataService dataService;

    /**
     * Constructor que inyecta el servicio de datos.
     *
     * @param dataService El servicio de datos.
     */
    @Autowired
    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    /**
     * Metodo que retorna la lista entera de Author de la clase principal LSR
     * @return Una lista de autores.
     */
    @GetMapping("/autores")
    @CrossOrigin(origins = "http://localhost:3000")
    public ArrayList<Author> getAuthors(){
        return dataService.getAuthors();
    }

    /**
     * Metodo que retorna la lista entera de Song de la clase principal LSR
     * @return Una lista de canciones
     */
    @GetMapping("/canciones")
    @CrossOrigin(origins = "http://localhost:3000")
    public ArrayList<Song> getSongs(){
        System.out.println("obteniendo canciones");
        return dataService.getSongs();
    }

    /**
     * Metodo que va retorna todas la canciones que tengan al menos alguna coincidencia
     * con los parametros de busqueda
     * @param query Parametro(s) de busqueda
     * @return ArrayList Con todas las canciones que cumplan el criterio
     */
    @GetMapping("/buscar/cancionesOR")
    @CrossOrigin(origins = "http://localhost:3000")
    public ArrayList<Song> searchSongs(@RequestParam String query){
        System.out.println("Buscando canciones" + query);
        return dataService.searchSongsOR(query);
    }

    /**
     *Metodo que va retorna todas la canciones que tengan coincidencia
     *con TODOS los parametros de busqueda
     *@param query Parametro(s) de busqueda
     *@return ArrayList Con todas las canciones que cumplan el criterio
     */
    @GetMapping("/buscar/cancionesAND")
    @CrossOrigin(origins = "http://localhost:3000")
    public ArrayList<Song> searchSongsAND(@RequestParam String query){
        return dataService.searchSongsAND(query);
    }


    /**
     *Metodo que va retorna todas la canciones que tengan coincidencia
     *con TODOS o alguno de los parametros de busqueda
     *@param query Parametro(s) de busqueda
     *@return ArrayList Con todas las canciones que cumplan el criterio
     */
    @GetMapping("/buscar/cancionesAND&OR")
    @CrossOrigin(origins = "http://localhost:3000")
    public ArrayList<Song> searchSongsANDOR(@RequestParam String query){
        return dataService.searchSongsANDOR(query);
    }



}

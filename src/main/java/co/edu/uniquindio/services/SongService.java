package co.edu.uniquindio.services;

import co.edu.uniquindio.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class to manage song-related operations.
 */
@Service
public class SongService {

    private final LSRService lsrService;

    /**
     * Constructor to autowire the LSRService dependency.
     *
     * @param lsrService the LSRService instance to be injected
     */
    @Autowired
    public SongService(LSRService lsrService) {
        this.lsrService = lsrService;
    }

    /**
     * Creates a new song instance with predefined attributes.
     *
     * @return a new Song object with predefined attributes
     */
    public Song createSong() {
        return Song.builder()
                .code("1")
                .songName("La PI canción")
                .album(null)
                .time("74") // Tiempo en segundos
                .url("https://www.youtube.com/watch?v=3HRkKznJoZA&ab_channel=AsapSCIENCE")
                .genre(Song.Genre.POP)
                .author(null)
                .build();
    }

    /**
     * Saves a song to the LSR service.
     *
     * @param song the Song object to be saved
     */
    public void saveSong(Song song) {
        lsrService.guardarCancion(song);
        System.out.println("Song saved: " + song.getSongName());
    }

    /**
     * Deletes a song from the LSR service.
     *
     * @param song the Song object to be deleted
     */
    public void deleteSong(Song song) {
        // Implementation needed
    }
}

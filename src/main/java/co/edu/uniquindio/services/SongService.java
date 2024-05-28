package co.edu.uniquindio.services;

import co.edu.uniquindio.Repositories.SongRepository;
import co.edu.uniquindio.model.Exceptions.AuthorException;
import co.edu.uniquindio.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class to manage song-related operations.
 */
@Service
public class SongService {

    private final SongRepository songRepository;

    private static Services services= Services.getInstance();


    @Autowired
    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
        sendSongsToLsr();
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
    /**
     * Adds a song to an author's list of songs.
     *
     * @param author the name of the author
     * @param song the Song object to be added
     * @throws RuntimeException if the author is not found
     */
    public void addSongToAuthor(String author, Song song) {
        try {
            services.addSongToAuthor(author, song);
            songRepository.save(song);
        } catch (AuthorException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendSongsToLsr(){
        services.recibirCanciones(songRepository.findAll());
    }
}

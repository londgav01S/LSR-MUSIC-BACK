package co.edu.uniquindio.services;

import co.edu.uniquindio.model.Song;
import org.springframework.stereotype.Service;

@Service
public class SongService {

    public Song creteSong(){
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

    public void saveSong(Song song) {
        System.out.println("Song saved: " + song.getSongName());
    }
}

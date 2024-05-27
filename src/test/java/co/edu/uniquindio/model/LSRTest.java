package co.edu.uniquindio.model;

import co.edu.uniquindio.model.Exceptions.UsuarioException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LSRTest {

    private LSR lsr;

    @BeforeEach
    void setUp() {
        lsr = new LSR();
    }

    @Test
    void addUser() {
        User user1 = new User();
        user1.setUsername("John Doe");
        User user2 = new User();
        user2.setUsername("Jane Doe");

        // Test adding a new user
        assertDoesNotThrow(() -> lsr.addUser(user1));
        assertEquals(user1, lsr.getLstUsers().get(user1.getUsername()));

        // Test adding a duplicate user
        assertThrows(UsuarioException.class, () -> lsr.addUser(user1));

        // Test adding another new user
        assertDoesNotThrow(() -> lsr.addUser(user2));
        assertEquals(user2, lsr.getLstUsers().get(user2.getUsername()));
    }

    @Test
    void addSongToUser() {
        User user = new User();
        user.setUsername("John Doe");
        Song song = new Song();
        song.setCode("001");
        song.setSongName("Hit Song");
        lsr.getLstUsers().put(user.getUsername(), user);

        lsr.login(user.getUsername(), "password");

        ArrayList<Song> songs = lsr.addSongToUser(song);
        assertTrue(songs.contains(song));
        assertEquals(1, songs.size());
        assertEquals(song, songs.get(0));
    }

    @Test
    void addSongToArtist() {
        Author author = new Author();
        author.setName("Famous Artist");
        Song song = new Song();
        song.setCode("001");
        song.setSongName("Hit Song");
        lsr.getLstAuthors().insert(author);

        lsr.addSongToArtist(author.getName(), song);

        Author foundAuthor = lsr.getLstAuthors().find(author);
        assertNotNull(foundAuthor);
        assertTrue(foundAuthor.getListSongs().contains(song));
        assertEquals(1, foundAuthor.getListSongs().size());
        assertEquals(song, foundAuthor.getListSongs().get(0));
    }

    @Test
    void searchSongByCode() {
        Author author = new Author();
        author.setName("Famous Artist");
        Song song1 = new Song();
        song1.setCode("001");
        song1.setSongName("Hit Song 1");
        Song song2 = new Song();
        song2.setCode("002");
        song2.setSongName("Hit Song 2");
        author.addSong(song1);
        author.addSong(song2);
        lsr.getLstAuthors().insert(author);

        Song foundSong1 = lsr.searchSongByCode("001");
        Song foundSong2 = lsr.searchSongByCode("002");
        Song notFoundSong = lsr.searchSongByCode("003");

        assertEquals(song1, foundSong1);
        assertEquals(song2, foundSong2);
        assertNull(notFoundSong);
    }
}
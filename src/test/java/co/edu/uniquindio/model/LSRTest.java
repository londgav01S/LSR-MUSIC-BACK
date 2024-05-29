package co.edu.uniquindio.model;

import co.edu.uniquindio.model.Exceptions.UsuarioException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
    void addSongToUser() throws UsuarioException {
        User user = new User();
        user.setUsername("John Doe");
        Song song = new Song();
        song.setCode("001");
        song.setSongName("Hit Song");
        lsr.getLstUsers().put(user.getUsername(), user);

        lsr.login(user.getUsername(), "password");

        List<Song> songs = lsr.addSongToUser(song);
        assertTrue(songs.contains(song));
        assertEquals(1, songs.size());
        assertEquals(song, songs.get(0));
    }
}
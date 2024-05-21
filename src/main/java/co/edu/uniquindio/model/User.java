package co.edu.uniquindio.model;

import co.edu.uniquindio.model.estructurasDeDatos.List.RoundList;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends Persistence {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Setter(value = AccessLevel.PRIVATE)
    @EqualsAndHashCode.Include
    private String username;//The username shall NOT be repeated
    private String password;
    private String mail;

    @ToString.Exclude
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Song> songs = new ArrayList<>();  // Persisted as a List

    @Transient
    private RoundList<Song> roundSongs; // Application logic

    @ManyToOne
    private LSR lsr;


    @Builder
    public User(String username, String password, String mail) {
        super();
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.songs = new ArrayList<>();
        this.roundSongs = new RoundList<>();
    }

    @PostLoad
    private void initializeRoundList() {
        this.roundSongs = new RoundList<>();
        this.roundSongs.addAll(this.songs);
    }

    public ArrayList<Song> getListofSongs(){
        return new ArrayList<>(songs);
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }
}

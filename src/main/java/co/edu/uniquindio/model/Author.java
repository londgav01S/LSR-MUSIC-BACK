package co.edu.uniquindio.model;

import co.edu.uniquindio.model.estructurasDeDatos.List.DoubleLinkedList;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Setter
@Getter
@Table(name = "author")
public class Author extends Persistence implements Comparable<Author>{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String code;

    @Getter
    @Setter(value = AccessLevel.PRIVATE)
    @EqualsAndHashCode.Include
    private String name;//The name of the author shall NOT be repeated
    private String nationality;
    private boolean isGroup;

    @ToString.Exclude
    private String photo;

    @ToString.Exclude
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Song> listSongs = new ArrayList<>(); // Persisted as a List



    @Transient
    private DoubleLinkedList<Song> songs;

    @Builder
    public Author(String code, String name, String nationality, Boolean isGroup, String photo) {
        this.code = code;
        this.name = name;
        this.nationality = nationality;
        this.isGroup = isGroup;
        this.photo = photo;
        this.songs = new DoubleLinkedList<Song>();
    }

    @Builder
    public Author() {}

    @Override
    public int compareTo(Author o) {
        return o.name.compareTo(this.name);
    }


    public void addSong(Song song) {
        Objects.requireNonNull(song);
        songs.addTail(song);
        listSongs.add(song);
    }

    private boolean verifySong(Song song) {
        for (Song eachSong : songs) {
            if (eachSong.equals(song)) {
                return true;
            }
        }
        return false;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @PostLoad
    private void initializeDoubleLinkedList() {
        if (this.songs == null) {
            this.songs = new DoubleLinkedList<>();
        }
        if (this.listSongs != null) {
            this.songs.addAll(this.songs);
        }
    }

}

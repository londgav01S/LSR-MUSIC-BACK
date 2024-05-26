package co.edu.uniquindio.model;

<<<<<<< HEAD
import jakarta.persistence.*;

public class Author {
=======
import co.edu.uniquindio.model.estructurasDeDatos.List.DoubleLinkedList;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "author")
public class Author extends Persistence implements Comparable<Author>{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String code;

    @Setter(value = AccessLevel.PRIVATE)
    @EqualsAndHashCode.Include
    private String name;//The name of the author shall NOT be repeated
    private String nationality;
    private boolean isGroup;

    @ToString.Exclude
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Song> ListSongs = new ArrayList<>(); // Persisted as a List

    @Transient
    private DoubleLinkedList<Song> songs;

    @Builder
    public Author(String code, String name, String nationality, Boolean isGroup) {
        this.code = code;
        this.name = name;
        this.nationality = nationality;
        this.isGroup = isGroup;
        this.songs = new DoubleLinkedList<Song>();
    }

    public Author() {}

    @Override
    public int compareTo(Author o) {
        return o.name.compareTo(this.name);
    }
    public boolean addSong(Song song) {
        Objects.requireNonNull(song);
        if (verifySong(song)) return false;
        songs.addTail(song);
        return true;
    }

    private boolean verifySong(Song song) {
        for (Song eachSong : songs) {
            if (eachSong.equals(song)) {
                return true;
            }
        }
        return false;

    }

    @PostLoad
    private void initializeDoubleLinkedList() {
        if (this.songs == null) {
            this.songs = new DoubleLinkedList<>();
        }
        if (this.ListSongs != null) {
            this.songs.addAll(this.songs);
        }
    }
>>>>>>> luis

    private Long id;

    private String code;

    private String name;

    private String nationality;


    private boolean isGroup;



    public Author(String code, String name, String nationality, boolean isGroup) {
        this.code = code;
        this.name = name;
        this.nationality = nationality;
        this.isGroup = isGroup;
    }

    public Author() {

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public boolean isGroup() {
        return isGroup;
    }

    public void setGroup(boolean group) {
        isGroup = group;
    }

}

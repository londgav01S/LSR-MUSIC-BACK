package co.edu.uniquindio.model;

import co.edu.uniquindio.model.estructurasDeDatos.List.DoubleLinkedList;

import lombok.*;

import java.util.Objects;
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Author implements Comparable<Author>{
    private String code;
    @Setter(value = AccessLevel.PRIVATE)
    @EqualsAndHashCode.Include
    private String name;//The name of the author shall NOT be repeated
    private String nationality;
    private boolean isGroup;
    @ToString.Exclude
    private DoubleLinkedList<Song> songs;

    @Builder
    public Author(String code, String name, String nationality, Boolean isGroup) {
        this.code = code;
        this.name = name;
        this.nationality = nationality;
        this.isGroup = isGroup;
        this.songs = new DoubleLinkedList<Song>();
    }
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


}

package co.edu.uniquindio.model;

import co.edu.uniquindio.model.estructurasDeDatos.List.RoundList;
import lombok.*;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class User {
    @Setter(value = AccessLevel.PRIVATE)
    @EqualsAndHashCode.Include
    private String username;//The username shall NOT be repeated
    private String password;
    private String mail;
    @ToString.Exclude
    private RoundList<Song> songs;


    @Builder
    public User(String username, String password, String mail) {
        super();
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.songs = new RoundList<Song>();
    }
}

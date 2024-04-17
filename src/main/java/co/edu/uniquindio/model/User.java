package co.edu.uniquindio.model;

import co.edu.uniquindio.model.estructurasDeDatos.RoundList;

public class User {
    private String username;//The username shall NOT be repeated
    private String password;
    private String mail;
    private RoundList<Song> songs;
}

package co.edu.uniquindio.model;

import co.edu.uniquindio.model.estructurasDeDatos.ListaDoblementeEnlazada;

public class User {
    private String username;//The username shall NOT be repeated
    private String password;
    private String mail;
    private ListaDoblementeEnlazada<Song> songs;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public ListaDoblementeEnlazada<Song> getSongs() {
        return songs;
    }

    public void setSongs(ListaDoblementeEnlazada<Song> songs) {
        this.songs = songs;
    }
}

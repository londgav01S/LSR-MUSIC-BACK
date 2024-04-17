package co.edu.uniquindio.model;

import co.edu.uniquindio.model.estructurasDeDatos.ListaDoblementeEnlazada;

public class Author {
    private String code;
    private String name;//The name of the author shall NOT be repeated
    private String nationality;
    private boolean isGroup;
    private ListaDoblementeEnlazada<Song> songs;


}

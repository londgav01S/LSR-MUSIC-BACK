package co.edu.uniquindio.pruebas;

import co.edu.uniquindio.model.Album;
import co.edu.uniquindio.model.Author;
import co.edu.uniquindio.model.Genre;
import co.edu.uniquindio.model.LSR_Music;

public class TestCrudAlbum {

    public static void main(String[] args) {
        // Crear gestor de álbumes
        LSR_Music lSR_Music = new LSR_Music();

        // Crear algunos álbumes de ejemplo
        Album album1 = new Album("Álbum 1", Genre.ROCK, new Author("A001", "Autor 1", "Nacionalidad 1", false), "2022", "Cover 1");
        Album album2 = new Album("Álbum 2", Genre.POP, new Author("A002", "Autor 2", "Nacionalidad 2", false), "2023", "Cover 2");
        Album album3 = new Album("Álbum 3", Genre.CLASSIC, new Author("A003", "Autor 3", "Nacionalidad 3", false), "2024", "Cover 3");

        // Agregar álbumes al gestor
        lSR_Music.agregarAlbum(album1);
        lSR_Music.agregarAlbum(album2);
        lSR_Music.agregarAlbum(album3);

        // Mostrar todos los álbumes
        System.out.println("=== Todos los álbumes ===");
        lSR_Music.mostrarTodosLosAlbumes();

        // Obtener un álbum por índice
        int indice = 1;
        System.out.println("\n=== Obtener álbum en el índice " + indice + " ===");
        Album albumObtenido = lSR_Music.obtenerAlbumPorIndice(indice);
        System.out.println("Álbum obtenido: " + albumObtenido);

        // Actualizar un álbum
        Album albumActualizado = new Album("Álbum Actualizado", Genre.RAP, new Author("A004", "Autor 4", "Nacionalidad 4", false), "2025", "Cover 4");
        lSR_Music.actualizarAlbum(indice, albumActualizado);
        System.out.println("\n=== Álbum actualizado ===");
        lSR_Music.mostrarTodosLosAlbumes();

        // Eliminar un álbum
        lSR_Music.eliminarAlbumPorIndice(indice);
        System.out.println("\n=== Álbum eliminado ===");
        lSR_Music.mostrarTodosLosAlbumes();
    }
}

package co.edu.uniquindio.pruebas;

import co.edu.uniquindio.model.*;

public class TestCrudCanciones {
    public static void main(String[] args) {
        // Crear un gestor de canciones
        LSR_Music lSR_Music = new LSR_Music();

        // Crear algunos objetos de ejemplo para usar en las canciones




        Author author1 = new Author("123" ,"Author1", "colombia", false );
        Author author2 = new Author("1234" ,"Author2", "colombia", false);


        Album album1 = new Album("hola", Genre.CLASSIC, author1 , "2000", "nose");
        Album album2 = new Album("como estas", Genre.CLASSIC, author2 , "2000", "si se");
        // Crear algunas canciones de ejemplo
        Song cancion1 = new Song("1", "Song 1", album1, "180", "url1", Genre.CLASSIC, author1);
        Song cancion2 = new Song("2", "Song 2", album1, "240", "url2", Genre.PUNK, author2);
        Song cancion3 = new Song("3", "Song 3", album2, "200", "url3", Genre.OTHER, author2);

        // Agregar canciones al gestor
        lSR_Music.agregarCancion(cancion1);
        lSR_Music.agregarCancion(cancion2);
        lSR_Music.agregarCancion(cancion3);

        // Mostrar todas las canciones
        System.out.println("Lista de todas las canciones:");
        lSR_Music.mostrarTodasLasCanciones();

        // Actualizar una canción
        Song cancionActualizada = new Song("2", "Updated Song 2", album2, "250", "new_url2", Genre.RAP, author1);
        lSR_Music.actualizarCancion(1, cancionActualizada);

        // Mostrar todas las canciones después de la actualización
        System.out.println("\nLista después de actualizar una canción:");
        lSR_Music.mostrarTodasLasCanciones();

        // Buscar una canción por su código
        Song encontrada = lSR_Music.buscarCancionPorCodigo("1");
        if (encontrada != null) {
            System.out.println("\nCanción encontrada con código '1': " + encontrada.getSongName());
        } else {
            System.out.println("\nNo se encontró la canción con el código '1'");
        }


        // Eliminar una canción directamente usando el objeto
        lSR_Music.eliminarCancion(encontrada);

        // Mostrar todas las canciones después de eliminar por objeto
        System.out.println("\nLista después de eliminar la canción actualizada:");
        lSR_Music.mostrarTodasLasCanciones();
    }
}

package co.edu.uniquindio.model;


import co.edu.uniquindio.model.estructurasDeDatos.ListaDoblementeEnlazada;
import co.edu.uniquindio.model.estructurasDeDatos.NodoDoble;
import jakarta.persistence.*;

import java.io.Serializable;


public class LSR_Music <T> implements Serializable {
   private Long id;

    private String name;


    public LSR_Music(String name) {
        this.name = name;
    }
    public LSR_Music() {

    }

    ///////////////////////////////////////////////////////
    //Listas
    private ListaDoblementeEnlazada <Song> listaCanciones = new ListaDoblementeEnlazada<>();
    private ListaDoblementeEnlazada<Author> listaAutores = new ListaDoblementeEnlazada<>();
    private ListaDoblementeEnlazada<Album> listaAlbumes = new ListaDoblementeEnlazada<>();

    private ListaDoblementeEnlazada<User> listaUsuarios = new ListaDoblementeEnlazada<>();

 ///////////////////////////////////////////////////////



 // Crear (Agregar) una nueva canción a la lista
 public void agregarCancion(Song nuevaCancion) {
  // Crear un nuevo nodo y añadirlo al final de la lista
  NodoDoble<Song> nuevoNodo = new NodoDoble<>(nuevaCancion);

  if (listaCanciones.estaVacia()) {
   listaCanciones.setNodoPrimero(nuevoNodo);
   listaCanciones.setNodoUltimo(nuevoNodo);
  } else {
   NodoDoble<Song> ultimoNodo = listaCanciones.getNodoUltimo();
   ultimoNodo.setSiguienteNodo(nuevoNodo);
   nuevoNodo.setAnteriorNodo(ultimoNodo);
   listaCanciones.setNodoUltimo(nuevoNodo);
  }

  listaCanciones.setTamanio(listaCanciones.getTamanio() + 1);
 }

 // Leer (Obtener) todas las canciones
 public void mostrarTodasLasCanciones() {
  listaCanciones.imprimirLista();
 }

 // Leer (Obtener) una canción por su índice
 public Song obtenerCancionPorIndice(int indice) {
  return listaCanciones.obtener(indice);
 }

 // Actualizar una canción en la lista dada su posición
 public void actualizarCancion(int indice, Song nuevaCancion) {
  listaCanciones.modificarNodo(indice, nuevaCancion);
 }

 // Eliminar una canción dado su índice
 public void eliminarCancionPorIndice(int indice) {
  Song cancion = listaCanciones.obtener(indice);

  if (cancion != null) {
   listaCanciones.eliminar(cancion);
  } else {
   throw new RuntimeException("No se encontró la canción en el índice especificado.");
  }
 }

 // Eliminar una canción dado su objeto (mediante comparación)
 public void eliminarCancion(Song cancion) {
  listaCanciones.eliminar(cancion);
 }

 // Buscar la posición de una canción específica
 public int buscarCancion(Song cancion) {
  return listaCanciones.obtenerPosicionNodo(cancion);
 }

 // Buscar una canción por su código
 public Song buscarCancionPorCodigo(String codigo) {
  for (int i = 0; i < listaCanciones.getTamanio(); i++) {
   Song cancion = listaCanciones.obtener(i);
   if (cancion != null && cancion.getCode().equals(codigo)) {
    return cancion;
   }
  }
  return null; // Retorna null si no se encuentra la canción
 }

 // Método para buscar una canción por nombre (ignorando mayúsculas/minúsculas)
 public Song buscarCancionPorNombre(String nombre) {
  for (int i = 0; i < listaCanciones.getTamanio(); i++) {
   Song cancion = listaCanciones.obtener(i);
   if (cancion != null && cancion.getSongName().equalsIgnoreCase(nombre)) {
    return cancion;
   }
  }
  return null; // Retorna null si no se encuentra la canción
 }

 // Método para eliminar una canción por nombre
 public void eliminarCancionPorNombre(String nombre) {
  Song cancion = buscarCancionPorNombre(nombre);
  if (cancion != null) {
   listaCanciones.eliminar(cancion);
  } else {
   throw new RuntimeException("No se encontró la canción con el nombre especificado.");
  }
 }


 //Fin de CRUD para Song
 ////////////////////////////////////////////////////////////////////////////////////////777
 //Inicio crud Author

 // Crear (Agregar) un nuevo autor a la lista
 public void agregarAutor(Author nuevoAutor) {
  // Crear un nuevo nodo y añadirlo al final de la lista
  NodoDoble<Author> nuevoNodo = new NodoDoble<>(nuevoAutor);

  if (listaAutores.estaVacia()) {
   listaAutores.setNodoPrimero(nuevoNodo);
   listaAutores.setNodoUltimo(nuevoNodo);
  } else {
   NodoDoble<Author> ultimoNodo = listaAutores.getNodoUltimo();
   ultimoNodo.setSiguienteNodo(nuevoNodo);
   nuevoNodo.setAnteriorNodo(ultimoNodo);
   listaAutores.setNodoUltimo(nuevoNodo);
  }

  listaAutores.setTamanio(listaAutores.getTamanio() + 1);
 }

 // Leer (Obtener) todos los autores
 public void mostrarTodosLosAutores() {
  listaAutores.imprimirLista();
 }


 // Buscar la posición de un autor específico por su nombre
 public int buscarAutorPorNombre(String nombre) {
  for (int i = 0; i < listaAutores.getTamanio(); i++) {
   Author autor = listaAutores.obtener(i);
   if (autor != null && autor.getName().equalsIgnoreCase(nombre)) {
    return i;
   }
  }
  return -1; // Retorna -1 si no se encuentra el autor
 }


 // Leer (Obtener) un autor por su índice
 public Author obtenerAutorPorIndice(int indice) {
  return listaAutores.obtener(indice);
 }

 // Actualizar un autor en la lista dada su posición
 public void actualizarAutor(int indice, Author nuevoAutor) {
  listaAutores.modificarNodo(indice, nuevoAutor);
 }

 public void eliminarAutorPorNombre(String nombre) {
  int indice = buscarAutorPorNombre(nombre);
  if (indice != -1) {
   listaAutores.eliminarPorIndice(indice);

  } else {
   throw new RuntimeException("No se encontró el autor con el nombre especificado.");
  }
 }


 public void actualizarAutorPorNombre(String nombre, Author nuevoAutor) {
  int indice = buscarAutorPorNombre(nombre);
  if (indice != -1) {
   listaAutores.modificarNodo(indice, nuevoAutor);
  } else {
   throw new RuntimeException("No se encontró el autor con el nombre especificado.");
  }
 }


 // Eliminar un autor dado su índice
 public void eliminarAutorPorIndice(int indice) {
  listaAutores.eliminarPorIndice(indice);
 }

 // Eliminar un autor dado su objeto (mediante comparación)
 public void eliminarAutor(Author autor) {
  listaAutores.eliminar(autor);
 }

 // Buscar la posición de un autor específico por su código
 public int buscarAutorPorCodigo(String codigo) {
  for (int i = 0; i < listaAutores.getTamanio(); i++) {
   Author autor = listaAutores.obtener(i);
   if (autor != null && autor.getCode().equals(codigo)) {
    return i;
   }
  }
  return -1; // Retorna -1 si no se encuentra el autor
 }
 // Fin CRUd Author
 //////////////////////////////////////////////////////////////

 //Inicio CRUD album
 // Crear (Agregar) un nuevo álbum a la lista
 public void agregarAlbum(Album nuevoAlbum) {
  listaAlbumes.agregar(nuevoAlbum);
 }

 // Leer (Obtener) todos los álbumes
 public void mostrarTodosLosAlbumes() {
  listaAlbumes.imprimirLista();
 }

 // Leer (Obtener) un álbum por su índice
 public Album obtenerAlbumPorIndice(int indice) {
  return listaAlbumes.obtener(indice);
 }

 // Actualizar un álbum en la lista dada su posición
 public void actualizarAlbum(int indice, Album nuevoAlbum) {
  listaAlbumes.modificarNodo(indice, nuevoAlbum);
 }

 // Eliminar un álbum dado su índice
 public void eliminarAlbumPorIndice(int indice) {
  listaAlbumes.eliminarPorIndice(indice);
 }

 // Eliminar un álbum dado su objeto (mediante comparación)
 public void eliminarAlbum(Album album) {
  listaAlbumes.eliminar(album);
 }

 // Buscar la posición de un álbum específico por su nombre
 public int buscarAlbumPorNombre(String nombre) {
  for (int i = 0; i < listaAlbumes.getTamanio(); i++) {
   Album album = listaAlbumes.obtener(i);
   if (album != null && album.getAlbumName().equalsIgnoreCase(nombre)) {
    return i;
   }
  }
  return -1; // Retorna -1 si no se encuentra el álbum
 }

 //Fin CRUD Album
 ////////////////////////////////////////////////////////

 //Inicio CRUD User

 // Crear (Agregar) un nuevo usuario a la lista
 public void agregarUsuario(User nuevoUsuario) {
  if (!existeUsuario(nuevoUsuario.getUsername())) {
   listaUsuarios.agregar(nuevoUsuario);
  } else {
   throw new RuntimeException("El nombre de usuario ya está en uso.");
  }
 }

 // Leer (Obtener) todos los usuarios
 public void mostrarTodosLosUsuarios() {
  listaUsuarios.imprimirLista();
 }

 // Leer (Obtener) un usuario por su nombre de usuario
 public User obtenerUsuarioPorNombre(String nombreUsuario) {
  for (int i = 0; i < listaUsuarios.getTamanio(); i++) {
   User usuario = listaUsuarios.obtener(i);
   if (usuario != null && usuario.getUsername().equals(nombreUsuario)) {
    return usuario;
   }
  }
  return null; // Retorna null si no se encuentra el usuario
 }

 // Actualizar un usuario en la lista
 public void actualizarUsuario(String nombreUsuario, User nuevoUsuario) {
  int indice = buscarUsuarioPorNombre(nombreUsuario);
  if (indice != -1) {
   listaUsuarios.modificarNodo(indice, nuevoUsuario);
  } else {
   throw new RuntimeException("El usuario no existe.");
  }
 }

 // Eliminar un usuario por su nombre de usuario
 public void eliminarUsuarioPorNombre(String nombreUsuario) {
  int indice = buscarUsuarioPorNombre(nombreUsuario);
  if (indice != -1) {
   listaUsuarios.eliminarPorIndice(indice);
  } else {
   throw new RuntimeException("El usuario no existe.");
  }
 }

 // Método auxiliar para verificar si un usuario ya existe en la lista
 private boolean existeUsuario(String nombreUsuario) {
  return buscarUsuarioPorNombre(nombreUsuario) != -1;
 }

 // Método auxiliar para buscar la posición de un usuario por su nombre de usuario
 private int buscarUsuarioPorNombre(String nombreUsuario) {
  for (int i = 0; i < listaUsuarios.getTamanio(); i++) {
   User usuario = listaUsuarios.obtener(i);
   if (usuario != null && usuario.getUsername().equals(nombreUsuario)) {
    return i;
   }
  }
  return -1; // Retorna -1 si no se encuentra el usuario
 }

}

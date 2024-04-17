package co.edu.uniquindio.model.estructurasDeDatos;

public class ListaDoblementeEnlazada<T> {
    private NodoDobleEnlazado<T> primero;
    private NodoDobleEnlazado<T> ultimo;
    private int tamano;

    public ListaDoblementeEnlazada() {

        this.primero = null;
        this.ultimo = null;
        this.tamano = 0;
    }

    public void agregar(T cancion) {
        NodoDobleEnlazado<T> nuevo = new NodoDobleEnlazado<>(cancion);
        if (primero == null) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.setSiguiente(nuevo);
            nuevo.setAnterior(ultimo);
            ultimo = nuevo;
        }
        tamano++;
    }

    public void eliminar(T cancion) {
        NodoDobleEnlazado<T> actual = primero;
        NodoDobleEnlazado<T> anterior = null;
        while (actual != null) {
            if (actual.getCancion().equals(cancion)) {
                if (anterior == null) {
                    primero = actual.getSiguiente();
                    primero.setAnterior(null);
                } else {
                    anterior.setSiguiente(actual.getSiguiente());
                    if (actual.getSiguiente() != null) {
                        actual.getSiguiente().setAnterior(anterior);
                    }
                }
                tamano--;
                return;
            }
            anterior = actual;
            actual = actual.getSiguiente();
        }
    }

    public NodoDobleEnlazado<T> getPrimero() {
        return primero;
    }

    public void setPrimero(NodoDobleEnlazado<T> primero) {
        this.primero = primero;
    }

    public NodoDobleEnlazado<T> getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoDobleEnlazado<T> ultimo) {
        this.ultimo = ultimo;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }


}

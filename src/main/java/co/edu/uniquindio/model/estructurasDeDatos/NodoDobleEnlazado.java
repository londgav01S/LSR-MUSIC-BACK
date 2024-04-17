package co.edu.uniquindio.model.estructurasDeDatos;

public class NodoDobleEnlazado<T>{
    private T cancion;
    private NodoDobleEnlazado<T> siguiente;
    private NodoDobleEnlazado<T> anterior;

    public NodoDobleEnlazado(T cancion){
        this.cancion = cancion;
        this.siguiente = null;
        this.anterior = null;
    }

    public T getCancion() {
        return cancion;
    }

    public void setCancion(T cancion) {
        this.cancion = cancion;
    }

    public NodoDobleEnlazado<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDobleEnlazado<T> siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDobleEnlazado<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDobleEnlazado<T> anterior) {
        this.anterior = anterior;
    }
}

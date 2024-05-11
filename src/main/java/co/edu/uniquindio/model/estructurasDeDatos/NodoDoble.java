package co.edu.uniquindio.model.estructurasDeDatos;

public class NodoDoble<T>{
    private T elemento;
    private NodoDoble<T> siguienteNodo;
    private NodoDoble<T> anteriorNodo;

    public NodoDoble(T elemento){
        this.elemento = elemento;
        this.siguienteNodo = null;
        this.anteriorNodo = null;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }



    public NodoDoble<T> getSiguienteNodo() {
        return siguienteNodo;
    }

    public void setSiguienteNodo(NodoDoble<T> siguienteNodo) {
        this.siguienteNodo = siguienteNodo;
    }

    public NodoDoble<T> getAnteriorNodo() {
        return anteriorNodo;
    }

    public void setAnteriorNodo(NodoDoble<T> anteriorNodo) {
        this.anteriorNodo = anteriorNodo;
    }
}

package co.edu.uniquindio.model.estructurasDeDatos;

public class RoundList <T>{
    private NodoDobleEnlazado<T> primero;
    private NodoDobleEnlazado<T> ultimo;
    private int size;

    public RoundList(){
        this.primero = null;
        this.ultimo = null;
        this.size = 0;
    }

    public void add(T cancion){
        NodoDobleEnlazado<T> nuevo = new NodoDobleEnlazado<>(cancion);
        if(primero == null){
            primero = nuevo;
            ultimo = nuevo;
            primero.setSiguiente(primero);
            primero.setAnterior(ultimo);
            ultimo.setSiguiente(primero);
            ultimo.setAnterior(ultimo);
        }else{
            ultimo.setSiguiente(nuevo);
            nuevo.setAnterior(ultimo);
            nuevo.setSiguiente(primero);
            primero.setAnterior(nuevo);
            ultimo = nuevo;
        }
        size++;
    }

    public void remove(T cancion){
        NodoDobleEnlazado<T> actual = primero;
        for(int i = 0; i < size; i++){
            if(actual.getCancion().equals(cancion)){
                if(actual == primero){
                    primero = primero.getSiguiente();
                    ultimo.setSiguiente(primero);
                    primero.setAnterior(ultimo);
                }else if(actual == ultimo){
                    ultimo = ultimo.getAnterior();
                    ultimo.setSiguiente(primero);
                    primero.setAnterior(ultimo);
                }else{
                    actual.getAnterior().setSiguiente(actual.getSiguiente());
                    actual.getSiguiente().setAnterior(actual.getAnterior());
                }
                size--;
                break;
            }
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

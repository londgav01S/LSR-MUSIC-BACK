package co.edu.uniquindio.model.estructurasDeDatos;

public class RoundList <T>{
    private NodoDoble<T> primero;
    private NodoDoble<T> ultimo;
    private int size;

    public RoundList(){
        this.primero = null;
        this.ultimo = null;
        this.size = 0;
    }

    public void add(T cancion){
        NodoDoble<T> nuevo = new NodoDoble<>(cancion);
        if(primero == null){
            primero = nuevo;
            ultimo = nuevo;
            primero.setSiguienteNodo(primero);
            primero.setAnteriorNodo(ultimo);
            ultimo.setSiguienteNodo(primero);
            ultimo.setAnteriorNodo(ultimo);
        }else{
            ultimo.setSiguienteNodo(nuevo);
            nuevo.setAnteriorNodo(ultimo);
            nuevo.setSiguienteNodo(primero);
            primero.setAnteriorNodo(nuevo);
            ultimo = nuevo;
        }
        size++;
    }

    public void remove(T cancion){
        NodoDoble<T> actual = primero;
        for(int i = 0; i < size; i++){
            if(actual.getElemento().equals(cancion)){
                if(actual == primero){
                    primero = primero.getSiguienteNodo();
                    ultimo.setSiguienteNodo(primero);
                    primero.setAnteriorNodo(ultimo);
                }else if(actual == ultimo){
                    ultimo = ultimo.getAnteriorNodo();
                    ultimo.setSiguienteNodo(primero);
                    primero.setAnteriorNodo(ultimo);
                }else{
                    actual.getAnteriorNodo().setSiguienteNodo(actual.getSiguienteNodo());
                    actual.getSiguienteNodo().setAnteriorNodo(actual.getAnteriorNodo());
                }
                size--;
                break;
            }
            actual = actual.getSiguienteNodo();
        }
    }

    public NodoDoble<T> getPrimero() {
        return primero;
    }

    public void setPrimero(NodoDoble<T> primero) {
        this.primero = primero;
    }

    public NodoDoble<T> getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoDoble<T> ultimo) {
        this.ultimo = ultimo;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

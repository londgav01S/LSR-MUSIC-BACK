package co.edu.uniquindio.model.estructurasDeDatos;

import java.util.Iterator;

public class ListaDoblementeEnlazada<T> {
    private NodoDoble<T> nodoPrimero;
    private NodoDoble<T> nodoUltimo;
    private int tamanio;

    public ListaDoblementeEnlazada() {

        this.nodoPrimero = null;
        this.nodoUltimo = null;
        this.tamanio = 0;
    }



    /**
     * Borra completamente la Lista
     */
    public void borrarLista() {
        nodoPrimero = nodoUltimo = null;
        tamanio = 0;
    }

    public void eliminarPorIndice(int indice) {
        if (indice < 0 || indice >= tamanio) {
            throw new IndexOutOfBoundsException("Índice fuera de los límites de la lista.");
        }

        NodoDoble<T> nodoActual = nodoPrimero;
        for (int i = 0; i < indice; i++) {
            nodoActual = nodoActual.getSiguienteNodo();
        }

        if (nodoActual == nodoPrimero) {
            nodoPrimero = nodoActual.getSiguienteNodo();
            if (nodoPrimero != null) {
                nodoPrimero.setAnteriorNodo(null);
            } else {
                nodoUltimo = null; // La lista quedó vacía
            }
        } else if (nodoActual == nodoUltimo) {
            nodoUltimo = nodoActual.getAnteriorNodo();
            nodoUltimo.setSiguienteNodo(null);
        } else {
            NodoDoble<T> anterior = nodoActual.getAnteriorNodo();
            NodoDoble<T> siguiente = nodoActual.getSiguienteNodo();
            anterior.setSiguienteNodo(siguiente);
            siguiente.setAnteriorNodo(anterior);
        }

        tamanio--;
    }

    //Obtener Nodo el valor de un Nodo
    public T obtenerValorNodo(int indice) {

        NodoDoble<T> nodoTemporal = null;
        int contador = 0;

        if (indiceValido(indice)) {
            nodoTemporal = nodoPrimero;

            while (contador < indice) {

                nodoTemporal = nodoTemporal.getSiguienteNodo();
                contador++;
            }
        }

        if (nodoTemporal != null)
            return nodoTemporal.getElemento();
        else
            return null;
    }


    //Verificar si indice es valido
    private boolean indiceValido(int indice) {
        if (indice >= 0 && indice < tamanio) {
            return true;
        }
        throw new RuntimeException("�ndice no v�lido");
    }


    //Verificar si la lista esta vacia
    public boolean estaVacia() {
        //		return(nodoPrimero == null)?true:false;
        return nodoPrimero == null && nodoUltimo == null;
    }


    /**
     * Imprime en consola la lista enlazada
     */
    public void imprimirLista() {

        NodoDoble<T> aux = nodoPrimero;

        while (aux != null) {
            System.out.print(aux.getElemento() + "\t");
            aux = aux.getSiguienteNodo();
        }

        System.out.println();
    }

    public void imprimirAtras() {

        for (NodoDoble<T> aux = nodoUltimo; aux != null; aux = aux.getAnteriorNodo()) {
            System.out.print(aux.getElemento().toString() + "\t");
        }
        System.out.println();

    }


    //Eliminar dado el valor de un nodo

    /**
     * Elimina un elemento de la lista
     *
     * @param dato dato a eliminar
     * @return El dato que se elimina
     */
    public T eliminar(T dato) {

        NodoDoble<T> nodo = buscarNodo(dato);

        if (nodo != null) {

            NodoDoble<T> previo = nodo.getAnteriorNodo();
            NodoDoble<T> siguiente = nodo.getSiguienteNodo();

            if (previo == null) {
                nodoPrimero = siguiente;
            } else {
                previo.setSiguienteNodo(siguiente);
            }

            if (siguiente == null) {
                nodoUltimo = previo;
            } else {
                siguiente.setAnteriorNodo(previo);
            }

            nodo = null;
            tamanio--;

            return dato;
        }

        throw new RuntimeException("El valor no existe");
    }
    public void agregar(T nuevoElemento) {
        NodoDoble<T> nuevoNodo = new NodoDoble<>(nuevoElemento);

        if (estaVacia()) {
            nodoPrimero = nuevoNodo;
            nodoUltimo = nuevoNodo;
        } else {
            nodoUltimo.setSiguienteNodo(nuevoNodo);
            nuevoNodo.setAnteriorNodo(nodoUltimo);
            nodoUltimo = nuevoNodo;
        }

        tamanio++;
    }

    //Elimina el primer nodo de la lista
    public T eliminarPrimero() {

        if (!estaVacia()) {
            NodoDoble<T> nodoAux = nodoPrimero;
            T valor = nodoAux.getElemento();
            nodoPrimero = nodoAux.getSiguienteNodo();

            if (nodoPrimero == null) {
                nodoUltimo = null;
            } else {
                nodoPrimero.setAnteriorNodo(null);
            }

            tamanio--;
            return valor;
        }

        throw new RuntimeException("Lista vac�a");
    }


    public T eliminarUltimo() {

        if (!estaVacia()) {
            T valor = nodoUltimo.getElemento();
            NodoDoble<T> prev = obtenerNodo(tamanio - 2);
            nodoUltimo = prev;

            if (nodoUltimo == null) {
                nodoPrimero = null;
            } else {
                prev.setSiguienteNodo(null);
            }

            tamanio--;
            return valor;
        }

        throw new RuntimeException("Lista vac�a");
    }


    /**
     * Devuelve el Nodo de una lista dada su posici�n
     *
     * @param indice �ndice para obtener el Nodo
     * @return Nodo objeto
     */
    private NodoDoble<T> obtenerNodo(int indice) {

        if (indice >= 0 && indice < tamanio) {

            NodoDoble<T> nodo = nodoPrimero;

            for (int i = 0; i < indice; i++) {
                nodo = nodo.getSiguienteNodo();
            }

            return nodo;
        }

        return null;
    }

    /**
     * Devuelve un nodo que contenga un dato espec�fico
     *
     * @param dato Dato a buscar
     * @return Nodo
     */
    private NodoDoble<T> buscarNodo(T dato) {

        NodoDoble<T> aux = nodoPrimero;

        while (aux != null) {
            if (aux.getElemento().equals(dato)) {
                return aux;
            }
            aux = aux.getSiguienteNodo();
        }

        return null;
    }


    /**
     * Cambia el valor de un nodo dada su posici�n en la lista
     *
     * @param indice posici�n donde se va a cambiar el dato
     * @param nuevo  nuevo valor por el que se actualizar� el nodo
     */
    public void modificarNodo(int indice, T nuevo) {

        if (indiceValido(indice)) {
            NodoDoble<T> nodo = obtenerNodo(indice);
            nodo.setElemento(nuevo);
        }

    }


    /**
     * Retorna la primera posici�n donde est� guardado el dato
     *
     * @param dato valor a buscar dentro de la lista
     * @return primera posici�n del dato
     */
    public int obtenerPosicionNodo(T dato) {

        int i = 0;

        for (NodoDoble<T> aux = nodoPrimero; aux != null; aux = aux.getSiguienteNodo()) {
            if (aux.getElemento().equals(dato)) {
                return i;
            }
            i++;
        }

        return -1;
    }


    /**
     * Devuelve un elemento de la lista dado su �ndice
     *
     * @param indice �ndice de la lista
     * @return dato guardado en el �ndice especificado
     */
    public T obtener(int indice) {

        if (indiceValido(indice)) {
            NodoDoble<T> n = obtenerNodo(indice);

            if (n != null) {
                return n.getElemento();
            }
        }

        return null;
    }

    public NodoDoble<T> getNodoPrimero() {
        return nodoPrimero;
    }

    public void setNodoPrimero(NodoDoble<T> nodoPrimero) {
        this.nodoPrimero = nodoPrimero;
    }

    public NodoDoble<T> getNodoUltimo() {
        return nodoUltimo;
    }

    public void setNodoUltimo(NodoDoble<T> nodoUltimo) {
        this.nodoUltimo = nodoUltimo;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }
}

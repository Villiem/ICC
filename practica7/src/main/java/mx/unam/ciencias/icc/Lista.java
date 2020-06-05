package mx.unam.ciencias.icc;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * <p>Clase para listas genéricas doblemente ligadas.</p>
 *
 * <p>Las listas nos permiten agregar elementos al inicio o final de la lista,
 * eliminar elementos de la lista, comprobar si un elemento está o no en la
 * lista, y otras operaciones básicas.</p>
 *
 * <p>Las listas implementan la interfaz {@link Iterable}, y por lo tanto se
 * pueden recorrer usando la estructura de control <em>for-each</em>. Las listas
 * no aceptan a <code>null</code> como elemento.</p>
 *
 * @param <T> El tipo de los elementos de la lista.
 */
public class Lista<T> implements Iterable<T> {

    /* Clase interna privada para nodos. */
    private class Nodo {
        /* El elemento del nodo. */
        private T elemento;
        /* El nodo anterior. */
        private Nodo anterior;
        /* El nodo siguiente. */
        private Nodo siguiente;

        /* Construye un nodo con un elemento. */
        private Nodo(T elemento) {
            // Aquí va su código.
            this.elemento = elemento;
        }
    }

    /* Clase Iterador privada para iteradores. */
    private class Iterador implements IteradorLista<T> {
        /* El nodo anterior. */
        private Nodo anterior;
        /* El nodo siguiente. */
        private Nodo siguiente;

        /* Construye un nuevo iterador. */
        private Iterador() {
            // Aquí va su código.
            siguiente = cabeza;
        }

        /* Nos dice si hay un elemento siguiente. */
        @Override public boolean hasNext() {
            // Aquí va su código.
            return siguiente != null;
        }

        /* Nos da el elemento siguiente. */
        @Override public T next() {
            // Aquí va su código.
            if(!hasNext())
            	throw new NoSuchElementException();
            else{
            	T elemento = siguiente.elemento;
            	anterior = siguiente;
            	siguiente = siguiente.siguiente;
            	return elemento;
            }
        }

        /* Nos dice si hay un elemento anterior. */
        @Override public boolean hasPrevious() {
            // Aquí va su código.
            return anterior != null;
        }

        /* Nos da el elemento anterior. */
        @Override public T previous() {
            // Aquí va su código.
            if(!hasPrevious())
            	throw new NoSuchElementException();
            else{
            	T elemento = anterior.elemento;
            	siguiente = anterior;
            	anterior = anterior.anterior;
            	return elemento;
            }
        }

        /* Mueve el iterador al inicio de la lista. */
        @Override public void start() {
            // Aquí va su código.
            siguiente = cabeza;
            anterior = null;
        }

        /* Mueve el iterador al final de la lista. */
        @Override public void end() {
            // Aquí va su código.
            anterior = rabo;
            siguiente = null;
        }
    }

    /* Primer elemento de la lista. */
    private Nodo cabeza;
    /* Último elemento de la lista. */
    private Nodo rabo;
    /* Número de elementos en la lista. */
    private int longitud;

    /**
     * Regresa la longitud de la lista.
     * @return la longitud de la lista, el número de elementos que contiene.
     */
    public int getLongitud() {
        // Aquí va su código.
        return longitud;
    }

    /**
     * Nos dice si la lista es vacía.
     * @return <code>true</code> si la lista es vacía, <code>false</code> en
     *         otro caso.
     */
    public boolean esVacia() {
        // Aquí va su código.
        if(cabeza == null)
        	return true;
        return false;
    }

    /**
     * Agrega un elemento al final de la lista. Si la lista no tiene elementos,
     * el elemento a agregar será el primero y último.
     * @param elemento el elemento a agregar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     *         <code>null</code>.
     */
    public void agregaFinal(T elemento) {
        // Aquí va su código.
        if (elemento == null)
            throw new IllegalArgumentException();
        Nodo estudiante = new Nodo(elemento);
        if (this.esVacia()) {
        this.rabo = this.cabeza = estudiante;
        } else {
          Nodo aux = this.rabo;
          this.rabo = estudiante;
          estudiante.anterior = aux;
          aux.siguiente = estudiante;
        }
        this.longitud++;
    }

    /**
     * Agrega un elemento al inicio de la lista. Si la lista no tiene elementos,
     * el elemento a agregar será el primero y último.
     * @param elemento el elemento a agregar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     *         <code>null</code>.
     */
    public void agregaInicio(T elemento) {
        // Aquí va su código.
        if(elemento == null)
            throw new IllegalArgumentException();
        Nodo estudiante = new Nodo(elemento);
        if (this.esVacia()) {
        this.cabeza = this.rabo = estudiante;
      } else {
        Nodo aux = this.cabeza;
        this.cabeza = estudiante;
        estudiante.siguiente = aux;
        aux.anterior = estudiante;
      }
      this.longitud++;
    }

    /**
     * Inserta un elemento en un índice explícito.
     *
     * Si el índice es menor o igual que cero, el elemento se agrega al inicio
     * de la lista. Si el índice es mayor o igual que el número de elementos en
     * la lista, el elemento se agrega al fina de la misma. En otro caso,
     * después de mandar llamar el método, el elemento tendrá el índice que se
     * especifica en la lista.
     * @param i el índice dónde insertar el elemento. Si es menor que 0 el
     *          elemento se agrega al inicio de la lista, y si es mayor o igual
     *          que el número de elementos en la lista se agrega al final.
     * @param elemento el elemento a insertar.
     * @throws IllegalArgumentException si <code>elemento</code> es
     *         <code>null</code>.
     */
    public void inserta(int i, T elemento) {
        // Aquí va su código.
        if (elemento == null) {
        	throw new IllegalArgumentException();
        }
        else if (i <= 0) {
          this.agregaInicio(elemento);
        } else if (i >= this.longitud) {
          this.agregaFinal(elemento);
        } else { 
          Nodo aux = getIesimo(cabeza, i, 1);
          Nodo nodo = new Nodo(elemento);
          nodo.anterior = aux;
          nodo.siguiente = aux.siguiente;
          nodo.siguiente.anterior = nodo;
          nodo.anterior.siguiente = nodo;
          this.longitud++;
      }
    }
    private Nodo getIesimo(Nodo nodo, int i, int j) {
        if (i == j)
           return nodo;
        return getIesimo(nodo.siguiente, i, ++j);
    }

    /**
     * Elimina un elemento de la lista. Si el elemento no está contenido en la
     * lista, el método no la modifica.
     * @param elemento el elemento a eliminar.
     */
    public void elimina(T elemento) {
        // Aquí va su código.
        Nodo nodo = this.buscaNodo(cabeza, elemento);
        if(nodo == null)
            return;
        else if (cabeza == rabo) {
            cabeza = rabo = null;
        }
        else if (cabeza == nodo){
            cabeza = cabeza.siguiente;
            cabeza.anterior = null;
        } else if(rabo == nodo){
            rabo = rabo.anterior;
            rabo.siguiente = null;
        } else {
            nodo.siguiente.anterior = nodo.anterior;
            nodo.anterior.siguiente = nodo.siguiente; 
        }
        longitud--;
    }
    //Metodo auxiliar busca nodo
    private Nodo buscaNodo(Nodo a, T elemento) {
        if (a == null || a.elemento.equals(elemento))
            return a;
        return buscaNodo(a.siguiente, elemento);
    }

    /**
     * Elimina el primer elemento de la lista y lo regresa.
     * @return el primer elemento de la lista antes de eliminarlo.
     * @throws NoSuchElementException si la lista es vacía.
     */
    public T eliminaPrimero() {
        // Aquí va su código.
        if(this.esVacia())
           throw new NoSuchElementException();

        T estudiante = cabeza.elemento;
        if (longitud == 1) {
            cabeza = rabo = null;
            longitud--;
            return estudiante;
        }
        Nodo aux = cabeza.siguiente;
        cabeza = aux;
        cabeza.anterior = null;
        longitud--;
        return estudiante;
    }

    /**
     * Elimina el último elemento de la lista y lo regresa.
     * @return el último elemento de la lista antes de eliminarlo.
     * @throws NoSuchElementException si la lista es vacía.
     */
    public T eliminaUltimo() {
        // Aquí va su código.
        if(this.esVacia())
            throw new NoSuchElementException();

        T estudiante = rabo.elemento;
        if (longitud == 1) {
            cabeza = rabo = null;
            longitud--;
            return estudiante;
        }
        Nodo aux = rabo.anterior;
        rabo = aux;
        rabo.siguiente = null;
        longitud--;
        return estudiante;
    }

    /**
     * Nos dice si un elemento está en la lista.
     * @param elemento el elemento que queremos saber si está en la lista.
     * @return <code>true</code> si <code>elemento</code> está en la lista,
     *         <code>false</code> en otro caso.
     */
    public boolean contiene(T elemento) {
        // Aquí va su código.
        if(this.buscaNodo(cabeza, elemento) == null)
           return false;
       return true;
    }

    /**
     * Regresa la reversa de la lista.
     * @return una nueva lista que es la reversa la que manda llamar el método.
     */
    public Lista<T> reversa() {
        // Aquí va su código.
      Lista<T> listaAuxiliar = new Lista<T>();
      Nodo nodo = rabo;
      while(nodo != null){
        listaAuxiliar.agregaFinal(nodo.elemento);
        nodo = nodo.anterior;
      }
      return listaAuxiliar;
    }

    /**
     * Regresa una copia de la lista. La copia tiene los mismos elementos que la
     * lista que manda llamar el método, en el mismo orden.
     * @return una copiad de la lista.
     */
    public Lista<T> copia() {
        // Aquí va su código.
      Lista<T> listaAuxiliar = new Lista<T>();
      Nodo nodo = cabeza;
      while(nodo != null){
        listaAuxiliar.agregaFinal(nodo.elemento);
        nodo = nodo.siguiente;
      }
      return listaAuxiliar;
    }

    /**
     * Limpia la lista de elementos, dejándola vacía.
     */
    public void limpia() {
        // Aquí va su código.
        cabeza = rabo = null;
        longitud = 0;
    }

    /**
     * Regresa el primer elemento de la lista.
     * @return el primer elemento de la lista.
     * @throws NoSuchElementException si la lista es vacía.
     */
    public T getPrimero() {
        // Aquí va su código.
        if(cabeza == null)
        	throw new NoSuchElementException();
        return cabeza.elemento;
    }

    /**
     * Regresa el último elemento de la lista.
     * @return el primer elemento de la lista.
     * @throws NoSuchElementException si la lista es vacía.
     */
    public T getUltimo() {
        // Aquí va su código.
        if(esVacia())
            throw new NoSuchElementException();
        return this.rabo.elemento;
    }

    /**
     * Regresa el <em>i</em>-ésimo elemento de la lista.
     * @param i el índice del elemento que queremos.
     * @return el <em>i</em>-ésimo elemento de la lista.
     * @throws ExcepcionIndiceInvalido si <em>i</em> es menor que cero o mayor o
     *         igual que el número de elementos en la lista.
     */
    public T get(int i) {
        // Aquí va su código.
        if (i <0 || i >= getLongitud())
            throw new ExcepcionIndiceInvalido();
        return get(i, cabeza, 0);
    }
    private T get(int i, Nodo nodo, int j){
        if(i==j)
            return nodo.elemento;
        return get(i, nodo.siguiente,j+1);
    }

    /**
     * Regresa el índice del elemento recibido en la lista.
     * @param elemento el elemento del que se busca el índice.
     * @return el índice del elemento recibido en la lista, o -1 si el elemento
     *         no está contenido en la lista.
     */
    public int indiceDe(T elemento) {
        // Aquí va su código.
        return indiceDe(0,cabeza,elemento);
    }
    private int indiceDe(int i, Nodo nodo, T elemento){
        if (nodo == null)
            return -1;
        if (nodo.elemento.equals(elemento))
            return i;
        return indiceDe(i+1, nodo.siguiente, elemento);
    }

    /**
     * Regresa una representación en cadena de la lista.
     * @return una representación en cadena de la lista.
     */
    @Override public String toString() {
        // Aquí va su código.
         if (cabeza == null)
            return "[]";
        return "[" + cabeza.elemento.toString() + toString(cabeza.siguiente);
    }

    private String toString(Nodo nodo) {
        if(nodo == null)
            return "]";
        return ", " + nodo.elemento.toString() + toString(nodo.siguiente);
    }

    /**
     * Nos dice si la lista es igual al objeto recibido.
     * @param objeto el objeto con el que hay que comparar.
     * @return <code>true</code> si la lista es igual al objeto recibido;
     *         <code>false</code> en otro caso.
     */
    @Override public boolean equals(Object objeto) {
        if (objeto == null || getClass() != objeto.getClass())
            return false;
        @SuppressWarnings("unchecked") Lista<T> lista = (Lista<T>)objeto;
        // Aquí va su código.
        if(lista == null)
            return false;
        if(this.longitud != lista.longitud)
            return false;
        if(lista == null)
            return false;
        return equals(this.cabeza, lista.cabeza);    
    }
    /** Metodo auxiliar para comparar
     */
    private boolean equals(Nodo a, Nodo b){
        if (a == null && b == null)
            return true;
        if (a != null && b != null && a.elemento.equals(b.elemento))
            return equals(a.siguiente, b.siguiente);            
        return false;
    }

    /**
     * Regresa un iterador para recorrer la lista en una dirección.
     * @return un iterador para recorrer la lista en una dirección.
     */
    @Override public Iterator<T> iterator() {
        return new Iterador();
    }

    /**
     * Regresa un iterador para recorrer la lista en ambas direcciones.
     * @return un iterador para recorrer la lista en ambas direcciones.
     */
    public IteradorLista<T> iteradorLista() {
        return new Iterador();
    }
}

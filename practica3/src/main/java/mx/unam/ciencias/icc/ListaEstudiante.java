package mx.unam.ciencias.icc;

/**
 * <p>Clase para listas de estudiantes doblemente ligadas.</p>
 *
 * <p>Las listas de estudiantes nos permiten agregar elementos al inicio o final
 * de la lista, eliminar elementos de la lista, comprobar si un elemento está o
 * no en la lista, y otras operaciones básicas.</p>
 *
 * <p>Las listas de estudiantes son iterables utilizando sus nodos. Las listas
 * no aceptan a <code>null</code> como elemento.</p>
 *
 * <p>Los elementos en una lista de estudiantes siempre son instancias de la
 * clase {@link Estudiante}.</p>
 */
public class ListaEstudiante {

    /**
     * Clase interna para nodos.
     */
    public class Nodo {

        /* El elemento del nodo. */
        private Estudiante elemento;
        /* El nodo anterior. */
        private Nodo anterior;
        /* El nodo siguiente. */
        private Nodo siguiente;

        /* Construye un nodo con un elemento. */
        private Nodo(Estudiante elemento) {
            // Aquí va su código.
            
            this.elemento = elemento;           
        }

        /**
         * Regresa el nodo anterior del nodo.
         * @return el nodo anterior del nodo.
         */
        public Nodo getAnterior() {
            // Aquí va su código.
            return this.anterior;

        }

        /**
         * Regresa el nodo siguiente del nodo.
         * @return el nodo siguiente del nodo.
         */
        public Nodo getSiguiente() {
            // Aquí va su código.
            return this.siguiente;
        }

        /**
         * Regresa el elemento del nodo.
         * @return el elemento del nodo.
         */
        public Estudiante get() {
            // Aquí va su código.
            return this.elemento;
        
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
        return this.longitud;
    }

    /**
     * Nos dice si la lista es vacía.
     * @return <code>true</code> si la lista es vacía, <code>false</code> en
     *         otro caso.
     */
    public boolean esVacia() {
        // Aquí va su código. Si la logngituf=0 o cabeza y rabo = 0
        if (this.longitud == 0)
            return true;
        return false;
    }

    //Metodo auxiliar busca nodo
    private Nodo buscaNodo(Nodo a, Estudiante elemento) {
        if (a == null)
            return null;
        if(a.get().equals(elemento))
            return a;
        return buscaNodo(a.siguiente, elemento);
    }


    /**
     * Agrega un elemento al final de la lista. Si la lista no tiene elementos,
     * el elemento a agregar será el primero y último.
     * @param elemento el elemento a agregar. El elemento se agrega únicamente
     *                 si es distinto de <code>null</code>.
     */
    public void agregaFinal(Estudiante elemento) {
        // Aquí va su código.
        if (elemento == null)
            return;

       Nodo estudiante = new Nodo(elemento);
        if (this.esVacia()) {
          this.cabeza = estudiante;
          this.rabo = estudiante;
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
     * @param elemento el elemento a agregar. El elemento se agrega únicamente
     *                 si es distinto de <code>null</code>.
     */
    public void agregaInicio(Estudiante elemento) {
        // Aquí va su código.
        if(elemento == null)
            return;
        Nodo estudiante = new Nodo(elemento);
        if (this.esVacia()) {
        this.cabeza = estudiante;
        this.rabo = estudiante;
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
     * @param elemento el elemento a insertar. El elemento se inserta únicamente
     *                 si es distinto de <code>null</code>.
     */
    public void inserta(int i, Estudiante elemento) {

         if (i <= 0) {
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
    public void elimina(Estudiante elemento) {
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

    /**
     * Elimina el primer elemento de la lista y lo regresa.
     * @return el primer elemento de la lista antes de eliminarlo, o
     *         <code>null</code> si la lista es vacía.
     */
    public Estudiante eliminaPrimero() {
        // Aquí va su código.
        if(this.esVacia())
            return null;

        Estudiante estudiante = cabeza.elemento;
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
     * @return el último elemento de la lista antes de eliminarlo, o
     *         <code>null</code> si la lista es vacía.
     */
    public Estudiante eliminaUltimo() {
        // Aquí va su código.
         if(this.esVacia())
            return null;

        Estudiante estudiante = rabo.elemento;
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
    public boolean contiene(Estudiante elemento) {
        // Aquí va su código.
        if(this.buscaNodo(cabeza, elemento) == null)
           return false;
       return true;


    }

    /**
     * Regresa la reversa de la lista.
     * @return una nueva lista que es la reversa la que manda llamar el método.
     */
    public ListaEstudiante reversa() {
        // Aquí va su código.
         ListaEstudiante listaAuxiliar = new ListaEstudiante();
        return reversa(listaAuxiliar, cabeza);
    }
    private ListaEstudiante reversa(ListaEstudiante lista, Nodo nodo){
        if (nodo == null)
            return lista;
        lista.agregaInicio(nodo.get());
        return reversa (lista, nodo.siguiente);
    }

    /**
     * Regresa una copia de la lista. La copia tiene los mismos elementos que la
     * lista que manda llamar el método, en el mismo orden.
     * @return una copiad de la lista.
     */
    public ListaEstudiante copia() {
        // Aquí va su código. ES con un for para cada uno de las cajitas de la lista
        ListaEstudiante listaAuxiliar = new ListaEstudiante();
        return copia(listaAuxiliar, cabeza);
    }
    private ListaEstudiante copia(ListaEstudiante lista, Nodo nodo){
        if (nodo == null)
            return lista;
        lista.agregaFinal(nodo.get());
        return copia(lista, nodo.siguiente);
    }

    /**
     * Limpia la lista de elementos, dejándola vacía.
     */
    public void limpia() {
        // Aquí va su código. Hacer que los atributos se vean como quiero, esto es cabeza = null, longitud = 0, rabbo = null
        this.cabeza = null;
        this.rabo = null;
        this.longitud=0;

    }

    /**
     * Regresa el primer elemento de la lista.
     * @return el primer elemento de la lista, o <code>null</code> si la lista
     *         es vacía.
     */
    public Estudiante getPrimero() {
        // Aquí va su código. #Opinion usar  una variable = this.cabeza.elemento null vacia y no vacia return 'una variable'
        if(esVacia())
            return null;
        return this.cabeza.get();
    }

    /**
     * Regresa el último elemento de la lista.
     * @return el último elemento de la lista, o <code>null</code> si la lista
     *         es vacía.
     */
    public Estudiante getUltimo() {
        // Aquí va su código. Es igual que con el primero
        if (esVacia()) 
            return null;                    
        return this.rabo.get();
    }

    /**
     * Regresa el <em>i</em>-ésimo elemento de la lista.
     * @param i el índice del elemento que queremos.
     * @return el <em>i</em>-ésimo elemento de la lista, o <code>null</code> si
     *         <em>i</em> es menor que cero o mayor o igual que el número de
     *         elementos en la lista.
     */
    public Estudiante get(int i) {
        // Aquí va su código.
        if (i <0 || i >= getLongitud())
            return null;
        return get(i, cabeza, 0);
    }
    private Estudiante get(int i, Nodo nodo, int j){
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
    public int indiceDe(Estudiante elemento) {
        // Aquí va su código.
        return indiceDe(0,cabeza,elemento);
    }
    private int indiceDe(int i, Nodo nodo, Estudiante elemento){
        if (nodo == null)
            return -1;
        if (nodo.get().equals(elemento))
            return i;
        return indiceDe(i+1, nodo.siguiente, elemento);
    }
    // 

    /**
     * Regresa una representación en cadena de la lista.
     * @return una representación en cadena de la lista.
     */
    public String toString() {
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
     * Nos dice si la lista es igual a la lista recibida.
     * @param lista la lista con la que hay que comparar.
     * @return <code>true</code> si la lista es igual a la recibida;
     *         <code>false</code> en otro caso.
     */
    public boolean equals(ListaEstudiante lista) {
        
        //Aquí va su código. revisar longitud
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
        if (a != null && b != null && a.get().equals(b.get()))
            return equals(a.siguiente, b.siguiente);            
        return false;
    }

    /**
     * Regresa el nodo cabeza de la lista.
     * @return el nodo cabeza de la lista.
     */
    public Nodo getCabeza() {
        // Aquí va su código.
        return this.cabeza;
    }

    /**
     * Regresa el nodo rabo de la lista.
     * @return el nodo rabo de la lista.
     */
    public Nodo getRabo() {
        // Aquí va su código.
        return this.rabo;
    }
    
}
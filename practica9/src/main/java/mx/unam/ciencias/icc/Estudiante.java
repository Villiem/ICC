package mx.unam.ciencias.icc;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Clase para representar estudiantes. Un estudiante tiene nombre, número de
 * cuenta, promedio y edad. La clase implementa {@link Registro}, por lo que
 * puede representarse con una línea de texto y definir sus propiedades con una
 * línea de texto; además de determinar si sus campos cazan valores arbitrarios.
 */
public class Estudiante implements Registro<Estudiante, CampoEstudiante> {

    /* Nombre del estudiante. */
    private StringProperty nombre;
    /* Número de cuenta. */
    private IntegerProperty cuenta;
    /* Pormedio del estudiante. */
    private DoubleProperty promedio;
    /* Edad del estudiante.*/
    private IntegerProperty edad;

    /**
     * Define el estado inicial de un estudiante.
     * @param nombre el nombre del estudiante.
     * @param cuenta el número de cuenta del estudiante.
     * @param promedio el promedio del estudiante.
     * @param edad la edad del estudiante.
     */
    public Estudiante(String nombre,
                      int    cuenta,
                      double promedio,
                      int    edad) {
        this.nombre = new SimpleStringProperty(nombre);
        // Aquí va su código.
        this.cuenta = new SimpleIntegerProperty(cuenta);
        this.promedio = new SimpleDoubleProperty(promedio);
        this.edad = new SimpleIntegerProperty(edad);
    }

    /**
     * Regresa el nombre del estudiante.
     * @return el nombre del estudiante.
     */
    public String getNombre() {
        return nombre.get();
    }

    /**
     * Define el nombre del estudiante.
     * @param nombre el nuevo nombre del estudiante.
     */
    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    /**
     * Regresa la propiedad del nombre.
     * @return la propiedad del nombre.
     */
    public StringProperty nombreProperty() {
        return this.nombre;
    }

    /**
     * Regresa el número de cuenta del estudiante.
     * @return el número de cuenta del estudiante.
     */
    public int getCuenta() {
        // Aquí va su código.
        return cuenta.get();
    }

    /**
     * Define el número cuenta del estudiante.
     * @param cuenta el nuevo número de cuenta del estudiante.
     */
    public void setCuenta(int cuenta) {
        // Aquí va su código.
        this.cuenta.set(cuenta);
    }

    /**
     * Regresa la propiedad del número de cuenta.
     * @return la propiedad del número de cuenta.
     */
    public IntegerProperty cuentaProperty() {
        // Aquí va su código.
        return this.cuenta;
    }

    /**
     * Regresa el promedio del estudiante.
     * @return el promedio del estudiante.
     */
    public double getPromedio() {
        // Aquí va su código.
        return promedio.get();
    }

    /**
     * Define el promedio del estudiante.
     * @param promedio el nuevo promedio del estudiante.
     */
    public void setPromedio(double promedio) {
        // Aquí va su código.
        this.promedio.set(promedio);
    }

    /**
     * Regresa la propiedad del promedio.
     * @return la propiedad del promedio.
     */
    public DoubleProperty promedioProperty() {
        // Aquí va su código.
        return this.promedio;
    }

    /**
     * Regresa la edad del estudiante.
     * @return la edad del estudiante.
     */
    public int getEdad() {
        // Aquí va su código.
        return this.edad.get();
    }

    /**
     * Define la edad del estudiante.
     * @param edad la nueva edad del estudiante.
     */
    public void setEdad(int edad) {
        // Aquí va su código.
        this.edad.set(edad);
    }

    /**
     * Regresa la propiedad de la edad.
     * @return la propiedad de la edad.
     */
    public IntegerProperty edadProperty() {
        // Aquí va su código.
        return this.edad;
    }

    /**
     * Regresa una representación en cadena del estudiante.
     * @return una representación en cadena del estudiante.
     */
    @Override public String toString() {
        // Aquí va su código.
        String cadena = String.format("Nombre   : %s\n" +
                                      "Cuenta   : %09d\n" +
                                      "Promedio : %2.2f\n" +
                                      "Edad     : %d",
                                      getNombre(), getCuenta(), getPromedio(), getEdad());
        return cadena;
    }

    /**
     * Nos dice si el objeto recibido es un estudiante igual al que manda llamar
     * el método.
     * @param objeto el objeto con el que el estudiante se comparará.
     * @return <code>true</code> si el objeto o es un estudiante con las mismas
     *         propiedades que el objeto que manda llamar al método,
     *         <code>false</code> en otro caso.
     */
    @Override public boolean equals(Object objeto) {
        if (!(objeto instanceof Estudiante))
            return false;
        Estudiante estudiante = (Estudiante)objeto;
        // Aquí va su código.
        if(this.getNombre().equals(estudiante.getNombre()) && this.getCuenta() == estudiante.getCuenta() && this.getPromedio() == estudiante.getPromedio() && this.getEdad() == estudiante.getEdad())
            return true;
        return false;
    }

    /**
     * Regresa el estudiante serializado en una línea de texto. La línea de
     * texto que este método regresa debe ser aceptada por el método {@link
     * Estudiante#deserializa}.
     * @return la serialización del estudiante en una línea de texto.
     */
    @Override public String serializa() {
        // Aquí va su código.
        String serializa = String.format("%s\t%d\t%2.2f\t%d\n", 
                      getNombre(), getCuenta(), getPromedio(), getEdad());
        return serializa;
    }

    /**
     * Deserializa una línea de texto en las propiedades del estudiante. La
     * serialización producida por el método {@link Estudiante#serializa} debe
     * ser aceptada por este método.
     * @param linea la línea a deserializar.
     * @throws ExcepcionLineaInvalida si la línea recibida es nula, vacía o no
     *         es una serialización válida de un estudiante.
     */
    @Override public void deserializa(String linea) {
        // Aquí va su código.
        if(linea == null || linea.isEmpty())
        	throw new ExcepcionLineaInvalida("error1");
        
        String dato_limpio = linea.replace("\n", "");
        String[] cadena = dato_limpio.split("\t");
        if(cadena.length != 4)
            throw new ExcepcionLineaInvalida("error2");
        setNombre(cadena[0]);
        try{
            setCuenta(Integer.parseInt(cadena[1]));
            setPromedio(Double.parseDouble(cadena[2]));
            setEdad(Integer.parseInt(cadena[3]));
        } catch (NumberFormatException e){
        	throw new ExcepcionLineaInvalida("cadena ExcepcionLineaInvalida");
        } 
    }

    /**
     * Actualiza los valores del estudiante con los del estudiante recibido.
     * @param estudiante el estudiante con el cual actualizar los valores.
     * @throws IllegalArgumentException si el estudiante es <code>null</code>.
     */
    public void actualiza(Estudiante estudiante) {
        // Aquí va su código.
        if (estudiante == null) {
        	throw new IllegalArgumentException();
        } else{ 
        	setNombre(estudiante.getNombre());
        	setEdad(estudiante.getEdad());
        	setPromedio(estudiante.getPromedio());
        	setCuenta(estudiante.getCuenta());
        }
    }

    /**
     * Nos dice si el estudiante caza el valor dado en el campo especificado.
     * @param campo el campo que hay que cazar.
     * @param valor el valor con el que debe cazar el campo del registro.
     * @return <code>true</code> si:
     *         <ul>
     *           <li><code>campo</code> es {@link CampoEstudiante#NOMBRE} y
     *              <code>valor</code> es instancia de {@link String} y es una
     *              subcadena del nombre del estudiante.</li>
     *           <li><code>campo</code> es {@link CampoEstudiante#CUENTA} y
     *              <code>valor</code> es instancia de {@link Integer} y su
     *              valor entero es menor o igual a la cuenta del
     *              estudiante.</li>
     *           <li><code>campo</code> es {@link CampoEstudiante#PROMEDIO} y
     *              <code>valor</code> es instancia de {@link Double} y su
     *              valor doble es menor o igual al promedio del
     *              estudiante.</li>
     *           <li><code>campo</code> es {@link CampoEstudiante#EDAD} y
     *              <code>valor</code> es instancia de {@link Integer} y su
     *              valor entero es menor o igual a la edad del
     *              estudiante.</li>
     *         </ul>
     *         <code>false</code> en otro caso.
     * @throws IllegalArgumentException si el campo es <code>null</code>.
     */
    @Override public boolean caza(CampoEstudiante campo, Object valor) {
        // Aquí va su código.
        if (campo == null)
            throw new IllegalArgumentException("No chavo, asi no se puede");
 
        switch(campo){
			case NOMBRE: return cazaNombre(valor);
			case CUENTA: return cazaCuenta(valor);     	
			case PROMEDIO: return cazaPromedio(valor);
			case EDAD: return cazaEdad(valor);
			default: throw new IllegalArgumentException();
		}
	}
	  private boolean cazaNombre(Object o){
      if(!(o instanceof String))
      	return false;
      String s = (String) o;
      if(s.isEmpty()) 
      	return false;
      return getNombre().contains(s);
    }
    private boolean cazaCuenta(Object o){
      if(!(o instanceof Integer)) 
      	return false;
      Integer i = (Integer) o;
      return getCuenta() >= i.intValue();
    }
    private boolean cazaEdad(Object o){
      if(!(o instanceof Integer)) 
      	return false;
      Integer i = (Integer) o;
      return getEdad() >= i.intValue();
    }
    private boolean cazaPromedio(Object o){
      if(!(o instanceof Double))
       return false;
      Double d = (Double) o;
      return getPromedio() >= d.doubleValue();
    }
}

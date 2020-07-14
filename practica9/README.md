Introducción a Ciencias de la Computación
=========================================

Práctica 9: Interfaces gráficas
-------------------------------

### Fecha de entrega: martes 9 de junio, 2020

Deben agregar escuchas a las clases
[`Estudiante`](https://aztlan.fciencias.unam.mx/gitlab/2020-2-icc/practica9/blob/master/src/main/java/mx/unam/ciencias/icc/Estudiante.java)
y
[`BaseDeDatos`](https://aztlan.fciencias.unam.mx/gitlab/2020-2-icc/practica9/blob/master/src/main/java/mx/unam/ciencias/icc/BaseDeDatos.java).

Además deben completar los métodos de las clases en el paquete
[`fx`](https://aztlan.fciencias.unam.mx/gitlab/2020-2-icc/practica9/blob/master/src/main/java/mx/unam/ciencias/icc/fx/). Noten
que estas clases no cuentan con pruebas unitarias.

Una vez que hayan terminado sus clases, deben compilar al hacer:

```
$ mvn compile
```

También deben pasar todas sus pruebas unitarias al hacer:

```
$ mvn test
```

Por último, se debe ejecutar correctamente el programa escrito en la clase
[`Practica9`](https://aztlan.fciencias.unam.mx/gitlab/2020-2-icc/practica9/blob/master/src/main/java/mx/unam/ciencias/icc/Practica9.java)
al ejecutar:

```
$ mvn install
...
$ java -jar target/practica9.jar
```

Los únicos archivos que deben modificar son:

* `Arreglos.java`,
* `BaseDeDatos.java`,
* `BaseDeDatosEstudiantes.java`,
* `CampoEstudiante.java`,
* `Estudiante.java`,
* `Lista.java`,
* `fx/ControladorFormaBusquedaEstudiantes.java`,
* `fx/ControladorFormaEstudiante.java`,
* `fx/ControladorForma.java`,
* `fx/ControladorTablaEstudiantes.java` y
* `fx/EntradaVerificable.java`.

*No deben modificar de ninguna manera ninguno de los otros archivos de la
práctica*.

### Repositorio

Pueden clonar la práctica con el siguiente comando:

```
$ git clone https://canek@aztlan.fciencias.unam.mx/gitlab/2020-2-icc/practica9.git
```

### Documentación

La documentación generada por JavaDoc la pueden consultar aquí:

[Documentación generada por JavaDoc para la práctica
9](https://aztlan.fciencias.unam.mx/~canek/2020-2-icc/practica9/apidocs/index.html)

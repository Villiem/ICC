Introducción a Ciencias de la Computación
=========================================

Práctica 8: Ordenamientos y búsquedas
-------------------------------------

### Fecha de entrega: martes 12 de mayo, 2020

Deben completar los métodos de la clase
[`Arreglos`](https://aztlan.fciencias.unam.mx/gitlab/2020-2-icc/practica8/blob/master/src/main/java/mx/unam/ciencias/icc/Arreglos.java).
Además, deben agregar los métodos
[`mergeSort()`](https://aztlan.fciencias.unam.mx/gitlab/2020-2-icc/practica8/blob/master/src/main/java/mx/unam/ciencias/icc/Lista.java#L290)
y
[`busquedaLineal()`](https://aztlan.fciencias.unam.mx/gitlab/2020-2-icc/practica8/blob/master/src/main/java/mx/unam/ciencias/icc/Lista.java#L315)
a la clase
[`Lista`](https://aztlan.fciencias.unam.mx/gitlab/2020-2-icc/practica8/blob/master/src/main/java/mx/unam/ciencias/icc/Lista.java).

Una vez que hayan terminado sus clases, deben compilar al hacer:

```
$ mvn compile
```

También deben pasar todas sus pruebas unitarias al hacer:

```
$ mvn test
```

Por último, se debe ejecutar correctamente el programa escrito en la clase
[`Practica8`](https://aztlan.fciencias.unam.mx/gitlab/2020-2-icc/practica8/blob/master/src/main/java/mx/unam/ciencias/icc/Practica8.java)
al ejecutar:

```
$ mvn install
...
$ java -jar target/practica8.jar
```

Los únicos archivos que deben modificar son:

* `Arreglos.java`,
* `BaseDeDatos.java`,
* `BaseDeDatosEstudiantes.java`,
* `CampoEstudiante.java`,
* `Estudiante.java` y
* `Lista.java`.

*No deben modificar de ninguna manera ninguno de los otros archivos de la
práctica*.

### Repositorio

Pueden clonar la práctica con el siguiente comando:

```
$ git clone https://canek@aztlan.fciencias.unam.mx/gitlab/2020-2-icc/practica8.git
```

### Documentación

La documentación generada por JavaDoc la pueden consultar aquí:

[Documentación generada por JavaDoc para la práctica
8](https://aztlan.fciencias.unam.mx/~canek/2020-2-icc/practica8/apidocs/index.html)

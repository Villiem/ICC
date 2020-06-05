Introducción a Ciencias de la Computación
=========================================

Práctica 6: Genéricos
---------------------

### Fecha de entrega: martes 21 de abril, 2020

Deben hacer genéricas las clases
[Lista](https://aztlan.fciencias.unam.mx/gitlab/2020-2-icc/practica6/blob/master/src/main/java/mx/unam/ciencias/icc/Lista.java) y
[BaseDeDatos](https://aztlan.fciencias.unam.mx/gitlab/2020-2-icc/practica6/blob/master/src/main/java/mx/unam/ciencias/icc/BaseDeDatos.java).
Además, como la interfaz
[Registro](https://aztlan.fciencias.unam.mx/gitlab/2020-2-icc/practica6/blob/master/src/main/java/mx/unam/ciencias/icc/Registro.java) 
es ahora genérica, deben actualizar la clase
[Estudiante](https://aztlan.fciencias.unam.mx/gitlab/2020-2-icc/practica6/blob/master/src/main/java/mx/unam/ciencias/icc/Estudiante.java)
para hacer uso de ello.

Una vez que hayan terminado su clase, debe compilar al hacer:

```
$ mvn compile
```

También debe pasar todas sus pruebas unitarias al hacer:

```
$ mvn test
```

Por último, se debe ejecutar correctamente el programa escrito en la clase
[Practica6](https://aztlan.fciencias.unam.mx/gitlab/2020-2-icc/practica6/blob/master/src/main/java/mx/unam/ciencias/icc/Practica6.java)
al ejecutar:

```
$ mvn install
...
$ java -jar target/practica6.jar -g archivo.bd
```

para guardar una base de datos de estudiantes en el archivo `archivo.bd`, o

```
$ mvn install
...
$ java -jar target/practica6.jar -c archivo.bd
```

para cargar una base de datos de estudiantes del archivo `archivo.bd`.

Los únicos archivos que deben modificar son:

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
$ git clone https://canek@aztlan.fciencias.unam.mx/gitlab/2020-2-icc/practica6.git
```

### Documentación

La documentación generada por JavaDoc la pueden consultar aquí:

[Documentación generada por JavaDoc para la práctica
6](https://aztlan.fciencias.unam.mx/~canek/2020-2-icc/practica6/apidocs/index.html)

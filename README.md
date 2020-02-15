# FelicitadorPrueba
Trabajo construido por Matias Bravo Pinto, consta de una API Restful Java, con un Front End con Jquery en php.

Herramientas Utilizadas en el proyecto:
-Netbeans 8.2 Java y PHP
-JDK 8
-XAMPP
-Libreria Java gson-2.8.2.jar
-Libreria Java java-json.jar

Pasos para deployar el proyecto:

-API RestFul Java:
Primero deben abrir el proyecto usando Netbeans 8.2, en un equipo que tenga el JDK 8, Netbeans pedira arreglar las referecias (ya que utilice unas librerias extras para usar objetos Json) Estos .Jar van adjuntados en el Git.
Una vez abierto en Netbeans, solo basta con darle a "Run Project" y esta lista para usarse (Es necesario que este programado para abrir en el puerto por defecto 8080).

-Front End Jquery-PHP
Para deployar este proyectos es necesario que en su equipo este instalado un servidor Apache y guardar la carpeta del proyecto en la correspondiente ruta definida para ejecutarlo (Yo utilice XAMPP por lo que la ruta es: "C:\xampp\htdocs\"). Si utilizarán el mismo equipo para deployar los 2 proyectos, es necesario cambiar el puerto Apache del 80 al 81, si es en otro equipo, deberán cambiar la URL en el proyecto para comunicarse al equipo que tenga el servidor (En el index.php irá un comentario de donde esta la URL).
Una vez tenga bien configurado su servidor Apache, puede abrir en su navegador la ruta con el nombre del proyecto.
Ejemplo : http://localhost:81/FrontEndFelicitador/index.php

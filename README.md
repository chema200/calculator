
# CALCULADORA

Api Calculadora. Suma y resta de dos números.


1. INSTALACIÓN DE LIBRERÍAS TRACER.

Hay que instalar las librerías suministradas para la prueba en el repositorio local con el siguiente comando:

mvn install:install-file -Dfile=tracer-1.0.0.jar -DgroupId=io.corp -DartifactId=calculator -Dversion=1.0.0 -Dpackaging=jar -DgeneratedPom=true


2. COMPILAR EL PROYECTO

Compilar y empaquetar el proyecto. Nos situamos en la raiz y ejecutamos el siguiente comando:
mvn clean install


3. EJECUTAR EL JAR GENERADO

Ejecutar el jar que está en la carpeta Target

java -jar calculator-1.0.0.jar

4. CONSUMIR SERVICIO

Consumir desde cualquier aplicación llamando por POST a la siguiente url:
URL: http://localhost:8080/calculate

Los parámetros de entrada deben de seguir el siguiente formato JSON:
Ejemplo suma:
{
"operation":"+",
"parameters": [7800,100]
}
Ejemplo resta:
{
"operation":"-",
"parameters": [7800,100]
}


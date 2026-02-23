# compunetII
TALLER 1


1. Condiciones de entrega

● Únicamente se recibirán trabajos en la fecha establecida.

● El código debe tener una estructura adecuada.

● Grupos de 3 estudiantes.

● Debe siempre usar inyección de dependencias

● La aplicación debe estar funcionando.

● La aplicación debe cumplir con los requisitos planteados.

● Está completamente prohibida la copia y/o reproducción total o parcial del taller del curso.

● Cero tolerancia al plagio.


2. Problema

Crear un sistema de gestión de discografía de artistas musicales.


1. Cree las clases modelo, repositorio/servicio, para una aplicación de gestión discografía de artistas musicales.


2. En su paquete de modelo debe tener la clase Artist con los atributos, id, name, nationality. Tambien debe haber un clase Track que tenga los atributos id, title, genre, duration, albumTitle.


3. La relación entre las entidades es Artist many to many con Track.


4. Cree una clase de repositorio/servicio para Artist que permita

a. Obtener todos los artistas

b. Crear un artista

c. Obtener un Artist con todas sus Tracks buscando por nombre del artista

d. Eliminar un artista específico usando el id.


5. Cree una clase de repositorio/servicio para Track que permita

a. Obtener todos las Tracks registrados en la plataforma

b. Crear un Track permitiendo registrar 1 o varios artistas como autores.

c. Eliminar un Track por id




3. Inicialización

La aplicación debe iniciar ya con algunos tracks y artistas aslmacenados.

a. Cree 50 Tracks

b. Cree 10 artistas

c. Agregue esos 50 Tracks a los 10 artistas (5 por artista).



4. Servlets

Mediante servlets realice

a. Un listado de todos los artistas

b. Un formulario para crear los artistas

c. Un formulario que permita buscar un artista a traves de su nombre. Debe listas todos los datos del artista y todas sus canciones

d. Un formulario que permita eliminar un artista por su Id.

e. Una lista de todas las canciones registradas en la plataforma. Cada canción debe mostrarse con su información y los artistas asociados.

f. Un formulario para crear un Track que permita asignar artistas.

g. Un form para eliminar Tracks.



Puede ser mediante varias páginas donde se puedan ver los resultados.

5. Versiones

Debes hacer tres versiones del proyecto, para la inyección de dependencias:

a) Configuración usando XML.

b) Configuración usando Annotations en las clases.

c) Configuración usando archivo de configuración.

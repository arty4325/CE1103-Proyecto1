CE Music Player
====================================
 
## Introducción y descripción de la problemática
 
El proyecto presente consiste en la implementación de una aplicación que reproduzca música al estilo de spotify, esta aplicación tiene la capacidad de gestionar bibliotecas musicales y de reproducir música con la interacción de un Arduino. Para poder realizar esta implementación se hace uso de las listas enlazadas, las listas doblemente enlazadas y las listas enlazadas circulares como estructuras de datos que permiten almacenar la información necesaria para el correcto funcionamiento de la aplicación. La aplicación tiene las siguientes funcionalidades:
 
* **Gestionar Usuarios**
 
La aplicación permite que se autentiquen los usuarios que están interactuando en ella, para de esta manera gestionar la información de cada usuario. Todos los usuarios de la plataforma poseen nombre, correo, provincia y contraseña. Cuando la aplicación se inicia toda esta información es creada en una lista simple.
 
 
* **Gestionar Bibliotecas Musicales**
 
Todos los usuarios dentro de la aplicación tienen la capacidad de gestionar sus propias bibliotecas. Cuando el usuario es autenticado, se muestra en pantalla la lista de bibliotecas que este posee, cada biblioteca tiene una cantidad de canciones y una fecha de creación, el usuario puede entrar a estas y gestionar lo que está en ellas a su gusto.
 
* **Gestionar Canciones De Una Biblioteca Musical**
 
Todos los usuarios tienen la capacidad de gestionar las canciones que se encuentran en su propia biblioteca. Esta gestión implica la capacidad de agregar canciones a una biblioteca propia, la eliminación de canciones de una biblioteca, la modificación de la metadata de cada canción (género, artista, álbum, año, letra) y la selección de canciones favoritas por parte del usuario.
 
* **Reproducción de Canciones**
 
Todos los usuarios de la aplicación tienen la capacidad de reproducir, pausar y pasar canciones, además pueden subirle y bajarle el volumen a la música.
 
* **Reproduccion de Musica desde el Arduino**
 
Todos los usuarios dentro de la aplicación tienen la capacidad de enviar a reproducir música desde un arduino que funciona como control. Este arduino tendrá botones que permitan reproducir o pausar las canciones, además tendrá otro botón que permite activar o desactivar la funcionalidad que mantiene a las canciones reproduciendo. El control contará con un potenciómetro el cual podrá subir y bajar el volumen y habrá una serie de luces led que indican si la cancion esta dentro de la lista de los favoritos, si la cancion esta en modo reproducción continua y indicarán cual es el volumen al cual se está reproduciendo la canción.

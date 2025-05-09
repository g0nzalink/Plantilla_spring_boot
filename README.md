## **Plantilla Spring Boot**
Esta plantilla es para Spring Boot y en general para ahorrar toda la implementación de Spring Security.
Si ven que algo falta agradecería que pudieran implementarlo pero haciendo pull request para que no sea toda una sopa rara. Por favor si quieren hacer un cambio hagan pull request al branch "cambios" para tenerlos a parte y proximamente hacer el merge.

## **IMPORTANTE**
Esta es una plantilla general, si la descargas puedes borrar la carpeta de "__otras_entidades" ya que es un ejemplo y de ahí crear tus entidades con sus respectivos controller's, service's, dto's, model's y repository's.
También tener en cuenta application.properties; modifica tu puerto, usuario y contraseña según lo hayas configurado TÚ en tu computadora/laptop. También genera tu propia jwtkey (puedes usar una cualquiera) y la pones ahí para que el programa arranque.


## **¿Cómo usarlo?**
Para que sea realmente seguro, solo un administrador puede registrar un nuevo usuario con cualquier role que desee. Para esto se ha creado un usuario con rol de "ADMIN" por defecto (pueden encontrar su nombre y contraseña config -> UserInitializer). Para poder tener permiso de registrar cualquier usuario recuerden usar el token que obtienen con el endpoint de "login".

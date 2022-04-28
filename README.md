# demoCrudTEST

###1)Se aplica la relación @ManyToMany debido a que un usuario puede tener varios roles, de igual manera un rol puede tener varios usuarios.

### Para aplicar esta relación se crea una nueva tabla roles y una tabla que sirve de puente o conexión llamada usuario_rol, a continuación se presenta la estructura:

![img.png](img.png)

###Para agregar un rol a un usuario se ejecuta lo siguiente:
###El usuario con el id:2 tiene el siguiente registro actual ->

![img_2.png](img_2.png)

###A continuación se le agrega un nuevo rol de vendedor:

![img_3.png](img_3.png)

####A continuación se muestra usurio con id:2 actualizado ->

![img_4.png](img_4.png)

####Nota: en la tabla roles se tienen los siguientes roles registrados:
![img_5.png](img_5.png)

###2) A continuación se presenta un ejemplo aplicado para editar un usuario:

### El usuario con id:4 de la tabla usuarios tiene el siguiente registro ->
![img_6.png](img_6.png)

####Se quiere editar el nombre, para ello se aplica lo siguiente ->

![img_8.png](img_8.png)

####A continuación se muestra el usuario actualizado con id:4 ->

![img_9.png](img_9.png)

####Si se quiere editar el nombre y el correo del usuario con id:4 se aplica lo siguiente->

![img_10.png](img_10.png)

####Así queda registrado el usuario con id:4 actualizado:

![img_11.png](img_11.png)















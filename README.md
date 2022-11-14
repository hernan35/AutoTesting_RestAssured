# Automatizacion de pruebas API REST

## REST ASSURED

### Instalacion 

````
  gradle build
````

### Run Test
En la raiz del proyecto comando de linea.

> Ejecutar todas las pruebas

````
gradle :test --tests "GoRest"
````

> Ejecutar la creacion de usaurio femenino

 ````
 gradle :test --tests "GoRest.createUserFamale"

 ````

> Ejecutar la creacion de post de historia

 ````
 gradle :test --tests "GoRest.createPostHistory"

 ````

## Run test by Env

> Para el ambiente de producción

 ````
 gradle :test --tests "GoRest.createUserFamale" -Denv=prod
 ````


> Para el ambiente de pruebas

 ````
 gradle :test --tests "GoRest.createUserFamale" -Denv=test
 ````
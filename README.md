#  Ricksy Business Observer

## Introducción
Rick se queda a cargo Morty y Summer, y celebra una pedazo de fiesta. Entre los invitados hay adolescentes, aliens, Gearhead, Squanchy, Birdpearson y Abradolph Lincler (una combinación de DNA de Adolf Hitler y Abraham Lincoln).

Cuando un invitado/a llega a la fiesta, se le da de alta en el receptivo del sistema mediante su tarjeta de crédito.

El receptivo carga en el crédito de la tarjeta:

El coste del UberOvni de vuelta a casa
El coste del pack de bienvenida (Collaxion crystals).
El componente de reserva de Ovnis y el componente de entrega del pack de bienvenida observan al componente receptivo, de modo que cuando el receptivo da de alta a un invitado/a automáticamente cargan en la tarjeta del invitado/a el coste de ambos servicios.


![image](diagrama/diagrama_clases_%20UML_.png)

## Funcionalidades
#### Credit Card
- Se puede realizar un pago y se le descuenta el dinero de la tarjeta

#### Ufos Park
- Añade ufos a una lista si no están ocupados
- Asignamos un ufo al invitado si no lo tiene asignado y tiene suficiente dinero
- Nos dice si tenemos ya un ufo asignado y si es así, nos dice cual es el que tenemos asignado

#### Crystal Expender
- Comprueba que tenemos dinero suficiente para el coste del item y si es así, nos lo descuenta de la tarjeta y le resta a la cantidad de stock

#### Receptivo
- Automatiza las tareas UfosPark, CrystalExpender

#### Rick Menu Dispatcher
- Comprueba que tenemos dinero suficiente para el coste del menú y si es así, nos lo descuenta de la tarjeta y le resta a la cantidad de stock

## Prerequisitos
- Java 11
- Maven

## Instalación

Para instalar las dependencias de maven ejecuta:
```
mvn install
```

## Créditos

Este proyecto a sido creado por Manuel Ortega.

## Contacto
Github: https://github.com/ManuOrt/Sneaker_Raffle

Email: mortegamarti@cifpfbmoll.eu
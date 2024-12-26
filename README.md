## Introducción

Bienvenido/a a Roll The Dice, videojuego en creado para la materia Programación 1, perteneciente a la carrera TUDAI del Instituto Universitario Aeronáutico Córdoba. Roll The Dice es un juego de tipo RPG (Role Playing Game), donde el usuario puede elegir entre 3 razas (Cada una con sus propias características) para luchar contra un monstruo y poder escapar del calabozo en el que se encuentra. La posibilidad de atacar va a estar dada por la tirada de un dado. Este videojuego ha sido creado en Java, para mostrar el conocimiento alcanzado con respecto a los pilares del lenguaje. 

## Modo de Juego 

- En primer lugar, deberá ingresar en el cuadro de diálogo la cantidad de jugadores. En caso de no ingresar un número entero, el sistema le notificará que debe hacerlo.

<img src="src/ACTIVIDADPROMOCION_PROG1_BARELLAMARIANO/img_readme/rtd_1.png" alt="Inicio del Juego">

- Luego de ingresar la cantidad de jugadores, iniciará el programa principal mostrando el menú de opciones, a saber:

<img src="src/ACTIVIDADPROMOCION_PROG1_BARELLAMARIANO/img_readme/rtd_2.png" alt="Menu del Juego">

1. "Comenzar Juego": Eligiendo esta opción, da lugar a que el programa
comience su funcionamiento. Por cada jugador, deberá ingresar un nombre,
además de elegir la raza. Cabe destacar que cada raza posee armas y/o
ataques con distintas cualidades.

2. “Listar Jugadores”: Esta opción despliega la información de cada uno de los
jugadores ingresados.

3. “Mostrar Ganadores”: Aquí se muestran solamente aquellos jugadores que
hayan logrado vencer al monstruo, asi como la cantidad de intentos en los
que lo hicieron. Esto se logra ingresando al atributo de tipo boolean “ganó”
mediante su correspondiente getter.

4. “Ver Ganador (Por menos intentos)”: Mediante un método de la clase
demoRPG denominado ordenarGanadores (que trabaja con un algoritmo de
ordenamiento de tipo bubble, se ordenan los jugadores teniendo en cuenta
la cantidad de intentos que les llevó completar el juego. Una vez ordenado,
se encuentra mediante búsqueda secuencial aquel jugador que haya
ganado, y que a la vez posea la menor cantidad de intentos.

5. “Listar Jugadores por Raza”: Este es un informe personalizado que
determina mediante instanceof a qué raza corresponde cada jugador, y
devuelve la cantidad de jugadores que corresponden a cada una de las 3
razas del juego (Guerrero, Mago, Orco).

- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

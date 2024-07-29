![images (2)](https://github.com/user-attachments/assets/3336fbff-1646-46fa-920b-cd77daf396fd)

##Nombre : Bryan Maita

##Correo institucional: bmaitac@est.ups.edu.ec

##Materia : Estructura de datos

##Version : v2.2.2


##Descripcioón:

Aplicar métodos distintos como la programación dinámica, programación recursiva, Bfs y Dfs para recorrer un laberinto y saber cual de estos métodos es mejor para el recorrido en un laberinto.
Habrá ocasiones donde el laberinto tendrá celdas transitables y no transitables.

##Propuesta solución:

-Marco Teórico:

1.-Programación recursiva: Esta se ecarga de llamarse así misma para poder solventar problemas que pueden ser complejos, tenemos el caso base y el caso recursivo.

2.-Programación dinámica: Esta nos ayuda a dividir el problema, solucionarlo y almacenarlo en un cache. Esto se hace para que no hayan cálculos repetidos y el código sea eficiente.

3.-BFS(Breadth-first search): Explora un nodo de un arbol o grafo, haciendolo de nivel en nivel. Comienza en una raiz, explora a los vecinos y luego pasa al siguiente nivel. En en bfs usualmente se usan las colas(FIFO)

4.-DFS(Depth-First search): Este se encarga de adentrarse a lo más profundo de una rama para después seguir con otras ramas. Es decir que esté se basa en una búsqueda de profundidad. En el dfs Usualmente se usan las pilas(LIFO)

-Propuesta Solución: Usar los métodos antes mencionados para que se haga un correcto recorrido en un laberinto. Además de analizar y concluir sobre que método es el más eficiente para un recorrido correcto de laberinto

Lenguajes utilizados: java.

Codigo: Mi código está hecho mediante un model vista controlador, donde la vista es la interfaz gráfica, el modelo es la lógica del programa, y el controlador es la interacción entre el vista y el modelo para que todo funcione bien. En mi caso el MVC es simple, ya que solo se basa en la creación de la matriz. Los métodos, como programación dinámica, programación recursiva, DFS y BFS están hechas en el vista. La creación de la matriz principalmente está en la clase mostrar matriz, no solo está la creación de la matriz sino los otros botones que sirven para realizar los métodos pedidos

La clase ClearButtonListener está para limpiar el panel después de haberlo colorido, ya sea de negro o verde.

La clase cellButtonListener es sencillo y sirve para pintar de negro la matriz.

En el modelo está el almacenamiento de filas y columnas de la  matriz, en la vista solo está creado el boton para generar la matriz y en el controlador está la clase que se encargará de crear la matriz.

la clase TimeListener fue creada para dar animación al recorrido de los métodos, iniciando por {0,1} que sería el inicio del laberinto, este recorrido lo hará hasta que haya llegado a su destino, esta clase será muy importante para los 4 métodos que se aplicarán.

La clase recursivoMetodoButtonListener será donde se llamara a otra clase que usa recursividad, mientras limpia el path, que es un ArrayList que se encarga de almacenar los pasos dados de cada uno de los métodos. También implementa el Timer para que se pueda visualizar paso a paso. 

La clase recorrerMatriz está compuesta por un caso base donde no returna nada si es que el recorrido ya alcanzo su objetivo, si la matriz es nula, o si choca con un boton negro. Luego el caso recursivo que debería cerrar el recorrido porque llego al botón de la ezquina inferior derecha, mientra que, para hacer los recorridos, se llama a si mismo.

La clase programacionDinamica se encarga de recorrer utilizando la programación dinámica, valga la redundancia. Basicamente se encarga de limpiar el path e inicializa el recorrido guardando en la clase privada, fillCache, que se encargara de guardar los datos, también se encarga de mirar si hay un camino disponible, sino returnara un error. Cuando encuentre un camino, el fillCache llena el cache, para que está haga el recorrido más corto que haya encontrado y el reconstructPath reconstruye en la interfaz gráfica.

La clase BFSButtonListener se encarga de inicializar el recorrido. Para el recorrido se utilizo colas(Queue), la clase privada bfs se encarga de buscar el recorrido más corto y eficiento visitando celdas, en este caso la clase ReconstructPaths se encarga de reconstruir el camino trazado por la clase bfs.

La clase DFSButtonListener se encarga de inicializar el recorrido y tener listo el Timer. Su subclase privada dfs se encarga de hacer el recorrido, marcando las celdas que ya visito, esto lo hace hata que pueda encontrar el último boton que sería la meta ha llegar. En este caso no fue necesario usar el reconstructPath.

por último la clase setActionButtonListener se encarga de que al momento de clicar algún botón este funcione bien y controla que los listener esten funcionando de acuerdo al botón que se les asignó, es necesario para un buen funcionamiento de los eventos

-Criterio de integrante: 
1.-Bryan Maita: Utilizar los conocimientos adquiridos en clases además de investigar en alguna páguina web, si es que se tiene alguna duda de algo. Utilizar principalmente los métodos pedidos como la programación dinámica, programación recursiva, BFS y DFS

-Capturas de la integraz grafica y su funcionamiento:
![InterfazGrafica](https://github.com/user-attachments/assets/0d276f4c-1aef-4907-ae8d-236035de558f)

![MetodoRecursivo](https://github.com/user-attachments/assets/da5780f6-9c72-4550-b989-cdd0e2b0587e)

![MetodoProgramacionDinamica](https://github.com/user-attachments/assets/871c1430-dfba-4f52-bd6b-388c941a54eb)

![MetodoBFS](https://github.com/user-attachments/assets/d3e19744-202e-4190-b243-aae90b7c8a34)

![MetodoDFS](https://github.com/user-attachments/assets/d1a3f215-5aae-4d46-a799-1c83946a425d)



##Conclusiones: Como se puede ver, la programación dinámica es el método más eficiente en un recorrido de laberinto, porque en el momento en el que pintaba un cuadro, esa información se guardaba en un cache, por lo que se evitaría realizar acciones repetidas y seguiria su camino normalmente, llegando a su destino sin problema alguno. Sin embargo hay que tener en cuenta mientras más grande sea el laberinto, más memoria va a consumir ya que tiene que guardar más datos.

Consideraciones: Ninguna, creo que está bien debido a que se usaron métodos que habiamos visto en clase, por lo que no creo que sea nesecario alguno consideración, al menos por mi parte.

Buen día.



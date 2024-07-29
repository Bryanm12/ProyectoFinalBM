![images (2)](https://github.com/user-attachments/assets/3336fbff-1646-46fa-920b-cd77daf396fd)

##Nombre : Bryan Maita

##Correo institucional: bmaitac@est.ups.edu.ec

##Materia : Estructura de datos


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

-Criterio de integrante: 
1.-Bryan Maita: Utilizar los conocimientos adquiridos en clases además de investigar en alguna páguina web, si es que se tiene alguna duda de algo. Utilizar principalmente los métodos pedidos como la programación dinámica, programación recursiva, BFS y DFS





##Conclusiones: Como se puede ver, la programación dinámica es el método más eficiente en un recorrido de laberinto, porque en el momento en el que pintaba un cuadro, esa información se guardaba en un cache, por lo que se evitaría realizar acciones repetidas y seguiria su camino normalmente, llegando a su destino sin problema alguno. La programación recursiva no paraba hasta llenar toda la cuadricula, excepto los cuadro marcados de negro y cuadros blancos, los cuales no se podían acceder debido a que los cuadro negros bloqueaban su acceso. Aunque quiza sea un error de mi código. El método BFS


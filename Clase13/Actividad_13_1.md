Clase 13, ejercicio 1:

Primera respuesta: El backtracking utilizado en el problema "n reinas" busca evitar avanzar hacia caminos que no llevan a la solución y de esta manera
ahorrar pasos y cómputo. En el árbol de decisión si detecta que el siguiente nodo no lleva al resultado esperado no se avanza en esa dirección y sus 
ramificaciones ya que directamente se busca otro nodo y por tanto otro camino. En este caso se decide si poner o no una reina en la siguiente fila.

Segunda respuesta: El algoritmo finaliza cuando son ubicadas todas las reinas, ya que en este caso fue posible resolver el problema, si todas las casillas
estaban bloqueadas/atacadas por las demás reinas no sería posible poner todas las reinas y se debería tomar otro camino. Cuando no se pueden colocar más
reinas puede significar que ya fueron colocadas todas las reinas o que ese camino no es el correcto, depende de la cantidad de reinas que se buscan colocar.

Tercera respuesta: El algoritmo luego de probar, retrocede cuando el siguiente nodo no lleva a la solución/camino correcto, el python tutor vuelve a la 
posición en la que se encontraba poniendo a los iteradores i y j el valor de -1 ya que retrocede al nodo anterior para probar por otros caminos. Además en
el método isSafe devuelve true o false según puede o no colocarse una dama en esa celda.

Cuarta respuesta: Para cambiar la cantidad de reinas en el código del repositorio de la materia se debe cambiar el valor de la constante N, pasando esta
de valer 4 a 8. El costo para resolver este algoritmo es factorial por lo cual aumenta enormemente el tiempo de ejecución por cada reina agregada, en el
caso de pasar de 4 a 8, sería pasar de 4*3*2*1 = 24 a 8*7*6*5*4*3*2*1 = 40320.

Quinta respuesta: El método isSafe detecta si la posición en la que se está queriendo colocar la dama esta siendo atacado por otra dama, en caso de no estarlo
es una celda segura y por tanto devolverá true y se podrá colocar la dama, caso contrario devolverá false y el algoritmo deberá probar con la siguiente
casilla llamando al mismo método para comprobar si es segura y así constantemente hasta finalizar el programa.


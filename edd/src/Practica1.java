/** Práctica 1.- Estructuras de datos
 * @author Alcántara Estrada Kevin Isaac
 * @author Rubio Haro Mauricio
 */

package Clases;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

import Clases.IteradorLista;

public class Practica1 {

    /**
     * Hacer la unión de conjuntos representador en listas
     * 
     * Primero necesitamos los iteradores de ambas listas, luego solo necesitamos
     * recorrer una de las dos listas, es este caso decidí que fuese la primera,
     * por ello recorremos la segunda lista (como solo recorremos la lista, el
     * tiempo
     * de ejecución es de O(n)) y preguntamos si tal elemento ya están en la lista1,
     * sólo
     * en caso de no estar será cuando lo agregaremos en la primer lista
     * 
     * ¿Cómo mejoraríamos el tiempo?
     * El detalle con este método, es que al preguntar si existe (contains) dentro
     * de un for,
     * la complejidad es O(n*m), osea que si ambas listas tienen longitud 1000,
     * haremos un millón
     * de ejecuciones. Lo que se podría hacer, es ordenar ambas listas (lo cuál sólo
     * requeriría un for)
     * y como estamos hablando de números enteros, es posible, posteriormente a
     * manera de pilas
     * comparar los números, si los de una pila son más pequeños que los de otra,
     * agregamos el pequeño,
     * de otro modo agregamos el granda, así hasta haber recorrdio ambas pilas,
     * luego preguntamos
     * si son iguales, en caso de que sí, nos saltaremos de posición en ambas pilas,
     * como sólo se
     * necesita de un bucle para hacer esto, la complejidad del tiemo sería O(n+m)
     * 
     * @param lista1
     * @param lista2
     */

    public static void Union(Lista<Integer> lista1, Lista<Integer> lista2) {
        IteradorLista<Integer> iteradorL2 = lista2.iteradorLista();
        int longiAux2 = lista2.size();
        for (int i = 0; i < longiAux2; i++) {
            if (!lista1.contains(iteradorL2.next())) {
                iteradorL2.previous();
                lista1.add(iteradorL2.next());
            }
        }
        return;
    }

    /**
     * Metodo para agregar un elemento en una lista ordenada en el lugar
     * correspondiente.
     * Nuestro algoritmo utiliza un tiempo O(n) puesto que para agregar el elemento
     * de manera ordenada, debe recorrer la lista hasta encontrar un número que sea
     * mayor que el que queremos agregar a la lista. En el peor de los casos,
     * ninguno de los elementos de la lista es mayor al que deseamos agregar; por
     * ello, hemos recorrido todos los elementos de la lista y al final agregamos el
     * nuevo elemento.
     *
     * Suponiendo de nuestra lista tiene n elementos y se da el peor de los casos,
     * hemos hecho n comparaciones, por lo que estaríamos en un tiempo O(n).
     *
     * En cuanto al espacio, nuestro algoritmo usa espacio O(1), puesto que sólo
     * creamos un iterador, una variable booleana y dos variables de tipo entero,
     * por lo que el espacio que ocupas es siempre la misma cantidad y, por lo
     * tanto, constante. Por lo tanto, el espacio que ocupamos pertenece a O(1).
     * 
     * @param lista Representa una lista de enteros a la que se le agregara un
     *              elemento
     * @param nuevo Representa el elemento tipo int a agregar en la lista
     * @return lista Regresa la lista que recibimos como parametro ya modificada
     */

    public static Lista<Integer> AgregaOrdenado(Lista<Integer> lista, int nuevo) {

        Iterator<Integer> iterador = lista.iterator();
        if (iterador.hasNext()) {
            int p = 0;
            int c = 0;
            boolean listo = false;

            while (listo == false) {
                c = lista.indexOf(p);
                if (p >= nuevo) {
                    lista.insert(c, nuevo);
                    listo = true;
                }
                p++;
            }
        } else {

            lista.add(nuevo);
        }
        return lista;

    }

    /**
     * Metodo para obtener la interseccion entre dos listas
     * En cuanto a tiempo, nuestro algoritmo toma un tiempo de O(n*m) siendo n el
     * número de elementos de "lista" y m el número de elementos de "lista2".
     *
     * Ello debido a que por cada elemento de "lista" evaluamos si se encuentra en
     * "lista" con el método contains(), (que tiene un tiempo O(n), pero al ser
     * ocupado sobre la segunda lista sería tiempo 0(m)), teniendo en ese primer
     * paso O(n*m) en tiempo.
     *
     * Posteriomente, para eliminar repetidos, por cada elemento de la intersección
     * ya formada, (que corresponde a los elementos de "lista" que permanecen), el
     * peor de los casos es tener n elementos y, como usamos el método contains(),
     * suponiendo que no hay elementos repetidos en "lista", entonces tendríamos un
     * tiempo O(n^2) sumándose al que ya teníamos; sin embargo, sabemos lo
     * siguiente:
     * nm <= 2nm -----> n^2+nm <= n^2 +2nm para todo n,m>=1
     * Por lo anterior, el tiempo sigue pertenenciendo a O(n*m)
     *
     * EN cuanto a espacio, ademas de algunas variables de tipo entero y un iterador
     * (que ocupan espacio O(1)), utilizamos una lista auxiliar a la que le
     * agregamos los elementos de la intersección que, como mencionamos, a lo mucho
     * son n elementos (contando repetidos); por lo cual usamos un espacio de O(n).
     *
     * Como se trabaja agregando los elementos de "lista" a "listAux", si tenemos el
     * caso donde m>n, no es relevante, pues el espacio utilizado será el de n, que
     * al ser menor, sigue perteneciendo a O(m); así, se cumple que:
     *
     *
     * Tiempo: O(n/m)
     * Espacio: O(n) u O(m) si m>n
     *
     * ¿Como lo mejorariamos?
     * Para mejorar el tiempo, pensaria en buscar una manera de hacerlo de O(n) o
     * O(n^2), puesto que hay casos en los que O(n*m) es mucho mayor en tiempo que
     * los anteriores mencionados, por ello,primero haria copias de las listas (toma
     * O(n) + O(m)) consideraria hacer metodos para eliminar repetidos de las listas
     * que sean mas eficientes en tiempo, sin repetidos, ordenamos las listas (con
     * un buen algoritmo nos puede tomar menos de O(n^2)) y una vez ordenadas
     * unirlas con mezclaOrdenada (cuyo tiempo es O(n+m)) y entonces, utilizando
     * unas de las lineas de codigo implementadas en el algoritmo, en vez de
     * eliminar repetidos, agregar a una lista nueva solamente los repetidos y asi
     * el tiempo seria, a lo mucho O(n^2), pero perderiamos en memoria.
     * 
     * @param lista  Representa la primer lista a considerar para la interseccion,
     *               esta sera modificada
     * @param lista2 Representa la otra lista de enteros con la que haremos la
     *               interseccion, esta no sera modificada
     */
    // Aqui va tu comentario
    public static void Interseccion(Lista<Integer> lista, Lista<Integer> lista2) {
        Lista<Integer> listAux = new Lista<Integer>();
        IteradorLista<Integer> ite = lista.iteradorLista();
        int j = 0;

        while (ite.hasNext()) {

            j = ite.next();

            if (!lista2.contains(j)) {

                lista.delete(j);
            }
        }

        ite.start();
        while (ite.hasNext()) {
            j = ite.next();
            if (!listAux.contains(j)) {
                listAux.add(j);
            } else {
                lista.delete(j);
            }

        }

        return;
    }

    public static void main(String[] args) {
        Lista<Integer> primera = new Lista<Integer>();
        Lista<Integer> segunda = new Lista<Integer>();
        Lista<Integer> tercera = new Lista<Integer>();

        // Tests toString
        for (int i = 0; i <= 5; i++) {
            primera.add(i);
        }

        String test = "0 -> 1 -> 2 -> 3 -> 4 -> 5";
        if (!primera.toString().equals(test)) {
            System.out.println("1 El toString no funciona!");
        }
        primera = new Lista<Integer>();
        if (!primera.toString().equals("")) {
            System.out.println("2 El toString no funciona!");
        }

        // Tests Reverse
        primera = new Lista<Integer>();
        segunda = new Lista<Integer>();

        for (int i = 0; i <= 10; i++) {
            primera.add(i);
            segunda.agregaInicio(i);
        }

        primera.reverse();
        if (!primera.toString().equals(segunda.toString())) {
            System.out.println("1 El reverse no funciona!");
        }
        primera = new Lista<Integer>();
        segunda = new Lista<Integer>();
        primera.reverse();
        if (!primera.toString().equals(segunda.toString())) {
            System.out.println("2 El reverse no funciona!");
        }

        // Tests Append
        primera = new Lista<Integer>();
        segunda = new Lista<Integer>();
        for (int i = 0; i <= 10; i++) {
            primera.add(i);
            segunda.add(i);
        }
        for (int i = 0; i <= 10; i++) {
            segunda.add(i);
        }
        primera.append(primera.clone());

        if (!primera.toString().equals(segunda.toString())) {
            System.out.println("1 El Append no funciona!");
        }

        // Tests IndexOf
        if (primera.indexOf(0) != 0) {
            System.out.println("1 El IndexOf no funciona!");
        }
        if (primera.indexOf(1) != 1) {
            System.out.println("2 El IndexOf no funciona!");
        }
        if (primera.indexOf(10) != 10) {
            System.out.println("3 El IndexOf no funciona!");
        }

        // Tests Insert
        primera = new Lista<Integer>();
        segunda = new Lista<Integer>();
        for (int i = 0; i <= 10; i++) {
            primera.add(i);

        }
        for (int i = 0; i <= 4; i++) {
            segunda.add(i);

        }
        segunda.add(6);
        for (int i = 5; i <= 10; i++) {
            segunda.add(i);

        }

        primera.insert(5, 6);
        if (!primera.toString().equals(segunda.toString())) {
            System.out.println("1 El insert no funciona!");
        }

        // Tests Mezcla Alternada
        primera = new Lista<Integer>();
        segunda = new Lista<Integer>();
        for (int i = 0; i <= 10; i++) {
            if (i % 2 == 0) {
                primera.add(i);
            }
        }
        primera.add(11);
        for (int i = 0; i <= 10; i++) {
            if (i % 2 != 0) {
                segunda.add(i);
            }

        }
        for (int i = 0; i <= 11; i++) {

            tercera.add(i);

        }

        primera.mezclaAlternada(segunda);
        if (!primera.toString().equals(tercera.toString())) {
            System.out.println("1 la mezclaAlternada no funciona!");
        }

        // Tests Agrega Ordenado
        primera = new Lista<Integer>();
        segunda = new Lista<Integer>();
        for (int i = 0; i <= 10; i++) {
            primera.add(i);
        }
        for (int i = 0; i <= 9; i++) {
            segunda.add(i);
        }
        segunda.add(9);
        segunda.add(10);

        tercera = AgregaOrdenado(primera,9);
        if (!tercera.toString().equals(segunda.toString())) {
            System.out.println("1 el agregaOrdenado no funciona!");
        }

        // Tests Union
        primera = new Lista<Integer>();
        segunda = new Lista<Integer>();
        tercera = new Lista<Integer>();
        primera.add(1);
        primera.add(2);
        primera.add(3);
        segunda.add(2);
        Union(primera, segunda);

        if (!(primera.contains(1) && primera.contains(2) && primera.contains(3) && primera.size() == 3)) {
            System.out.println("1 La union no funciona!");
        }

        // Tests interseccion
        primera = new Lista<Integer>();
        segunda = new Lista<Integer>();
        tercera = new Lista<Integer>();
        primera.add(1);
        primera.add(2);
        primera.add(3);
        segunda.add(2);
        Interseccion(primera, segunda);

        if (!(primera.contains(2) && primera.size() == 1)) {
            System.out.println("1 La intersección no funciona!");
        }
    }

}

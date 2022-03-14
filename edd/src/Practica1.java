package Clases;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

import Clases.IteradorLista;

public class Practica1 {

    
    /** Hacer la unión de conjuntos representador en listas
     * 
     * Primero necesitamos los iteradores de ambas listas, luego solo necesitamos
     * recorrer una de las dos listas, es este caso decidí que fuese la primera,
     * por ello recorremos la segunda lista (como solo recorremos la lista, el tiempo
     * de ejecución es de O(n)) y preguntamos si tal elemento ya están en la lista1, sólo
     * en caso de no estar será cuando lo agregaremos en la primer lista
     * 
     * ¿Cómo mejoraríamos el tiempo?
     * El detalle con este método, es que al preguntar si existe (contains) dentro de un for,
     * la complejidad es O(n*m), osea que si ambas listas tienen longitud 1000, haremos un millón 
     * de ejecuciones. Lo que se podría hacer, es ordenar ambas listas (lo cuál sólo requeriría un for)
     * y como estamos hablando de números enteros, es posible, posteriormente a manera de pilas
     * comparar los números, si los de una pila son más pequeños que los de otra, agregamos el pequeño,
     * de otro modo agregamos el granda, así hasta haber recorrdio ambas pilas, luego preguntamos
     * si son iguales, en caso de que sí, nos saltaremos de posición en ambas pilas, como sólo se
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

    // Aqui va tu comentario

    public static void Interseccion(Lista<Integer> lista, Lista<Integer> lista2) {

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

        // tercera = AgregaOrdenado(primera,9);
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

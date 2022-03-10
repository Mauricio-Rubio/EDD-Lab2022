package Clases;

import java.util.Iterator;
import java.util.Scanner;

public class Practica1 {

    // Aqui va tu comentario
    
      public static Lista<Integer> AgregaOrdenado(Lista<Integer> lista, int nuevo)
      {
      	int q = 0;
	int r = 0;
	Iterator<Integer> iterador = lista.iterator();
	if(iterador.hasNext()){
	    int p=0;
	    boolean listo=false;
	    p = 0;
	    
	    while(listo==false){
		int c = lista.indexOf(p);
	    if(p>=nuevo){
		lista.insert(c,nuevo);
		listo=true;
	    }
	    p++;
	    }
	}else{
	    
	    lista.add(nuevo);
	}   
	return lista;
      
      }
    /* 
     * // Aqui va tu comentario
     * public static void Union(Lista<Integer> lista1,Lista<Integer> lista2) {
     * return ;
     * }
     */ 
      // Aqui va tu comentario
      public static void Interseccion(Lista<Integer> lista,Lista<Integer> lista2) {
	  Lista<Integer> listAux = lista;
	  IteradorLista<Integer> ite = lista.iteradorLista();
	  // Nodo n = new Nodo(elemento);
	  while(ite.hasNext()){
	  ite.start();
	  // for(int i=0; i<listAux.longi; i++){
	  // if(!iterador.hasNext()){
	  //	  break;
	  //  }
	  int i = ite.next();
	  
	  if(!lista2.contains(i)){
	      listAux.delete(i);

	      
	      
	  }

	  if(ite.next()==null){
	      if(lista2.contains(ite.previous())){
		  listAux.delete(ite.previous());
	      }
	  }
	  /*else if(!lista2.contains(ite.previous())){
	       listAux.delete(ite.previous());
	  }else{
	      listAux.add(ite.next()); 
	  }
	   */
	  
	  // }
	  lista=listAux;

	  
	  
	  i++;
	  }
	  ite.end();
	  if(!lista2.contains(ite.previous())){
	      listAux.delete(ite.next());
	  }
      return ;
      }
     

    public static void main(String[] args) {
        Lista<Integer> primera = new Lista<Integer>();
        Lista<Integer> segunda = new Lista<Integer>();
        Lista<Integer> tercera = new Lista<Integer>();

        // Tests toString
	/*
        for (int i = 0; i <= 5; i++) {
            primera.add(i);
        }
        String test = "0 -> 1 -> 2 -> 3 -> 4 -> 5";
        // System.out.println(primera.toString());
        if (!primera.toString().equals(test)) {
            System.out.println("1 El toString no funciona!");
        }
        primera = new Lista<Integer>();
        if (!primera.toString().equals("")) {
            System.out.println("2 El toString no funciona!");
        }
	*/
        // Tests Reverse
        primera = new Lista<Integer>();
        segunda = new Lista<Integer>();

        for (int i = 0; i <= 10; i++) {
            primera.add(i);
            segunda.agregaInicio(i);
        }
 System.out.println(primera.toString());
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

	//Test IndexOf
	if (primera.indexOf(0) != 0) {
          System.out.println("1 El IndexOf no funciona!");
          }
          if (primera.indexOf(1) != 1) {
          System.out.println("2 El IndexOf no funciona!");
          }
          if (primera.indexOf(10) != 10) {
	      System.out.println("10 El index no funciona");
	  }

	  System.out.println(primera.indexOf(1));
	   System.out.println(primera.indexOf(2));
	    System.out.println(primera.indexOf(10)); 

        // Tests IndexOf
        /*
         * if (primera.indexOf(0) != 0) {
         * System.out.println("1 El IndexOf no funciona!");
         * }
         * if (primera.indexOf(1) != 1) {
         * System.out.println("2 El IndexOf no funciona!");
         * }
         * if (primera.indexOf(10) != 10) {
         * System.out.println("3 El IndexOf no funciona!");
         * }
         */

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
        /*
         * primera = new Lista<Integer>();
         * segunda = new Lista<Integer>();
         * for (int i = 0; i <= 10; i++) {
         * if (i % 2 == 0) {
         * primera.add(i);
         * }
         * }
         * primera.add(11);
         * for (int i = 0; i <= 10; i++) {
         * if (i % 2 != 0) {
         * segunda.add(i);
         * }
         * 
         * }
         * for (int i = 0; i <= 11; i++) {
         * 
         * tercera.add(i);
         * 
         * }
         * 
         * 
         * primera.mezclaAlternada(segunda);
         * if (!primera.toString().equals(tercera.toString())) {
         * System.out.println("1 la mezclaAlternada no funciona!");
         * }
         * 
         * 
	 */
	//Tests Agrega Ordenado
         
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
	System.out.println(tercera.toString());

        // Tests Union
        /*
         * primera = new Lista<Integer>();
         * segunda = new Lista<Integer>();
         * tercera = new Lista<Integer>();
         * primera.add(1);
         * primera.add(2);
         * primera.add(3);
         * segunda.add(2);
         * Union(primera, segunda);
         * 
         * if (!(primera.contains(1) && primera.contains(2) && primera.contains(3) &&
         * primera.size() == 3)) {
         * System.out.println("1 La union no funciona!");
         * }
         * 
	 */
         // Tests interseccion
          primera = new Lista<Integer>();
          segunda = new Lista<Integer>();
          tercera = new Lista<Integer>();
	  primera.add(-2);
	  primera.add(-1);
	  primera.add(0);
          primera.add(1);
          primera.add(2);
          primera.add(3);
	  segunda.add(1);
          segunda.add(2);
	  segunda.add(3);
	  segunda.add(4);
	  
	  System.out.println("////////////");
	  System.out.println(primera.toString());
	  System.out.println(segunda.toString());
          Interseccion(primera, segunda);
          
          if (!(primera.contains(2) && primera.size() == 1)) {
          System.out.println("1 La intersección no funciona!");
          }

	  System.out.println("Interseccion "+primera.toString());
	  System.out.println(segunda.toString());
	  /*System.out.println("////////////");
 Interseccion(primera, segunda);
	   System.out.println(primera.toString());
	 
	  System.out.println("////////////");
 Interseccion(primera, segunda);
	   System.out.println(primera.toString());

	    
	  System.out.println("////////////");
 Interseccion(primera, segunda);
	   System.out.println(primera.toString());

	    System.out.println("////////////");
 Interseccion(primera, segunda);
	   System.out.println(primera.toString());
	  */
          
	  /* for(int i = 0; i<primera.longi; i++){
          System.out.println(primera);
          }
          // Scanner sc = new Scanner (System.in);
          // //Lista<Integer> primera = new Lista<Integer>();
          // Lista <Integer> testReverse = new Lista<>();
          // for(int i = 0; i<3; i++){
          // System.out.println("Ingresa un numero");
          // testReverse.add(sc.nextInt());
          // }
          // for(int i = 0; i<testReverse.longi; i++){
          // //System.out.println("-->"+testReverse.);
         * // }
         */

    }

}

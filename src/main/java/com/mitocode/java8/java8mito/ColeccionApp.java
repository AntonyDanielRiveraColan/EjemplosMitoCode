package com.mitocode.java8.java8mito;

import java.util.ArrayList;
import java.util.List;

public class ColeccionApp {

  private List<String> lista;

  /**
   * Metodo sin retorno que crea y llena y una lista.
   */
  public void llenaLista() {
    lista = new ArrayList<>();
    lista.add("Mito Code");
    lista.add("Code");
    lista.add("Mito");
  }

  /**
   * Metodo que usa la estructura de repeticion ForEach. En el cual se realiza la operacion de
   * imprimir
   */
  public void usarForEach() {
    /* for(String elemento : lista) {
       System.out.println(elemento);
   } */

    //lista.forEach(x -> System.out.println(x));

    lista.forEach(System.out::println);
  }

  /**
   * En el sgt meotodo se utliza removeIf. En el cual se elimina de una lista el elemento que cumpla
   * con determinado filtro
   */
  private void usarRemoveIf() {
    /*
      Iterator<String> it = lista.iterator();
      while (it.hasNext()) {
      if (it.next().equalsIgnoreCase("Code")) {
      it.remove();
      }
    }
    */
    //Expresion lambda apoyado de equalsIgnoreCase hace que mayusculas o minusculas sean indistintas
    lista.removeIf(x -> x.equalsIgnoreCase("Code"));

  }

  /**
   * El sgt metodo ordena una lista de forma alfabéticamente.
   */
  private void usarSort() {
    //Para ordenar la lista de forma accedente usando un comparador
    lista.sort((x, y) -> x.compareTo(y));

  }

  /**
   * Metodo principal. En este metodo se esta llamando a los metodos creados anteriormente para su
   * ejecucion
   */
  public static void main(String... mitoCode) {
    ColeccionApp app = new ColeccionApp();
    app.llenaLista();
    //app.usarRemoveIf();
    app.usarSort();
    app.usarForEach();
  }


}

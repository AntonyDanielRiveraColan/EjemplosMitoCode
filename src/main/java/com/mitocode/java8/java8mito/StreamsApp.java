package com.mitocode.java8.java8mito;

import java.util.ArrayList;
import java.util.List;


public class StreamsApp {

  private List<String> lista;
  private List<String> numeros;

  /**En el sgt constructor se inicializa las listas.
 * Ademas se les agrega un valor */
  public StreamsApp() {
    lista = new ArrayList<>();
    lista.add("Mito");
    lista.add("Code");
    lista.add("Jaime");
    lista.add("MitoCode");

    numeros = new ArrayList<>();
    numeros.add("1");
    numeros.add("2");

  }

  private void filtrar() {
    lista.stream().filter(x -> x.startsWith("M")).forEach(System.out::println);

  }

  private void ordenar() {
    //Acendente
    //lista.stream().sorted().forEach(System.out::println);
    //Desendente
    lista.stream().sorted((x, y) -> y.compareTo(x)).forEach(System.out::println);
  }


  private void transformar() {
    //lista.stream().map(String::toUpperCase).forEach(System.out::println);
    /**
     for (String x : numeros) {
      int num = Integer.parseInt(x) + 1;
      System.out.println(num);
    } */

    numeros.stream().map(x -> Integer.parseInt(x) + 1).forEach(System.out::println);
  }

  private void limitar() {
    lista.stream().limit(2).forEach(System.out::println);

  }

  private void contar() {
    long x = lista.stream().count();
    System.out.println(x);
  }

  /**El sgt metodo es el principal se encarga de llamar a los metodos anterioemente creados. */
  public static void main(String[] args) {
    StreamsApp app = new StreamsApp();
    //app.filtrar();
    //app.ordenar();
    //app.transformar();
    //app.limitar();
    app.contar();
  }


}

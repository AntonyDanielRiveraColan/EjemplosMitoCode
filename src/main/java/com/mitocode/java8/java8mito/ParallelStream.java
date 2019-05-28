package com.mitocode.java8.java8mito;

import java.util.ArrayList;
import java.util.List;

public class ParallelStream {

  private List<Integer> numeros;

  /**El sgt metodo.
   * LLena la lista declarada lineas arriba*/
  public void llena() {
    numeros = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      numeros.add(i);
    }
  }

  /**El sgt metodo prueba stream.
   * Lee e imprime toda la lista*/
  private void probarStream() {
    numeros.stream().forEach(System.out::println);

  }

  /**El sgt metodo prueba parallelStream.
   * Lee e imprime toda la lista utilizando hilos*/
  private void probarParalelo() {
    numeros.parallelStream().forEach(System.out::println);

  }

  /**El sgt metodo es el principal.
   *Llama a los otros metodos creados lineas arriba*/
  public static void main(String[] args) throws InterruptedException {
    ParallelStream app = new ParallelStream();

    app.llena();
    //app.probarStream();
    app.probarParalelo();
  }


}

package com.mitocode.java8.java8mito;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class HighApp {

  /**Convierte la cadena en mayusculas.*/
  private Function<String, String> convertirMayusculas = x -> x.toUpperCase();
  /**Convierte la cadena en minusculas.*/
  private Function<String, String> convertirMinusculas = x -> x.toLowerCase();

  /**Imprime el valor aplicando la funcion que se le ingresa.*/
  public void imprimir(Function<String, String> funsion, String valor) {
    System.out.println(funsion.apply(valor));

  }

  /**El siguiente metodo realiza una agregacion de cadenas.*/
  public Function<String, String> mostrar(String mensaje) {
    return (String x) -> mensaje + x;
  }

  /**El siguiente metodo realiza un filtrado respecto a los datos que se le ingresan.*/
  public void filtrar(List<String> lista, Consumer<String> consumidor, int longitud) {
    lista.stream().filter(this.establecerLogicaFiltro(longitud)).forEach(consumidor);

  }

  /**El siguiente metodo realiza un filtrado respecto a los datos que se le ingresan.*/
  public void filtro2(List<String> lista, Consumer<String> consumidor, int longitud,
      String cadena) {
    lista.stream().filter(this.establecerLogicaFiltro(cadena)).forEach(consumidor);

  }

  /**El siguiente metodo realiza una restriccion a manera de logica.*/
  public Predicate<String> establecerLogicaFiltro(int longitud) {
    return texto -> texto.length() < longitud;
  }

  /**El siguiente metodo realiza una restriccion a manera de logica.*/
  public Predicate<String> establecerLogicaFiltro(String cadena) {
    return texto -> texto.contains(cadena);
  }

  /**El siguiente metodo principal.*/
  public static void main(String[] args) {
    HighApp app = new HighApp();
    app.imprimir(app.convertirMayusculas, "hola mundo");
    app.imprimir(app.convertirMinusculas, "HOLA MUNDO");

    String respuesta = app.mostrar("Hola  ").apply("Antony");
    app.imprimir(app.convertirMayusculas, respuesta);

    //Tradicional
    System.out.println(respuesta.toLowerCase());
    System.out.println(respuesta.toUpperCase());

    List<String> lista = new ArrayList<>();
    lista.add("Rivera");
    lista.add("Colan");
    lista.add("Antony");
    app.filtrar(lista, System.out::println, 6);
    app.filtro2(lista, System.out::println, 0, "tony");
  }

}

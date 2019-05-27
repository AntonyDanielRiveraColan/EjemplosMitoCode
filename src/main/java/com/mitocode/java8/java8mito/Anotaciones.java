package com.mitocode.java8.java8mito;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Anotaciones {

  /**
   * La sgt @Retention – Especifica el nivel de retención de la anotación. RetentionPolicy.SOURCE =
   * Retenida sólo a nivel de código; ignorada por el compilador. RetentionPolicy.CLASS — Retenida
   * en tiempo de compilación, pero ignorada en tiempo de ejcución. RetentionPolicy.RUNTIME —
   * Retenida en tiempo de ejecución, sólo se puede acceder a ella en este tiempo.
   */
  @Retention(RetentionPolicy.RUNTIME)

  /** Una anotación se define con @interface */
  public @interface Lenguajes {
    /**Se crea un arreglo con un valor por defecto. */
    Lenguaje[] value() default {};
  }


  /*** La sgt anotacion @Repeatable.
   *  Se puede utilizar varias veces en el alcance donde se define
   */
  @Repeatable(value = Lenguajes.class)
  public @interface Lenguaje {
    /**La sgt linea indica que solo resive datos del tipo cadena.*/
    String value();
  }

  /**
   * Uso de la nueva anotacion.
   */
  @Lenguaje("Java")
  @Lenguaje("Pyton")
  @Lenguaje("VB")

  public interface LenguajeProgramacion {

  }

  /**El sgt metodo crea un arreglo apoyandose en la notacion creada.
   *  para ser impreso,para tal motivo se recorre a traves de una estructura for de repeticion */
  public static void main(String[] args) {
    Lenguaje[] lenguajeArray = LenguajeProgramacion.class.getAnnotationsByType(Lenguaje.class);
    System.out.println("Se tiene  " + lenguajeArray.length + " anotaciones en lenguaje");
    Lenguajes len = LenguajeProgramacion.class.getAnnotation(Lenguajes.class);
    for (Lenguaje elemento : len.value()) {
      System.out.println(elemento.value());
    }
  }

}

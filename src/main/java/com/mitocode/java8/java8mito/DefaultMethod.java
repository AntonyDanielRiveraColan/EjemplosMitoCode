package com.mitocode.java8.java8mito;

import interfacePrimerosEjercicios.PersomaB;
import interfacePrimerosEjercicios.PersonaA;

public class DefaultMethod implements PersonaA, PersomaB {

  /**
   * El sgt es el metodo principal. En el presente metodo encontramos los llamados a los metodos
   * implementamos
   */
  public static void main(String[] args) {
    DefaultMethod app = new DefaultMethod();
    //app.caminar();
    app.hablar();
  }


  @Override
  public void caminar() {
    System.out.println("Hola a todos");

  }

  /** //Desbloquear para realizar la reescritura del metodo.
   * @Override
 public void hablar() {
 //PersonaA.super.hablar();
 System.out.println("Hola hablar desde la PersonaA");
  } */

  @Override
  public void hablar() {
    PersomaB.super.hablar();

  }


}

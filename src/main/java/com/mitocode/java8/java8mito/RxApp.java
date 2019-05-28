package com.mitocode.java8.java8mito;

import java.util.ArrayList;
import java.util.List;

import rx.functions.Action1;

public class RxApp {

  private List<Integer> list1;
  private List<Integer> list2;

  /**Metodo que crea dos listas y llama a un metodo para llenarlas.*/
  public RxApp() {
    list1 = new ArrayList<>();
    list2 = new ArrayList<>();
    this.llenarLista();
  }

  /**Metodo para llenar las listas.*/
  private void llenarLista() {
    for (int i = 0; i < 10000; i++) {
      list1.add(i);
      list2.add(i);
    }

  }

  /**En el sgt metodo buscar.
   * Se declara dos objetos del tipo Observable y se le pasa las listas
   * para luego unir lo obejtos aplicar un filtro y al final imprimir*/
  private void buscar() {
    rx.Observable<Integer> obs = rx.Observable.from(list1);
    rx.Observable<Integer> obs2 = rx.Observable.from(list2);

    /**
     rx.Observable.merge(obs, obs2).subscribe(new Action1<Integer>() {

     @Override
     public void call(Integer numero) {
     if (numero==1 ) {
     system.out.println(numero);
    }
    }
     });  */

    //rx.Observable.merge(obs,obs2).filter(x -> x>1 && x < 9).subscribe(System.out::println);

    rx.Observable.merge(obs, obs2).filter(x -> x > 10).subscribe(x -> {
      //Puedes completar el filtro deseado con una logica interna
      if (x < 20) {
        System.out.println(x);
      }
    });

    /** rx.Observable.merge(obs,obs2).subscribe(x -> {
    if (x >1 && x<20) {
    System.out.println(x);
    }
    }); */

  }

  /**En el sgt metodo MetodoPrueba.
   * Se declara dos objetos del tipo Observable y se le pasa las listas
   * para luego unir lo obejtos aplicar un filtro y al final imprimir*/
  private void metodoPrueba() {
    List<String> lista = new ArrayList<>();
    lista.add("Mito");
    lista.add("Code");
    lista.add("MitoCode");

    rx.Observable<String> obs = rx.Observable.from(lista);
    obs.subscribe(new Action1<String>() {

      @Override
      public void call(String elemento) {
        System.out.println(elemento);

      }

    });

  }

  /**El sgt es el metodo principal.*/
  public static void main(String[] args) {
    RxApp app = new RxApp();
    // app.metodoPrueba();
    app.buscar();
  }

  // Final
}

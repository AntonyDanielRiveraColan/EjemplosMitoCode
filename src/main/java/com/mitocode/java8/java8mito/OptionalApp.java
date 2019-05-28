package com.mitocode.java8.java8mito;

import java.util.Optional;

public class OptionalApp {

  /**
   * En el sgt metodo. Se utiliza Optional el cual se puede utilizar con una exception ligera
   */
  public void probar(String valor) {
    //System.out.println(valor.contains("mito"));
    try {
      Optional op = Optional.empty();
      op.get();

    } catch (Exception e) {
      System.out.println("Elemento erroneo");
    }
  }

  /**
   * En el sgt metodo usamos orElse. Noss devuelve el valor o si no devolverá el valor que le
   * demos.
   */
  private void orElse(String valor) {
    Optional<String> op = Optional.ofNullable(valor);
    String x = op.orElse("predeterminado");
    System.out.println(x);

  }

  /**
   * En el sgt metodo usamos orElseThrow. Noss devolverá el valor si está presente y si invocará la
   * función que le pasemos, la cual tiene que devolver una excepción y lanzará dicha excepción.
   */
  private void orElseThrow(String valor) {
    Optional<String> op = Optional.ofNullable(valor);
    String x = op.orElseThrow(NumberFormatException::new);
    System.out.println(x);
  }

  /**
   * En el sgt metodo usamos isPresent. El cual equivale a variable != null
   */
  private void isPresent(String valor) {
    Optional<String> op = Optional.ofNullable(valor);
    System.out.println(op.isPresent());
  }

  /**
   * En el sgt metodo es el principal. El cual realiza los llamados a los otros metodos
   */
  public static void main(String[] args) {
    OptionalApp app = new OptionalApp();
    //app.probar("MitoCode");
    //app.orElse(null);
    //app.orElseThrow("Prueba");
    app.isPresent(null);
  }


}

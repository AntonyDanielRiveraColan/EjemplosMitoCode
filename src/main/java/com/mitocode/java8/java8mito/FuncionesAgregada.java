package com.mitocode.java8.java8mito;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class FuncionesAgregada {

  /**
   * En la sgt lineaclave/valor. Se creo un objeto clave valor
   */
  private Map<Integer, String> map;

  /**
   * En el siguiente metodo. Se llena el valor del objeto anteriormente creado
   */
  public void poblar() {
    map = new HashMap<>();
    map.put(1, "Mito");
    map.put(2, "Code");
    map.put(3, "Suscribete");

  }

  /**
   * El siguiente metodo. Realiza la impresion de la forma java 7
   */
  public void imprimir_v7() {
    for (Entry<Integer, String> e : map.entrySet()) {
      System.out.println(" Llave: " + e.getKey() + " Valor: " + e.getValue());
    }
  }

  /**
   * El siguiente metodo. Realiza la impresion de la forma java 8
   */
  public void imprimir_v8() {
    //map.forEach((k,v) -> System.out.println("Llave: "+k+" Valor: "+v));
    map.entrySet().stream().forEach(System.out::println);
  }

  /**
   * El siguiente metodo recolecta. Estudiar este metodo hasta entenderlo
   */
  public void recolectar() {
    Map<Integer, String> mapRecolectado = map.entrySet().stream()
        .filter(x -> x.getValue().contains("o"))
        .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));

    mapRecolectado.forEach((k, v) -> System.out.println("Llave : " + k + " Valor : " + v));
  }

  /**El siguiente metodo.
   * Inserta un dato si el id no existe
   */
  private void insertarSiEsAusente() {
    //SI EXISTE NO LO REEMPLAZA Y SI NO SOLO SE AGREGA
    //map.putIfAbsent(2, "Felix");
    map.putIfAbsent(4, "Felix");
  }

  /**El siguiente metodo.
   * Realiza una logica si el id existe
   */
  private void operarSiPresente() {
    // SI ESTA PRESENTE EL ELEMENTO SE RELIZA UNA DETERMINADA OPEERACION
    map.computeIfPresent(3, (k, v) -> k + " ----> " + v);
    System.out.println(map.get(3));

  }

  /**El siguiente metodo.
   * Agrega un valor por defecto si no se le ingresa un dato real
   */
  private void obtenerOrPredeterminado() {
    // SI EXISTE EL ELEMENTO NO LE AGREGA EL VALOR POR DEFECTO
    //String valor = map.getOrDefault(2, "VALOR POR DEFECTO");
    String valor = map.getOrDefault(5, "VALOR POR DEFECTO");
    System.out.println(valor);

  }

  /**
   * El sgt metodo es el principal. El cual llama a los anteriormente creados
   */
  public static void main(String[] args) {
    FuncionesAgregada app = new FuncionesAgregada();
    app.poblar();

    //app.insertarSiEsAusente();
    //app.operarSiPresente();
    //app.imprimir_v8();
    //app.obtenerOrPredeterminado();

    app.recolectar();
  }


}

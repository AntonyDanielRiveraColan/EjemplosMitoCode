package com.mitocode.java8.java8mito;

import interfacesFuncionales.Operacion1;
import interfacesFuncionales.PersonaInterface;
import java.util.Arrays;


public class MeReApp {

  public static void referenciarMetodoStatic() {
    System.out.println("Metodo Referido Static");
  }

  /**
   * El sgt metodo imprime el arreglo.
   */
  public void referenciarMetodoInstanciaObjetoArbitrario() {
    String[] nombres = {"mito", "code", "jaime"};

    /** Arrays.sort(nombres, new Comparator<String>() {
    @Override public int compare(String o1, String o2) {
    return o1.compareToIgnoreCase(o2);
    }
    }); */

    /**
     //Lambda
     Arrays.sort(nombres, (s1,s2) -> s1.compareToIgnoreCase(s2));
     System.out.println(Arrays.toString(nombres));  */

    Arrays.sort(nombres, String::compareToIgnoreCase);
    System.out.println(Arrays.toString(nombres));

  }

  public void referenciarMetodoInstanciaObjetoParticular() {
    System.out.println("Metodo referido instancia de un objeto en particular");
  }

  /**El sgt metodo utiliza.
   *  A un constructor para luego llamar a un metodo crear
   */
  public void referenciarConstructor() {
    /**
     PersonaInterface iper = new PersonaInterface() {


    @Override public Persona crear(int id, String nombre) {
    return new Persona(id,nombre);
    }
    };
     iper.crear(1, "MitoCode");
     */

    /** Expresiones lambda*/

    /**
     PersonaInterface iper2 = (x,y) ->(new Persona(x, y));
     Persona per = iper2.crear(1,"MitoCode");
     System.out.println(per.getId()+" - "+per.getNombre());
     */

    PersonaInterface iper3 = Persona::new;
    Persona per1 = iper3.crear(1, "MitoCode");
    System.out.println(per1.getId() + " - " + per1.getNombre());
  }

  /** El sgt metodo .
   *Solo realiza un salto entre clases para llamar a un metodo void
   */
  public void operar() {
    /** Operacion1 op = () -> MeReApp.referenciarMetodoStatic();
     op.saludar();  */
    Operacion1 op2 = MeReApp::referenciarMetodoStatic;
    op2.saludar();
  }

  /**Este es el metodo principal.
   */
  public static void main(String[] args) {
    MeReApp app = new MeReApp();
    //app.referenciarMetodoInstanciaObjetoArbitrario();
    //Operacion1 op = app::referenciarMetodoInstanciaObjetoParticular;
    //op.saludar();

    app.referenciarConstructor();
  }

}

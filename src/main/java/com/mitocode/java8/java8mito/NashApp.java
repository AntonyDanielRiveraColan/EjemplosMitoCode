package com.mitocode.java8.java8mito;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class NashApp {
  /** Las siguiente declaracion de variables.
   *ScriptEngineManager = para ejecutar código JavaScript
   *ScriptEngine = Permite ejecutar / evaluar declaraciones en un idioma diferente.
   *Invocable = Es una interface
   *  */
  private ScriptEngineManager eme;
  private ScriptEngine eee;
  private Invocable invocador;

  /**El sgt metodo es un constructor sin parametros.*/
  public NashApp() {
    eme = new ScriptEngineManager();
    eee = eme.getEngineByName("nashorn");
    invocador = (Invocable) eee;
  }

  /** El sgt metodo realiza el llamado a varias fuentes.*/
  public void llamarFunciones()
      throws ScriptException, FileNotFoundException, NoSuchMethodException {
    //e.eval("print('SJ desde Java')");
    eee.eval(new FileReader("src/main/java/archivosJavaScrip/archivo.js"));

    String rpst = (String) invocador.invokeFunction("calcular", "2", "3");
    System.out.println(rpst);

    Double rpst2 = (Double) invocador.invokeFunction("calcular", 2, 3);
    System.out.println(rpst2);
  }

  /** */
  public void implementarInterfaz() throws Exception {
    eee.eval(new FileReader("src/main/java/archivosJavaScrip/archivo.js"));

    Object implementacion = eee.get("hiloImpl");
    Runnable r = invocador.getInterface(implementacion, Runnable.class);

    Thread th1 = new Thread(r);
    th1.start();

    Thread th2 = new Thread(r);
    th2.start();
  }

  public static void main(String[] args) throws Exception {
    NashApp app = new NashApp();
    app.implementarInterfaz();

  }

}

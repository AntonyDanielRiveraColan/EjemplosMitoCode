package com.mitocode.java8.java8mito;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class NashApp {
	private ScriptEngineManager m ;
	private ScriptEngine e;
	private Invocable invocador;
	
	public NashApp() {
		m = new ScriptEngineManager();
		e = m.getEngineByName("nashorn");
		invocador=(Invocable) e;
	}
	
	public void llamarFunciones() throws ScriptException, FileNotFoundException, NoSuchMethodException {
		//e.eval("print('SJ desde Java')");
		e.eval(new FileReader("src/main/java/archivosJavaScrip/archivo.js"));
		
		String rpst = (String) invocador.invokeFunction("calcular", "2","3");
		System.out.println(rpst);
		
		Double rpst2 = (Double) invocador.invokeFunction("calcular", 2,3);
		System.out.println(rpst2);
	}

	public void implementarInterfaz() throws Exception{
		e.eval(new FileReader("src/main/java/archivosJavaScrip/archivo.js"));
		
		Object implementacion = e.get("hiloImpl");
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

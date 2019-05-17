package com.mitocode.java8.java8mito;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ColeccionApp {

	private  List<String> lista;
	
	public void llenaLista() {
		lista = new ArrayList<>();
		lista.add("Mito Code");
		lista.add("Code");
		lista.add("Mito");
	}
	
	public void usarForEach() {
		
		 /* for(String elemento : lista) {
			System.out.println(elemento);
		} */
		
		 //lista.forEach(x -> System.out.println(x));
		
		lista.forEach(System.out::println);
	}
	
	private void usarRemoveIf() {
	/*
	Iterator<String> it = lista.iterator();
	while (it.hasNext()) {
		if (it.next().equalsIgnoreCase("Code")) {
			it.remove();
		}
		
	}
	*/
		//Expresion lambda
		lista.removeIf(x -> x.equalsIgnoreCase("Code"));

	}
	
	private void usarSort() {
		//Para ordenas la lista de forma accedente
		lista.sort((x,y) -> x.compareTo(y));
		
	}

public static void main(String...mitoCode) {
	ColeccionApp app = new ColeccionApp();
	app.llenaLista();
	//app.usarRemoveIf();
	app.usarSort();
	app.usarForEach();
}





}

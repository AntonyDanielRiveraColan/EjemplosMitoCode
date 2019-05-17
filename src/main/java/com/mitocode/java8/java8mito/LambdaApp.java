package com.mitocode.java8.java8mito;

import java.util.List;

import interfacePrimerosEjercicios.Operacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LambdaApp {

	public void ordenar() {

		List<String> lista = new ArrayList<>();
		lista.add("MitoCode");
		lista.add("Mito");
		lista.add("Code");
		
		/*
		Collections.sort(lista, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
			
		});
		*/
		
		// Lambda
		Collections.sort(lista, (String p1, String p2) -> p1.compareTo(p2));
		
		for (String elemento: lista) {
			System.out.println(elemento);
		}
	}
	
	/* public void calcular() {
		Operacion operacion = (double x, double y) -> (x+y)/2;
		System.out.println(operacion.calcularPromedio(2, 3));
	} */
	
	private double probarSintaxis() {
	//	Operacion operacion = (double x, double y) -> {return (x+y)/2;};
		// Operacion operacion = (double x, double y) ->  (x+y)/2;
		/* Operacion operacion = (double x, double y) -> {
			double a = 2.0;
			System.out.println(a);
			return (x+y)/2 + a;
		}; */
		
		Operacion operacion = (x, y) -> {	
		double a = 2.0;
		System.out.println("Resultado = ");
		return (x + y)/2 + a;
	}; 
		
		//Operacion operacion = (x, y) ->  (x+y)/2;
		//Operacion operacion = () -> 2;
		/*
		Operacion operacion = () -> {
			double x=2;
			double y = 3;
			return (x + y) /2 ;
		};  */
		return  operacion.calcularPromedio(2,3);
		
	}
	
	public static void main(String[] args) {
		LambdaApp app= new LambdaApp();
		//app.ordenar();
		//app.calcular();
		System.out.println(app.probarSintaxis());
	}
}

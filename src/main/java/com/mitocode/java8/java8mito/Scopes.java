package com.mitocode.java8.java8mito;

import interfacePrimerosEjercicios.Operacion;

public class Scopes {

	public static double atributo1;
	public  double atributo2;
	
	
	
	public static void main(String[] args) {
		Scopes scopes= new Scopes();
		// System.out.println(scopes.probarSintaxis());
		System.out.println(scopes.probarAtributosStaticVariables());
	}

	
	private double probarAtributosStaticVariables() {
		Operacion op = new Operacion() {

			@Override
			public double calcularPromedio(double n1, double n2) {
				atributo1 = n1+n2;
				atributo2 = atributo1;
				return atributo2;
			} 
		};
		
		
		
		Operacion operacion = (x, y) -> {
			atributo1 = x+y;
			atributo2 = atributo1;
			return atributo2;
		};
		
		return op.calcularPromedio(3, 2);
	}


	private double probarSintaxis() {
	double n3 = 3;
	
	Operacion op = new Operacion() {
		@Override
		public double calcularPromedio(double n1, double n2) {
		
			return  n1+n2+n3;
		}
	};
	
	Operacion operacion = (x,y) -> {
		return  x + y + n3;
	};
	return op.calcularPromedio(1, 1);
	}
	
	
}

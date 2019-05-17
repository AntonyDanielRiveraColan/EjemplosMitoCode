package com.mitocode.java8.java8mito;

import interfacePrimerosEjercicios.PersomaB;
import interfacePrimerosEjercicios.PersonaA;

public class DefaultMethod implements PersonaA, PersomaB {

	public static void main(String[] args) {
		DefaultMethod app = new DefaultMethod();
		//app.caminar();
		app.hablar();
	}



	@Override
	public void caminar() {
		System.out.println("Hola a todos");
	
	}



	/* @Override
	public void hablar() {
		//PersonaA.super.hablar();
		System.out.println("Hola hablar desde la PersonaA");
		
	} */


	@Override
	public void hablar() {
		PersomaB.super.hablar();
		
	}




	
}

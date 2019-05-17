package com.mitocode.java8.java8mito;

import java.util.ArrayList;
import java.util.List;

public class ParallelStream {

	private List<Integer> numeros;
	
	public void llena() {
		numeros = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			numeros.add(i);
		}
	}
	
	private void probarStream() {
		numeros.stream().forEach(System.out::println);
		
	}
	private void probarParalelo() {
		numeros.parallelStream().forEach(System.out::println);
		
	}
	
	public static void main(String[] args) throws InterruptedException{
		ParallelStream app = new ParallelStream();
		
		app.llena();
		//app.probarStream();
		app.probarParalelo();
	}

	
	
}

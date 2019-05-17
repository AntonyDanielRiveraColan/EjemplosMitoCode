package com.mitocode.java8.java8mito;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FuncionesAgregada {
	private Map<Integer, String> map;	

	public void poblar() {
		map = new HashMap<>();
		map.put(1, "Mito");
		map.put(2, "Code");
		map.put(3, "Suscribete");
		
	}
	
	
	public void imprimir_v7() {
		for (Entry<Integer, String> e : map.entrySet()) {
			System.out.println(" Llave: "+ e.getKey() +" Valor: " + e.getValue());
		}
	}
	
	
	public void imprimir_v8() {
		//map.forEach((k,v) -> System.out.println("Llave: "+k+" Valor: "+v));
		map.entrySet().stream().forEach(System.out::println);
	}
	
	//ESTUDIAR Y ENTENDER ESTE METODO
	public void recolectar() {
		Map<Integer,String> mapRecolectado = map.entrySet().stream()
				.filter(x -> x.getValue().contains("o"))
				.collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
		
	mapRecolectado.forEach((k,v) -> System.out.println("Llave : " +k +" Valor : " + v));
	}
	
	private void insertarSiEsAusente() {
		//SI EXISTE NO LO REEMPLAZA Y SI NO SOLO SE AGREGA
		//map.putIfAbsent(2, "Felix");
		map.putIfAbsent(4, "Felix");
	}
	

	private void operarSiPresente() {
		// SI ESTA PRESENTE EL ELEMENTO SE RELIZA UNA DETERMINADA OPEERACION
		map.computeIfPresent(3, (k,v) -> k +" ----> "+ v );
		System.out.println(map.get(3));
		
	}
	

	private void obtenerOrPredeterminado() {
		// SI EXISTE EL ELEMENTO NO LE AGREGA EL VALOR POR DEFECTO
		//String valor = map.getOrDefault(2, "VALOR POR DEFECTO");
		String valor = map.getOrDefault(5, "VALOR POR DEFECTO");
		System.out.println(valor);
		
	}
	
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

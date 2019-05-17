package com.mitocode.java8.java8mito;

import java.util.Optional;

public class OptionalApp {
	
public void probar(String valor) {
	//System.out.println(valor.contains("mito"));
	try {
		Optional  op = Optional.empty();
		op.get();
		
	} catch (Exception e) {
		System.out.println("Elemento erroneo");
	}
}

private void orElse(String valor) {
	Optional<String> op = Optional.ofNullable(valor);
	String x = op.orElse("predeterminado");
	System.out.println(x);
	
}
private void orElseThrow(String valor) {
	Optional<String> op = Optional.ofNullable(valor);
	String x = op.orElseThrow(NumberFormatException::new);
	System.out.println(x);
}

private void isPresent(String valor) {
	Optional<String> op = Optional.ofNullable(valor);
	System.out.println(op.isPresent());
}



public static void main(String[] args) {
	OptionalApp app = new OptionalApp();
	//app.probar("MitoCode");
	//app.orElse(null);
	//app.orElseThrow("Prueba");
	app.isPresent(null);
}





}

package interfacesFuncionales;

import com.mitocode.java8.java8mito.Persona;

@FunctionalInterface
public interface PersonaInterface {

  Persona crear(int id, String nombre);

}

package interfacePrimerosEjercicios;

public interface PersomaB {


  default public void hablar() {
    System.out.println("Saludos a todos - desde PersonaB");
  }

  ;
}

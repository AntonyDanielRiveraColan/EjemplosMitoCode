package interfacePrimerosEjercicios;

public interface PersonaA {

  public void caminar();

  default public void hablar() {
    System.out.println("Saludos a todos - desde PersonaA");
  }

  ;
}

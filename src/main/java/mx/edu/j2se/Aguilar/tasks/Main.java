package mx.edu.j2se.Aguilar.tasks;

public class Main {
	
	public static void main(String[] args) {
		Persona estudianteNC = new Persona();
		estudianteNC.setEdad(18);
		int laEdad = estudianteNC.getEdad();
		String loDejaron = loDejanEntrarAlBar(laEdad);
		System.out.println("Gabriel: " + loDejaron);


	}
	public static String loDejanEntrarAlBar(int laEdad){
		if (laEdad >= 18) {
			return "Bienvenido al bar !!!";
		}
		else{
			return "Sigue participando";
		}
	}

	
}

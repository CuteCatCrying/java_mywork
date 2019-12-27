package kelasOverloading;

/* Overloading adalah kelas yang mempunyai banyak metod yang mempunyai nama sama tapi paramater yang berbeda*/

class Tuhan{
	void cipta(String objek){
		System.out.println("Tuhan menciptakan = "+objek);
	}

	void cipta(String objek, String objek2){
		System.out.println("Tuhan menciptakan = "+objek+" dan "+objek2);	
	}
}


public class Main{
	public static void main(String[] args) {
		Tuhan T = new Tuhan();

		T.cipta("Gajah");
		T.cipta("Manusia","Pohon");
	}
}
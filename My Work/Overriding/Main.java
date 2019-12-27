package kelasOverriding;

/* Overridding adalah anak kelas yang mempunyai metod,parameter yang sama dan turunan pada induk kelasnya */

class Hewan{
	void mamalia(){
		System.out.println("Mamalia binatang yang melahirkan");
	}
}

class Paus extends Hewan{
	void mamalia(){
		System.out.println("Paus adalah mamalia");
	}
}


public class Main{
	public static void main(String[] args) {
		Hewan H = new Hewan();
		Paus P = new Paus();

		H.mamalia();
		P.mamalia();
	}
}
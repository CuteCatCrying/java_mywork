package kelasSuperKeywordSuper2;

/* Super dapat memanggil kelas induknya*/

class Prajurit{
	void equipment(){
		System.out.println("Pedang");
	}
}

class Bambang extends Prajurit{
	void equipment(){
		System.out.println("Panah");
	}
	void posisi(){
		System.out.println("Pojok kanan bawah");
	}
	void tempur(){
		super.equipment();
		posisi();
	}
}

public class Main{
	public static void main(String[] args) {
		Bambang B = new Bambang();

		B.tempur();
	}
}
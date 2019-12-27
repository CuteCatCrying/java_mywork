package kelasSuperKeywordSuper1;

/* Super dapat digunakan untuk merujuk variable kelas induknya*/

class Makhluk{
	String jenis = "Tergantung";
}

class Hewan extends Makhluk{
	String jenis = "Nyata";

	void printJenis(){
		System.out.println("Hewan jenisnya   : "+jenis);
		System.out.println("Makhluk jenisnya : "+super.jenis);
	}
}

public class Main{
	public static void main(String[] args) {
		Hewan H = new Hewan();

		H.printJenis();
	}
}
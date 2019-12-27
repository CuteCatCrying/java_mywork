package kelasSuperKeywordSuper3;

/* Super digunakan untuk menampilkan konstruktor induk kelasnya*/

class Hewan{
	Hewan(){
		System.out.println("Hewan adalah makhluk");
	}
}

class Paus extends Hewan{
	Paus(){
		super();
		System.out.println("Paus adalah hewan terbesar yang ada diair");
	}
}

public class Main{
	public static void main(String[] args) {
		Paus P = new Paus();
	}
}
package kelasInterfaceInheritance;

interface Galaksi{
	void orbit();
}

interface Planet extends Galaksi{
	void massa();
}

class Bumi implements Planet{
	public void orbit(){
		System.out.println("Mengorbit matahari");
	}
	public void massa(){
		System.out.println("Massa bumi belum saya ketahui");
	}
}

public class Main{
	public static void main(String[] args) {
		Bumi B = new Bumi();
		B.orbit();
		B.massa();
	}
}
package kelasAbstract;

abstract class Planet{
	abstract void orbit();
}

class Bumi extends Planet{
	void orbit(){
		System.out.println("Mengorbit");
	}
}

public class Main{
	public static void main(String[] args) {
		Planet objek = new Bumi();
		objek.orbit();
	}
}
/* Interface dalam java adalah sebuah blueprint sebuah class, yang mempunyai statis konstan dan abstract method*/

package kelasInterface;

interface Planet{
	void orbit();
}

class Bumi implements Planet{
	public void orbit(){
		System.out.println("Punya gaya grafitasi");
	}
}

public class Main{
	public static void main(String[] args) {
		Bumi B = new Bumi();
		B.orbit();
	}
}
package kelasGetterAndSetter;

class Kalimat{
	private String kata;

	public void setKata(String kata){
		this.kata = kata;
	}
	String getKata(){
		return kata;
	}
}

public class Main{
	public static void main(String[] args) {
		/*Kelas Kalimat*/
		Kalimat k = new Kalimat();
		k.setKata("Hello world!!");
		System.out.println(k.getKata());
	}
}
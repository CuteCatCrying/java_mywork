class Titik{
	/*Kelas yang digunakan untuk mengimplementasikan sebuah tipe titik*/
	private int x; /*Koordinat x*/
	private int y; /*Koordinat y*/

	Titik(){
		/*Konstruktor*/
		x = 0;
		y = 0;
	}
	Titik(int xp,int yp){
		/*Konstruktor*/
		x = xp;
		y = yp;
	}
	public void setX(int xp){
		/*Mengeset nilai koordinat x*/
		x = xp;
	}
	public int getX(){
		/*Mengembalikan nilai koordinat x*/
		return x;
	}
	public void setY(int yp){
		/*Mengeset nilai koordinat y*/
		y = yp;
	}
	public int getY(){
		/*Mengembalikan nilai koordinat y*/
		return y;
	}
	public void finalize(){
		/*Desktruktor*/
	}
}
public class Main{
	public static void main(String[] args){
		Titik t1 = new Titik();
		Titik t2 = new Titik(11,9);

		t1.setX(56);
		t1.setY(36);
		System.out.println("T2 x: "+t2.getX()+" y: "+t2.getY());
		System.out.println("T1 x: "+t1.getX()+" y: "+t1.getY());
	}

}
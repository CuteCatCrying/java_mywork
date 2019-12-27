package example.titik.pak.antarmuka;

interface Titik{
	public void setX(int xp);
	public int getX();
	public void setY(int yp);
	public int getY();
	public void printTitik();
}

class Titik3D implements Titik{
	private int x; /*Koordinat x*/
	private int y; /*Koordinat y*/
	private int z; /*Koordinat z*/

	Titik3D(){
		/*Konstruktor*/
		x = 0;
		y = 0;
		z = 0;
	}
	Titik3D(int xp,int yp,int zp){
		/*Konstruktor*/
		x = xp;
		y = yp;
		z = zp;
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
	public void setZ(int zp){
		/*Mengeset nilai koordinat z*/
		z = zp;
	}
	public int getZ(){
		/*Mengembalikan nilai koordinat z*/
		return z;
	}
	public void printTitik(){
		/*Menampilkan nilai koordinat titik*/
		System.out.println("Nilai X : "+getX());
		System.out.println("Nilai Y : "+getY());
		System.out.println("Nilai Z : "+getZ());
	}
}

class CobaTitik3DPI{
	/*Metode main untuk mengetes antarmuka Titik dan kelas Titik3D*/
	public static void main(String[] args) {
		Titik3D t = new Titik3D(0, 0, 7);

		t.setX(28);
		t.setY(1);

		t.printTitik();

		System.out.println("=============");
	}
}
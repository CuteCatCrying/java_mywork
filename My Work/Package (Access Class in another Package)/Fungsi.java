package kelasFungsi;

public class Fungsi{
	public int pangkat(int x,int y){
		int hasil = 1;
		for(int i=1; i<=y; i++){
			hasil *= x;
		}
		return hasil;
	}
}
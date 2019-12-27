package kelasAggregation;

class Operasi{
	int faktor(int angka){
		int hasil = 1;

		for(int i=1; i<=angka; i++){
			hasil *= i;
		}
		return hasil;
	}
}

class Hitung{
	Operasi op;
	int pembilang,penyebut;

	int permutasi(int n, int r){
		op = new Operasi();

		pembilang = op.faktor(n);
		penyebut  = op.faktor(n-r);

		return (pembilang/penyebut);
	}

	int kombinasi(int n, int r){
		op = new Operasi();

		pembilang = op.faktor(n);
		penyebut  = op.faktor(r) * op.faktor(n-r);

		return (pembilang/penyebut);
	}
}


public class Main{
	public static void main(String[] args) {
		Hitung H = new Hitung();
		int hasil ;

		hasil = H.permutasi(3,2);
		System.out.println("Permutasi(3,2) : "+hasil);

		hasil = H.kombinasi(3,2);
		System.out.println("kombinasi(3,2) : "+hasil);
	}
}
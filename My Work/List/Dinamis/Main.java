package kelasListDinamis;

class NilaiMatkul {
	String nim;
	String nama;
	String nilai;
	NilaiMatkul(){
	}
}

class Elemen {
	NilaiMatkul elmt;
	Elemen next;
	Elemen(){
		elmt = new NilaiMatkul();
	}
}

class List {
	Elemen first;
	List(){
	}
	/*--------------------------------------------------------------------------------------*/
	void createList(){
		first = null;
	}
	/*--------------------------------------------------------------------------------------*/
	int countElemen(){
		int hasil = 0;
		if(first != null){
			/*List tidak kosong*/
			Elemen elmt;
			/*Inisialisasi*/
			elmt = first;
			while(elmt != null){
				/*Proses*/
				hasil += 1;
				/*Iterasi*/
				elmt = elmt.next;
			}
		}
		return hasil;
	}
	/*--------------------------------------------------------------------------------------*/
	void addFirst(String nim,String nama,String nilai){
		Elemen elmt;
		elmt = new Elemen();
		elmt.elmt.nim   = nim;
		elmt.elmt.nama  = nama;
		elmt.elmt.nilai = nilai;
		elmt.next = first;
		first = elmt;
		elmt = null;
	}
	/*--------------------------------------------------------------------------------------*/
	void addAfter(Elemen prec,String nim,String nama,String nilai){
		Elemen elmt;
		elmt = new Elemen();

		elmt.elmt.nim   = nim;
		elmt.elmt.nama  = nama;
		elmt.elmt.nilai = nilai;
		elmt.next = prec.next;
		prec.next = elmt;
		elmt = null;
	}
	/*--------------------------------------------------------------------------------------*/
	void addLast(String nim,String nama,String nilai){
		if(first == null){
			/*Jika list adalah list kosong*/
			addFirst(nim,nama,nilai);
		}else{
			/*Jika list tidak kosong*/
			Elemen elmt;
			elmt = new Elemen();

			elmt.elmt.nim   = nim;
			elmt.elmt.nama  = nama;
			elmt.elmt.nilai = nilai;

			elmt.next = null;
			/*Mencari elemen terakhir list*/
			Elemen last = first;
			while(last.next != null){
				/*Iterasi*/
				last = last.next;
			}
			last.next = elmt;
			elmt = null;
		}
	}
	/*--------------------------------------------------------------------------------------*/
	void delFirst(){
		if(first != null){
			/*Jika list bukan list kosong*/
			Elemen elmt = first;
			first = first.next;
			elmt.next = null;
		}
	}
	/*--------------------------------------------------------------------------------------*/
	void delAfter(Elemen prec){
		Elemen elmt = prec.next;
		prec.next = elmt.next;
		elmt.next = null;
	}
	/*--------------------------------------------------------------------------------------*/
	void delLast(){
		if(first != null){
			/*Jika list tidak kosong*/
			if(countElemen() == 1){
				/*Jika list terdiri hanya satu elemen*/
				delFirst();
			}else{
				/*Mencari elemen terakhir list*/
				Elemen last = first;
				Elemen beforeLast = null;
				while(last.next != null){
					/*Iterasi*/
					beforeLast = last;
					last = last.next;
				}
				beforeLast.next = null;
			}
		}
	}
	/*--------------------------------------------------------------------------------------*/
	void printElemen(){
		if(first != null){
			/*Jika list tidak kosong*/
			/*Inisialisasi*/
			Elemen elmt = first;
			int i = 1;
			while(elmt != null){
				System.out.println("Elemen ke : "+i);
				System.out.println("Nim   : "+elmt.elmt.nim);
				System.out.println("Nama  : "+elmt.elmt.nama);
				System.out.println("Nilai : "+elmt.elmt.nilai);
				System.out.println("----------------------");
				/*Iterasi*/
				elmt = elmt.next;
				i += 1;
			}
		}else{
			/*Proses jika list kosong*/
			System.out.println("List Kosong");
		}
	}
	/*--------------------------------------------------------------------------------------*/
	void delAll(){
		if(countElemen() != 0){
			int i;
			for(i=countElemen(); i>=1; i--){
				/*Proses menghapus elemen list*/
				delLast();
			}
		}
	}
}
public class Main {
	public static void main(String[] args) {
		List l = new List();
		l.createList();
		l.addFirst("1312","FREA","30");
		l.addAfter(l.first,"1333","Popi","90");
		l.addLast("5123","Diplo","80");
		l.printElemen();
		System.out.println("Banyak list : "+l.countElemen());
		l.delFirst();
		l.delLast();
		l.printElemen();
		System.out.println("Banyak list : "+l.countElemen());
		l.delLast();
		l.printElemen();
	}
}
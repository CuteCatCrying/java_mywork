package kelasListStatis;

// Mendeklarasikan struktur data utama yang menjadi elemen
class NilaiMatkul {
	String nim;
	String nama;
	String nilai;
	NilaiMatkul(){
	}
}
// Mendeklarasikan struktur data elemen
class Elemen {
	NilaiMatkul elmt;
	int next;
	Elemen(){
		elmt = new NilaiMatkul();
	}
}
// Mendeklarasikan list tunggal menggunakan array
class List {
	int first;
	Elemen[] data = new Elemen[10];
	List(){
		for(int i=0; i<10; i++){
			data[i] = new Elemen();
		}
	}
	/*--------------------------------------------------------------------------------------*/		
	// Create list
	/*
	========================
	|| -1 = berarti first ||  
	|| -2 = berarti null  ||
	========================
	*/
	void createList(){
		first = -1;
		int i;
		for(i=0; i<10; i++){
			/*Proses menginisialiasasi array*/
			data[i].next = -2;
		}
	}
	/*--------------------------------------------------------------------------------------*/
	// Menghitung Elemen yang ada di list
	int countElemen(){
		int hasil = 0;
		if(first != -1){
			/*List tidak kosong*/
			int elmt;
			/*Inisialisasi*/
			elmt = first;
			while(elmt != -1){
				/*Proses*/
				hasil += 1;
				/*Iterasi*/				
				elmt = data[elmt].next;
			}
		}
		return hasil;
	}
	/*--------------------------------------------------------------------------------------*/
	int emptyElemen(){
		int hasil = -1;
		if(countElemen() < 10){
			boolean ketemu = false;
			int i=0;
			while((ketemu == false) && (i < 10)){
				if(data[i].next == -2){
					hasil  = i;
					ketemu = true; 
				}else{
					i += 1;
				}
			}
		}
		return hasil;
	}
	/*--------------------------------------------------------------------------------------*/
	void addFirst(String nim,String nama,String nilai){
		if(countElemen() < 10){
			int indeks = emptyElemen();
			data[indeks].elmt.nim   = nim;
			data[indeks].elmt.nama  = nama;
			data[indeks].elmt.nilai = nilai;
			if(first == -1){
				/*Jika list kosong*/
				data[indeks].next = -1;
			}else{
				/*Jika list tidak kosong*/
				data[indeks].next = data[first].next;
			}
			first = indeks;
		}else{
			/*Proses jika array penuh*/
			System.out.println("Sudah tidak dapat ditambah (Penuh)");
		}
	}
	/*--------------------------------------------------------------------------------------*/
	void addAfter(int prec,String nim,String nama,String nilai){
		if(countElemen() < 10){
			int indeks = emptyElemen();
			data[indeks].elmt.nim   = nim;
			data[indeks].elmt.nama  = nama;
			data[indeks].elmt.nilai = nilai;
			data[indeks].next = data[prec].next;
			data[prec].next   = indeks;
		}else{
			/*Proses jika array penuh*/
			System.out.println("Sudah tidak dapat ditambah (Penuh)");
		}
	}
	/*--------------------------------------------------------------------------------------*/
	void addLast(String nim,String nama,String nilai){
		if(first == -1){
			/*Proses jika list masih kosong*/
			int indeks = 0;
			data[indeks].elmt.nim   = nim;
			data[indeks].elmt.nama  = nama;
			data[indeks].elmt.nilai = nilai;
			data[indeks].next = -1;
			first = indeks;
		}else{
			/*Proses jika list telah berisi elemen*/
			if(countElemen() < 10){
				/*Proses jika array belum penuh*/
				int indeks = emptyElemen();
				data[indeks].elmt.nim   = nim;
				data[indeks].elmt.nama  = nama;
				data[indeks].elmt.nilai = nilai;
				data[indeks].next = -1;
				/*Proses mencari indeks elemen terakhir*/
				/*Inisialisasi*/
				int last = first;
				while(data[last].next != -1){
					/*Iterasi*/
					last = data[last].next;
				}
				data[last].next = indeks;
			}else{
				/*Proses jika array penuh*/
				System.out.println("Sudah tidak dapat ditambah (Penuh)");
			}
		}
	}
	/*--------------------------------------------------------------------------------------*/
	void delFirst(){
		if(first != -1){
			int elmt = first;
			first = data[first].next;
			/*Elemen awal sebelumnya dikosongkan*/
			data[elmt].next = -2;
		}else{
			/*Proses jika list kosong*/
			System.out.println("List kosong");
		}
	}
	/*--------------------------------------------------------------------------------------*/
	void delAfter(int prec){
		int elmt = data[prec].next;
		data[prec].next = data[elmt].next;
		/*Pengosongan elemen*/
		data[elmt].next = -2;
	}
	/*--------------------------------------------------------------------------------------*/
	void delLast(){
		if(first != -1){
			if(countElemen() == 1){
				/*Proses jika list hanya berisi satu elemen*/
				delFirst();
			}else{
				int last = first;
				int beforeLast = -1;
				while(data[last].next != -1){
					/*Iterasi*/
					beforeLast = last;
					last = data[last].next;
				}
				/*Elemen sebelum elemen terakhir menjadi elemen terakhir*/
				data[beforeLast].next = -1;
				/*Elemen terakhir sebelumnya dikosongkan*/
				data[last].next = -2;
			}
		}else{
			/*Proses jika list kosong*/
			System.out.println("List Kosong");
		}
	}
	/*--------------------------------------------------------------------------------------*/
	void printElemen(){
		if(first != -1){
			/*Inisialisasi*/
			int elmt = first;
			int i = 1;
			while(elmt != -1){
				/*Proses*/
				System.out.println("Elemen Ke : "+i);
				System.out.println("Nim   : "+ data[elmt].elmt.nim);
				System.out.println("Nama  : "+ data[elmt].elmt.nama);
				System.out.println("Nilai : "+ data[elmt].elmt.nilai);
				System.out.println("Next  : "+ data[elmt].next);
				System.out.println("------------------------");
				/*Iterasi*/
				elmt = data[elmt].next;
				i += 1;
			}
		}else{
			/*Proses jika list kosong*/
			System.out.println("List Kosong");
		}
	}
	void delAll(){
		int i;
		for(i=countElemen(); i>=1; i--){
			/*Proses menghapus elemen list*/
			delLast();
		}
	}
}
/*--------------------------------------------------------------------------------------*/
public class Main {
	public static void main(String[] args) {
		List l = new List();
		l.createList();
		l.addFirst("123","LOL","R");
		l.addAfter(l.first,"155","eqw","T");
		l.addAfter(l.first,"133","edaw","W");
		l.addLast("321","POOP","S");
		l.printElemen();
		System.out.println("Berapa elemen : "+ l.countElemen());
	}
}
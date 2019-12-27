package kelasQueueDinamis;

class NilaiMatkul{
	String nim;
	String nama;
	double nilai;
	NilaiMatkul(){		
	}
}
class Elemen{
	NilaiMatkul elmt;
	Elemen next;
	
	Elemen(){
		elmt = new NilaiMatkul();
	}
}
class Queue{
	Elemen first;
	Elemen last;
	
	Queue(){
	}
	/*--------------------------------------------------------------------------------------*/
	void createEmpty(){
		first = null;
		last = null;
	}
	/*--------------------------------------------------------------------------------------*/
	boolean isEmpty(){
		boolean hasil = false;
		if(first == null){
			hasil = true;
		}
		return hasil;
	}
	/*--------------------------------------------------------------------------------------*/
	int countElemen(){
		int hasil = 0;
		if(first != null){
			/*Queue tidak kosong*/
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
	void add(String nim,String nama,double nilai){
		Elemen elmt;
		elmt = new Elemen();

		elmt.elmt.nim   = nim;
		elmt.elmt.nama  = nama;
		elmt.elmt.nilai = nilai;
		elmt.next = null;
		if(first == null){
			first = elmt;
		}else{
			last.next = elmt;
		}
		last = elmt;
		elmt = null;
	}
	/*--------------------------------------------------------------------------------------*/
	void del(){
		if(first != null){
			/*Jika queue bukan list kosong*/
			Elemen elmt = first;
			first = first.next;
			elmt.next = null;
		}
	}
	/*--------------------------------------------------------------------------------------*/
	void printQueue(){
		if(first != null){
			System.out.println("------Isi queue------");
			Elemen elmt = first;
			int i = 1;
			while(elmt != null){
				System.out.println("==================");
				System.out.println("Elemen ke : "+i);
				System.out.println("Nim   : "+elmt.elmt.nim);
				System.out.println("Nama  : "+elmt.elmt.nama);
				System.out.println("Nilai : "+elmt.elmt.nilai);
				/*Iterasi*/
				elmt = elmt.next;
				i += 1;
			}
			System.out.println("--------------------");
		}else{
			/*Proses jika queue kosong*/
			System.out.println("Queue kosong");
		}
	}
	/*--------------------------------------------------------------------------------------*/
}
public class Main{
	public static void main(String[] args){
		Queue q = new Queue();
		q.createEmpty();
		q.add("1443","Pooop",61.2);
		q.printQueue();
	}
}
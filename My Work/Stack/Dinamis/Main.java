package kelasStackDinamis;

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

class Stack{
	Elemen top;
	Stack(){
	}
	/*--------------------------------------------------------------------------------------*/
	void createEmpty(){
		top = null;
	}
	/*--------------------------------------------------------------------------------------*/
	boolean isEmpty(){
		boolean hasil = false;
		if(top == null){
			hasil = true;
		}
		return hasil;
	}
	/*--------------------------------------------------------------------------------------*/
	int countElemen(){
		int hasil = 0;
		if(top != null){
			/*Stack tidak kosong*/
			Elemen elmt;
			/*Inisalisasi*/
			elmt = top;
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
	void push(String nim,String nama,double nilai){
		Elemen elmt;
		elmt = new Elemen();

		elmt.elmt.nim   = nim;
		elmt.elmt.nama  = nama;
		elmt.elmt.nilai = nilai;
		elmt.next = top;
		top = elmt;
		elmt = null;
	}
	/*--------------------------------------------------------------------------------------*/
	void pop(){
		if(top != null){
			/*Jika stack bukan list kosong*/
			Elemen elmt = top;
			top = top.next;
			elmt.next = null;
		}
	}
	/*--------------------------------------------------------------------------------------*/
	void printStack(){
		if(top != null){
			System.out.println("------Isi Stack-----");
			Elemen elmt = top;
			int i = 1;
			while(elmt != null){
				System.out.println("=====================");
				System.out.println("Elemen ke : "+i);
				System.out.println("NIM   : "+elmt.elmt.nim);
				System.out.println("Nama  : "+elmt.elmt.nama);
				System.out.println("Nilai : "+elmt.elmt.nilai);
				/*Iterasi*/
				elmt = elmt.next;
				i += 1;
			}
			System.out.println("-------------------------");
		}else{
			/*Proses jika stack kosong*/
			System.out.println("Stack kosong");
		}
	}
}
public class Main {
	public static void main(String[] args){
		Stack s = new Stack();
		s.createEmpty();
		s.push("1123","TREA",90);
		s.push("113413","TasdA",90.3);
		s.push("11233","TRdasd",40.12);
		s.printStack();
		System.out.println("Banyak elemen : "+s.countElemen());
	}
}
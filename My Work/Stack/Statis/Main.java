package kelasStackStatis;

class NilaiMatkul{
	String nim;
	String nama;
	double nilai;
	NilaiMatkul(){
	}
}

class Stack{
	int top;
	NilaiMatkul[] data = new NilaiMatkul[10];

	Stack(){
		for(int i=0; i<10; i++){
			data[i] = new NilaiMatkul();
		}
	}
	/*--------------------------------------------------------------------------------------*/
	void createEmpty(){
		top = -1;
	}
	/*--------------------------------------------------------------------------------------*/
	boolean isEmpty(){
		boolean hasil = false;
		if(top == -1){
			hasil = true;
		}
		return hasil;
	}
	/*--------------------------------------------------------------------------------------*/
	boolean isFull(){
		boolean hasil = false;
		if(top == 9){
			hasil = true;
		}
		return hasil;
	}
	/*--------------------------------------------------------------------------------------*/
	void push(String nim,String nama,double nilai){
		if(isFull() == true){
			/*Jika stack penuh*/
			System.out.println("Stack penuh!!");
		}else{
			if(isEmpty() == true){
				/*Jika stack kosong*/
				top = 0;
				data[0].nim   = nim;
				data[0].nama  = nama;
				data[0].nilai = nilai;
			}else{
				/*Jika stack tidak kosong*/
				top = top + 1;
				data[top].nim   = nim;
				data[top].nama  = nama;
				data[top].nilai = nilai;
			}
		}
	}
	/*--------------------------------------------------------------------------------------*/
	void pop(){
		if(top == 0){
			/*Jika stack berisi satu elemen*/
			top = -1;
		}else{
			if(top != -1){
				/*Jika stack tidak kosong*/
				top = top - 1;
			}
		}
	}
	/*--------------------------------------------------------------------------------------*/
	void printStack(){
		if(top != -1){
			System.out.println("-------Isi stack------");
			int i;
			for(i=top; i>=0; i--){
				System.out.println("=================");
				System.out.println("Elemen ke : "+i);
				System.out.println("Nim   : "+data[i].nim);
				System.out.println("Nama  : "+data[i].nama);
				System.out.println("Nilai : "+data[i].nilai);
			}
			System.out.println("------------------");
		}else{
			/*Proses jika stack kosong*/
			System.out.println("Stack kosong");
		}
	}
}
public class Main{
	public static void main(String[] args) {
		Stack s = new Stack();
		s.createEmpty();
		s.printStack();
		s.push("12321","POOP",80.5);
		s.push("121231","daOP",87.5);
		s.push("123123","RtP",40.5);
		s.printStack();
		s.pop();
		s.printStack();
	}
}
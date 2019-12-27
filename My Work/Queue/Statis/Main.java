package kelasQueueStatis;

class NilaiMatkul{
	String nim;
	String nama;
	double nilai;
	NilaiMatkul(){
	}
}

class Queue{
	int first;
	int last;
	NilaiMatkul[] data = new NilaiMatkul[10];

	Queue(){
		for(int i=0; i<10; i++){
			data[i] = new NilaiMatkul();
		}
	}
	/*--------------------------------------------------------------------------------------*/
	void createEmpty(){
		first = -1;
		last = -1;
	}
	/*--------------------------------------------------------------------------------------*/
	boolean isEmpty(){
		boolean hasil = false;
		if(first == -1){
			hasil = true;
		}
		return hasil;
	}
	/*--------------------------------------------------------------------------------------*/
	boolean isFull(){
		boolean hasil = false;
		if(last == 9){
			hasil = true;
		}
		return hasil;
	}
	/*--------------------------------------------------------------------------------------*/
	void add(String nim,String nama,double nilai){
		if(isEmpty() == true){
			/*Jika queue masih kosong*/
			last = 0;
			first = 0;
			data[0].nim   = nim;
			data[0].nama  = nama;
			data[0].nilai = nilai;
		}else{
			/*Jika queue tidak kosong*/
			if(isFull() != true){
				last = last + 1;
				data[last].nim   = nim;
				data[last].nama  = nama;
				data[last].nilai = nilai;
			}else{
				System.out.println("Queue penuh");
			}
		}
	}
	/*--------------------------------------------------------------------------------------*/
	void del(){
		if(last == 0){
			first = -1;
			last = -1;
		}else{
			/*Menggeser elemen ke depan*/
			int i;
			for(i=(first+1); i<=last; i++){
				data[i-1].nim   = data[i].nim;
				data[i-1].nama  = data[i].nama;
				data[i-1].nilai = data[i].nilai;
			}
			last -= 1;
		}
	}
	/*--------------------------------------------------------------------------------------*/
	void printQueue(){
		if(first != -1){
			System.out.println("-------Isi queue-------");
			int i;
			for(i=last; i>=first; i--){
				System.out.println("===============");
				System.out.println("Elemen ke : "+i);
				System.out.println("Nim   : "+data[i].nim);
				System.out.println("Nama  : "+data[i].nama);
				System.out.println("Nilai : "+data[i].nilai);
			}
			System.out.println("-------------------");
		}else{
			/*Proses jika queue kosong*/
			System.out.println("Queue Kosong");
		}
	}
	/*--------------------------------------------------------------------------------------*/
}
public class Main{
	public static void main(String[] args){
		Queue q = new Queue();
		q.createEmpty();
		q.add("100312","Lily",76.4);
		q.printQueue();
	}
}
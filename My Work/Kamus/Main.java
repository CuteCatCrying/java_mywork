package kelasKamus;

import java.util.Scanner;
import java.io.*;

public class Main{
	static boolean cekFile() throws IOException{
		File cekFileData = new File("Data.bin");
		boolean hasil = false;

		if(cekFileData.exists()){
			hasil = true;
		}
		return hasil;
	}

	static void buatFile() throws IOException{
		if(cekFile() == false){
			try{
				new File("Data.bin").createNewFile();
			}finally{}
		}
	}

	public static void main(String[] args) throws IOException{
		Scanner input = new Scanner(System.in);
		String kata, artiNoun, artiVerb, artiAdj;
		String cari;
		int menu;

		System.out.println("\tKamus inggris to indonesia");
		System.out.println("1. Input kata");
		System.out.println("2. Cari kata");
		System.out.print("Pilih : ");
			menu = input.nextInt();
		
		/* Membuat File */
		buatFile();
		System.out.println();
		switch(menu){
			case 1 : {
				System.out.print("Input kata : ");
					kata = input.next();
				System.out.printf("Arti Adj (%s) : ",kata);
					artiAdj  = input.next();
				System.out.printf("Arti Noun (%s) : ",kata);
					artiNoun = input.next();
				System.out.printf("Arti Verb (%s) : ",kata);
					artiVerb = input.next();
				
				/* Proses */
				try{
					PrintWriter pw = new PrintWriter(new FileWriter("Data.bin",true));
					pw.println(kata);
					pw.println("Arti Adj  : "+artiAdj);
					pw.println("Arti Noun : "+artiNoun);
					pw.println("Arti Verb : "+artiVerb);
					pw.flush();
					pw.close();
				}finally{}
				break;
			}
			case 2 : {
				System.out.print("Cari kata  : ");
					kata = input.next();
				cari = kata.substring(0, kata.length());

				try{
					FileReader findKata = new FileReader("Data.bin");
					BufferedReader baca = new BufferedReader(findKata);
					String line, cariData;

					System.out.println();
					while((line = baca.readLine()) != null){
						
						/* Jika line lebih kecil dari kata
						berguna agar tidak terjadi error string out of index 
						jika kondisi memenuhi maka pengulangan akan kembali keatas*/
						if(line.length() < kata.length()){
							continue;
						}

						cariData = line.substring(0, kata.length());
						if(cari.equalsIgnoreCase(cariData)){
							System.out.println(line);
							for(int i=1; i<=3; i++){	
								System.out.println(baca.readLine());
							}
						}
					}
				}finally{}
				break;
			}
			default : {
				System.out.println("Pilihan tidak ada");
			}
		}

		input.close();
	}
}
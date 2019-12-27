package kelasFillTheGlass;

import java.util.Scanner;
public class Main{
	static int iterasiY = 10,iterasiN = 10; // Variabel global
	static void tanyaIsiGelas(int x,int y){
		Scanner input = new Scanner(System.in);
		char isi;

		System.out.println();
		System.out.print("Isi gelas : ");
			isi = input.next().charAt(0);
		if(isi == 'Y' || isi == 'y'){
			isiGelas(x);
			iterasiN = iterasiY;
		}else if(isi == 'N' || isi == 'n'){
			isiGelas(y);
		}
	}
	static void gelasKosong(){
		isiGelas(10);
	}
	static void isiGelas(int atas){
		int i,j;
		int kosong;

		// atas   = sampai indeks i berapa gelas akan terisi
		// kosong = selisih indeks yang akan mengisi kosong
		kosong = atas - 1;
		for(i=1; i<=kosong; i++){
			for(j=1; j<=1; j++){
				System.out.print("#");
			}
			for(j=2; j<=13; j++){
				System.out.print(" ");
			}
			for(j=14; j<=14; j++){
				System.out.print("#");
			}
			System.out.println();
		}
		for(i=atas; i<=9; i++){
			for(j=1; j<=1; j++){
				System.out.print("#");
			}
			for(j=2; j<=13; j++){
				System.out.print("O");
			}
			for(j=14; j<=14; j++){
				System.out.print("#");
			}
			System.out.println();
		}
		for(i=10; i<=10; i++){
			for(j=1; j<=14; j++){
				System.out.print("#");
			}
			System.out.println();
		}
	}
	public static void main(String[] args){
		boolean kondisi = true;
		int i,j;

		for(i=1; i<=10; i++){
			for(j=1; j<=14; j++){
				if(j==1 || j==14 || i==10){
					System.out.print("#");
				}else{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		// penuh = 1, kosong = 10
		while(kondisi){
			iterasiY -= 3;
			tanyaIsiGelas(iterasiY,iterasiN);
			if(iterasiY == 1){
				System.out.println("Gelas penuh !!!!");
				kondisi = false;
			}
		}
	}
}
package kelasPenjumlahanMatriks;

import java.util.Scanner;
import java.util.Random;

public class Main{
	static void printMatriks(int[][] a,int baris,int kolom){
		for(int i=0; i<baris; i++){
			System.out.print("[");
			for(int j=0; j<kolom; j++){
				System.out.print(a[i][j]);
				if(j < (kolom-1)){
					System.out.print("\t");
				}else{
					System.out.print("]");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random rand = new Random();

		int[][] a;
		int[][] b;
		int[][] c;
		int i,j;
		int baris,kolom;
		int baris2,kolom2;
		int range = (19-10)+10;

		System.out.println("Matriks 1");
		System.out.print("Baris : ");
			baris = input.nextInt();
		System.out.print("Kolom : ");
			kolom = input.nextInt();
		a = new int[baris][kolom];

		/*Penginputan matriks 1*/
		for(i=0; i<baris; i++){
			for(j=0; j<kolom; j++){
				a[i][j] = rand.nextInt(range);
			}
		}
		printMatriks(a,baris,kolom);

		System.out.println("\nMatriks 2");
		System.out.print("Baris : ");
			baris2 = input.nextInt();
		System.out.print("Kolom : ");
			kolom2 = input.nextInt();
		b = new int[baris2][kolom2];

		/*Penginputan matriks 2*/
		for(i=0; i<baris2; i++){
			for(j=0; j<kolom2; j++){
				b[i][j] = rand.nextInt(range);
			}
		}
		printMatriks(b,baris2,kolom2);

		/*Proses*/
		if(baris == baris2 && kolom == kolom2){
			System.out.println("\nHasil penjumlahan");
			c = new int[baris][kolom];
			for(i=0; i<baris; i++){
				for(j=0; j<kolom; j++){
					c[i][j] = a[i][j] + b[i][j];
				}
			}
			printMatriks(c,baris,kolom);
		}else{
			System.out.println("Tidak bisa dijumlahkan, karena baris atau kolom berbeda");
		}
	}
}
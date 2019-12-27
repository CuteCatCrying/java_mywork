package kelasDeterminanMatriks;

import java.util.Scanner;
import java.util.Random;

public class Main{
	static void printMatriks(int[][] a, int baris, int kolom){
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

	static int cariDeterminan2x2(int[][] a, int baris, int kolom){
		int[] diagonalKeKanan = new int[baris];
		int[] diagonalKeKiri = new int[baris];

		int hasilKaliDiagonalKeKanan = 1;
		int hasilKaliDiagonalKeKiri = 1;
		int det,i,j;

		for(i=0; i<2; i++){
			for(j=0; j<2; j++){
				if(i == j){
					diagonalKeKanan[i] = a[i][j];
				}else{
					diagonalKeKiri[i] = a[i][j];
				}
			}
			hasilKaliDiagonalKeKanan *= diagonalKeKanan[i];
			hasilKaliDiagonalKeKiri *= diagonalKeKiri[i];
		}

		det = hasilKaliDiagonalKeKanan - hasilKaliDiagonalKeKiri;
		return det;
	}

	static int cariDeterminan3x3(int[][] a,int baris,int kolom){
		int i,j,det;
		int[][] b = new int[3][5];

		for(i=0; i<3; i++){
			for(j=0; j<5; j++){
				if(j < 3){
					b[i][j] = a[i][j];
				}else{
					b[i][j] = a[i][j-3];
				}
			}
		}

		det = (
			(b[0][0]*b[1][1]*b[2][2])+(b[0][1]*b[1][2]*b[2][3])+(b[0][2]*b[1][3]*b[2][4])
			-(b[0][4]*b[1][3]*b[2][2])-(b[0][3]*b[1][2]*b[2][1])-(b[0][2]*b[1][1]*b[2][0])
			);

		return det;
	}

	static int cariDeterminan4x4(int[][] a,int baris,int kolom){
		int[][] a00 = new int[3][3];
		int[][] a10 = new int[3][3];
		int[][] a20 = new int[3][3];
		int[][] a30 = new int[3][3];
		int detA00, detA10, detA20, detA30;
		int i,j,det;

		/*Kofaktor pada entri a00*/
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				a00[i][j] = a[i+1][j+1];
			}
		}
		detA00 = cariDeterminan3x3(a00,3,3);

		/*Kofaktor pada entri a10*/
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				if(i == 0){
					a10[i][j] = a[i][j+1];
				}else{
					a10[i][j] = a[i+1][j+1];
				}
			}
		}
		detA10 = cariDeterminan3x3(a10,3,3);

		/*Kofaktor pada entri a20*/
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				if(i == 2){
					a20[i][j] = a[i+1][j+1];
				}else{
					a20[i][j] = a[i][j+1];
				}
			}
		}
		detA20 = cariDeterminan3x3(a20,3,3);

		/*Kofaktor pada entri a30*/
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				a30[i][j] = a[i][j+1];
			}
		}
		detA30 = cariDeterminan3x3(a30,3,3);

		/*Rumus cari determinan menggunakan kofaktor*/
		det = (a[0][0]*detA00) - (a[1][0]*detA10) + (a[2][0]*detA20) - (a[3][0]*detA30);
		return det;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random rand = new Random();

		int[][] a;
		int i,j;
		int baris,kolom;
		int determinan;
		int range = (30-10)+10;

		System.out.println("\nDeterminan Matriks 2x2");
		System.out.print("Baris : ");
			baris = input.nextInt();
		System.out.print("Kolom : ");
			kolom = input.nextInt();

		a = new int[baris][kolom];

		/*Penginputan Matriks*/
		for(i=0; i<baris; i++){
			for(j=0; j<kolom; j++){
				a[i][j] = rand.nextInt(range);
			}
		}

		if(baris == kolom){
			if(baris == 2 && kolom == 2){
				printMatriks(a,baris,kolom);
				determinan = cariDeterminan2x2(a,baris,kolom);
			}else if(baris == 3 && kolom == 3){
				printMatriks(a,baris,kolom);
				determinan = cariDeterminan3x3(a,baris,kolom);
			}else if(baris == 4 && kolom == 4){
				printMatriks(a,baris,kolom);
				determinan = cariDeterminan4x4(a,baris,kolom);
			}else{
				System.out.println("Matriks yang bisa dioperasi adalah:\n2x2\n3x3\n4x4");
				determinan = 0;
			}
		}else{
			System.out.println("Baris dan kolom harus sama");
			determinan = 0;
		}
		System.out.println("Determinan : "+determinan);
	}
}
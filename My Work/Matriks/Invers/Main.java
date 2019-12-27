package kelasInvers;

import java.util.Random;
import java.util.Scanner;
import java.text.DecimalFormat;

class Determinan{
	Determinan(){

	}

	static int det2x2(int[][] a, int baris, int kolom){
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

	static int det3x3(int[][] a,int baris,int kolom){
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

	static int det4x4(int[][] a,int baris,int kolom){
		int[][] a00 = new int[3][3];
		int[][] a10 = new int[3][3];
		int[][] a20 = new int[3][3];
		int[][] a30 = new int[3][3];
		int detA00, detA10, detA20, detA30;
		int i,j,det;

		/*Minor pada entri a00*/
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				a00[i][j] = a[i+1][j+1];
			}
		}
		detA00 = det3x3(a00,3,3);

		/*Minor pada entri a10*/
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				if(i == 0){
					a10[i][j] = a[i][j+1];
				}else{
					a10[i][j] = a[i+1][j+1];
				}
			}
		}
		detA10 = det3x3(a10,3,3);

		/*Minor pada entri a20*/
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				if(i == 2){
					a20[i][j] = a[i+1][j+1];
				}else{
					a20[i][j] = a[i][j+1];
				}
			}
		}
		detA20 = det3x3(a20,3,3);

		/*Minor pada entri a30*/
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				a30[i][j] = a[i][j+1];
			}
		}
		detA30 = det3x3(a30,3,3);

		/*Rumus cari determinan menggunakan Minor*/
		det = (a[0][0]*detA00) - (a[1][0]*detA10) + (a[2][0]*detA20) - (a[3][0]*detA30);
		return det;
	}
}

class Invers extends Determinan{
	/*Deklarasi objek Main*/
	static Main M = new Main();

	Invers(){

	}

	static void printMatriksInvers(String[][] a, int baris, int kolom){
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

	/*Membuat bilangan desimal ke rasional*/
	static String rasional(int num, int denum){
		int i,gcd = 1;
		double kecil,numHasil,denumHasil;
		String hasil;

		/* Jika num dan denum sama negatif, maka cari yang angka negatif yang mendekati nol */
		if(num < 0 && denum < 0){
			kecil = (num < denum) ? denum : num;
		}else{
			kecil = (num < denum) ? num : denum;
		}
		
		/* Kecil harus di absolutkan, karena jika kecil bernilai negatif
		for akan break */
		for(i=1; i<=Math.abs(kecil); i++){
			if(num%i == 0 && denum%i == 0){
				gcd = i;
			}
		}
		numHasil = (double)num/gcd;
		denumHasil = (double)denum/gcd;

		if(num == 0){
			/* Jika num 0 */
			hasil = "0";
		}else{
			if(numHasil < 0 && denumHasil < 0){
				/* Jika num dan denum sama negatif, dijadikan positif */
				hasil = String.format("%.0f/%.0f", (-1*numHasil), (-1*denumHasil));
			}else{
				hasil = String.format("%.0f/%.0f", numHasil, denumHasil);
			}
		}
		return hasil;
	}

	static void inv2x2(int[][] a, int baris, int kolom){
		int det = det2x2(a,baris,kolom);
		int i,j;
		/*Variable untuk adjoin matriks*/
		int[][] b = new int[2][2];

		/*Matriks a akan disalin ke b*/
		/*B11*/ b[0][0] = a[1][1];
		/*B12*/ b[0][1] = (-1)*a[0][1];
		
		/*B21*/ b[1][0] = (-1)*a[1][0];
		/*B22*/ b[1][1] = a[0][0];
		
		System.out.println("\nDeterminan : "+det);
		System.out.println("Adjoin -------------------");
		M.printMatriks(b,baris,kolom);

		/*Menyalin dari b ke c yang sudah dirasionalkan, kenapa d harus string, karena fungsi pada rasional mengembalikan
		nilai String*/
		String[][] c = new String[2][2];
		for(i=0; i<2; i++){
			for(j=0; j<2; j++){
				c[i][j] = rasional(b[i][j],det);
			}
		}
		System.out.println("Hasil -------------------");
		printMatriksInvers(c,baris,kolom);
	}

	static void inv3x3(int[][] a, int baris, int kolom){
		int det = det3x3(a, 3, 3);
		int i,j;
		int[][] b = new int[3][3];
		int[][] c = new int[2][2]; /* Matrik untuk menampung elemen yang akan
		dideterminankan, setelah itu hasilnya akan disalin ke matriks b */
		int[][] d = new int[3][3]; /* Matrik untuk mentransposkan matrik b */
		String[][] e = new String[3][3]; /* Matrik hasil */

		/* Metode minor dan kofaktor */
		/* Menentukan minor */
		/* Minor dari B00 */
		for(i=0; i<2; i++){
			for(j=0; j<2; j++){
				c[i][j] = a[i+1][j+1];
			}
		}
		b[0][0] = det2x2(c, 2, 2);

		/* Minor dari B01 */
		for(i=0; i<2; i++){
			for(j=0; j<2; j++){
				if(j == 0){
					c[i][j] = a[i+1][j];
				}else{
					c[i][j] = a[i+1][j+1];
				}
			}
		}
		b[0][1] = det2x2(c, 2, 2);

		/* Minor dari B02 */
		for(i=0; i<2; i++){
			for(j=0; j<2; j++){
				c[i][j] = a[i+1][j];
			}
		}
		b[0][2] = det2x2(c, 2, 2);

		/* Minor dari B10 */
		for(i=0; i<2; i++){
			for(j=0; j<2; j++){
				if(i == 1){
					c[i][j] = a[i+1][j+1];
				}else{
					c[i][j] = a[i][j+1];
				}
			}
		}
		b[1][0] = det2x2(c, 2, 2);
		
		/* Minor dari B11 */
		c[0][0] = a[0][0];
		c[0][1] = a[0][2];
		c[1][0] = a[2][0];
		c[1][1] = a[2][2];
		b[1][1] = det2x2(c, 2, 2);
		
		/* Minor dari B12 */
		for(i=0; i<2; i++){
			for(j=0; j<2; j++){
				if(i == 1){
					c[i][j] = a[i+1][j];
				}else{
					c[i][j] = a[i][j];
				}
			}
		}
		b[1][2] = det2x2(c, 2, 2);
		
		/* Minor dari B20 */
		for(i=0; i<2; i++){
			for(j=0; j<2; j++){
				c[i][j] = a[i][j+1];
			}
		}
		b[2][0] = det2x2(c, 2, 2);
		
		/* Minor dari B21 */
		for(i=0; i<2; i++){
			for(j=0; j<2; j++){
				if(j == 1){
					c[i][j] = a[i][j+1];
				}else{
					c[i][j] = a[i][j];
				}
			}
		}
		b[2][1] = det2x2(c, 2, 2);
		
		/* Minor dari B22 */
		for(i=0; i<2; i++){
			for(j=0; j<2; j++){
				c[i][j] = a[i][j];
			}
		}
		b[2][2] = det2x2(c, 2, 2);

		/* Mencari kofaktor dengan cara */
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				if((i+j)%2 == 0){
					b[i][j] = 1*b[i][j];
				}else{
					b[i][j] = (-1)*b[i][j];
				}
			}
		}

		/* Mencari adjoin dengan cara mentranspos */
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
					d[i][j] = b[j][i];
			}
		}
		System.out.println("\nAdjoin ------------------");
		M.printMatriks(d, 3, 3);
		System.out.println("\nDeterminan : "+det);

		/* Mencari invers */
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				e[i][j] = rasional(d[i][j], det);
			}
		}
		System.out.println("Hasil ------------------");
		printMatriksInvers(e, 3, 3);
	}

	static void inv4x4(int[][] a, int baris, int kolom){
		int det = det4x4(a, baris, kolom);
		int i,j;

		/* METODE SARRUS */
		int[][] b = new int[4][4];/* Matriks yang berfungsi untuk menyimpan hasil dari determinan-determinan
		elemen pada matriks c */
		int[][] c = new int[3][3];/* Matriks yang berfungsi untuk menyimpan hasil dari minor matriks a */
		int[][] d = new int[4][4];/* Matirks untuk mentransposkan matriks b hasil determinan */
		String[][] e = new String[4][4];/* Matriks hasil */

		/* B00 */
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				c[i][j] = a[i+1][j+1];
			}
		}
		b[0][0] = det3x3(c, 3, 3);
		
		/* B01 */
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				if(j >= 1){
					c[i][j] = a[i+1][j+1];
				}else{
					c[i][j] = a[i+1][j];
				}
			}
		}
		b[0][1] = det3x3(c, 3, 3);
		
		/* B02 */
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				if(j >= 2){
					c[i][j] = a[i+1][j+1];
				}else{
					c[i][j] = a[i+1][j];
				}
			}
		}
		b[0][2] = det3x3(c, 3, 3);
		
		/* B03 */
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				c[i][j] = a[i+1][j];
			}
		}
		b[0][3] = det3x3(c, 3, 3);
		
		/* B10 */
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				if(i >= 1){
					c[i][j] = a[i+1][j+1];
				}else{
					c[i][j] = a[i][j+1];
				}
			}
		}
		b[1][0] = det3x3(c, 3, 3);
		
		/* B11 */
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				if(i == 0){
					if(j < 1){
						c[i][j] = a[i][j];
					}else{
						c[i][j] = a[i][j+1];
					}
				}else if(i == 1){
					if(j < 1){
						c[i][j] = a[i+1][j];
					}else{
						c[i][j] = a[i+1][j+1];
					}
				}else{
					if(j < 1){
						c[i][j] = a[i+1][j];
					}else{
						c[i][j] = a[i+1][j+1];
					}
				}
			}
		}
		b[1][1] = det3x3(c, 3, 3);
		
		/* B12 */
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				if(i == 0){
					if(j < 2){
						c[i][j] = a[i][j];
					}else{
						c[i][j] = a[i][j+1];
					}
				}else if(i == 1){
					if(j < 2){
						c[i][j] = a[i+1][j];
					}else{
						c[i][j] = a[i+1][j+1];
					}
				}else{
					if(j < 2){
						c[i][j] = a[i+1][j];
					}else{
						c[i][j] = a[i+1][j+1];
					}
				}
			}
		}
		b[1][2] = det3x3(c, 3, 3);
		
		/* B13 */
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				if(i < 1){
					c[i][j] = a[i][j];
				}else{
					c[i][j] = a[i+1][j];
				}
			}
		}
		b[1][3] = det3x3(c, 3, 3);
		
		/* B20 */
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				if(i < 2){
					c[i][j] = a[i][j+1];
				}else{
					c[i][j] = a[i+1][j+1];
				}
			}
		}
		b[2][0] = det3x3(c, 3, 3);
		
		/* B21 */
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				if(i == 0){
					if(j < 1){
						c[i][j] = a[i][j];
					}else{
						c[i][j] = a[i][j+1];
					}
				}else if(i == 1){
					if(j < 1){
						c[i][j] = a[i][j];
					}else{
						c[i][j] = a[i][j+1];
					}
				}else{
					if(j < 1){
						c[i][j] = a[i+1][j];
					}else{
						c[i][j] = a[i+1][j+1];
					}
				}
			}
		}
		b[2][1] = det3x3(c, 3, 3);
		
		/* B22 */
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				if(i == 0){
					if(j < 2){
						c[i][j] = a[i][j];
					}else{
						c[i][j] = a[i][j+1];
					}
				}else if(i == 1){
					if(j < 2){
						c[i][j] = a[i][j];
					}else{
						c[i][j] = a[i][j+1];
					}
				}else{
					if(j < 2){
						c[i][j] = a[i+1][j];
					}else{
						c[i][j] = a[i+1][j+1];
	   				}
				}
			}
		}
		b[2][2] = det3x3(c, 3, 3);
		
		/* B23 */
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				if(i < 2){
					c[i][j] = a[i][j];
				}else{
					c[i][j] = a[i+1][j];
				}
			}
		}
		b[2][3] = det3x3(c, 3, 3);
		
		/* B30 */
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				c[i][j] = a[i][j+1];
			}
		}
		b[3][0] = det3x3(c, 3, 3);
		
		/* B31 */
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				if(j < 1){
					c[i][j] = a[i][j];
				}else{
					c[i][j] = a[i][j+1];
				}
			}
		}
		b[3][1] = det3x3(c, 3, 3);
		
		/* B32 */
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				if(j < 2){
					c[i][j] = a[i][j];
				}else{
					c[i][j] = a[i][j+1];
				}
			}
		}
		b[3][2] = det3x3(c, 3, 3);
		
		/* B33 */
		for(i=0; i<3; i++){
			for(j=0; j<3; j++){
				c[i][j] = a[i][j];
			}
		}
		b[3][3] = det3x3(c, 3, 3);

		/* Mencari kofaktor dengan cara */
		for(i=0; i<4; i++){
			for(j=0; j<4; j++){
				if((i+j)%2 == 0){
					b[i][j] = 1*b[i][j];
				}else{
					b[i][j] = (-1)*b[i][j];
				}
			}
		}
		
		/* Mentransposkan matriks b atau adjoin*/
		System.out.println("\nAdjoin ------------");
		for(i=0; i<4; i++){
			for(j=0; j<4; j++){
				d[i][j] = b[j][i];
			}
		}
		M.printMatriks(d, 4, 4);
		System.out.println("Determinan : "+det);

		/* Proses final */
		System.out.println("\nHasil ------------");
		for(i=0; i<4; i++){
			for(j=0; j<4; j++){
				e[i][j] = rasional(d[i][j], det);
			}
		}
		printMatriksInvers(e, 4, 4);
	}
}

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

	public static void main(String[] args) {
		Determinan D = new Determinan();
		Invers I = new Invers();
		Scanner input = new Scanner(System.in);
		Random rand = new Random();

		int[][] a;
		int range = (10-0) + 0;
		int baris,kolom;
		int i,j;

		System.out.println("\tInvers Matriks");
		System.out.print("Baris : ");
			baris = input.nextInt();
		System.out.print("Kolom : ");
			kolom = input.nextInt();
		a = new int[baris][kolom];

		if(baris == 2 && kolom == 2){
			for(i=0; i<2; i++){
				for(j=0; j<2; j++){
					a[i][j] = rand.nextInt(range);
				}
			}
			printMatriks(a,baris,kolom);
			I.inv2x2(a,baris,kolom);
		}else if(baris == 3 && kolom == 3){
			for(i=0; i<3; i++){
				for(j=0; j<3; j++){
					a[i][j] = rand.nextInt(range);
				}
			}
			printMatriks(a,baris,kolom);
			I.inv3x3(a, baris, kolom);
		}else if(baris == 4 && kolom == 4){
			for(i=0; i<4; i++){
				for(j=0; j<4; j++){
					a[i][j] = rand.nextInt(range);
				}
			}
			printMatriks(a,baris,kolom);
			I.inv4x4(a, baris, kolom);
		}else{
			System.out.println("\tBaris dan Kolom tidak sama\n\tAtau ukuran matriks diluar batas");
		}
	}
}
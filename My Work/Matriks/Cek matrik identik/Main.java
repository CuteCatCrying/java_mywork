package kelasCekMatrikIdentik;

/* Mengecek matrik identik atau tidak */
import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

		int[][] matrik;
		int[][] matrik2;
		int baris,kolom;
		int baris2,kolom2;
		int i,j;
		boolean cekMatrik = true;

		// Matrik Pertama
		System.out.println("Matriks Pertama");
		System.out.print("Baris : ");
			baris = input.nextInt();
		System.out.print("kolom : ");
			kolom = input.nextInt();

		matrik = new int[baris][kolom];
		for(i=0; i<baris; i++){
			for(j=0; j<kolom; j++){
				System.out.printf("Matrik[%d][%d] : ",i,j);
					matrik[i][j] = input.nextInt();
			}
			System.out.println();
		}

		// Matrik Kedua
		System.out.println("\nMatriks Kedua");
		System.out.print("Baris : ");
			baris2 = input.nextInt();
		System.out.print("kolom : ");
			kolom2 = input.nextInt();

		matrik2 = new int[baris2][kolom2];
		for(i=0; i<baris2; i++){
			for(j=0; j<kolom2; j++){
				System.out.printf("Matrik[%d][%d] : ",i,j);
					matrik2[i][j] = input.nextInt();
			}
			System.out.println();
		}

		// Pengoutputan kedua matriks
		System.out.println("Matriks Pertama");
		for(i=0; i<baris; i++){
			System.out.print("[");
			for(j=0; j<kolom; j++){
				System.out.print(matrik[i][j]);
				if(j < (kolom-1)){
					System.out.print("\t");
				}else{
					System.out.print("]");
				}
			}
			System.out.println();
		}
		System.out.println("\nMatriks Kedua");
		for(i=0; i<baris2; i++){
			System.out.print("[");
			for(j=0; j<kolom2; j++){
				System.out.print(matrik2[i][j]);
				if(j < (kolom2-1)){
					System.out.print("\t");
				}else{
					System.out.print("]");
				}
			}
			System.out.println();
		}

		// Pengecekan
		if(baris == baris2 && kolom == kolom2){
			for(i=0; i<baris; i++){
				for(j=0; j<kolom; j++){
					if(matrik[i][j] == matrik2[i][j]){
						cekMatrik = true;
					}else{
						cekMatrik = false;
					}
				}
			}
			if(cekMatrik == true){
				System.out.println("Kedua Matriks Identik!!");
			}
		}else{
			System.out.println("Ukuran baris dan kolom berbeda otomatis kedua matrik tidak identik");
		}
	}
}
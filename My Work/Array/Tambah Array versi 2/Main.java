package kelasTambahArrayVersi2;

import java.util.Scanner;
import java.util.Random;

public class Main{
	static void printArray(int[] a,int n){
		for(int i=0; i<n; i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}

	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		Random rand = new Random();

		int[] a;
		int[] b;
		int i;
		int range = (90 - 20 +1)+20;
		int n,tambahNilai,indeksTambah;

		System.out.print("Banyak Array : ");
			n = input.nextInt();
		a = new int[n];

		// Penginputan
		for(i=0; i<n; i++){
			a[i] = rand.nextInt(range);
		}
		printArray(a,n);

		// Penambahan array
		System.out.print("\nNilai : ");
			tambahNilai = input.nextInt();
		System.out.print("Pada indeks : ");
			indeksTambah = input.nextInt();

		// Proses penambahan
		b = new int[n+1];
		for(i=0; i<(n+1); i++){
			if(i >= indeksTambah){
				b[indeksTambah] = tambahNilai;
				b[i] = a[i-1];
			}else{
				b[i] = a[i];
			}
		}
		printArray(b,(n+1));
	}
}
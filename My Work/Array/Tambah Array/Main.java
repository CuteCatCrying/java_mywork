package kelasTambahArray;

import java.util.Scanner;
import java.util.Random;

public class Main{
	static void printArray(int[] a,int n){
		for(int i=0; i<n; i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random rand = new Random();

		int[] a;
		int[] b;
		int i;
		int n;
		int indeksTambah,nilaiTambah;
		int range = (90 - 20 +1)+20;

		System.out.print("Banyak array : ");
			n = input.nextInt();
		a = new int[n];

		// Penginputan
		for(i=0; i<n; i++){
			a[i] = rand.nextInt(range);
		}
		printArray(a,n);

		System.out.print("\nIndeks array yang ditambahkan : ");
			indeksTambah = input.nextInt();
		System.out.print("Nilai : ");
			nilaiTambah = input.nextInt();

		// Proses penambahan
		b = new int[n+1];
		for(i=0; i<indeksTambah; i++){
			b[i] = a[i];
		}
		b[indeksTambah] = nilaiTambah;
		for(i=(indeksTambah+1); i<(n+1); i++){
			b[i] = a[i-1];
		}
		printArray(b,(n+1));
	}
}
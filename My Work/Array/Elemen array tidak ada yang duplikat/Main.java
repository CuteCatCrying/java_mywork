package kelasNoDuplicateArray;

import java.util.Scanner;
import java.util.Random;

public class Main {
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
		int i,j,n;
		int temp;
		int indexB=0;
		int range = (90 - 20 +1)-20;

		System.out.print("Banyak array : ");
			n = input.nextInt();
		a = new int[n];
		b = new int[n];

		for(i=0; i<n; i++) {
			a[i] = rand.nextInt(range);
		}
		printArray(a,n);

		// Sorting dari kecil ke besar
		for(i=0; i<n; i++) {
			for(j=(n-1); j>i; j-- ) {
				if(a[j] < a[j-1]) {
					temp   = a[j];
					a[j]   = a[j-1];
					a[j-1] = temp;
				}
			}
		}
		System.out.println("\nSorting");
		printArray(a,n);

		// Penyeleksian jika ada yang duplikat
		j = 0;
		for(i=1; i<(n-1); i++){
			if(a[i] != a[i+1]){
				b[j++] = a[i];
			}
		}
		b[j++] = a[n-1];
		printArray(b,n);
	}
}
package kelasHapusArrayVersi2;

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
		int n,indeksHapus;
		int range = (90 - 20 +1)+20;

		System.out.print("Banyak array : ");
			n = input.nextInt();
		a = new int[n];

		// Penginputan
		for(i=0; i<n; i++){
			a[i] = rand.nextInt(range);
		}
		printArray(a,n);

		// Hapus array
		System.out.print("\nIndek yang dihapus : ");
			indeksHapus = input.nextInt();
		b = new int[n-1];

		// Proses penghapusan
		for(i=0; i<(n-1); i++){
			if(i >= indeksHapus){
				b[i] = a[i+1];
			}else{
				b[i] = a[i];
			}
		}
		printArray(b,(n-1));
	}
}
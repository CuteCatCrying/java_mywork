package kelasKonversiDesimalKeRasional;

import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		double angka;
		int i;

		System.out.println("Konversi decimal ke rasional");
		System.out.print("Input : ");
			angka = input.nextDouble();

		/***************************Proses***************************/
		String konversiAngka = String.valueOf(angka);
		/*Mencari berapa angka dibelakang koma*/
		int digitDec = konversiAngka.length() - 1 - konversiAngka.indexOf('.');
		int denum = 1; /*Inisialiasi denum*/

		/*Menghilangkan koma dengan cara mengkali angka 10 sebanyak angka dibelakang koma*/
		for(i=0; i<digitDec; i++){
			angka *= 10;
			denum *= 10;
		}

		/*Pembulatan angka, karena jika angka decimal paling belakang adalah 1 maka tanpa pembulatan akan menjadi 0
		(Convert Force)*/
		int num = (int)Math.round(angka);

		/*Mencari pembagi terbesar untuk num dan denum*/
		int gcd = 1;
		for(i=1; i<=num && i<=denum; i++){
			/*Maksudnya adalah jika num yang terkecil loop akan langsung break begitupun sebaliknya*/
			if(num%i == 0 && denum%i == 0){
				gcd = i;
			}
		}

		/*Membagi num dan denum dengan pembagi terbesar*/
		num = num/gcd;
		denum = denum/gcd;
		System.out.println(num + "/" + denum);
	}
}
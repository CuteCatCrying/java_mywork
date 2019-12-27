package kelasException;

import java.util.Scanner;
import java.lang.NumberFormatException;

public class Main{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String a,b;
		int hasil;
		double hasilFloat;

		System.out.print("Angka 1 : ");
			a = input.nextLine();
		System.out.print("Angka 2 : ");
		 	b = input.nextLine();

		try{
			hasil = Integer.valueOf(a) * Integer.valueOf(b);
			System.out.println("Hasil kali   = "+hasil);

			hasilFloat = Float.valueOf(a) / Float.valueOf(b);
			System.out.println("Hasil bagi   = "+hasilFloat);

			hasil = Integer.valueOf(a) + Integer.valueOf(b);
			System.out.println("Hasil tambah = "+hasil);

			hasil = Integer.valueOf(a) - Integer.valueOf(b);
			System.out.println("Hasil kurang = "+hasil);
		}catch(NumberFormatException e){
			System.err.println("Angka salah satunya atau keduanya adalah String atau Char");
		}
	}
}
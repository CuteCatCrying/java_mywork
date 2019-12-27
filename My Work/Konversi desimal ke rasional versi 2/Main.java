package kelasKonversiDesimalKeRasionalVersi2;

import java.util. Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int gcd = 1;
        double num,denum;
        double kecil;
        double hasil;

        System.out.print("Masukkan num   : ");
            num = input.nextDouble();
        System.out.print("Masukkan denum : ");
            denum = input.nextDouble();

        kecil = (num > denum) ? denum : num;
        for(int i=1; i<=kecil; i++){
            if(num%i == 0 && denum%i == 0){
                gcd = i;
            }
        }

        num = (double)num/gcd;
        denum = (double)denum/gcd;
        System.out.printf("Hasil : %.2f/%.2f\n",num,denum);


        input.close();
    }
}
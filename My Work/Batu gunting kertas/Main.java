package kelasBatuGuntingKertas;

import java.util.Scanner;
import java.util.Random;

public class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        String hasilUser = null, hasilKomputer = null, hasilAkhir = null;
        int range = (30 - 1) + 1;
        int pilihanKomputer;
        int pilihanUser;

        System.out.println("\tBatu gunting kertas");;
        System.out.println("1. Batu");
        System.out.println("2. Kertas");
        System.out.println("3. Gunting");
        System.out.print("Apa yang anda pilih : ");
            pilihanUser = input.nextInt();
        /*
            10 < Batu
            10 > Kertas < 20
            20 > Gunting
        */
        pilihanKomputer = rand.nextInt(range);
        
        System.out.println();
        if(pilihanUser == 1){
            /* User memilih batu */
            hasilUser = "Batu";
            if(pilihanKomputer < 10){
                /* Komputer memilih batu */
                hasilKomputer = "Batu";
                hasilAkhir = "Hasil seri";
            }else if(pilihanKomputer > 10 && pilihanKomputer < 20){
                /* Komputer memilih kertas */
                hasilKomputer = "Kertas";
                hasilAkhir = "Anda kalah";
            }else{
                /* Komputer memilih guntig */
                hasilKomputer = "Gunting";
                hasilAkhir = "Selamat anda menang !!!";
            }
        }else if(pilihanUser == 2){
            /* User memilih Kertas */
            hasilUser = "Kertas";
            if(pilihanKomputer < 10){
                /* Komputer memilih batu */
                hasilKomputer = "Batu";
                hasilAkhir = "Selamat anda menang !!!";
            }else if(pilihanKomputer > 10 && pilihanKomputer < 20){
                /* Komputer memilih kertas */
                hasilKomputer = "Kertas";
                hasilAkhir = "Hasil seri";
            }else{
                /* Komputer memilih gunting */
                hasilKomputer = "Gunting";
                hasilAkhir = "Anda kalah";
            }
        }else if(pilihanUser == 3){
            /* User memilih gunting */
            hasilUser = "Gunting";
            if(pilihanKomputer < 10){
                /* Komputer memilih batu */
                hasilKomputer = "Batu";
                hasilAkhir = "Anda kalah";
            }else if(pilihanKomputer > 10 && pilihanKomputer < 20){
                /* Komputer memilih kertas */
                hasilKomputer = "Kertas";
                hasilAkhir = "Selamat anda menang !!!";
            }else{
                /* Komputer memilih gunting */
                hasilKomputer = "Gunting";
                hasilAkhir = "Hasil seri";
            }
        }else{
            System.out.println("Pilihan tidak ada");
        }
        hasilUser = String.format("User memilih     : %s",hasilUser);
        hasilKomputer = String.format("Komputer memilih : %s",hasilKomputer);

        System.out.println(hasilUser);
        System.out.println(hasilKomputer);
        System.out.println(hasilAkhir);
        input.close();
    }
}
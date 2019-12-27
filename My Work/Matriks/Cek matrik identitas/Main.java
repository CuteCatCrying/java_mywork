package kelasCekMatrikIdentitas;

/* Mengecek Cek matrik identitas atau tidak */
import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

		int[][] matrik;
		int baris,kolom;
		int i,j;
		boolean cekMatrik = true ,cekMatrik2 = true ,hasilCek;

		System.out.print("Baris : ");
			baris = input.nextInt();
		System.out.print("Kolom : ");
			kolom = input.nextInt();

		matrik = new int[baris][kolom];
		if(baris == kolom){
			// Penginputan matrik
			for(i=0; i<baris; i++){
				for(j=0; j<kolom; j++){
					System.out.printf("Matrik[%d][%d] = ",i,j);
						matrik[i][j] = input.nextInt();
				}
				System.out.println();
			}
			// Cek identitas atau tidak
			for(i=0; i<baris; i++){
				for (j=0; j<kolom; j++) {
					if(i==j){
						if(matrik[i][j] == 1){
							cekMatrik = true;
							break;
						}else{
							cekMatrik = false;
							break;
						}
					}else{
						if(matrik[i][j] == 0){
							cekMatrik2 = true;
							break;
						}else{
							cekMatrik2 = false;
							break;
						}
					}
				}
			}
			hasilCek = (cekMatrik && cekMatrik2);
			if(hasilCek == true){
				System.out.println("Matrik Identitas!!");
			}else{
				System.out.println("Bukan Matriks identitas walapun baris dan kolom sama");
			}
			System.out.println();
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
		}else{
			System.out.println("Matrik identitas seharusnya baris dan kolom sama!!");
		}
	}
}
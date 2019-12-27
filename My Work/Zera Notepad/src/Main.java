import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class Main{
	private static String dir = System.getProperty("user.home") + "/Zera_Notepad";
	private static String dirFile = System.getProperty("user.home") + "/Zera_Notepad/zeranotepad.bin";
	private static File theDir = new File(dir);
	private static File theDirFile = new File(dirFile);

	private static String getOs(){
		return System.getProperty("os.name");
	}

	private static boolean isLinux(){
		if(getOs().equals("Linux")){
			return true;
		}

		return false;
	}

	private static void makeDirAndFile(){
		try{
			if(isLinux()){
				if(!theDir.exists()){
					theDir.mkdir();
					if(!theDirFile.exists()){
						theDirFile.createNewFile();
					}
				}
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}

	public static void main(String[] args) throws IOException{
		makeDirAndFile(); // Pembuatan directori diawal
		Scanner in = new Scanner(System.in);

		String pilihanUser, kata;
		int banyakData;
		boolean ulang = true;

		// Penulisan Data
		FileWriter fw = new FileWriter(dirFile, true);
		PrintWriter pw = new PrintWriter(fw);

		// Pembacaan Data
		FileReader fr = new FileReader(dirFile);
		BufferedReader br = new BufferedReader(fr);

		if(!(args.length == 0)){ //Jika user menginputkan data melalui argument
			for(int i=0; i<args.length; i++){
				pw.println(args[i]);
			}
			System.out.println(args.length + " Kata Berhasil Ditambahkan");
			pw.flush();
		}

		while(ulang){
			System.out.println("\t==========================");
			System.out.println("\t||\tZera Notepad\t||");
			System.out.println("\t|| 1. Entri Data\t||");
			System.out.println("\t|| 2. Delete Data\t||");
			System.out.println("\t|| 3. Delete All Data\t||");
			System.out.println("\t|| 4. Check All Data\t||");
			System.out.println("\t|| 5. Help\t\t||");
			System.out.println("\t|| 6. Exit\t\t||");
			System.out.println("\t==========================");
			System.out.print("Choose ? ");
				pilihanUser = in.next();

			in.nextLine(); //Clearing Buffer
			switch(pilihanUser){
				case "1" : {
					makeDirAndFile(); //membuat file lagi ketika file dihapus dan user ingin menambahkan data
					System.out.println("\t==================");
					System.out.println("\t|| Entri Data\t||");
					System.out.println("\t==================");
					System.out.print("Kata : ");
						kata = in.nextLine();
					pw.println(kata);
					pw.flush();
					break;
				}

				case "2" : {
					System.out.println("\t==================");
					System.out.println("\t|| Delete Data\t||");
					System.out.println("\t==================");
					System.out.println("No : ");
						kata = in.nextLine();
					break;
				}

				case "3" : {
					System.out.println("\t==========================");
					System.out.println("\t|| Delete All Data\t||");
					System.out.println("\t==========================");
					System.out.print("Are you sure (y/n)? ");
						kata = in.nextLine();
					if(kata.charAt(0) == 'y' || kata.charAt(0) == 'Y'){
						theDirFile.delete();
						theDir.delete();
						System.out.println("Delete Complete!");
						ulang = false;
					}else if(kata.charAt(0) == 'n' || kata.charAt(0) == 'N'){
						break;
					}else{
						break;
					}
					break;
				}

				case "4" : {
					System.out.println("\t==========================");
					System.out.println("\t|| Check All Data\t||");
					System.out.println("\t==========================");
					// kata = null;
					br.mark(200); // set tanda pada awal buffer
					banyakData = 1;
					while((kata = br.readLine()) != null){
						System.out.println(banyakData + ". " + kata);
						banyakData++;
					}
					br.reset(); // mereset ulang ke tanda terakhir yakni 0
					break;
				}

				case "5" : {
					System.out.println("\t==================");
					System.out.println("\t|| Help\t\t||");
					System.out.println("\t==================");
					System.out.println("1. Path directory for save data '/UserHome/Zera_Notepad'");
					System.out.println("2. Can be input data with arguments");
					System.out.println("3. Delete Data With Number of Data");
					break;
				}

				case "6" : {
					fw.close();
					pw.close();
					in.close();
					ulang = false;
					break;
				}
			}
		}











	}
}
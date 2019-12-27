package kelasIOFile;

import java.util.Scanner;
import java.io.*;
import java.util.Base64; // Library Base64

public class Main{
	// Enumarasi
	enum Menu{tambah,cek,hapus,exit}

	static String encodingBase64(String estr){
		// Getting encoder  
	    Base64.Encoder encoder = Base64.getEncoder();  
	    // Encoding string  
	    estr = encoder.encodeToString(estr.getBytes());  
	    return estr;
	}
	static String decodingBase64(String dstr){
	    // Getting decoder  
	    Base64.Decoder decoder = Base64.getDecoder();  
	    // Decoding string  
	    dstr = new String(decoder.decode(dstr));
	    return dstr;
	}

	static void cekFile(){
		File cekFileData;
		cekFileData = new File("Data.txt");
		if(cekFileData.exists()){
		}else{
			try{
				new File("Data.txt").createNewFile();
			}catch(Exception e){}
		}
	}
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		String akun,username,password;
		// Mendeklarasikan variable enum
		Menu pilihMenu;
		int pilih;

		System.out.println("\t====== Save My Password ======");
		System.out.println("1. Tambah Data");
		System.out.println("2. Cek Data");
		System.out.println("3. Hapus Data");
		System.out.println("4. Exit");
		System.out.print("Pilih Menu ? : ");
			pilih = input.nextInt();
		// Menginisialisasi enum ke values
		if(pilih == 1){
			pilihMenu = Menu.tambah;
		}else if(pilih == 2) {
			pilihMenu = Menu.cek;
		}else if(pilih == 3){
			pilihMenu = Menu.hapus;
		}else{
			pilihMenu = Menu.exit;
		}

		cekFile();
		System.out.println();

		switch(pilihMenu){
			case tambah : {
				System.out.println("1. Tambah Data");
				System.out.print("Akun     : ");
					akun = input.next();
				System.out.print("Username : ");
					username = input.next();
				System.out.print("Password : ");
					password = input.next();

				try{
					PrintWriter pw = new PrintWriter(new FileWriter("Data.txt",true));
					pw.println(encodingBase64("================================="));
					// Proses Encoding ke Base64
					String eAkun = encodingBase64("Akun     : "+akun);
					String eUsername = encodingBase64("Username : "+username);
					String ePassword = encodingBase64("Password : "+password);
					pw.println(eAkun);
					pw.println(eUsername);
					pw.println(ePassword);
					pw.flush();
				}catch(Exception e){}
				break;
			}
			case cek : {
				System.out.println("2. Cek Data");
				try{
					FileReader fr = new FileReader("Data.txt");
					BufferedReader in = new BufferedReader(fr);
					String line;
					String dLine;
					while((line = in.readLine()) != null){
						/*Proses decoding*/
						dLine = decodingBase64(line);
						System.out.println(dLine);
					}
				}catch(Exception e){}
				break;
			}
			case hapus : {
				File delData = new File("Data.txt");
				delData.delete();
			}
			case exit : {
				return;
			}
		}
	}
}
package kelasBufferedByteStream;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;

public class Main{
	public static void main(String[] args) throws IOException{
		long waktuStart, waktuFinish;

		// Membaca dari file
		FileInputStream byteInput = new FileInputStream("input.txt");
		System.out.println(byteInput.available()); //Melihat berapa banyak karakter didalam file

		// menghitung waktu pembacaan
		waktuStart = System.nanoTime();
		System.out.println(byteInput.readAllBytes());
		waktuFinish = System.nanoTime();
		System.out.println("Waktu : "+(waktuFinish - waktuStart));
		byteInput.close();

		// Membaca dari memory
		FileInputStream byteInput2 = new FileInputStream("input.txt");
		BufferedInputStream bufferedInput = new BufferedInputStream(byteInput2);

		bufferedInput.mark(200);
		// menghitung waktu pembacaan
		waktuStart = System.nanoTime();
		System.out.println(bufferedInput.readAllBytes());
		waktuFinish = System.nanoTime();
		System.out.println("Waktu : "+(waktuFinish - waktuStart));

		// baca ulang
		bufferedInput.reset();
		byte[] data = bufferedInput.readAllBytes();
		String dataString = new String(data);
		System.out.println(dataString);
		bufferedInput.close();
		byteInput2.close();

		// menulis dengan buffered output
		FileOutputStream byteOutput = new FileOutputStream("output.txt");
		BufferedOutputStream bufferedOutput = new BufferedOutputStream(byteOutput);

		// Write data berupa byte
		bufferedOutput.write(data,0,data.length);
		bufferedOutput.flush();
		bufferedOutput.close();
		byteOutput.close();
	}
}
package kelasFungsi;

import java.util.ArrayList;
import java.util.List;

public class StackFunction {
	private List<Object> list = new ArrayList<Object>();
	private int currentIndex = -1;

	// Push, digunakan untuk memasukkan data ke dalam stack
	public void push(Object object){
		list.add(object);
		currentIndex++;
	}

	// Pop, digunakan untuk mengeluarkan data teratas dari stack
	public Object pop(){
		Object object = list.remove(currentIndex);
		currentIndex--;
		return object;
	}

	// Count, digunakan untuk mengetahui jumlah isi data pada stack
	public int count(){
		return list.size();
	}

	// Peek, digunakan untu melihat data yang berada pada posisi paling atas
	public Object peek(){
		return list.get(currentIndex);
	}

	// Clear, digunakan untuk menghapus seluruh data yang ada pada stack
	public void clear(){
		list.clear();
		currentIndex = -1;
	}
}
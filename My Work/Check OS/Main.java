public class Main{
	public static void main(String[] args) {
		String os = System.getProperty("os.name");
		System.out.println("OS Name : " + os);

		System.out.println("\n\nSystem Properties");
		System.getProperties().list(System.out);
	}
}
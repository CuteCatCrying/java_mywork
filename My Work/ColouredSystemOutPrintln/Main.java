package kelasColouredSystemOutPrintln;

public class Main{
	static public String ANSI_RESET = "\u001B[0m";

	static public String ANSI_BLACK  = "\u001B[30m";
	static public String ANSI_RED    = "\u001B[31m";
	static public String ANSI_GREEN  = "\u001B[32m";
	static public String ANSI_YELLOW = "\u001B[33m";
	static public String ANSI_BLUE   = "\u001B[34m";
	static public String ANSI_PURPLE = "\u001B[35m";
	static public String ANSI_CYAN   = "\u001B[36m";
	static public String ANSI_WHITE  = "\u001B[37m";

	static public String ANSI_BRIGHT_BLACK  = "\u001B[90m";
	static public String ANSI_BRIGHT_RED    = "\u001B[91m";
	static public String ANSI_BRIGHT_GREEN  = "\u001B[92m";
	static public String ANSI_BRIGHT_YELLOW = "\u001B[93m";
	static public String ANSI_BRIGHT_BLUE   = "\u001B[94m";
	static public String ANSI_BRIGHT_PURPLE = "\u001B[95m";
	static public String ANSI_BRIGHT_CYAN   = "\u001B[96m";
	static public String ANSI_BRIGHT_WHITE  = "\u001B[97m";

	static public String ANSI_BG_BLACK  = "\u001B[40m";
	static public String ANSI_BG_RED    = "\u001B[41m";
	static public String ANSI_BG_GREEN  = "\u001B[42m";
	static public String ANSI_BG_YELLOW = "\u001B[43m";
	static public String ANSI_BG_BLUE   = "\u001B[44m";
	static public String ANSI_BG_PURPLE = "\u001B[45m";
	static public String ANSI_BG_CYAN   = "\u001B[46m";
	static public String ANSI_BG_WHITE  = "\u001B[47m";

	static public String ANSI_BRIGHT_BG_BLACK  = "\u001B[100m";
	static public String ANSI_BRIGHT_BG_RED    = "\u001B[101m";
	static public String ANSI_BRIGHT_BG_GREEN  = "\u001B[102m";
	static public String ANSI_BRIGHT_BG_YELLOW = "\u001B[103m";
	static public String ANSI_BRIGHT_BG_BLUE   = "\u001B[104m";
	static public String ANSI_BRIGHT_BG_PURPLE = "\u001B[105m";
	static public String ANSI_BRIGHT_BG_CYAN   = "\u001B[106m";
	static public String ANSI_BRIGHT_BG_WHITE  = "\u001B[107m";

	static public String[] FOREGROUNDS = {
		ANSI_BLACK, ANSI_RED, ANSI_GREEN, ANSI_YELLOW,
		ANSI_BLUE, ANSI_PURPLE, ANSI_CYAN, ANSI_WHITE,
		ANSI_BRIGHT_BLACK, ANSI_BRIGHT_RED, ANSI_BRIGHT_GREEN,
		ANSI_BRIGHT_BLUE, ANSI_BRIGHT_PURPLE, ANSI_BRIGHT_CYAN
	};

	static public String[] BACKGROUNDS = {
		ANSI_BG_BLACK, ANSI_BG_RED, ANSI_BG_GREEN, ANSI_BG_YELLOW,
		ANSI_BG_BLUE, ANSI_BG_PURPLE, ANSI_BG_CYAN, ANSI_BG_WHITE,
		ANSI_BRIGHT_BG_BLACK, ANSI_BRIGHT_BG_RED, ANSI_BRIGHT_BG_GREEN,
		ANSI_BRIGHT_BG_BLUE, ANSI_BRIGHT_BG_PURPLE, ANSI_BRIGHT_BG_CYAN	
	};
		
	public static void main(String[] args) {
		System.out.println("\n Default text\n");

		for(String fg : FOREGROUNDS){
			for(String bg : BACKGROUNDS){
				System.out.print(fg + bg + "TEST");
			}
			System.out.println(ANSI_RESET);
		}
		System.out.println(ANSI_RESET + "\n Resetting");
	}
}
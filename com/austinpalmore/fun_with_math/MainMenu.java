package com.austinpalmore.fun_with_math;
public class MainMenu {
	final static private com.austinpalmore.fun_with_math.util.Display display = new com.austinpalmore.fun_with_math.util.Display();
	final static private java.util.Scanner console = new java.util.Scanner(System.in);
	private static String items[] = { "Exit","Numbers", "Algorithms", "Cryptograpy"/*,"Probability"*/ };
	private static String messages[] = {"Welcome To Fun With Math By Austin Palmore","Pleze Select A Item from the menu below"};
	MainMenu(String args[]) {
		boolean run = true;
		int input = -1;
		java.util.Scanner console = new java.util.Scanner(System.in);
		while(run) {
			while(input < 0 || input > items.length) {
				new Menu(items,messages);
				input = getInt(console);
			}
			switch (input) {
				case 0:
					System.out.println("Exiting!");
					run = false;
					break;
				case 1:
					new com.austinpalmore.fun_with_math.numbers.Numbers(display,console);
					input = -1;
					break;
				case 2:
				       	new com.austinpalmore.fun_with_math.algorithms.Algorithms(display, console);
					input = -1;
					break;
				case 3:
					new com.austinpalmore.fun_with_math.cryptograpy.Cryptograpy(display,console);
					input = -1;
					break;
				/*case 4:
					new com.austinpalmore.fun_with_math.probability.Probability(display,console,args);
					input = -1;
					break;*/
				default:
					run = false;
					break;
			}
		}
	}
	public static void pauseForEnter(java.util.Scanner console) {
		System.out.println("Press Enter To Retern to Main Menu...");
		console.nextLine();
		console.nextLine();
	}
	public static int getInt(java.util.Scanner console) {
		while(!console.hasNextInt()) {
			console.next();
			System.err.print("\nEnter a intiger: ");
		}
		return console.nextInt();
	}
}

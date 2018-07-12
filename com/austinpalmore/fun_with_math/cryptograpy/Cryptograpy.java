package com.austinpalmore.fun_with_math.cryptograpy;
public class Cryptograpy {
	private static String items[] = { "Exit","ROT13",/*"Prime Generator"*/ };
	private static String messages[] = {"Welcome To Fun With Cryptograpy","Pleze Select A Item from the menu below"};
	public Cryptograpy(com.austinpalmore.fun_with_math.util.Display display, java.util.Scanner scan) {
		boolean run = true;
		int input = -1;
		while(run) {
			while(input < 0 || input > items.length) {
				new com.austinpalmore.fun_with_math.util.Menu(items,messages);
				input = getInt(scan);
			}
			switch (input) {
				case 0:
					System.out.println("Exiting!");
					run = false;
					break;
				case 1:
					Rot13.driver();
					input = -1;
					pauseForEnter(scan);
					break;
				/*case 2:
					Primegenerator pg = new Primegenerator(1,100);
					input = -1;
					pauseForEnter(scan);
					break;
				*/
				default:
					run = false;
					break;
			}
		}
	}
	private static void pauseForEnter(java.util.Scanner s) {
		System.out.println("Press Enter To Retern to Main Menu...");
		s.nextLine();
		s.nextLine();
	}
	private static int getInt(java.util.Scanner console) {
		while(!console.hasNextInt()) {
			console.next();
			System.err.print("\nEnter a intiger: ");
		}
		return console.nextInt();
	}
}

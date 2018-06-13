package com.austinpalmore.fun_with_math;
public class MainMenu {
	final static protected Display display = new Display();
	final static protected java.util.Scanner console = new java.util.Scanner(System.in);
	protected static String items[] = { "Exit","Numbers", "Algorithms", "Probability","Cryptograpy" };
	protected static String messages[] = {"Welcome To Fun With Math By Austin Palmore","Pleze Select A Item from the menu below"};
	protected static boolean underDevelopment[] = { false,false,false,true,true };
	MainMenu() {
		boolean run = true;
		int input = -1;
		java.util.Scanner console = new java.util.Scanner(System.in);
		while(run) {
			while(input < 0 || input > 4) {
				new Menu(items,messages,underDevelopment);
				input = getInt(console);
			}
			switch (input) {
				case 0:
					System.out.println("Exiting!");
					run = false;
					break;
				case 1:
					new Numbers(display,console);
					input = -1;
					pauseForEnter(console);
					break;
				case 2:
				       	new Algorithms(display, console);
					input = -1;
					pauseForEnter(console);
					break;
				case 3:
					new Probability(display,console);
					input = -1;
					pauseForEnter(console);
					break;
				case 4:
					new Cryptograpy(display,console);
					input = -1;
					pauseForEnter(console);
					break;
				default:
					run = false;
					break;
			}
		}
	}
	protected static void pauseForEnter(java.util.Scanner console) {
		System.out.println("Press Enter To Retern to Main Menu...");
		console.nextLine();
		console.nextLine();
	}
	protected static int getInt(java.util.Scanner console) {
		while(!console.hasNextInt()) {
			console.next();
			System.err.print("\nEnter a intiger: ");
		}
		return console.nextInt();
	}
}

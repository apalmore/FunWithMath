package com.austinpalmore.fun_with_math.numbers;
public class Numbers {
	private static String items[] = { "Exit","Fun With Primes", "Fibinachi Numbers" };
	private static String messages[] = {"Welcome To Fun With Numbers","Pleze Select A Item from the menu below"};
	public Numbers(com.austinpalmore.fun_with_math.util.Display display, java.util.Scanner scan) {
		boolean run = true;
		int input = -1;
		while(run) {
			while(input < 0 || input > 2) {
				new com.austinpalmore.fun_with_math.Menu(items,messages);
				input = getInt(scan);
			}
			switch (input) {
				case 0:
					System.out.println("Exiting!");
					run = false;
					break;
				case 1:
					Primes.driver(display, scan);
					input = -1;
					pauseForEnter(scan);
					break;
				case 2:
				       	Fibinacci.driver(91);
					input = -1;
					pauseForEnter(scan);
					break;
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

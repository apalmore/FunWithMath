package com.austinpalmore.fun_with_math;
public class Probability {
	protected static String items[] = { "Exit","Lottery Game" };
	protected static String messages[] = {"Welcome To Fun With Probability","Pleze Select A Item from the menu"};
	Probability(Display display, java.util.Scanner scan,String args[]) {
		boolean run = true;
		int input = -1;
		while(run) {
			while(input < 0 || input > 5) {
				new Menu(items,messages);
				input = getInt(scan);
			}
			switch (input) {
				case 0:
					System.out.println("Exiting!");
					run = false;
					break;
				case 1:
					Application1.driver(args);
					input = -1;
					pauseForEnter(scan);
					break;
				case 2:
					System.out.println("This is not yet avaliable");
					input = -1;
					pauseForEnter(scan);
					break;
				case 3:
					System.out.println("This is not yet avaliable");
					input = -1;
					pauseForEnter(scan);
					break;
				case 4:
					System.out.println("This is not yet avaliable");
					input = -1;
					pauseForEnter(scan);
					break;
				case 5:
					System.out.println("This is not yet avaliable");
					input = -1;
					pauseForEnter(scan);
					break;
				default:
					run = false;
					break;
			}
		}
	}
	protected static void pauseForEnter(java.util.Scanner s) {
		System.out.println("Press Enter To Retern to Main Menu...");
		s.nextLine();
		s.nextLine();
	}
	protected static int getInt(java.util.Scanner console) {
		while(!console.hasNextInt()) {
			console.next();
			System.err.print("\nEnter a intiger: ");
		}
		return console.nextInt();
	}
}

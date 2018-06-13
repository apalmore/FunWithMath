package com.austinpalmore.fun_with_math;
public class Numbers {
	protected static String items[] = { "Exit","Fun With Primes", "Fibinachi Numbers" };
	protected static String messages[] = {"Welcome To Fun With Numbers","Pleze Select A Item from the menu below"};
	protected static boolean underDevelopment[] = { false,false,false };
	Numbers(Display display, java.util.Scanner scan) {
		boolean run = true;
		int input = -1;
		while(run) {
			while(input < 0 || input > 2) {
				new Menu(items,messages,underDevelopment);
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
	protected static void printMenu() {
		System.out.println("##############################################");
		System.out.println("# Welcome To Fun With Math Numbers           #");
		System.out.println("#********************************************#");
		System.out.println("#   Pleze Select A Item from the menu below  #");
		System.out.println("#********************************************#");
		System.out.println("| (0) Exit                                   |");
		System.out.println("----------------------------------------------");
		System.out.println("| (1) Fun With Primes                        |");
		System.out.println("----------------------------------------------");
		System.out.println("| (2) fibinachi numbers                      |");
		System.out.println("----------------------------------------------");
		System.out.println();
		System.out.print("Enter your chose >>: ");
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

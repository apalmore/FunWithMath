package com.austinpalmore.fun_with_math;
public class Probability {
	protected static String items[] = { "Lottery Game","Factorials","Random Walk","Monte Carlo","Dice" };
	protected static String messages[] = {"Welcome To Fun With Probability","Pleze Select A Item from the menu"};
	protected static boolean underDevelopment[] = { true,true,true,true,true };
	Probability(Display display, java.util.Scanner scan) {
		boolean run = true;
		int input = -1;
		while(run) {
			while(input < 0 || input > 5) {
				new Menu(items,messages,underDevelopment);
				input = getInt(scan);
			}
			switch (input) {
				case 0:
					System.out.println("Exiting!");
					run = false;
					break;
				case 1:
					System.out.println("This is not yet avaliable");
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
	protected static void printMenu() {
		System.out.println("##############################################");
		System.out.println("# Welcome To Fun With Probability            #");
		System.out.println("#********************************************#");
		System.out.println("#   Pleze Select A Item from the menu below  #");
		System.out.println("#********************************************#");
		System.out.println("| (0) Exit                                   |");
		System.out.println("----------------------------------------------");
		System.out.println("| (1) Lottery Game     [ under development ] |");
		System.out.println("----------------------------------------------");
		System.out.println("| (2) Factorials       [ under development ] |");
		System.out.println("----------------------------------------------");
		System.out.println("| (3) Random Walk      [ under development ] |");
		System.out.println("----------------------------------------------");
		System.out.println("| (4) Monte Carlo      [ under development ] |");
		System.out.println("----------------------------------------------");
		System.out.println("| (5) Dice             [ under development ] |");
		System.out.println("##############################################");
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

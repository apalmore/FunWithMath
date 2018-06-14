package com.austinpalmore.fun_with_math.algorithms;
public class Algorithms {
	private static String items[] = { "Exit","Euclid's Algorithum", "Boubble Sort", "Simple Search", "Binary Search" };
	private static String messages[] = {"Welcome To Fun With Algorithms","Pleze Select A Item from the menu below"};

	public Algorithms(com.austinpalmore.fun_with_math.util.Display display, java.util.Scanner scan) {
		boolean run = true;
		int input = -1;
		while(run) {
			while(input < 0 || input > items.length) {
				new com.austinpalmore.fun_with_math.Menu(items,messages);
				input = getInt(scan);
			}
			switch (input) {
				case 0:
					System.out.println("Exiting!");
					run = false;
					break;
				case 1:
					EuclidsAlgorithm.driver();
					input = -1;
					pauseForEnter(scan);
					break;
				case 2:
					(new BoubbleSort(15)).driver(15);
					input = -1;
					pauseForEnter(scan);
					break;
				case 3:
					Search.lenearSearch();
					input = -1;
					pauseForEnter(scan);
					break;
				case 4:
					Search.binarySearch();
					input = -1;
					pauseForEnter(scan);
					break;
				default:
					run = false;
					break;
			}
		}
	}
	public void pauseForEnter(java.util.Scanner s) {
		System.out.println("Press Enter To Retern to Main Menu...");
		s.nextLine();
		s.nextLine();
	}
	public static int getInt(java.util.Scanner console) {
		while(!console.hasNextInt()) {
			console.next();
			System.err.print("\nEnter a intiger: ");
		}
		return console.nextInt();
	}
}

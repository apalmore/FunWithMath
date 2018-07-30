package com.austinpalmore.fun_with_math;
import com.austinpalmore.fun_with_math.util.*;
import com.austinpalmore.fun_with_math.numbers.*;
import com.austinpalmore.fun_with_math.algorithms.*;
import com.austinpalmore.fun_with_math.cryptograpy.*;
import com.austinpalmore.fun_with_math.probability.*;

public class Main {
	final static public com.austinpalmore.fun_with_math.util.Display display = new com.austinpalmore.fun_with_math.util.Display();
	final static public java.util.Scanner console = new java.util.Scanner(System.in);
	private static String items[] = { "Exit","Numbers", "Algorithms", "Cryptograpy" ,"Probability" };
	private static String messages[] = {"Welcome To Fun With Math By Austin Palmore","Please Select A Item from the menu below"};
	public static void main(String args[]) {
		boolean run = true;
		int input = -1;
		while(run) {
			while(input < 0 || input > items.length) {
				new Menu(items,messages);
				input = getInt();
			}
			switch (input) {
				case 0:
					System.out.println("Exiting!");
					run = false;
					break;
				case 1:
					new Numbers();
					input = -1;
					break;
				case 2:
				       	new Algorithms();
					input = -1;
					break;
				case 3:
					new Cryptograpy();
					input = -1;
					break;
				case 4:
					new Probability();
					input = -1;
					break;
				default:
					run = false;
					break;
			}
		}
		System.exit(0);
	}
	public static void pauseForEnter() {
		System.out.println("Press Enter To Return to Main Menu...");
		console.nextLine();
		console.nextLine();
	}
	public static int getInt() {
		while(!console.hasNextInt()) {
			console.next();
			System.err.print("\nEnter a interger: ");
		}
		return console.nextInt();
	}
}

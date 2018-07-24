package com.austinpalmore.fun_with_math.algorithms;
import com.austinpalmore.fun_with_math.*;
public class Algorithms {
	private static String items[] = { "Exit","Euclid's Algorithum", "Bubble Sort", "Simple Search", "Binary Search", "Merge Sort Top Down" };
	private static String messages[] = {"Welcome To Fun With Algorithms","Please Select A Item from the menu below"};

	public Algorithms() {
		boolean run = true;
		int input = -1;
		while(run) {
			while(input < 0 || input > items.length) {
				new com.austinpalmore.fun_with_math.util.Menu(items,messages);
				input = Main.getInt();
			}
			switch (input) {
				case 0:
					System.out.println("Exiting!");
					run = false;
					break;
				case 1:
					EuclidsAlgorithm.driver();
					input = -1;
					Main.pauseForEnter();
					break;
				case 2:
					BoubbleSort.init();
					input = -1;
					Main.pauseForEnter();
					break;
				case 3:
					Search.lenearSearch();
					input = -1;
					Main.pauseForEnter();
					break;
				case 4:
					Search.binarySearch();
					input = -1;
					Main.pauseForEnter();
					break;
				case 5:
					MergeSort.init();
					input = -1;
					Main.pauseForEnter();;
				default:
					run = false;
					break;
			}
		}
	}
}

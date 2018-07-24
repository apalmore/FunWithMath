package com.austinpalmore.fun_with_math.numbers;
import com.austinpalmore.fun_with_math.*;
public class Numbers {
	private static String items[] = { "Exit","Fun With Primes", "Fibinachi Numbers","GPS", "Factor to primes" };
	private static String messages[] = {"Welcome To Fun With Numbers","Pleze Select A Item from the menu below"};
	public Numbers() {
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
					Primes.driver();
					input = -1;
					Main.pauseForEnter();
					break;
				case 2:
				       	Fibinacci.driver(91);
					input = -1;
					Main.pauseForEnter();
					break;
				case 3:
					LatLon.init();
					input = -1;
					Main.pauseForEnter();
				case 4:
					Factor.init();
					input = -1;
					Main.pauseForEnter();
				default:
					run = false;
					break;
			}
		}
	}
}

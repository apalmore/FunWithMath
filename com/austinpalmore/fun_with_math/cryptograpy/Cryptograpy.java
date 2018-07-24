package com.austinpalmore.fun_with_math.cryptograpy;
import com.austinpalmore.fun_with_math.*;
public class Cryptograpy {
	private static String items[] = { "Exit","ROT13",/*"Prime Generator"*/ };
	private static String messages[] = {"Welcome To Fun With Cryptograpy","Pleze Select A Item from the menu below"};
	public Cryptograpy() {
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
					Rot13.driver();
					input = -1;
					Main.pauseForEnter();
					break;
				/*case 2:
					Primegenerator pg = new Primegenerator(1,100);
					input = -1;
					Main.pauseForEnter();
					break;
				*/
				default:
					run = false;
					break;
			}
		}
	}
}

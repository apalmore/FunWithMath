package com.austinpalmore.fun_with_math.probability;
import com.austinpalmore.fun_with_math.*;
import com.austinpalmore.fun_with_math.util.*;

public class Probability {
	private static String items[] = { "Exit","Lottery Game (eazy Mode)","Lottery Game (realistic)" };
	private static String messages[] = {"Welcome To Fun With Probability","Pleze Select A Item from the menu"};
	public Probability() {
		boolean run = true;
		int input = -1;
		while(run) {
			while(input < 0 || input > 2) {
				new Menu(items,messages);
				input = Main.getInt();
			}
			switch (input) {
				case 0:
					System.out.println("Exiting!");
					run = false;
					break;
				case 1:
					new Lottery(true);//starting Lottery in Training mode
					input = -1;
					Main.pauseForEnter();
					break;
                                case 2:
                                        new Lottery(false);//starting Lottery in Real world odds mode
                                        input = -1;
                                        Main.pauseForEnter();
                                        break;
				default:
					run = false;
					break;
			}
		}
	}
}

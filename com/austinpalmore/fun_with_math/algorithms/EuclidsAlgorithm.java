package com.austinpalmore.fun_with_math.algorithms;
import com.austinpalmore.fun_with_math.*;
import com.austinpalmore.fun_with_math.util.OutputManager;

public class EuclidsAlgorithm {
	public static void driver() {
		OutputManager out = new OutputManager();
		out.println("Enter a number: ");
		int x = Main.getInt();
		out.noConsole("" + x + "\n");
		out.println("Enter a smaller number: ");
		int y = Main.getInt();
		out.noConsole("" + y + "\n");
		gcd(x,y,out);
		out.dispWindow("Euclids Algorithm");
	}

	private static void gcd(int x,int y, OutputManager out) {
		int a = x, b = y;
		out.print(String.format("A = %d%nB = %d%n",a,b));
		int t;
		while(b != 0) {
			t = b;
			out.println("T = B = " + t);
			b = a % b;
			out.println("B = A MOD B = " + a + " MOD " + t + " = " + b);
			a = t;
			out.println("A = T = " + t);
		}
		out.println("T = 0 Stoping");
		out.println("The GCD of " + x + " and " + y + " is " + a);
	}
}

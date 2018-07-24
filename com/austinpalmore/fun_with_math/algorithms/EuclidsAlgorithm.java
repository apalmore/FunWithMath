package com.austinpalmore.fun_with_math.algorithms;
import com.austinpalmore.fun_with_math.*;
public class EuclidsAlgorithm {
	public static void driver() {
		System.out.println("Enter a number: ");
		int x = Main.getInt();
		System.out.println("Enter a smaller number: ");
		int y = Main.getInt();
		gcd(x,y);
	}

	private static void gcd(int x,int y) {
		int a = x, b = y;
		System.out.printf("A = %d%nB = %d%n",a,b);
		int t;
		while(b != 0) {
			t = b;
			System.out.println("T = B = " + t);
			b = a % b;
			System.out.println("B = A MOD B = " + a + " MOD " + t + " = " + b);
			a = t;
			System.out.println("A = T = " + t);
		}
		System.out.println("T = 0 Stoping");
		System.out.println("The GCD of " + x + " and " + y + " is " + a);
	}
}

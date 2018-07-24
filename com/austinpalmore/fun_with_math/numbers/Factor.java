package com.austinpalmore.fun_with_math.numbers;
public class Factor {
	public static void init() {
		int number = 0;
		java.util.Scanner console = new java.util.Scanner(System.in);
		number = getInt(console);
		System.out.println(factorToString(number));
	}
	public static String factorToString(int number) {
		java.lang.StringBuilder r = new java.lang.StringBuilder();
		int exp = 0;
		int t = number;
		for(int k = 2;k <= (int)(Math.sqrt(number)) + 1;k++) {
			exp = 0;
			while (t % k == 0) {
				t /= k;
				exp++;
			}
			if(exp == 1) {
				if(t <= 1) {
					r.append(k);
				} else {
					r.append(k + " * ");
				}
			} else if (exp > 1) {
				if(t <= 1) {
					r.append(k + "^" + exp);
				} else {
					r.append(k + "^" + exp + " * ");
				}
			}
		}
		if(t == number) r.append(t + " Is a Prime Number");
		else if(t > 1) r.append(t);
		return r.toString();
	}
	public static int getInt(java.util.Scanner console) {
		System.out.print("Enter a intiger: ");
		while(!console.hasNextInt()) {
		       	console.next();
			System.out.print("Plese Try Again: ");
		}
		return console.nextInt();
	}
}

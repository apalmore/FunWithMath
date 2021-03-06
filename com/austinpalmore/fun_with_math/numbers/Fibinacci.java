package com.austinpalmore.fun_with_math.numbers;
import com.austinpalmore.fun_with_math.util.*;

public class Fibinacci {
	static long[] fibinacci_cache = new long[1000];
	public static long fibinacci(int n) {
		if (fibinacci_cache[n] != 0) return fibinacci_cache[n];
		if (n == 1) return 1;
		if (n == 2) return 2;
		long value = fibinacci(n-1) + fibinacci(n-2);
		fibinacci_cache[n] = value;
		return value;
	}
	public static void driver(int n) {
		OutputManager out = new OutputManager();
		if(n < 2 || n > 91) {
			throw new IllegalArgumentException("Value Passed To fibinacci outside of range [2,91] or no value passed");
		}
		for(int i = 1; i <= n; i++)
			out.print(String.format("fibinacci(%2d) = %-20d\n",i, fibinacci(i)));
		out.print(String.format("Phi is aproxamntly %1.12f\n",(double)fibinacci(n)/fibinacci(n-1)));
		out.dispWindow("Fibinacci");
	}
}

package com.austinpalmore.fun_with_math.numbers;
final public class Prime {
	protected static long numberOfPrimes = 0;
	protected static synchronized void counter() { numberOfPrimes++; }
	protected final int VALUE;
	protected final boolean IS_PRIME;
	protected final boolean HAS_COMPLEX_CONJUGATE;
	protected final double SQUARE_ROOT;
	protected final int LEAST_COMMON_MULTIPLE;
	protected final int[] COMPLEX_CONJUGATE = new int[2];
	protected final String COMPLEX_CONJUGATE_STRING;
	Prime (int value) {
		VALUE = value;
		SQUARE_ROOT = Math.sqrt(VALUE);
		IS_PRIME = isPrime(VALUE,SQUARE_ROOT);
		LEAST_COMMON_MULTIPLE = (int)Math.floor(SQUARE_ROOT);
		COMPLEX_CONJUGATE[0] = LEAST_COMMON_MULTIPLE;
		COMPLEX_CONJUGATE[1] = getComplexConjugate(VALUE,LEAST_COMMON_MULTIPLE);
		HAS_COMPLEX_CONJUGATE = (COMPLEX_CONJUGATE[1] != -1);
		COMPLEX_CONJUGATE_STRING = ComplexConjugateToString(COMPLEX_CONJUGATE);
		counter();
	}
	private boolean isPrime(int n,double sr) {
		if(n == 2 || n == 5) return true;
		if(n < 3 || n % 2 == 0 || n % 5 == 0) return false;
		int range = (int)(sr + 1);
		for (int i = 2;i <= range;i++)
			if (n % i == 0) return false;
		return true;
	}
	private int getComplexConjugate(int value,int lcm) {
		double test = Math.sqrt(value - lcm * lcm);
		if (test % 1 < 0.00000000001) return (int)test;
		else return -1;
	}
	private String ComplexConjugateToString(int... n) {
		if(n.length != 2) throw new java.lang.IllegalArgumentException();
		String s = "(" + n[0] + "+" + n[1] + "i)(" + n[0] + "-" + n[1] + "i)";
		return s;
	}
}

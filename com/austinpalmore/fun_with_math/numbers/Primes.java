package com.austinpalmore.fun_with_math.numbers;
import com.austinpalmore.fun_with_math.util.*;

final public class Primes {
	private int lcs = 1;
	private String primes = "";
	private String complex = "";
	public String getPrimes() { return this.primes; }
	public String getComplex() { return this.complex; }
	private void setlcs(int i) { lcs = i; }
	private void findPrimes(int start,int end) throws java.lang.IllegalArgumentException {
		if(start < 0 || end < start) throw new java.lang.IllegalArgumentException();
		if(Primes.logical.isPrime(start)) {
		   	this.primes += "," + start;
			if(Primes.logical.isPerfictSquare(start-1)) {
				int f = (int)Math.sqrt(start-1);
				this.lcs = f;
				this.complex += start + ";(" + f + "+i)(" + f + "-i)";
			} else {
				int t = start - this.lcs;
				int f = (int)Math.sqrt(this.lcs);
				if(Primes.logical.isPerfictSquare(t)) {
					t = (int)Math.sqrt(t);
					this.complex += start + ";(" + f + "+" + t + "i)(" + f + "-" + t + "i)";
				}
			}
		}
		for (int i = start + 1;i < end;i++) {
			if(Primes.logical.isPrime(i)) {
		       		this.primes += "," + i;
				if(Primes.logical.isPerfictSquare(i-1)) {
					int f = (int)Math.sqrt(i-1);
					this.lcs = f;
					this.complex += "," + i + ";(" + f + "+i)(" + f + "-i)";
				} else {
					int t = i - this.lcs;
					int f = (int)Math.sqrt(this.lcs);
					if(Primes.logical.isPerfictSquare(t)) {
						t = (int)Math.sqrt(t);
						this.complex += "," + i + ";(" + f + "+" + t + "i)(" + f + "-" + t + "i)";
					}
				}
			}
		}
	}
	static class logical {
		public static boolean isPrime(int n) {
			if(n == 2 || n == 5) return true;
			if(n < 3 || n % 2 == 0 || n % 5 == 0) return false;
			int range = (int)(Math.sqrt(n) + 1);
			for (int i = 2;i <= range;i++)
				if (n % i == 0) return false;
			return true;
		}
		public static boolean isPerfictSquare(int n) {
			return (Math.sqrt(n) % 1 < 0.00000000001);
		}
		public static int getPrimeCountEstimation(int n) {
			return (int)(Math.round(Math.pow(Math.log(n),-1.0) * n));
		}
	}
	static class run {
		public static Thread primeThread(Primes p,int primesPerThread,int i) {
			return new Thread(new Runnable() {
				@Override
				public void run() {
					p.findPrimes(i * primesPerThread + 1, (1 + i) * primesPerThread);
				}
			});
		}
		public static Thread primeThread(Primes p,int primesPerThread) {
			return new Thread(new Runnable() {
				@Override
				public void run() {
					p.findPrimes(3,primesPerThread);
				}
			});
		}
	}
	public static String printPrimes(Primes... p) {
		java.lang.StringBuilder sb = new java.lang.StringBuilder();
		sb.append("2");
		for (int i = 0;i < p.length;i++)
			sb.append(p[i].getPrimes());
		sb.append("\n");
		return sb.toString();
	}
	public static String printComplex(Primes... p) {
		java.lang.StringBuilder sb = new java.lang.StringBuilder();
		sb.append("2;(1+i)(1-i)");
		for (int i = 0;i < p.length;i++)
			sb.append(p[i].getComplex());
		sb.append("\n");
		return sb.toString();
	}
	public static void driver() {
		final int threadCount = Runtime.getRuntime().availableProcessors();
		String message = "Enter the max range for the prime function that is a multiple of " + threadCount + " and greater than " + threadCount * 2 + ": ";
		int max = Display.getIntFromUser(message,new Tester() {
			@Override
			public boolean test(int n) {
				return n % Runtime.getRuntime().availableProcessors() != 0 || n <= (Runtime.getRuntime().availableProcessors() * 2);
			}
		});
		final int primesPerThread = max / threadCount;
		Display.DisplayMessage("I predict that there will be " + Primes.logical.getPrimeCountEstimation(primesPerThread * threadCount) + " Primes to " + primesPerThread * threadCount);

		Primes[] p = new Primes[threadCount];
		for (int i = 0;i < threadCount;i++) p[i] = new Primes();
		Thread t[] = new Thread[threadCount];
		t[0] = Primes.run.primeThread(p[0],primesPerThread);
		for (int i = 1;i < threadCount;i++)
			t[i] = Primes.run.primeThread(p[i],primesPerThread,i);
		for (int i = 0;i<threadCount;i++)
			t[i].start();
		try {
			for (int i = 0;i < threadCount;i++)
				t[i].join();
		} catch (InterruptedException e) {
			System.err.println(e);
		}
		OutputManager out1 = new OutputManager();
		OutputManager out2 = new OutputManager();
		out1.println(Primes.printComplex(p));
		out2.println(Primes.printPrimes(p));
		out1.save("Complex.txt");
		out1.dispWindow("Complex");
		out2.dispWindow("Primes");
		out2.save("Primes.txt");
	}
}

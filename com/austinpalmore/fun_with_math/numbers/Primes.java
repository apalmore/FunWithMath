package com.austinpalmore.fun_with_math.numbers;
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
	public static String printPrimes(java.io.PrintStream ps,Primes... p) {
		java.lang.StringBuilder sb = new java.lang.StringBuilder();
		ps.print("2");
		sb.append("2");
		for (int i = 0;i < p.length;i++) {
			ps.print(p[i].getPrimes());
			sb.append(p[i].getPrimes());
		}
		ps.println();
		sb.append("\n");
		return sb.toString();
	}
	public static String printComplex(java.io.PrintStream ps,Primes... p) {
		java.lang.StringBuilder sb = new java.lang.StringBuilder();
		ps.print("2;(1+i)(1-i)");
		sb.append("2;(1+i)(1-i)");
		for (int i = 0;i < p.length;i++) {
			ps.print(p[i].getComplex());
			sb.append(p[i].getComplex());
		}
		ps.println();
		sb.append("\n");
		return sb.toString();
	}
	public static void driver() {
		final int threadCount = Runtime.getRuntime().availableProcessors();
		String message = "Enter the max range for the prime function that is a multiple of " + threadCount + " and greater than " + threadCount * 2 + ": ";
		int max = com.austinpalmore.fun_with_math.util.Display.getIntFromUser(message,new com.austinpalmore.fun_with_math.util.Tester() {
			@Override
			public boolean test(int n) {
				return n % Runtime.getRuntime().availableProcessors() != 0 || n <= (Runtime.getRuntime().availableProcessors() * 2);
			}
		});
		final int primesPerThread = max / threadCount;
		com.austinpalmore.fun_with_math.util.Display.DisplayMessage("I predict that there will be " + Primes.logical.getPrimeCountEstimation(primesPerThread * threadCount) + " Primes to " + primesPerThread * threadCount);

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
		Primes.printComplex(System.out,p);
		Primes.printPrimes(System.out,p);
		//display.DisplayTextBox("Complex",Primes.printComplex(System.out,p));
		//display.DisplayTextBox("Primes",Primes.printPrimes(System.out,p));
	
		try (
			java.io.PrintStream ps1 = new java.io.PrintStream(new java.io.File("primes.txt")); 
			java.io.PrintStream ps2 = new java.io.PrintStream(new java.io.File("complex.txt"));
		) {
			Primes.printPrimes(ps1,p);
			Primes.printComplex(ps2,p);
		} catch (java.io.FileNotFoundException e) {
			System.err.println(e);
		}
	}
}

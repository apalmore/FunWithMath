package com.austinpalmore.fun_with_math.cryptograpy;
import com.austinpalmore.fun_with_math.numbers.*;
import java.util.*;
public class Primegenerator {
	private Random rand = new Random();
	private int p1 0,p2 = 0, q = 0;
	Primegenerator(int min, int max) {
		this.p1 = nextPrime(min,max);
		this.p2 = nextPrime(min,max);
		this.q = p1 * p2;
	}
	public int getProduct() { return this.q; }
	public int getP1() { return this.p1; }
	public int getP2() { return this.p2; }
	private int nextPrime(int min, int max) {
		int x = rand.nextInt(max) + min;
		while(!Prime.isPrime(x,Math.sqrt(x))) x = rand.nextInt(max) + min;
		return x;	
	}
}

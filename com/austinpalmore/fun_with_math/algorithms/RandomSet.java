package com.austinpalmore.fun_with_math.algorithms;
public class RandomSet {
	protected static int[] getSet(int size) {
		final int[] rand_set = new int[size];
		final boolean[] rand_set_used = new boolean[size];
		for (int i = 0;i < size;i++) {
			rand_set[i] = nextRand(rand_set_used);
			rand_set_used[rand_set[i]] = true;
		}
		return rand_set;
	}
	protected static int[] getRangedSet(int size, int max) {
		int[] rand_set = new int[size];
		int r = 0;
		for (int i = 0;i < size;i++) {
			do {
				r = (int)(Math.random() * max + 1);
			} while (isInArray(rand_set,r));
			rand_set[i] = r;
		}
		return rand_set;
	}
	private static boolean isInArray(int arr[],int n) {
		for (int i : arr)
			if(i == n) return true;
		return false;
	}
	private static int nextRand(boolean[] rand_set_used) {
		int canidate = (int)(Math.random() * rand_set_used.length);
		while (rand_set_used[canidate])
			canidate = (int)(Math.random() * rand_set_used.length);
		return canidate;
	}
}

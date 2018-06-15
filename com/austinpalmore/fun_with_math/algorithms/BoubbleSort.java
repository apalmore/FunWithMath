package com.austinpalmore.fun_with_math.algorithms;
public class BoubbleSort {
	private static final int ARRAY_SIZE = 20;
	private static int swap_count = 0;
	private static int comps = 0;
	public static void init() {
		int[] set = RandomSet.getRangedSet(ARRAY_SIZE,(ARRAY_SIZE * 5));
		System.out.println("Creating Random set of 20 values non repeting [0,100]");
		System.out.println(java.util.Arrays.toString(set));
		int count = 0;
		System.out.println("Sorting Set...");
		while(boubblesort(set)) {
			System.out.println(java.util.Arrays.toString(set));
		}
		System.out.println("The array is now sorted it took " + count + " passes, " + comps + " comparisins, and " + swap_count + " swaps");
	}
	protected static boolean boubblesort(int[] arr) {
		boolean swap = false;
		for (int i = 0;i < arr.length - 1;i++) {
			comps++;
			if(arr[i] > arr[i+1]) {
				swap = true;
				swap_count++;
				int tmp = arr[i+1];
				arr[i+1] = arr[i];
				arr[i] = tmp;
			}
		}
		return swap;
	}
}

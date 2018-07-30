package com.austinpalmore.fun_with_math.algorithms;
import com.austinpalmore.fun_with_math.util.*;

public class BoubbleSort {
	private static final int ARRAY_SIZE = 30;
	private static int swap_count = 0;
	private static int comps = 0;
	public static void init() {
		OutputManager out = new OutputManager();
		int[] set = RandomSet.getRangedSet(ARRAY_SIZE,100);
		out.println("Creating Random set of " + ARRAY_SIZE + " values non repeating [0,100]");
		out.println(java.util.Arrays.toString(set));
		int count = 0;
		out.println("Sorting Set...");
		while(boubblesort(set)) {
			out.println(java.util.Arrays.toString(set));
		}
		out.println("The array is now sorted it took " + comps + " comparisons, and " + swap_count + " swaps");
		out.dispWindow("Boubble Sort");
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

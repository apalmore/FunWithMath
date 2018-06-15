package com.austinpalmore.fun_with_math.algorithms;
public class MergeSort {
	private static final int ARRAY_SIZE = 30;
	private static int swap_count = 0;
	public static int comps = 0;
	public static void init() {
		int[] set = RandomSet.getRangedSet(ARRAY_SIZE,100);
		int[] temp = java.util.Arrays.copyOf(set,set.length);
		System.out.println("Creating Random set of " + ARRAY_SIZE + " values non repeating [0,100]");
		System.out.println(java.util.Arrays.toString(set));
		System.out.println("Sorting Set...");
		TopDownSplitMerge(temp,0,set.length,set);
		System.out.println(java.util.Arrays.toString(set));
	}
	protected static void TopDownSplitMerge(int[] b,int start,int end,int[] a) {
		if(end - start < 2) return;
		int middle = (end + start) / 2;
		TopDownSplitMerge(a,start,middle,b);
		TopDownSplitMerge(a,middle,end,b);

		TopDownMerge(b,start,middle,end,a);
	}
	protected static void TopDownMerge(int[] a,int start,int middle,int end,int[] b) {
		System.out.println(java.util.Arrays.toString(a));
		int i = start;
		int j = middle;
		for (int k = start; k < end;k++) {
			if (i < middle && (j >= end || a[i] <= a[j])) {
				b[k] = a[i];
				i++;
			} else {
				b[k] = a[j];
				j++;
			}
		}
	}
}

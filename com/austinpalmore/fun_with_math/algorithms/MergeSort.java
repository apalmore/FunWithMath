package com.austinpalmore.fun_with_math.algorithms;
import com.austinpalmore.fun_with_math.util.*;

public class MergeSort {
	private static final int ARRAY_SIZE = 30;
	private static int swap_count = 0;
	public static int comps = 0;
	public static void init() {
		OutputManager out = new OutputManager();
		int[] set = RandomSet.getRangedSet(ARRAY_SIZE,100);
		int[] temp = java.util.Arrays.copyOf(set,set.length);
		out.println("Creating Random set of " + ARRAY_SIZE + " values non repeating [0,100]");
		out.println(java.util.Arrays.toString(set));
		out.println("Sorting Set...");
		TopDownSplitMerge(temp,0,set.length,set,out);
		out.println(java.util.Arrays.toString(set));
		out.dispWindow("Merge Sort Top Down");
	}
	protected static void TopDownSplitMerge(int[] b,int start,int end,int[] a,OutputManager out) {
		if(end - start < 2) return;
		int middle = (end + start) / 2;
		TopDownSplitMerge(a,start,middle,b,out);
		TopDownSplitMerge(a,middle,end,b,out);

		TopDownMerge(b,start,middle,end,a,out);
	}
	protected static void TopDownMerge(int[] a,int start,int middle,int end,int[] b,OutputManager out) {
		out.println(java.util.Arrays.toString(a));
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

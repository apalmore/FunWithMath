package com.austinpalmore.fun_with_math.algorithms;
public class MergeSort extends Sort {
	MergeSort(int n) {
		super(n);
	}
	protected boolean sortAlgorithm(int[] arr,int[] changed) {
		// This is a Boubble Sort implementation Merge Sort Is under Development
		boolean swap = false;
		changed[0] = -1;
		for (int i = 0;i < arr.length - 1;i++) {
			if(arr[i] > arr[i+1]) {
				swap = true;
				changed[0] = i;
				int tmp = arr[i+1];
				arr[i+1] = arr[i];
				arr[i] = tmp;
			}
		}
		return swap;
	}
}

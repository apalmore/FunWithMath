package com.austinpalmore.fun_with_math.algorithms;
public class Search {
	public final static int ARRAY_SIZE = 20;
	
	protected static void binarySearch() {
		int[] set = RandomSet.getRangedSet(ARRAY_SIZE,(ARRAY_SIZE * 5));
		System.out.println("Creating Random set of 20 values non-repeating [0,100]");
		System.out.println(java.util.Arrays.toString(set));
		System.out.println("Sorting Set...");
		boubbleSort(set);
		System.out.println(java.util.Arrays.toString(set));
		System.out.print("Enter a number in the array: ");
		int query = com.austinpalmore.fun_with_math.MainMenu.getInt(new java.util.Scanner(System.in));
		System.out.println("Searching for " + query);
		int index = binary(set,0,set.length,query);
		if (index > 0) System.out.println(query + " Was found at index " + index);
		else System.out.println(query + " is not contained in theis array");
	}
	protected static int binary(int arr[],int left,int right,int query) {
		int mid = (right + left) / 2;
		if(mid == left || mid == right) return -1;
		System.out.println("Searching index " + mid + " [" + arr[mid] + "]");
		if(arr[mid] == query) return mid;
		else if (arr[mid] > query) return binary(arr,left,mid,query);
		else return binary(arr,mid,right,query);
	}
	protected static void lenearSearch() {
		int[] set = RandomSet.getRangedSet(ARRAY_SIZE,(ARRAY_SIZE * 5));
		System.out.println("Creating Random set of 20 values non-repeating [0,100]");
		System.out.println(java.util.Arrays.toString(set));
		System.out.println("Sorting Set...");
		boubbleSort(set);
		System.out.println(java.util.Arrays.toString(set));
		System.out.print("Enter a number in the array: ");
		int query = com.austinpalmore.fun_with_math.MainMenu.getInt(new java.util.Scanner(System.in));
		System.out.println("Searching for " + query);
		int index = -1;
		for(int i = 0;i < set.length && index < 0;i++) {
			System.out.println("Searching index " + i);
			if(set[i] == query) index = i;
		}
		if (index > 0) System.out.println(query + " Was found at index " + index);
		else System.out.println(query + " is not contained in these array");
	}
	private static void boubbleSort(int[] arr) {
		boolean swap = false;
		do {
			swap = false;
			for (int i = 0;i < arr.length - 1;i++) {
				if(arr[i] > arr[i+1]) {
					swap = true;
					int tmp = arr[i+1];
					arr[i+1] = arr[i];
					arr[i] = tmp;
				}
			}
		} while (swap);
	}	
}

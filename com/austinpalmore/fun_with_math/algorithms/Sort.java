package com.austinpalmore.fun_with_math.algorithms;
public class Sort {
	int[] arr;
	int[] changed = new int[1];
	java.lang.StringBuilder stringbuilder = new java.lang.StringBuilder();
	Sort(int n) {
		arr = RandomSet.getSet(n);
	}
	protected final void driver(int n) {
		printTable(arr,"Unsorted array of random lengths",changed,stringbuilder);
		int round = 1;
		while(sortAlgorithm(arr,changed)) {
			printTable(arr,"Round " + round,changed,stringbuilder);
			round++;
		}
		System.out.println(stringbuilder.toString());
	}
	protected final void printTable(int[] arr,String message,int[] changed,java.lang.StringBuilder sb) {
		sb.append(message + "\n");
		for(int i = 0;i < arr.length + 4;i++)
			sb.append("-");
		sb.append("\n");
		for(int i = 0;i < arr.length;i++) {
			sb.append("[ ");
			for(int j = 0;j < arr[i];j++)
				sb.append("#");
			for(int j = arr[i];j < arr.length;j++)
				sb.append(" ");
			sb.append(" ]");
			if(changed[0] == i-1) sb.append(" <---");
			if(changed[0] == i) sb.append(" <---");
		        sb.append("\n");	
		}
		for(int j = 0;j < arr.length + 4;j++)
			sb.append("-");
		sb.append("\n");
	}
	protected boolean sortAlgorithm(int[] arr,int[] changed) {
		System.err.println("You Did not override the sortAlgorithm method");
		System.exit(1);	
		return false;
	}
}

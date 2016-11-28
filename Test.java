package test;

import java.util.Scanner;

public class Test {
	public static void findCost(int len) {
		Scanner sc = new Scanner(System.in);
		int[] array = new int[len];

		for (int i = 0; i < len; i++) {
			System.out.println("Enter the length of rope " + (i + 1) + " :");
			array[i] = sc.nextInt();
		}
		lenCalculation(array.length, array);
		minCost(array.length, array);
		genCost(array.length, array);
	}

	public static void genCost(int len, int[] array) {
		int j = array.length - 1;
		int k = 0;
		int genSum = 0;
		
		System.out.println("Normal Join ");
		for (int i = 0; i < array.length; i++) {
			if (k != j) {
				System.out.println("Joining rope of length " + array[k+1] + " with rope of length " + array[i]);
				genSum = genSum + array[i] + array[k + 1];
				k++;
			}
		}
		System.out.println("Normal Cost : " + genSum);
		System.out.println();
	}
	public static void lenCalculation(int len, int[] array)
	{
		int ropelen = 0;
		for(int i = 0 ;i < array.length; i++)
		{
			ropelen = ropelen + array[i];
		}
		System.out.println("New length of the rope :" + ropelen);
		System.out.println();
	}

	public static void minCost(int len, int[] array) {
		int sum = 0;
		int j = array.length - 1;
		int n = array.length, swap;
		for (int i = 0; i < (n - 1); i++) {
			for (int d = 0; d < n - i - 1; d++) {
				if (array[d] < array[d + 1]) {
					swap = array[d];
					array[d] = array[d + 1];
					array[d + 1] = swap;
				}
			}
		}
		/*
		 * for (int i = 0; i < array.length; i++) { System.out.print(array[i] +
		 * ","); } System.out.println();
		 */

		if (array.length % 2 != 0) {
			for (int i = 0; i < array.length; i++) {
				
				if (j > i ) {
					System.out.println("Joining rope of length " + array[i] + " with rope of length " + array[j]);
					System.out.println("Joining rope of length " + array[j] + " with rope of length " + array[i + 1]);
					sum = sum + 2 * array[j] + array[i] + array[i + 1];
					j--;
					
				}
			}
		} else {
			int i = 0;
			for (int it = 0; it < array.length; it++) {
				if(j>i && it!= array.length - 1)
				{
					System.out.println("Joining rope of length " + array[i] + " with rope of length " + array[j]);
					System.out.println("Joining rope of length " + array[j] + " with rope of length " + array[i+1]);
					sum = sum + 2*array[j] + array[i] + array[i + 1];
					i= i+ 2;
					j--;
					
				} 
				if(it == array.length - 1){
					System.out.println("Joining rope of length " + array[i -1] + " with rope of length " + array[j]);
					sum = sum + array[j] + array[i - 1]; 
					j--;
				}
			}
		}
		System.out.println("Minimum cost is :" + sum);
		System.out.println();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter total number of ropes :");
		int num = sc.nextInt();
		findCost(num);
	}

}


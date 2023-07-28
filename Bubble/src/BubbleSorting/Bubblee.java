package BubbleSorting;

import java.util.Arrays;

public class Bubblee {
	
		public static void bubbleSort(int []arr) {
			for(int i=0; i<arr.length; i++) {
				for(int j=0; j<arr.length-1; j++) {
					if(arr[i] < arr[j]) {
						int temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
					}
				}
			}
		}
		public static void main(String[] args) {
			int arr[] = {7,9,4,5,1,3};
			bubbleSort(arr);
			System.out.println(Arrays.toString(arr));
		}
}

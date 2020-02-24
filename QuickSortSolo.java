package ssafyalgo_0214;

import java.util.Arrays;

public class QuickSortSolo {
	static int[] arr;
	
	public static void swap(int i, int j) {
		int number = arr[i];
		arr[i] = arr[j];
		arr[j] = number;
	}
	
	public static void main(String[] args) {
		arr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
		int length = arr.length;
		System.out.println("정렬전:"+Arrays.toString(arr));
		quickSort(0, length-1);
		System.out.println("정렬:"+Arrays.toString(arr));
	}

	private static void quickSort(int low, int high) {
		int i = low;
		int j = high;
		int pivot = arr[(i+j)/2];
		while(i<=j) {
			while(arr[i] < pivot)i++;
			while(arr[j] > pivot)j--;
			if(i <= j) {
				swap(i, j);
				i++;
				j--;
			}
		}
		if(low < j) {//정렬이 덜 됐다면.
			quickSort(low, j);
		}
		if(i < high) {
			quickSort(i, high);
		}
	}

}

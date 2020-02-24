import java.util.Arrays;

public class QuickSort {
	
	static int arr[] = {3,4,7,5,3,1,2,3,6};
	static int len;
	public static void Quick(int low, int high) {
		int i = low;
		int j = high;
		int pivot = arr[((i+j)/2)];
		while(i <= j) {
			while(arr[i] < pivot)i++;
			while(arr[j] > pivot)j--;
			if(i<=j) {
				swap(i, j);
				i++;
				j--;
			}
		}
		if(i<high) {
			Quick(i, high);
		}
		if(j >low) {
			Quick(low, j);
		}
	}
	public static void swap(int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	public static void main(String[] args) {
		len = arr.length;
		Quick(0, len-1);
		System.out.println(Arrays.toString(arr));
	}
}

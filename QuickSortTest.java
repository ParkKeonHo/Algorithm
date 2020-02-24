package ssafyalgo_0214;

public class QuickSortTest {

	
	static int[] numbers;
	public static void main(String[] args) {
		numbers=new int[]{5,3,2,6,9,1,7,8,4};
		int arraylength=numbers.length;
		 quicksort(0, arraylength - 1);
		 for (int i = 0; i < arraylength; i++) {
			System.out.print(numbers[i]+" ");
		}
		 System.out.println();
	}
	

    public  static void quicksort(int low, int high) {
        int i = low, j = high;
        int pivot = numbers[(low + high) / 2];
        // Divide into two lists
        //왼쪽 i가 증가 오른쪽에서 감소 =>  i<=j일 때 
        while (i <= j) {
            while (numbers[i] < pivot)   i++;
            while (numbers[j] > pivot)  j--;
            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }

    private static  void swap(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
	

}

package ssafyalgo_0214;

import java.util.Arrays;

public class Another_Combi {
	static int[] arr = {1,2,3,4};
	static int N = arr.length;
	static int[] result = new int[3];
	static boolean[] used = new boolean[N];
	
	public static void combi(int idx, int count, int r) {
		if(count == r) {
			int j = 0;
			for (int i = 0; i < N; i++) {
				if(used[i]) {
					result[j++] = arr[i];
				}
			}
			System.out.println(Arrays.toString(result));
			return;
		}
		else if(idx == N) {
			return;
		}
		
		used[idx] = true;
		combi(idx+1, count+1, r);
		used[idx] = false;
		combi(idx+1, count, r);
	}
	
	
	
	public static void main(String[] args) {
		combi(0, 0, 3);
	}
}

package ssafyalgo_0214;

public class Test_comb {
	static int[] arr = {1,2,3};
	static boolean[] used = new boolean[arr.length];
	
	public static void main(String[] args) {
		comb(0, 0, 3);
	}
	
	static void comb(int idx, int cnt, int r) {
		if(cnt==r) { 
			for(int i=0; i<arr.length; i++) {
				if(used[i])
					System.out.print(arr[i]+" ");
			}
			System.out.println();
			return;
		}
		
		else if(idx == arr.length) {
			return;
		}
		
		
		
		used[idx] = true;
		comb(idx+1, cnt+1, r);
		used[idx] = false;
		comb(idx+1, cnt, r);
		
	}
	
}

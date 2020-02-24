
public class Combi {
	static int[] nums = {7, 8, 9, 10};
	static int R = 2;
	static int[] result = new int[R];
	public static void main(String[] args) {
//		combi(0,0);/
		perm(0,0);
	}
	public static void combi(int start_index, int digit) {
		if(digit == R) {
			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			result[digit] = nums[i];
			combi(i+1, digit+1);
		}
	}
	public static void perm(int flag, int digit) {
		if(digit == R) {
			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i]+" ");
			}System.out.println();
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if((flag & 1<<i) != 0) {
				continue;
			}else if((flag & 1<<i) == 0) {
				result[digit] = nums[i];
				perm((flag | 1<<i), digit+1);
			}
		}
	}
}

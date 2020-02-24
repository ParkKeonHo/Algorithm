import java.util.Arrays;

public class MorningcombiNperm {
	static int[] arr;
	static int N;
	static int R;
	static boolean[] used;
	static int[] result;
	static int cnt;

	public static void combi(int idx, int count) {
		if (count == R) {
			int j = 0;
			for (int i = 0; i < arr.length; i++) {
				if (used[i]) {
					result[j++] = arr[i];
				}
			}
			System.out.println(Arrays.toString(result));
			cnt++;
			return;
		} else if (idx == arr.length) {
			return;
		}
		used[idx] = true;
		combi(idx + 1, count + 1);
		used[idx] = false;
		combi(idx + 1, count);
	}

	public static void combi2(int idx, int count) {
		if (count == R) {
			System.out.println(Arrays.toString(result));
			cnt++;
			return;
		}
		for (int i = idx; i < arr.length; i++) {
			result[count] = i + 1;
			combi2(i + 1, count + 1);
		}
	}

	public static void perm1(int flag, int count) {
		if (count == R) {
			System.out.println(Arrays.toString(result));
			cnt++;
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if ((flag & 1 << i) != 0) {
				continue;
			}
			if ((flag & 1 << i) == 0) {
				result[count] = arr[i];
				perm1((flag | 1 << i), count + 1);
			}
		}
	}
	public static void perm2(int idx) {
		if(idx == R) {
			System.out.println(Arrays.toString(result));
			cnt++;
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if(!used[i]) {
				used[i] = true;
				result[idx] = arr[i];
				perm2(idx+1);
				used[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		R = 4;
		arr = new int[4];
		used = new boolean[arr.length];
		result = new int[R];
		int n = 0;
		for (int i = 1; i <= 4; i++) {
			arr[n++] = i;
		}

		combi(0, 0);
		System.out.println(cnt);
		System.out.println("------------------------------------------------------");
		cnt = 0;
		combi2(0, 0);
		System.out.println(cnt);
		System.out.println("------------------------------------------------------");
		cnt = 0;
		perm1(0, 0);
		System.out.println(cnt);
		System.out.println("------------------------------------------------------");
		cnt = 0;
		perm2(0);
		System.out.println(cnt);
	}
}

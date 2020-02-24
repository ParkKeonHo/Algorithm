package com.ssafy.edu;

import java.util.Arrays;

public class PermutationTest {
	static int cnt;
	static int N = 5;
	static int R = 3;
	static int[] nums;

	public static void main(String[] args) {
		cnt = 0;
		nums = new int[R];
		perm(0, 0);
		System.out.println(cnt);
	}

	private static void perm(int flag, int count) { // void타입이면 재귀를 많이 할 수 있다.
		if (R == count) {
			cnt++;
			System.out.println(Arrays.toString(nums));
			return;
		}
		for (int i = 0; i < N; i++) {
			// 간 적 있다면
			if ((flag & 1 << i) != 0) {
				continue;
			}
			// 간 적 없다면 |연산이라면 없는 값으로 바꿔주는 것
			if ((flag & 1 << i) == 0) {
				nums[count] = i + 1;
				perm(flag | 1 << i, count + 1);
			}
		}
	}
}

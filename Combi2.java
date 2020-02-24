package com.ssafy.algorithm;


public class Combi2 {
	//그냥 외우자!!
	static int N = 5, cnt;   //5C3을 구해보자
	static int R = 3;
	static int[] nums;
	static int[] cc = {1, -3, 4, -5, 6};
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) {
		cnt = 0;
		nums = new int[R];
		combi(0,0);
		System.out.println(max);
	}
	public static void combi(int start, int count) {
		if(count == R) {//반복횟수가 r이 되는 순간
			int value = 1;
			for (int i = 0; i < R; i++) {
				value *= nums[i];
			}
			if(max < value) {
				max = value;
			}
			return;
		}else {			
			for (int i = start; i < N; i++) {
				nums[count] = cc[i];
				combi(i+1,count+1);
			}
		}
	}

}

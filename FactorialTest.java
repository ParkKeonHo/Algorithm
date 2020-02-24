package com.ssafy.algorithm;


public class FactorialTest {
	public static void main(String[] args) {
		System.out.println(fact(12));//13부터는 범위를 초과하여 이상한 값 출력됨
	}
	public static int fact(int n) {
		if(n == 1) return 1;
		else {
			return n*fact(n-1);
		}
	}
}

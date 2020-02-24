package com.ssafy.algorithm;


public class Fibonacci {
	public static void main(String[] args) {
		System.out.println(fibo(10));
		//fibo의 연장선 : 황금율을 구할 때
		System.out.println(1.0*fibo(20)/fibo(21));
	}
	public static int fibo(int n) {
		if(n == 1)return 1;
		else if(n == 2) return 2;
		else return fibo(n-1)+fibo(n-2);
	}

}

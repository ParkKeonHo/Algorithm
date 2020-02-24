package com.ssafy.edu;

public class GCDTest {
	public static void main(String[] args) {
		System.out.println(gcd(30,50));
	}
	public static int gcd(int a, int b) {
		if(a==b) {
			return a;
		}else if(a > b) {
			return gcd(a-b, b);
		}else {
			return gcd(a, b-a);
		}
	}
	public static int lcm(int a, int b) {
		return a*b/gcd(a,b);
	}

}

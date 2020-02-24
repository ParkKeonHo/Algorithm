package com.ssafy.algorithm;

import java.util.Scanner;

public class Solution_re_369게임 {
	static int T;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int i = 0; i <= T; i++) {
			String n = i+"";
			char[] s = n.toCharArray();
			int count = 0;
			for(int j = 0; j < s.length; j++) {
				if(s[j] == '3' || s[j] == '6' || s[j] == '9') {
					count++;
				}
			}
			if(count == 0) {
				System.out.print(i+" ");
			}
			else {
				for(int j = 0; j < count; j++) {
					System.out.print("-");
				}
				System.out.print(" ");
			}
		}
	}
}
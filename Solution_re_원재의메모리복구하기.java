package com.ssafy.algorithm;

import java.util.Scanner;

public class Solution_re_원재의메모리복구하기 {
	static int T;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			String s = sc.next();
			int index = s.indexOf('1');
			int count = 1;
			if(index == -1) {
				count = 0;
			}
			else {
				for(int j = index; j < s.length()-1; j++) {
					if(s.charAt(j+1) != s.charAt(j)) {
						count++;
					}
				}
			}
			
			System.out.println("#"+(i+1)+" "+count);
		}
	}

}

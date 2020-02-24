package com.ssafy.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D2_조교의성적매기기 {
	static int T;
	static int ALLSTUDENT;
	static int STUDENT;
	static String[] grade = {"D0", "C-", "C0", "C+", "B-", "B0", "B+", "A-", "A0", "A+"};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int i = 1 ; i < T; i++) {
			ALLSTUDENT = sc.nextInt();
			STUDENT = sc.nextInt()-1;
			int Jumsu[] = new int[ALLSTUDENT];
			for(int j = 0; j < Jumsu.length; j++) {
				int mid = sc.nextInt();
				int fin = sc.nextInt();
				int hom = sc.nextInt();
				Jumsu[j] = mid*35 + fin*45 + hom*20;
			}
			int kscore = Jumsu[STUDENT];
			Arrays.sort(Jumsu);
			int krank = -1;
			for(int j = 0; j < Jumsu.length; j++) {
				if(Jumsu[j] == kscore) {
					krank = j;
				}
			}
			System.out.println("#"+i+" "+grade[krank]);
		}
	}
}

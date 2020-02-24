package com.swexpert.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D1_2027_대각선출력하기 {
	public static void main(String[] args) throws IOException{
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if(i==j) {
					System.out.print("#");
					continue;
				}
				System.out.print("+");
			}
			System.out.println();
		}
	}
}

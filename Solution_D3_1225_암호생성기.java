package com.swexpert.algorithm;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D3_1225_암호생성기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			Queue<Integer> queue = new LinkedList<>();
			int Case = sc.nextInt();
			for (int i = 0; i < 8; i++) {
				queue.add(sc.nextInt());
			}
			int i = 1;
			int x = 1;
			while(x>0) {
				x = queue.poll();
				x -= i++;
				if(x<=0) {
					x = 0;
				}
				if(i == 6) {
					i = 1;
				}
				queue.add(x);
			}
			System.out.print("#"+Case+" ");
			while(!queue.isEmpty()) {
				System.out.print(queue.poll()+" ");
			}
			System.out.println();
		}
	}
}

package com.swexpert.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_9280_D3_진용이네주차타워 {
	static int T, N, M;
	static int[] Ri;
	static int[] Wi;
	static Queue<Integer> queue = new LinkedList<>();
	static Queue<Integer> WaitQueue = new LinkedList<>();
	static int[] Park;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(r.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(r.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			Ri = new int[N];
			Wi = new int[M];
			Park = new int[N];
			for (int i = 0; i < N; i++) {
				Ri[i] = Integer.parseInt(r.readLine());
			}
			for (int i = 0; i < M; i++) {
				Wi[i] = Integer.parseInt(r.readLine());
			}
			for (int i = 0; i < 2*M; i++) {
				queue.add(Integer.parseInt(r.readLine()));
			}
			
			int sum = 0;
			while(!queue.isEmpty()) {
				int x = queue.poll();
				if(x>0) {//0보다 클 때 
					boolean eq = false;
					for (int i = 0; i < N; i++) {
						if(Park[i] == 0) { // 주차공간이 있다면 
							Park[i] = x;
							sum += (Ri[i] * Wi[x-1]);
							eq = true;
							break;
						}
					}
					if(!eq) {//들어갈 공간이 없다면 
						WaitQueue.add(x);
					}
				}else {//0보다 작을 때 
					boolean eq = false;
					for (int i = 0; i < N; i++) {
						if(Park[i] == Math.abs(x)) {
							if(!WaitQueue.isEmpty()) {
								int Wx = WaitQueue.poll();
								Park[i] = Wx;
								sum += (Ri[i] * Wi[Wx-1]);
								eq = true;
								break;
							}else {
								Park[i] = 0;
								eq = true;
								break;								
							}
						}
					}
					if(!eq) { // 뺄 차가 주차장에 없다면 
						WaitQueue.add(x);
					}
				}
			}
			
			System.out.println("#"+t+" "+sum);
		}
	}
}

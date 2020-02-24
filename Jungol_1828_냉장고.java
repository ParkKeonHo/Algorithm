package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Jungol_1828_냉장고 {
	static int N;

	public static class C {
		int min;
		int max;

		public C() {
		}

		public C(int min, int max) {
			super();
			this.min = min;
			this.max = max;
		}
	}

	public static class SC implements Comparator<C> {

		@Override
		public int compare(C c1, C c2) {
			int c1min = c1.min;
			int c2min = c2.min;
			if (c1min > c2min) {
				return 1;
			} else if (c1min < c2min) {
				return -1;
			} else {
				return 0;
			}
		}

	}

	static ArrayList<C> Group;
	static int[] temperature;
	static int result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(r.readLine().trim());
		Group = new ArrayList<>();
		result = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(r.readLine().trim());
			int min = (Integer.parseInt(st.nextToken())) + 270;
			int max = (Integer.parseInt(st.nextToken())) + 270;
			Group.add(new C(min, max));
		}
		Group.sort(new SC());
		while (!Group.isEmpty()) {
			temperature = new int[10271];
			for (int i = 0; i < Group.size(); i++) {
				for (int j = Group.get(i).min; j <= Group.get(i).max; j++) {
					temperature[j]++;
				}
			}
			int position = -1;
			int max = -1;
			for (int i = Group.get(0).min; i < temperature.length; i++) {
				if (max < temperature[i]) {
					max = temperature[i];
					position = i;
				} // max의 시작위치 찾는다.
			}
			for (int i = 0; i < Group.size(); i++) {
				if(Group.get(i).min <= position && Group.get(i).max >=position) {
					Group.remove(i);
					--i;
				}
				if(Group.isEmpty()) {
					break;
				}
			}
			result++;
		}
		System.out.println(result);
	}
}

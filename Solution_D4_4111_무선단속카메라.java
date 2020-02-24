package ssafyalgo_0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution_D4_4111_무선단속카메라 {
	static TreeSet<Integer> tr;
	static boolean[] highway;
	static int N;
	static int K;
	static int T;
	static int[] camera;
	static int[] distance;
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(r.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(r.readLine());
			K = Integer.parseInt(r.readLine());
			tr = new TreeSet<>();
			tr.clear();
			result = 0;
			StringTokenizer st = new StringTokenizer(r.readLine());
			while(st.hasMoreTokens()) {
				tr.add(Integer.parseInt(st.nextToken()));
			}
			distance = new int[tr.size()-1];
			int number = tr.size();
			int a = 0;
			int b = 0; // 7
			int d = 0;
			for (int i = 0; i < number-1; i++) {
				a = tr.pollLast();
				b = tr.last();
				distance[d++] = Math.abs(b-a);
			}
			Arrays.sort(distance);
			for (int i = 0; i < distance.length-(K-1); i++) {
				result+=distance[i];
			}
			if(K >= N) {
				System.out.println("#"+t+" "+result);
			}
			else{
				System.out.println("#"+t+" "+result);
			}
		}
	}
}

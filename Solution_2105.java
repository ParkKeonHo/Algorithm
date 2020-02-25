import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//디저트 카페 
public class Solution_2105 {
	static class P{
		int y, x, d, time;
		ArrayList<Integer> arraylist;
		public P(int y, int x, int d, ArrayList<Integer> arraylist, int time) {
			super();
			this.y = y;
			this.x = x;
			this.d = d;
			this.arraylist = arraylist;
			this.time = time;
		}
	}
	static ArrayList<Integer> arrCopy;
	static int T, Sx, Sy, ans, N;
	static Queue<P> queue;
	static int[][] map;
	static int[] dy = {1, 1, -1, -1};
	static int[] dx = {1, -1, -1, 1};
	static boolean check(int Y, int X) {
		if(Y == 0 && X == 0) return false;
		else if(Y == 0 && X == N-1) return false;
		else if(Y == N-1 && X == 0) return false;
		else if(Y == N-1 && X == N-1) return false;
		return true;
	}
	static ArrayList<Integer> ArrayDeepCopy(ArrayList<Integer> original) {
		arrCopy = new ArrayList<Integer>();
		int size = original.size();
		for (int i = 0; i < size; i++) {
			arrCopy.add(original.get(i));
		}
		return arrCopy;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(r.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(r.readLine());
			map = new int[N][N];
			queue = new LinkedList<P>();
			ans = -1;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(r.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int y = 0; y < N-2; y++) {
				for (int x = 1; x < N-1; x++) {
					if(map[y][x] != map[y+1][x+1]) {
						Sy = y;
						Sx = x;
						P start = new P(y+1, x+1, 0, new ArrayList<>(), 1);
						start.arraylist.add(map[y+1][x+1]);
						start.arraylist.add(map[y][x]);
						queue.add(start);
						while(!queue.isEmpty()) {
							P now = queue.poll();
							
							if(now.d == 0) {
								int d1 = 0;
								int ny1 = now.y+dy[d1];
								int nx1 = now.x+dx[d1];
								int d2 = 1;
								int ny2 = now.y+dy[d2];
								int nx2 = now.x+dx[d2];
								if(ny1 == Sy && nx1 == Sx && d1 == 3) {
									ans = Math.max(ans, now.arraylist.size());
									continue;
								}
								if(ny2 == Sy && nx2 == Sx && d2 == 3) {
									ans = Math.max(ans, now.arraylist.size());
									continue;
								}
								if(ny1>=0 && ny1<N && nx1>=0 && nx1<N  && !(now.arraylist.contains(map[ny1][nx1])) && check(ny1,nx1)) {
									ArrayList<Integer> next = ArrayDeepCopy(now.arraylist);
									next.add(map[ny1][nx1]);
									queue.add(new P(ny1, nx1,d1, next, now.time+1));
								}
								if( ny2>=0 && ny2<N && nx2>=0 && nx2<N && !(now.arraylist.contains(map[ny2][nx2]))&& check(ny2,nx2)) {
									ArrayList<Integer> next = ArrayDeepCopy(now.arraylist);
									next.add(map[ny2][nx2]);
									queue.add(new P(ny2, nx2, d2, next, now.time+1));
								}
								
							}else if(now.d == 1) {
								int d1 = 1;
								int ny1 = now.y+dy[d1];
								int nx1 = now.x+dx[d1];
								int d2 = 2;
								int ny2 = now.y+dy[d2];
								int nx2 = now.x+dx[d2];
								if(ny1 == Sy && nx1 == Sx && d1 == 3) {
									ans = Math.max(ans, now.arraylist.size());
									continue;
								}
								if(ny2 == Sy && nx2 == Sx && d2 == 3) {
									ans = Math.max(ans, now.arraylist.size());
									continue;
								}
								if(ny1>=0 && ny1<N && nx1>=0 && nx1<N  && !(now.arraylist.contains(map[ny1][nx1]))&& check(ny1,nx1)) {
									ArrayList<Integer> next = ArrayDeepCopy(now.arraylist);
									next.add(map[ny1][nx1]);
									queue.add(new P(ny1, nx1,d1, next, now.time+1));
								}
								if( ny2>=0 && ny2<N && nx2>=0 && nx2<N  && !(now.arraylist.contains(map[ny2][nx2]))&& check(ny2,nx2)) {
									ArrayList<Integer> next = ArrayDeepCopy(now.arraylist);
									next.add(map[ny2][nx2]);
									queue.add(new P(ny2, nx2, d2, next, now.time+1));
								}
								
							}else if(now.d == 2) {
								int d1 = 2;
								int ny1 = now.y+dy[d1];
								int nx1 = now.x+dx[d1];
								int d2 = 3;
								int ny2 = now.y+dy[d2];
								int nx2 = now.x+dx[d2];
								if(ny1 == Sy && nx1 == Sx && d1 == 3) {
									ans = Math.max(ans, now.arraylist.size());
									continue;
								}
								if(ny2 == Sy && nx2 == Sx && d2 == 3) {
									ans = Math.max(ans, now.arraylist.size());
									continue;
								}
								if(ny1>=0 && ny1<N && nx1>=0 && nx1<N && !(now.arraylist.contains(map[ny1][nx1]))&& check(ny1,nx1)) {
									ArrayList<Integer> next = ArrayDeepCopy(now.arraylist);
									next.add(map[ny1][nx1]);
									queue.add(new P(ny1, nx1,d1, next, now.time+1));
								}
								if( ny2>=0 && ny2<N && nx2>=0 && nx2<N && !(now.arraylist.contains(map[ny2][nx2]))&& check(ny2,nx2)) {
									ArrayList<Integer> next = ArrayDeepCopy(now.arraylist);
									next.add(map[ny2][nx2]);
									queue.add(new P(ny2, nx2, d2, next, now.time+1));
								}
								
							}else if(now.d == 3) {
								int d1 = 3;
								int ny1 = now.y+dy[d1];
								int nx1 = now.x+dx[d1];
								int d2 = 0;
								int ny2 = now.y+dy[d2];
								int nx2 = now.x+dx[d2];
								if(ny1 == Sy && nx1 == Sx && d1 == 3) {
									ans = Math.max(ans, now.arraylist.size());
									continue;
								}
								if(ny2 == Sy && nx2 == Sx && d2 == 3) {
									ans = Math.max(ans, now.arraylist.size());
									continue;
								}
								if(ny1>=0 && ny1<N && nx1>=0 && nx1<N &&!(now.arraylist.contains(map[ny1][nx1]))&& check(ny1,nx1)) {
									ArrayList<Integer> next = ArrayDeepCopy(now.arraylist);
									next.add(map[ny1][nx1]);
									queue.add(new P(ny1, nx1,d1, next, now.time+1));
								}
								if( ny2>=0 && ny2<N && nx2>=0 && nx2<N && !(now.arraylist.contains(map[ny2][nx2]))&& check(ny2,nx2)) {
									ArrayList<Integer> next = ArrayDeepCopy(now.arraylist);
									next.add(map[ny2][nx2]);
									queue.add(new P(ny2, nx2, d2, next, now.time+1));
								}
								
							}
						}
					}
				}
			}
			System.out.println("#"+t+" "+ans);
		}
	}
}

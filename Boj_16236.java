import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

//아기상어 
public class Boj_16236 {
	static class P implements Comparable<P>{
		int y, x, exp;
		public P(int y, int x, int exp) {
			super();
			this.y = y;
			this.x = x;
			this.exp = exp;
		}
		@Override
		public int compareTo(P o) {
			if(this.y<o.y) {// 더 위에 있다면 
				return -1;
			}else if(this.y>o.y) {
				return 1;
			}else {
				if(this.x<o.x) {
					return -1;
				}else if(this.x>o.x) {
					return 1;
				}else {
					return 0;
				}
			}
		}
	}
	static int[] dy = {-1, 0, 0, 1};
	static int[] dx = {0, -1, 1, 0};
	static Queue<P> queue;
	static PriorityQueue<P> prqueue;
	static int N, Time, Level, Fish;
	static int[][] map;
	static boolean[][] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(r.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		queue = new LinkedList<P>();
		prqueue = new PriorityQueue<P>();
		Time = 0;
		Level = 2;
		Fish = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(r.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					map[i][j] = 0;
					queue.add(new P(i, j, 0));
					visit[i][j] = true;
					continue;
				}else if(map[i][j] != 0) {
					Fish++;
				}
			}
		}
		int time = 0;
		boolean eat = false;
		while(!queue.isEmpty()) {
			eat = false;
			if(Fish == 0) {
				break;
			}
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				P now = queue.poll();
				for (int d = 0; d < 4; d++) {
					int ny = now.y+dy[d];
					int nx = now.x+dx[d];
					if(ny>=0 && ny<N && nx>=0 && nx<N && !visit[ny][nx] && map[ny][nx]<=Level) {
						if(map[ny][nx] == 0 || map[ny][nx] == Level) {
							visit[ny][nx] = true;
							queue.add(new P(ny, nx, now.exp));
							continue;
						}else if(map[ny][nx] < Level) {
							visit[ny][nx] = true;
							prqueue.add(new P(ny, nx, now.exp));
						}
					}
				}
			}
			if(!prqueue.isEmpty()) {//먹은 물고기가 있다면 
				P shark = prqueue.poll(); //가장 우선순위에 있는 놈을 꺼낸 뒤 
				prqueue.clear();
				queue.clear();
				visit = new boolean[N][N];
				eat = true;
				Fish--;
				if((shark.exp+1) == Level) {
					Level++;
					visit[shark.y][shark.x] = true;
					map[shark.y][shark.x] = 0;
					queue.add(new P(shark.y, shark.x, 0));
				}else {
					visit[shark.y][shark.x] = true;
					map[shark.y][shark.x] = 0;
					queue.add(new P(shark.y, shark.x, (shark.exp+1)));
				}
			}
			if(eat) {
				Time = Time+(time+1);
				time = 0;
			}else {
				time++;
			}
		}
		System.out.println(Time);
	}
}













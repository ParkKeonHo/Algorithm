import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_숨바꼭질 {
	static int N;
	static int K;
	static int min;
	static boolean[] visit;
	static Queue<P> queue;
	static class P{
		int num, time;

		public P(int num, int time) {
			super();
			this.num = num;
			this.time = time;
		}
		
	}
	public static void bfs() {
		P now = new P(N, 0);
		visit[now.num] = true;
		queue.add(now);
		while(!queue.isEmpty()) {
			P next = queue.poll();
			if(next.num == K) {
				min = next.time;
				break;
			}
			int next1 = next.num+1;
			int next2 = next.num-1;
			int next3 = next.num*2;
			if(next1 <= K && !visit[next1]) {
				queue.add(new P(next1, next.time+1));
			}
			if(next2 > 0 && !visit[next2]) {
				queue.add(new P(next2, next.time+1));
			}
			if(next3 <= visit.length && !visit[next3]) {
				queue.add(new P(next3, next.time+1));
			}
		}
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(r.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visit = new boolean[K+(Math.abs(K-N))+1];
		queue = new LinkedList<P>();
		bfs();
		System.out.println(min);
	}
}

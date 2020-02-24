import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_숨바꼭질2 {
	static int N, K;
	static Queue<P> queue;
	static int bfs() {
		int time = 0;
		while(!queue.isEmpty()) {
			P now = queue.poll();
			if(now.position == K) {
				time = now.time;
				break;
			}
			P next1 = new P(now.position+1, now.time+1);
			P next2 = new P(now.position-1, now.time+1);
			P next3 = new P(now.position*2, now.time+1);
			if(next1.position>=0 && next1.position<visit.length && !visit[next1.position]) {
				visit[next1.position] = true;
				queue.add(next1);
			}
			if(next2.position>=0 && next2.position<visit.length && !visit[next2.position]) {
				visit[next2.position] = true;
				queue.add(next2);
			}
			if(next3.position>=0 && next3.position<visit.length && !visit[next3.position]) {
				visit[next3.position] = true;
				queue.add(next3);
			}
		}
		return time;
	}
	static class P{
		int position, time;

		public P(int position, int time) {
			super();
			this.position = position;
			this.time = time;
		}
		
		
	}
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(r.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		queue = new LinkedList<P>();
		visit = new boolean[100001];
		visit[N] = true;
		queue.add(new P(N, 0));
		int ans = bfs();
		System.out.println(ans);
	}
}

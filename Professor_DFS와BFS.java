import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Professor_DFS와BFS {
	static boolean[][] map;
	static boolean[] visit;
	static int N, M, V;

	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(r.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		visit = new boolean[N + 1];
		map = new boolean[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(r.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			map[v1][v2] = true;
			map[v2][v1] = true;
		}

		dfs(V);
		System.out.println();
		bfs(V);

	}

	public static void bfs(int start) { // 함수로 만드는것이 bfs는 좋다.
		visit = new boolean[N+1];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start); //시작하는 정점 번호가 방문 스케줄 표에 들어감.
		while(!queue.isEmpty()) { //방문할 정점이 남아있으면 계속하자.(때로는 안가보고 끝날 수도 있음)
			int now = queue.poll(); //스케줄 실행
			System.out.print(now+" "); 
			visit[now] = true;
			for (int i = 1; i <= N; i++) {
				if(map[now][i] && !visit[i]) {
					queue.add(i);
					visit[i] = true;
				}
			}
		}
	}
	
	public static void dfs(int now) {
		visit[now] = true;
		System.out.print(now+" ");
		
		for (int i = 1; i <= N; i++) {
			if(map[now][i] && !visit[i]) { // now-> i로 이동가능하며, 방문하지 않았다면
				dfs(i);
			}
		}
	}

}

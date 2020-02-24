import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_DFS와BFS {

	static boolean[] visited;
	static int N;
	static int M;
	static int V;
	static boolean[][] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(r.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		graph = new boolean[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(r.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			graph[y][x] = true;
			graph[x][y] = true;
		}
		dfs(V);
		visited = new boolean[N+1];
		System.out.println();
		bfs(V);
	}
	public static void dfs(int start) {
		visited[start] = true;
		System.out.print(start+" ");
		for (int i = 1; i <= N; i++) {
			if(graph[start][i] == true && visited[i] == false) {
				dfs(i);
			}
		}
	}
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;
		while(!queue.isEmpty()) {
			int x = queue.poll();
			System.out.print(x+" ");
			for (int i = 1; i <= N; i++) {
				if(graph[x][i] && visited[i] == false) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}
}

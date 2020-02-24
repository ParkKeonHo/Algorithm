import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//경로 찾기 
public class Boj_11403 {
	static int N;
	static boolean[] visit;
	static int[][] graph;
	static int[][] result;
	static Queue<Integer> queue;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(r.readLine());
		graph = new int[N][N];
		result = new int[N][N];
		queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(r.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int k = 0;
		for (int i = 0; i < N; i++) {
			visit = new boolean[N];
			queue.add(i);
			while(!queue.isEmpty()) {
				int now = queue.poll();
				for (int d = 0; d < N; d++) {
					if(graph[now][d] == 1 && !visit[d]) {
						queue.add(d);
						visit[d] = true;
						result[i][d] = 1;
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(result[i][j]+" ");
			}System.out.println();
		}
	}
}

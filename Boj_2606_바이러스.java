import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2606_바이러스 {
	static boolean[] visit;
	static boolean[][] graph;
	static int count;
	static int ComputerNum;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		ComputerNum = Integer.parseInt(r.readLine());
		graph = new boolean[ComputerNum+1][ComputerNum+1];
		visit = new boolean[ComputerNum+1];
		count = 0;
		N = Integer.parseInt(r.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(r.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = true;
			graph[b][a] = true;
		}
		dfs(1);
		System.out.println(count);
	}
	public static void dfs(int start_index) {
		visit[start_index] = true;
		for (int i = 1; i <= ComputerNum; i++) {
			if(graph[start_index][i] && !visit[i]) {
				count++;
				dfs(i);
			}
		}
	}
}

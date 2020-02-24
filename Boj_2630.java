import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//색종이 만들기
public class Boj_2630 {
	static int[][] map;
	static int[] count;
	static int N;

	static void Divide(int startY, int startX, int n) {
		if(n == 1) {
			count[map[startY][startX]]++;
			return;
		}
		boolean rectangle = true;
		int color = map[startY][startX];
		for (int i = startY; i < startY+n; i++) {
			for (int j = startX; j < startX+n; j++) {
				if (map[i][j] != color) {
					rectangle = false;
					break;
				}
			}
		}
		if (rectangle) {
			count[color]++;
			return;
		}else {
			//우측 상단 
			Divide(startY,startX+n/2 ,n/2);
			//좌측 상단 
			Divide(startY,startX ,n/2);
			//우측 하단 
			Divide(startY+n/2, startX+n/2, n/2);
			//좌측 하단 
			Divide(startY+n/2, startX, n/2);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(r.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(r.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		count = new int[2];
		Divide(0, 0, N);
		for (int i = 0; i < 2; i++) {
			System.out.println(count[i]);
		}
	}
}
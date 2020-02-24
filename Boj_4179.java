import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//불!
public class Boj_4179 {
	static int R, C, Time;
	static boolean[][] Jvisit;
	static char[][] map;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0,-1, 1};
	static boolean Escape;
	static Queue<FirePoint> Fqueue;
	static Queue<JihoonPoint> Jqueue;
	static class FirePoint{
		int y, x;
		public FirePoint(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
	static class JihoonPoint{
		int y, x;
		public JihoonPoint(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(r.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R+2][C+2];
		Jvisit = new boolean[R+2][C+2];
		Jqueue = new LinkedList<JihoonPoint>();
		Fqueue = new LinkedList<FirePoint>();
		for (int i = 0; i < R+2; i++) {
			char[] tmp = null;
			if(i != 0 && i != R+1) {
				tmp = r.readLine().toCharArray();
			}
			for (int j = 0; j < C+2; j++) {
				if(i == 0 || j == 0 || i == R+1 || j == C+1) {
					map[i][j] = '*';
				}else {
					map[i][j] = tmp[j-1];
					if(map[i][j] == 'J') {
						Jqueue.add(new JihoonPoint(i,  j));
						Jvisit[i][j] = true;
					}
					if(map[i][j] == 'F') {
						Fqueue.add(new FirePoint(i,  j));
					}
				}
			}
		}//map init complete
		Escape = false;
		int ans = 1;
		while(!Jqueue.isEmpty()) {
			int Fsize = Fqueue.size();
			for (int i = 0; i < Fsize; i++) {
				FirePoint Fnow = Fqueue.poll();
				for (int d = 0; d < 4; d++) {
					int Fny = Fnow.y+dy[d];
					int Fnx = Fnow.x+dx[d];
					if(Fny>=1 && Fny<R+1 && Fnx>=1 && Fnx<C+1 && map[Fny][Fnx] != 'F' && map[Fny][Fnx] != '#') {
						map[Fny][Fnx] = 'F';
						Fqueue.add(new FirePoint(Fny, Fnx));
					}
				}//FirePoint Init
			}
			int size = Jqueue.size();
			for (int i = 0; i < size; i++) {
				JihoonPoint Jnow = Jqueue.poll();
				for (int d = 0; d < 4; d++) {
					int Jny = Jnow.y+dy[d];
					int Jnx = Jnow.x+dx[d];
					if(Jny>=0 && Jny<R+2 && Jnx>=0 && Jnx<C+2 && !Jvisit[Jny][Jnx] && (map[Jny][Jnx] == '.' || map[Jny][Jnx] == '*')) {
						if(map[Jny][Jnx] == '*') {
							Escape = true;
							break;
						}
						Jvisit[Jny][Jnx] = true;
						map[Jny][Jnx] = 'J';
						Jqueue.add(new JihoonPoint(Jny, Jnx));
					}
				}
			}
			if(Escape) {
				Time = ans;
				break;
			}
			ans++;
		}
		System.out.println((Escape)?Time:"IMPOSSIBLE");
	}
}

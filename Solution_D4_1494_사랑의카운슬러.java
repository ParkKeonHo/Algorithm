package ssafyalgo_0214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_D4_1494_사랑의카운슬러 {
     
    static boolean []visit;
    static int N;
    static long result;
    static Worm[] Worms;
    public static class Worm{
    	int y;
    	int x;
		public Worm(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
    	
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(r.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(r.readLine());
            Worms = new Worm[N];
            visit = new boolean[N];
            result = Long.MAX_VALUE;
             
            for (int i = 0; i < N; i++) {
            	StringTokenizer st = new StringTokenizer(r.readLine());
            	int y = Integer.parseInt(st.nextToken());
            	int x = Integer.parseInt(st.nextToken());
            	Worms[i] = new Worm(y, x);
            }
             
            find(0,0);
            System.out.println("#"+t+" "+result);
        }
    }
     
    public static void find (int start, int count) {
        if(N/2 == count) {
            long distanceY=0;
            long distanceX=0;
            for (int i = 0; i < N; i++) {
                if(visit[i] == true) {
                    distanceY += Worms[i].y;
                    distanceX += Worms[i].x;
                }
                else {
                    distanceY -= Worms[i].y;
                    distanceX -= Worms[i].x;
                     
                }
            }
            long distance = distanceY*distanceY+distanceX*distanceX;
            if(result > distance) {
                result = distance;
            }
            return;
        }
        for (int i = start; i < N; i++) {
            if(!visit[i]) {
                visit[i] = true;
                find(i+1,count+1);
                visit[i] = false;
            }
        }
    }
}
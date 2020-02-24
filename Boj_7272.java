import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_7272 {
	static int T;
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(r.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(r.readLine());
			String s1 = new String();
			String s2 = new String();
			s1 = st.nextToken();
			s2 = st.nextToken();
			String last1 = "";
			String last2 = "";
			for (int i = 0; i < 2; i++) {
				if(i == 0) {
					last1 = s1.replaceAll("[CEFGHIJKLMNSTUVWXYZ]", "1");
					last2 = s2.replaceAll("[CEFGHIJKLMNSTUVWXYZ]", "1");					
				}else if(i == 1) {
					last1 = last1.replaceAll("[ADOPQR]", "2");
					last2 = last2.replaceAll("[ADOPQR]", "2");
				}
			}
			System.out.println("#"+t+" "+(last1.equals(last2)?"SAME":"DIFF"));
		}
	}
}

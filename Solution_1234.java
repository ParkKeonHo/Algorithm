import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution_1234 {
	static char[] s;
	static int T;
	static ArrayList<Integer> array;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(r.readLine());
		for (int t = 1; t <=T; t++) {
			s = r.readLine().toCharArray();
			array = new ArrayList<>();
			for (int i = 0; i < s.length; i++) {
				array.add(s[i]-48);
			}
			boolean eq = true;
			while(eq) {
				for (int i = 0; i < s.length-1; i++) {
					int j = i+1;
					if(array.get(i) == array.get(j)) {
						for (int j2 = 0; j2 < 2; j2++) {
							array.remove(i);
						}
						break;
					}
					if(i == s.length-2) {
						eq = false;
						break;
					}
				}
			}
			for (int i = 0; i < array.size(); i++) {
				System.out.print(array.get(i));
			}
		}
	}
}

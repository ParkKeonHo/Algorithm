import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_크로아티아알파벳 {
	static String[] croatia = { "c-", "c=", "dz=", "d-", "lj", "nj", "s=", "z=" };
	static String s;

	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		s = r.readLine();
		String copy = null;
		copy = s.replaceAll(croatia[0], "#");
		copy = copy.replaceAll(croatia[1], "#");
		copy = copy.replaceAll(croatia[2], "#");
		copy = copy.replaceAll(croatia[3], "#");
		copy = copy.replaceAll(croatia[4], "#");
		copy = copy.replaceAll(croatia[5], "#");
		copy = copy.replaceAll(croatia[6], "#");
		copy = copy.replaceAll(croatia[7], "#");
		System.out.println(copy.length());
	}
}

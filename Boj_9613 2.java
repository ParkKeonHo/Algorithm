
public class Boj_9613 {

	public static int GCD(int a, int b) {
		if (a == b) {
			return a;
		} else {
			if (a > b) {
				return GCD(a - b, b);
			} else {
				return GCD(a, b - a);
			}
		}
	}

	public static void main(String[] args) {

	}
}


public class Combi1 {
	static int count = 0;
	public static void main(String[] args) {
		combi(5,3);	
		System.out.println(count);
	}
	public static void combi(int n, int r) {
		if(n == r || r == 0) {
			count++;
			return;
		}
		else {
			combi(n-1,r);
			combi(n-1,r-1);
		}
		
	}
}

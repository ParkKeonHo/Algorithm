
public class combi2 {
	static int N = 5;
	static int R = 3;
	static char[] alpha = {'a','b','c','d','e'};
	static char[] combiA;
	public static void main(String[] args) {
		combiA = new char[R];
		combination(0,0);
	}
	public static void combination(int start, int count) { // count는 값을 대입할 index
		if(R == count) {
			for (int i = 0; i < R; i++) {
				System.out.print(combiA[i]+" ");
			}
			System.out.println();
			return;
		}
		else {
			for (int i = start; i < N; i++) {
				combiA[count] = alpha[i];
				combination(i+1, count+1);
			}
		}
	}

}

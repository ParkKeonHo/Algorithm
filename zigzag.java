
public class zigzag {
	static long[][] zigzag;
	public static void main(String[] args) {
		zigzag = new long[30][];
		zigzag[1] = new long[2];
		zigzag[1][0] = 1L;
		zigzag[1][1] = 1L;
		for (int i = 2; i < zigzag.length; i++) {
			zigzag[i] = new long[i+1];
			zigzag[i][0] = 1L;
			zigzag[i][i] = 1L;
			for (int j = 1; j < i; j++) {
				zigzag[i][j] = zigzag[i-1][j-1]+zigzag[i-1][j];
			}
		}
		for (int i = 1; i < zigzag.length; i++) {
			for (int j = 0; j < zigzag[i].length; j++) {
				System.out.print(zigzag[i][j]+" ");
			}System.out.println();
		}
		System.out.println(zigzag[3][1]);
	}
}

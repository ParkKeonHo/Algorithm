import java.util.Arrays;

public class ReverseString {
	static String s;
	public static void main(String[] args) {
		s = new String("안녕하세요 저는 박건호입니다.");
		int len = s.length();
		System.out.println(len);
		char[] cs = new char[len];
		for (int i = 0; i < (len)/2; i++) {
			char tmp = s.charAt(i);
			cs[i] = s.charAt(len-1-i);
			cs[len-1-i] = tmp;
		}
		System.out.println(String.valueOf(cs));
	}
}

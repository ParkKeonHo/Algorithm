package com.swexpert.algorithm;

public class parseTest {
//	1.String->Int
//	2.int->String
//	3.char->Int
//	4.int->char
//	5.String->char
//	6.char->String
	public static void main(String[] args) {
		String string = "123";
		int stringtoint = Integer.parseInt(string);
		System.out.println(stringtoint);
		String inttostring = stringtoint+"";
		System.out.println(inttostring);
		int a = 9;
		char inttochar = (char)(a+'0');
		System.out.println(inttochar);
		char c = '9';
		int chartoint  = c-'0';
		System.out.println(chartoint);
		String sc = c+"";
		System.out.println(sc);
		String cs = Character.toString(c);
		System.out.println(cs);
	}

}

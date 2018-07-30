package com.austinpalmore.fun_with_math.cryptograpy;
import com.austinpalmore.fun_with_math.util.*;

public class Rot13 {
	protected static void driver() {
		String s = Display.getStringFromUser("Enter a Message to be encoded", new Tester() {
			@Override
			public boolean test(String s) {
				return s.equals("");
			}
		});
		new TextWindow("Rot13 Message", permutate(s));
	}
	private static String permutate(String s) {
		String ps = "";
		for(int i = 0;i < s.length();i++) {
			if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
				if(s.charAt(i) <= 'm') {
					ps += (char)(s.charAt(i) + 13);
				} else {
					ps += (char)(s.charAt(i) - 13);
				}
			} else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
				if(s.charAt(i) <= 'M') {
					ps += (char)(s.charAt(i) + 13);
				} else {
					ps += (char)(s.charAt(i) - 13);
				}
			} else {
				ps += s.charAt(i);
			}
		}
		return ps;

	}
}

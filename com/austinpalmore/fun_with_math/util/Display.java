package com.austinpalmore.fun_with_math.util;
import javax.swing.*;

@SuppressWarnings("serial")
public class Display {
	public static void DisplayMessage(String m) {
		final String message = m;
		(new Thread(new Runnable() {
			@Override
			public void run() {
				javax.swing.JOptionPane.showMessageDialog(null,message,"",javax.swing.JOptionPane.INFORMATION_MESSAGE);
			}
		})).start();
	}
	public static int getIntFromUser(String prompt, Tester t) {
		int i = -200;
		java.util.Scanner consul = null;
		while (t.test(i)) {
			try {
				consul = new java.util.Scanner(javax.swing.JOptionPane.showInputDialog(prompt));
				while(!consul.hasNextInt()) {
					consul = new java.util.Scanner(javax.swing.JOptionPane.showInputDialog(prompt));
				}
				i = consul.nextInt();
			} catch (java.lang.NullPointerException exc) {
				System.err.println("exiting...");
				System.exit(0);
			}
		}
		return i;
	}
	public static String getStringFromUser(String prompt, Tester t) {
		String s = "";
		while (t.test(s)) {
			try {
				s = javax.swing.JOptionPane.showInputDialog(prompt);
			} catch (java.lang.NullPointerException exc) {
				System.err.println("exiting...");
				System.exit(0);
			}
		}
		return s;
	}
}

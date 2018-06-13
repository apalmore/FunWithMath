package com.austinpalmore.fun_with_math;
import javax.swing.*;

@SuppressWarnings("serial")
public class Display {
	protected void DisplayTextBox(final String title, final String text) {
		(new Thread(new Runnable() {
			@Override
			public void run() {
				new TextBox(title,text);
			}
		})).start();
	}
	protected static void DisplayMessage(String m) {
		final String message = m;
		(new Thread(new Runnable() {
			@Override
			public void run() {
				javax.swing.JOptionPane.showMessageDialog(null,message,"",javax.swing.JOptionPane.INFORMATION_MESSAGE);
			}
		})).start();
	}
	protected static int getIntFromUser(String prompt, Tester t) {
		int i = -1;
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
	protected static String getStringFromUser(String prompt, Tester t) {
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
	@SuppressWarnings("serial")
	final class TextBox extends javax.swing.JFrame{
		protected TextBox(String title, String text){
			super(title);
			javax.swing.JTextArea textarea = new javax.swing.JTextArea(text);
			javax.swing.JPanel panel = new javax.swing.JPanel();;
			javax.swing.JScrollPane scrollpane = new javax.swing.JScrollPane(textarea,javax.swing.JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			setSize(800,500);
			setResizable(true);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			panel.setLayout(new java.awt.BorderLayout());
			textarea.setLineWrap(true);
			textarea.setWrapStyleWord(true);
			panel.add(scrollpane, java.awt.BorderLayout.CENTER);
			add(panel);
			
			setVisible(true);
		}
	}
}

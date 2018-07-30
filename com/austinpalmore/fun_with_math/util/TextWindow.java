package com.austinpalmore.fun_with_math.util;
import javax.swing.*;

public class TextWindow extends JFrame {
	public static void main(String args[]) {
		TextWindow gui = new TextWindow("Name","text area");
	}
	public TextWindow(String name,String text) {
		super(name);
		setSize(800,500);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel jpan = new JPanel();

		JTextArea textArea = new JTextArea(31,64);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setText(text);
		JScrollPane pane = new JScrollPane(textArea);
		pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		jpan.add(pane);

		add(jpan);
		setVisible(true);
	}
}

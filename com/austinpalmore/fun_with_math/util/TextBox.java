package com.austinpalmore.fun_with_math.util;
@SuppressWarnings("serial")
public final class TextBox extends javax.swing.JFrame{
	protected TextBox(String title, String text){
		super(title);
		javax.swing.JTextArea textarea = new javax.swing.JTextArea(text);
		javax.swing.JPanel panel = new javax.swing.JPanel();;
		javax.swing.JScrollPane scrollpane = new javax.swing.JScrollPane(textarea,javax.swing.JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    		javax.swing.text.DefaultCaret caret = (javax.swing.text.DefaultCaret)textarea.getCaret();
		setSize(800,500);
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		panel.setLayout(new java.awt.BorderLayout());
		textarea.setLineWrap(true);
        	textarea.setWrapStyleWord(true);
        	caret.setUpdatePolicy(javax.swing.text.DefaultCaret.ALWAYS_UPDATE);
        	panel.add(scrollpane, java.awt.BorderLayout.CENTER);
		add(panel);
		
		setVisible(true);
	}
}

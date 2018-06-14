package com.austinpalmore.fun_with_math;
public class Menu {
	final private static int WIDTH = 52;
	public Menu(String items[], String messages[]) {
		DrawLine('#',WIDTH - 2,true);
		showMessages(messages);
		DrawBar('#','*');
		addItems(items);
		DrawLine('#',WIDTH - 2,true);
		System.out.print("Enter your chose >>: ");
	}
	private static void DrawBar(char outer,char iner) {
		System.out.print(outer);
		DrawLine(iner,WIDTH - 4,false);
		System.out.println(outer);
	}
	private static void showMessages(String messages[]) {
		String l = "",r = "";
		for (String message : messages) {
			l = message.substring(0,message.length()/2);
			r = message.substring(message.length()/2,message.length());
			System.out.printf("# %" + (WIDTH/2-3) + "s%-"+(WIDTH/2-3)+"s #%n",l,r);
		}
	}
	private static void DrawLine(char c,int length,boolean newline) {
		for(int i = 0;i < length;i++)
			System.out.print(c);
		if (newline)
			System.out.println();
	}
	private static void addItems(String items[]) {
		for (int i = 0;i < items.length;i++) {
			System.out.printf("|  (%2d) %-"+(WIDTH-12)+"s |%n",i,items[i]);
			DrawBar('*','-');
		}
	}
}

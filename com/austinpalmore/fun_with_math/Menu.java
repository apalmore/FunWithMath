package com.austinpalmore.fun_with_math;
public class Menu {
	final private static int WIDTH = 52;
	Menu(String items[], String messages[], boolean underDevelopment[]) {
		DrawLine('#',WIDTH - 2,true);
		showMessages(messages);
		DrawBar('#','*');
		addItems(items,underDevelopment);
		DrawLine('#',WIDTH - 2,true);
		System.out.print("Enter your chose >>: ");
	}
	protected static void DrawBar(char outer,char iner) {
		System.out.print(outer);
		DrawLine(iner,WIDTH - 4,false);
		System.out.println(outer);
	}
	protected static void showMessages(String messages[]) {
		String l = "",r = "";
		for (String message : messages) {
			l = message.substring(0,message.length()/2);
			r = message.substring(message.length()/2,message.length());
			System.out.printf("# %" + (WIDTH/2-3) + "s%-"+(WIDTH/2-3)+"s #%n",l,r);
		}
	}
	protected static void DrawLine(char c,int length,boolean newline) {
		for(int i = 0;i < length;i++)
			System.out.print(c);
		if (newline)
			System.out.println();
	}
	protected static void addItems(String items[], boolean underDevelopment[]) {
		for (int i = 0;i < items.length;i++) {
			if(underDevelopment[i])
				System.out.printf("|UD(%2d) %-"+ (WIDTH-12)+"s |%n",i,items[i]);
			else
				System.out.printf("|  (%2d) %-"+(WIDTH-12)+"s |%n",i,items[i]);
			DrawBar('*','-');
		}
	}
}

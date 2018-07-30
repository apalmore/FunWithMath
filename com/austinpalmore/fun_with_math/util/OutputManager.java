package com.austinpalmore.fun_with_math.util;
import java.lang.StringBuffer;
import java.io.PrintStream;
import java.io.File;

public class OutputManager {
	private StringBuffer session_data = new StringBuffer();
	public String toString() { return this.session_data.toString(); }
	public String noConsole(String s) {
                this.session_data.append(s);
                return s;
	}
	 public String noConsoleln(String s) {
                this.session_data.append(s + "\n");
                return s + "\n";
        }
	public String print(String s) {
		System.out.print(s);
		this.session_data.append(s);
		return s;
	}
        public String println(String s) {
                System.out.println(s);
                this.session_data.append(s + "\n");
                return s;
        }
	public boolean save(String filename) {
		try (
			PrintStream ps = new PrintStream(new File(filename));
		) {
			ps.print(this.toString());
		} catch (java.io.FileNotFoundException e) {
			System.err.println(e);
			return false;
		}
		return true;
	}
	public void dispWindow(String title) {
		new TextWindow(title,this.toString());
	}
}	

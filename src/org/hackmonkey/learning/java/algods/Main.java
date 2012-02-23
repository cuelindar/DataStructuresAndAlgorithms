package org.hackmonkey.learning.java.algods;

import java.io.Console;

public class Main {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Console con = System.console();
		if (con != null){
			con.printf("Hello, world!");
			con.readLine();
			System.exit(0);
		}
		throw(new Exception("Hey"));
	}

}

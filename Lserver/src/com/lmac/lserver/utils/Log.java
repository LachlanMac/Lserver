package com.lmac.lserver.utils;

public class Log {

	public static void print(String str){
		
		System.out.println("LOG: " + str);
		
	}
	
	public static void print(int str){
		System.out.println("LOG: " + str);
	}
	
	public static void error(String str){
		System.out.println("ERROR: " + str);
		
	}
	
}

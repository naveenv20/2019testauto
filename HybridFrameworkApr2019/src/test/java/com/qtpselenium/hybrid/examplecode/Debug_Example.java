package com.qtpselenium.hybrid.examplecode;
public class Debug_Example {
//f5 -  take you inside the function
//f6 - line by line execution
//f8 - normal run

	public static void main(String[] args) {
		int i=1;
		int j=2;
		int k=3;
		i++;
		
		System.out.println(i);
		System.out.println(j);
		System.out.println(k);
		add(j,k);

	}
	
	public static void add(int a, int b){
		System.out.println(a+b);
		System.out.println("Addition done");
		System.out.println("Exiting function");
	}

}

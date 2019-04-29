package com.qtpselenium.hybrid.examplecode;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;



public class Set_Java {

	
	public static void main(String[] args) {
		// no duplicate elements
		// no indexing
		// no order
		Set<String> s = new HashSet<String>();
		System.out.println(s.size());
		s.add("india");//0
		s.add("uk");//1
		s.add("russia");//2
		s.add("usa");//3
		s.add("china");
		System.out.println(s.size());
		
		//s.get(0);
		
		Iterator<String> it = s.iterator();
		/*
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.next());
		*/
		while(it.hasNext())
			System.out.println(it.next());

	}

}

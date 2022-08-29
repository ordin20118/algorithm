package test;

import java.util.*;

public class StringOrder {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		
		
		list.add("121");
		list.add("112");
		list.add("13");
		list.add("31");
		list.add("22");
		list.add("211");
		list.add("1111");
		
		System.out.println(list);
		
		System.out.println("");
		Collections.sort(list);
		
		System.out.println(list);
		

	}

}

package test;

import java.util.*;

public class ObjectOrder {

	public static void main(String[] args) {
		
		
		List<Item> itemList = new ArrayList<>();
		itemList.add(new Item(6, 30));
		itemList.add(new Item(3, 9));
		itemList.add(new Item(1, 30));
		itemList.add(new Item(3, 7));
		itemList.add(new Item(2, 35));
		itemList.add(new Item(4, 10));
		itemList.add(new Item(3, 4));
		itemList.add(new Item(4, 6));

		
		printList(itemList);
		
		
		Collections.sort(itemList, new Comparator<Item>(){

			@Override
			public int compare(Item o1, Item o2) {
				if(o1.a < o2.a) {
					return -1;
				} else if(o1.a > o2.a) {
					return 1;
				} else {
					if(o1.b < o2.b) {
						return -1;
					} else if(o1.b < o2.b) {
						return -1;
					} else {
						return 0;	
					}
				}
				
			}
			
		});
		
		printList(itemList);
		

	}
	
	public static void printList(List<Item> list) {
		System.out.println("====================================");
		for(Item i : list) {
			System.out.println("[" + i.a + "]/[" + i.b + "]");
		}
		System.out.println("====================================");
	}

	static class Item {
		public int a;
		public int b;
		Item(int a, int b) {
			this.a = a; this.b = b;
		}
	}

}

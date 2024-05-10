package gwang.java.grammer;

import java.util.*;
import java.util.stream.Collectors;

public class StreamSortExample {

	public static void main(String[] args) {
		
		
		List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
	        
        List<String> sortedNames = names.stream()
                                       .sorted(Comparator.reverseOrder())
                                       .collect(Collectors.toList());
		
		
		List<Toy> toyList = new ArrayList<>();
		
		for(int i=0; i<15; i++) {
			Toy toy = new Toy("장난감" + (i+1), i+1);
			toyList.add(toy);
		}
		Toy toy1 = new Toy("장난감2", 5);
		Toy toy2 = new Toy("장난감2", 10);
		toyList.add(toy1);
		toyList.add(toy2);
		
		// 오름참순 정렬 
		//toyList.sort(Comparator.comparingInt(toy -> toy.cost));
		//toyList.sort(Comparator.comparing(toy -> toy.cost));
		toyList.sort(Comparator.comparing((Toy toy) -> toy.name));
		print(toyList);
		
		System.out.println("=====================================");
		
		
		// 내림차순 정렬
		//toyList.sort(Comparator.comparingInt((Toy toy) -> toy.cost).reversed());
		//toyList.sort(Comparator.comparing((Toy toy) -> toy.cost).reversed());
		toyList.sort(Comparator.comparing((Toy toy) -> toy.name).reversed());		
		print(toyList);
		
		
		System.out.println("=====================================");
		
		// 이름을 우선순위로 정렬 하면서 이름이 같다면 가격이 비싼 순으로 정렬
	  Comparator<Toy> comparator = Comparator.comparing((Toy toy) -> toy.name)
                  .thenComparingInt(toy -> toy.cost).reversed();
	  toyList.sort(comparator);
	  print(toyList);
		
	}
	
	static void print(List<Toy> toyList) {
		for(Toy toy : toyList) {
			System.out.println("["+toy.name+"] cost:" + toy.cost);
		}
	}
	
	static class Toy {
		String	name;
		int cost;
		Toy(String name, int cost) {
			this.name = name; this.cost = cost;
		}
	}

}

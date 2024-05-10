package gwang.baekjoon.doing;

import java.io.*;
import java.util.*;

public class baekjoon_1202 {

	static int N, K;	
	static Gem[] gems;
	static Integer[] bags;
	static long maxValue = 0;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String firstLine = br.readLine();
		
		String[] firstArr = firstLine.split(" ");
		N = Integer.parseInt(firstArr[0]);
		K = Integer.parseInt(firstArr[1]);
		
		gems = new Gem[N];
		bags = new Integer[K];
				
		for(int i=0; i<N; i++) {
			String bagStr = br.readLine();
			String[] bagStrArr = bagStr.split(" ");
			Gem gem = new Gem(i, Integer.parseInt(bagStrArr[0]), Integer.parseInt(bagStrArr[1]));
			gems[i] = gem;
		}
		
		for(int i=0; i<K; i++) {
			Integer weight = Integer.parseInt(br.readLine());
			bags[i] = weight;
		}
		
		
		// 정렬		
		// 보석 - 무게를 위주로 오름차순 
		Arrays.sort(gems, (o1, o2) -> Integer.compare(o1.w, o2.w));
		
		// 가방 오름차순
		Arrays.sort(bags);
		
	
		for(int i=0; i<N; i++) {
			System.out.print(gems[i]+" ");
		}
		System.out.println("");
		for(int i=0; i<K; i++) {
			System.out.print(bags[i]+" ");
		}
		System.out.println("");
	
		
		PriorityQueue<Gem> gemQ = new PriorityQueue<>(Collections.reverseOrder());
		
		boolean[] visited = new boolean[N];

		for(int i=0; i<K; i++) {
			System.out.println("BAG["+bags[i]+"]");
			for(int j=0; j<N; j++) {
				System.out.print("BAG["+bags[i]+"]/GEM["+gems[j]+"]");
				
				if(visited[gems[j].id]) continue;
				
				if(bags[i] >= gems[j].w) {
					gemQ.offer(gems[j]);
					System.out.println("");
				} else {
					break;
				}
//				else {
//					System.out.println("=> break");
//					g = j;
//					break;
//				}							
			}
			if(!gemQ.isEmpty()) {
				Gem polled = gemQ.poll();
				visited[polled.id] = true;
				System.out.println("poll => " + polled);
				maxValue += polled.v;
			}	
		}

		System.out.println(maxValue);
		
		//solution(0, new boolean[gems.length], 0, 0);
	}
	
	
	static public void solution(int gemDepth, boolean[] visited, int bagDepth, int value) {
		
		if(bagDepth == bags.length || gemDepth == gems.length) {
			if(value >= maxValue) {
				maxValue = value;
			}
			return;
		}
				
		//value = value + gems[depth].v;
		if(gems[gemDepth].w <= bags[bagDepth]) {
			visited[gemDepth] = true;			
			solution(gemDepth+1, visited, bagDepth+1, value + gems[gemDepth].v);
		}		
		
		visited[gemDepth] = false;
		solution(gemDepth+1, visited, bagDepth, value);
	}
	

	static class Gem implements Comparable<Gem> {
		private int id;
		private int w;
		private int v;
		public Gem(int id, int w, int v) {
			this.id = id; this.w = w; this.v = v;
		}
		public String toString() {
			return "id:"+this.id+"/w:"+this.w+"/v:"+this.v;
		}
		
		@Override
	    public int compareTo(Gem gem) {
	        return this.v <= gem.v ? -1: 1;
	    }
	}
	
}

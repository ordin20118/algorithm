package gwang.baekjoon.level.bronze;

import java.util.Scanner;

public class baekjoon_2798 {
	
	static int answer = 0;
	static int M;
	static int N;
	
	public static void main(String[] args) {		
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();

		int[] cards = new int[N];
		
		for(int i=0; i<N; i++) {
			cards[i] = sc.nextInt();
		}
		
		dfs(cards, 0, 0, 0, "");
		
		//newDfs(cards, 0, 0, 0, 0, new boolean[cards.length]);
		
		
		System.out.println(""+answer+"");
		
	}
	
	// selected: for debug
	static public void dfs(int[] cards, int depth, int cnt, int sum, String selected) {
	
		//System.out.println("selected:[" + selected + "] 			| cnt:["+cnt+"] | sum:["+sum+"]");
		
		if(sum > M) {
			return;
		}
		
		if(depth == N || cnt >= 3) {
			//System.out.println("[[RES]] => selected:[" + selected + "]/ cnt:["+cnt+"] / depth:["+depth+"]");	
			if(cnt == 3) {
				answer = Math.max(answer, sum);
			}
			return;
		}
		
		
		for(int i=0; i<2; i++) {
			if(i == 0) {
				//sum += cards[depth];				
				String newSelected = selected + " " + cards[depth];
				dfs(cards, depth+1, cnt+1, sum+cards[depth], newSelected);				
			} else {			
				dfs(cards, depth+1, cnt, sum, selected);				
			}
		}
		
	}
}

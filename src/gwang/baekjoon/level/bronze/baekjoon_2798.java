package gwang.baekjoon.level.bronze;

import java.util.Scanner;

public class baekjoon_2798 {
	
	static int answer = 0;

	public static void main(String[] args) {		
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] cards = new int[N];
		
		for(int i=0; i<N; i++) {
			cards[i] = sc.nextInt();
		}
		
		dfs(cards, 0, 0, 0, M, "");
		
		System.out.println("answer:["+answer+"]");
		
	}
	
	static public void dfs(int[] cards, int depth, int cnt, int sum, int blackjack, String selected) {
	
		if(depth == cards.length || cnt >= 3) {
			
			if(cnt == 3 && sum <= blackjack && (blackjack-sum) < (blackjack-answer)) {
				answer = sum;
			}
			return;
		}
		
		//System.out.println("" + selected + "/ cnt:["+cnt+"] / depth:["+depth+"]");
		
		for(int i=0; i<2; i++) {
			if(i == 0) {
				sum += cards[depth];				
				String newSelected = selected + " " + cards[depth];
				dfs(cards, depth+1, cnt+1, sum, blackjack, newSelected);				
			} else {			
				dfs(cards, depth+1, cnt, sum, blackjack, selected);				
			}
		}
		
	}
}

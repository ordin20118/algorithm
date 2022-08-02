package gwang.baekjoon.level.bronze;
import java.util.Scanner;

public class test {
	
	static int answer = 0;

	public static void main(String[] args) {		
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] cards = new int[N];
		
		for(int i=0; i<N; i++) {
			cards[i] = sc.nextInt();
		}
		
		dfs(cards, 0, 0, 0, M);
		
		System.out.print(answer);
		
	}
	
	static public void dfs(int[] cards, int depth, int cnt, int sum, int blackjack) {
		
		if(depth == cards.length || cnt == 4 || sum > blackjack) {
			return;
		}
		
		for(int i=0; i<2; i++) {
			if(i == 0) {
				sum += cards[depth];				
				dfs(cards, depth+1, cnt+1, sum, blackjack);	
				sum -= cards[depth];				
			} else {			
				dfs(cards, depth+1, cnt, sum, blackjack);				
			}	
			
			if( (blackjack-sum) < (blackjack-answer) && cnt == 3) {
				answer = sum;
			}
		}	
	}

}


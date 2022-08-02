package gwang.baekjoon.level.bronze;

import java.util.Scanner;

public class baekjoon_5585 {
	
	static int[] coin = {500, 100, 50, 10, 5, 1};
	
	public static void main(String[] args) {		
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();

		System.out.println("N:["+N+"]");
		
		int change = 1000 - N;
		
		System.out.println("change:["+change+"]");
				
		int changeCnt = getChangeCnt(change);
		
		System.out.println("changeCnt:["+changeCnt+"]");
	}
	
	// value: 총 거스름돈 금액
	static public int getChangeCnt(int change) {
		
		int changeCnt = 0;
		
		for(int i=0; i<coin.length; i++) {
			int coinVal = coin[i];
			
			int v = change / coinVal;
			
			if(v >= 1) {
				System.out.println("["+coinVal+"원]:["+v+"개]");
				change = change - (coinVal * v);
				changeCnt += v;
			}
		}
		return changeCnt;
	}
	
	
}

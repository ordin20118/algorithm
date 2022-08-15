package gwang.baekjoon.level.gold;

import java.util.Scanner;

public class baekjoon_12869 {
	
	/**
	 * 문제
	 * 수빈이는 강호와 함께 스타크래프트 게임을 하고 있다. 수빈이는 뮤탈리스크 1개가 남아있고, 강호는 SCV N개가 남아있다.
	 * 각각의 SCV는 남아있는 체력이 주어져있으며, 뮤탈리스크를 공격할 수는 없다. 즉, 이 게임은 수빈이가 이겼다는 것이다.
	 * 뮤탈리스크가 공격을 할 때, 한 번에 세 개의 SCV를 공격할 수 있다.
	 * 첫 번째로 공격받는 SCV는 체력 9를 잃는다.
	 * 두 번째로 공격받는 SCV는 체력 3을 잃는다.
	 * 세 번째로 공격받는 SCV는 체력 1을 잃는다.
	 * SCV의 체력이 0 또는 그 이하가 되어버리면, SCV는 그 즉시 파괴된다. 한 번의 공격에서 같은 SCV를 여러 번 공격할 수는 없다.
	 * 남아있는 SCV의 체력이 주어졌을 때, 모든 SCV를 파괴하기 위해 공격해야 하는 횟수의 최솟값을 구하는 프로그램을 작성하시오.
	 * 
	 * 입력
	 * 첫째 줄에 SCV의 수 N (1 ≤ N ≤ 3)이 주어진다. 둘째 줄에는 SCV N개의 체력이 주어진다. 체력은 60보다 작거나 같은 자연수이다.
	 * 
	 * 출력
	 * 첫째 줄에 모든 SCV를 파괴하기 위한 공격 횟수의 최솟값을 출력한다.
	 * 
	 */
	
	static int[] scv;
	static int N = 0;
	
	static int[][][] dp;	// value = count
	
	static int[] attA = {9,9,3,3,1,1};
	static int[] attB = {3,1,9,1,9,3};
	static int[] attC = {1,3,1,9,3,9};
 
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		dp = new int[61][61][61];
		
		N = sc.nextInt();
		scv = new int[3];
				
		sc.nextLine();
		String[] scvArr = sc.nextLine().split(" ");
		
		
		for(int s=0; s<N; s++) {
			scv[s] = Integer.parseInt(scvArr[s]);			
		}
		
		for(int s=N; s<3; s++) {
			scv[s] = 0;
		}
		
		
		dfs(scv, 0);
		
		System.out.println("" + dp[0][0][0]);

	}
	
	public static void dfs(int[] arr, int count) {
		
		// dp check
		// - 값이 있는지
		// - 있다면 현재 값보다 작은지
		if(dp[arr[0]][arr[1]][arr[2]] > 0) {
			if(dp[arr[0]][arr[1]][arr[2]] > count) {
				dp[arr[0]][arr[1]][arr[2]] = count;
			} else {
				// 뒤늦게 들어온 방식이 결과가 더 안좋은 경우 => 더이상 진행 필요 없음
				return;
			}
		} else {	
			// dp = 0
			dp[arr[0]][arr[1]][arr[2]] = count;
		}
	
		
		// make next
		for(int i=0; i<attA.length; i++) {
			int nA = Math.max(arr[0] - attA[i], 0);
			int nB = Math.max(arr[1] - attB[i], 0);
			int nC = Math.max(arr[2] - attC[i], 0);
			
			dfs(new int[] {nA, nB, nC}, count+1);
		}
		
	}

}

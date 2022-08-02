package gwang.baekjoon.level.silver;

import java.io.IOException;
import java.util.Scanner;

public class baekjoon_15486 {
	
	/*
	 * Dynamic Programming
	 */
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int arr[][] = new int[2][N+2];	// 2를 주지 않으면 메모리 초과
		int dp[] = new int[N+2];		// dp[N] - n일 까지의 최대 임금
		
		for(int i=1; i<=N; i++) {
			int T = sc.nextInt();
			int P = sc.nextInt();
			arr[0][i] = T;
			arr[1][i] = P;			
		}
		
		// 마지막 날에 하루 일 할 수도 있음
		int max = 0;
		for(int i=1; i<=N+1; i++) {
			
			max = Math.max(max, dp[i]);
			
			int nextDay = i + arr[0][i];			
			if(nextDay > N+1) {
				continue;
			}			
			dp[nextDay] = Math.max(dp[nextDay], max + arr[1][i]);
			
		}
		
		System.out.println(max);
		
	}
	
	// 재귀로 dp
//	public static int solve(int n) {
//		if(n==0)
//		 return 0;
//		
//		if(dp[n]!=-1)
//			return dp[n]
//	
//		return max(solve(n-1), solve(n-소요시간)+arr[n-소요시간])
//	}

}

package gwang.baekjoon.level.silver;

import java.util.Scanner;

public class baekjoon_1890 {
	
	/*
	 * Dynamic Programming
	 */	
	/*
	 * 점프
	 * 
	 * 문제
	 * N×N 게임판에 수가 적혀져 있다. 이 게임의 목표는 가장 왼쪽 위 칸에서 가장 오른쪽 아래 칸으로 규칙에 맞게 점프를 해서 가는 것이다.
     * 각 칸에 적혀있는 수는 현재 칸에서 갈 수 있는 거리를 의미한다. 반드시 오른쪽이나 아래쪽으로만 이동해야 한다. 
     * 0은 더 이상 진행을 막는 종착점이며, 항상 현재 칸에 적혀있는 수만큼 오른쪽이나 아래로 가야 한다. 
     * 한 번 점프를 할 때, 방향을 바꾸면 안 된다. 즉, 한 칸에서 오른쪽으로 점프를 하거나, 아래로 점프를 하는 두 경우만 존재한다.
     * 가장 왼쪽 위 칸에서 가장 오른쪽 아래 칸으로 규칙에 맞게 이동할 수 있는 경로의 개수를 구하는 프로그램을 작성하시오.
     *
	 * 입력
	 * 첫째 줄에 게임 판의 크기 N (4 ≤ N ≤ 100)이 주어진다. 그 다음 N개 줄에는 각 칸에 적혀져 있는 수가 N개씩 주어진다. 
	 * 칸에 적혀있는 수는 0보다 크거나 같고, 9보다 작거나 같은 정수이며, 가장 오른쪽 아래 칸에는 항상 0이 주어진다.
	 * 
	 * 출력
	 * 가장 왼쪽 위 칸에서 가장 오른쪽 아래 칸으로 문제의 규칙에 맞게 갈 수 있는 경로의 개수를 출력한다. 경로의 개수는 263-1보다 작거나 같다.
	 * 
	 * 
	 */
	static int N = 0;
	static int map[][] = null;	
	static long dp[][] = null;
	static int count = 0;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();		
		map = new int[N][N];		
		dp = new long[N][N];	// => long 안하면 경의수가 많은 경우 틀림
		dp[0][0] = 1;
				
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
			
		// dp
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				
				// 종점이거나 맵의 끝이면 패스
				if((i == N-1 && j == N-1) || dp[i][j] == 0) {
					continue;
				}
				
				int moveCnt = map[i][j];
				int down = i + moveCnt;
				int right = j + moveCnt;
				
				if(down <= N-1) {
					dp[down][j] += dp[i][j];
				}
				
				if(right <= N-1) {
					dp[i][right] += dp[i][j];
				}
			}
		}		
		System.out.println("[경로]:" + dp[N-1][N-1] +" 개");
		
		//dfs(0,0);		
		//System.out.println("[경로]:" + count +" 개");
				
	}
	
	
	// 시간 초과
	public static void dfs(int i, int j) {
		
		int moveCnt = map[i][j];
		 
		// 끝인지 확인
		if(map[i][j] == 0) {
			count++;
			return;
		}		
		
		// 오른쪽으로
		if(j + moveCnt <= N-1) {
			dfs(i,j+moveCnt);
		}
		
		// 아래쪽으로
		if(i + moveCnt <= N-1) {
			dfs(i+moveCnt,j);
		}
		
	}

}

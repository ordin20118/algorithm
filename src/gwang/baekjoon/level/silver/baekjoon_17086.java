package gwang.baekjoon.level.silver;

import java.util.*;
import java.io.*;

public class baekjoon_17086 {
	
	
	/**
	 * 
	 * 문제 
	 * N×M 크기의 공간에 아기 상어 여러 마리가 있다. 공간은 1×1 크기의 정사각형 칸으로 나누어져 있다. 
	 * 한 칸에는 아기 상어가 최대 1마리 존재한다.
	 * 어떤 칸의 안전 거리는 그 칸과 가장 거리가 가까운 아기 상어와의 거리이다. 
	 * 두 칸의 거리는 하나의 칸에서 다른 칸으로 가기 위해서 지나야 하는 칸의 수이고, 
	 * 이동은 인접한 8방향(대각선 포함)이 가능하다.
	 * 안전 거리가 가장 큰 칸을 구해보자. 
	 * 
	 * 입력 
	 * 첫째 줄에 공간의 크기 N과 M(2 ≤ N, M ≤ 50)이 주어진다. 
	 * 둘째 줄부터 N개의 줄에 공간의 상태가 주어지며, 0은 빈 칸, 1은 아기 상어가 있는 칸이다. 
	 * 빈 칸과 상어의 수가 각각 한 개 이상인 입력만 주어진다.
	 * 
	 * 출력
	 * 첫째 줄에 안전 거리의 최댓값을 출력한다.
	 * 
	 */
	
	static int N;
	static int M;
	
	static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
	static int[] dy = {0, 0, -1, 1, -1, 1, 1, -1};
	
	static int[][] map;
	static int max = 0;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][M];
		
		sc.nextLine();
		
		for(int i=0; i<N; i++) {
			String[] arr = sc.nextLine().split(" ");
			for(int j=0; j<arr.length; j++) {
				map[i][j] = Integer.parseInt(arr[j]);
			}
		}
		
		for(int n=0; n<N; n++) {
			for(int m=0; m<M; m++) {
				if(map[n][m] == 0) {
					bfs(n, m);
				}
			}
		}
		
		System.out.println(max);
		
	}
	
	public static void bfs(int n, int m) {
		
		boolean[][] visitedL = new boolean[N][M];
		Queue<Step> queue = new LinkedList<>();
		
		Step first = new Step(n, m, 0);
		queue.add(first);
		visitedL[n][m] = true;
		
		int min = 100000;
		
		while(!queue.isEmpty()) {
			
			Step now = queue.poll();
			
			
			// 상어 발견
			if(map[now.row][now.col] == 1) {
				min = Math.min(now.cnt, min);
				continue;
			}
			
			if(now.cnt > min) {
				continue;
			}
			
			// 추가 할 수있는 방향
			for(int i=0; i<dx.length; i++) {
				int nRow = now.row + dy[i];
				int nCol = now.col + dx[i];
				
				if(validate(nRow, nCol) && !visitedL[nRow][nCol]) {
					visitedL[nRow][nCol] = true;
					queue.add(new Step(nRow, nCol, now.cnt+1));	
				}								
			}
			
		}
		
		max = Math.max(max, min);
	}
	
	static boolean validate(int n, int m) {
		if(n >= 0 && n < N && m >= 0 && m < M) {
			return true;
		}
		return false;
	}
	
	static class Step{
		int row;
		int col;
		int cnt;
		Step(int row, int col, int cnt) {
			this.row = row; this.col = col; this.cnt = cnt;
		}
	}

}

package gwang.baekjoon.level.gold;

import java.util.*;

public class baekjoon_16236 {
	
	/**
	 * 
	 * 문제 
	 * N×N 크기의 공간에 물고기 M마리와 아기 상어 1마리가 있다. 공간은 1×1 크기의 정사각형 칸으로 나누어져 있다. 한 칸에는 물고기가 최대 1마리 존재한다.
	 * 아기 상어와 물고기는 모두 크기를 가지고 있고, 이 크기는 자연수이다. 가장 처음에 아기 상어의 크기는 2이고, 아기 상어는 1초에 상하좌우로 인접한 한 칸씩 이동한다.
	 * 아기 상어는 자신의 크기보다 큰 물고기가 있는 칸은 지나갈 수 없고, 나머지 칸은 모두 지나갈 수 있다. 
	 * 아기 상어는 자신의 크기보다 작은 물고기만 먹을 수 있다. 따라서, 크기가 같은 물고기는 먹을 수 없지만, 그 물고기가 있는 칸은 지나갈 수 있다.
	 * 아기 상어가 어디로 이동할지 결정하는 방법은 아래와 같다.
	 * 더 이상 먹을 수 있는 물고기가 공간에 없다면 아기 상어는 엄마 상어에게 도움을 요청한다.
	 * 먹을 수 있는 물고기가 1마리라면, 그 물고기를 먹으러 간다.
	 * 먹을 수 있는 물고기가 1마리보다 많다면, 거리가 가장 가까운 물고기를 먹으러 간다.
	 * 거리는 아기 상어가 있는 칸에서 물고기가 있는 칸으로 이동할 때, 지나야하는 칸의 개수의 최솟값이다.
	 * 거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.
	 * 아기 상어의 이동은 1초 걸리고, 물고기를 먹는데 걸리는 시간은 없다고 가정한다. 즉, 아기 상어가 먹을 수 있는 물고기가 있는 칸으로 이동했다면, 
	 * 이동과 동시에 물고기를 먹는다. 물고기를 먹으면, 그 칸은 빈 칸이 된다.
	 * 아기 상어는 자신의 크기와 같은 수의 물고기를 먹을 때 마다 크기가 1 증가한다. 예를 들어, 크기가 2인 아기 상어는 물고기를 2마리 먹으면 크기가 3이 된다.
	 * 공간의 상태가 주어졌을 때, 아기 상어가 몇 초 동안 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는지 구하는 프로그램을 작성하시오.
	 * 
	 * 
	 * 입력 
	 * 첫째 줄에 공간의 크기 N(2 ≤ N ≤ 20)이 주어진다.
	 * 둘째 줄부터 N개의 줄에 공간의 상태가 주어진다. 공간의 상태는 0, 1, 2, 3, 4, 5, 6, 9로 이루어져 있고, 아래와 같은 의미를 가진다.
	 * 0: 빈 칸
	 * 1, 2, 3, 4, 5, 6: 칸에 있는 물고기의 크기
	 * 9: 아기 상어의 위치
	 * 아기 상어는 공간에 한 마리 있다.
	 * 
	 * 출력 
	 * 첫째 줄에 아기 상어가 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는 시간을 출력한다.
	 * 
	 * 
	 */

	
	public static int N;
	public static int M = 0;	// 물고기 수
	
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,-1,1};
	
	public static int[][] map;
	
	public static int time = 0;
	
	
	// 상어의 상태
	public static int nowSize = 2;
	public static int eatCnt = 0;
	public static int nowRow;
	public static int nowCol;
	
	public static boolean isFinish = false;
		
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];

		sc.nextLine();
		for(int i=0; i<N; i++) {
			String[] arr = sc.nextLine().split(" ");
			for(int j=0; j<arr.length; j++) {
				int val = Integer.parseInt(arr[j]);
				map[i][j] = val;
				if(val == 9) {
					nowRow = i;
					nowCol = j;
				}
				if(val > 0 && val != 9) {
					M++;
				}
			}
		}
		
		if(M == 0) {
			System.out.println(0);
			return;
		}
		
		// game start
		while(!isFinish) {			
			
			bfs(nowRow, nowCol);
			
			if(M == 0) break;
			
		}
		
		System.out.println(time);

	}
	
	public static void bfs(int row, int col) {
		
		boolean[][] visited = new boolean[N][N];
		Queue<Step> queue = new LinkedList<>();
		
		Step first = new Step(row, col, 0);
		queue.add(first);
		visited[row][col] = true;
		
		boolean findFish = false;
		int min = 100000;
		int mRow = -1;
		int mCol = -1;
		
		// scan
		while(!queue.isEmpty()) {
			
			Step now = queue.poll();
			
			// 물고기를 찾은 경우
			if(map[now.row][now.col] > 0 && map[now.row][now.col] != 9) {

				// 먹을 수 있는 물고기
				if(map[now.row][now.col] < nowSize) {
					
					// 최소인지 확인
					if(min == now.moveCnt) {
						if(mRow > now.row) {
							mRow = now.row;
							mCol = now.col;							
						} else if(mRow == now.row) {
							if(mCol > now.col) {
								mRow = now.row;
								mCol = now.col;	
							}
						}
					} else if(min > now.moveCnt) {
						min = now.moveCnt;
						mRow = now.row;
						mCol = now.col;
						findFish = true;
					}
				}
			}

			if(now.moveCnt > min) {
				continue;
			}
			
			// 다음 이동
			for(int i=0; i<dx.length; i++) {
				int nRow = now.row + dy[i];
				int nCol = now.col + dx[i];
				
				if(validate(nRow, nCol) && !visited[nRow][nCol] && map[nRow][nCol] <= nowSize) {
					queue.add(new Step(nRow, nCol, now.moveCnt + 1));
					// 방문처리
					visited[nRow][nCol] = true;
				}
			}
		}
		
		// check find fish
		if(findFish) {
			// update state
			M--;
			map[nowRow][nowCol] = 0;
			map[mRow][mCol] = 0;
			nowRow = mRow;
			nowCol = mCol;
			eatCnt++;
			if(eatCnt == nowSize) {
				nowSize++;
				eatCnt = 0;
			}
			time += min;
		} else {
			isFinish = true;
		}
		
		
	}
	
	public static boolean validate(int row, int col) {
		if(row >= 0 && row < N && col >= 0 && col < N) {
			return true;
		}
		return false;
	}
	
	static class Step {
		int row;
		int col;
		int moveCnt;
		Step(int row, int col, int moveCnt) {
			this.row = row; this.col = col; this.moveCnt = moveCnt;
		}
	}

}

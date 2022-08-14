package gwang.baekjoon.level.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon_1743 {

	/*
	 * BFS
	 * 
	 * 코레스코 콘도미니엄 8층은 학생들이 3끼의 식사를 해결하는 공간이다. 그러나 몇몇 비양심적인 학생들의 만행으로 음식물이 통로 중간 중간에 떨어져 있다. 이러한 음식물들은 근처에 있는 것끼리 뭉치게 돼서 큰 음식물 쓰레기가 된다. 

		이 문제를 출제한 선생님은 개인적으로 이러한 음식물을 실내화에 묻히는 것을 정말 진정으로 싫어한다. 참고로 우리가 구해야 할 답은 이 문제를 낸 조교를 맞추는 것이 아니다. 
		
		통로에 떨어진 음식물을 피해가기란 쉬운 일이 아니다. 따라서 선생님은 떨어진 음식물 중에 제일 큰 음식물만은 피해 가려고 한다. 
		
		선생님을 도와 제일 큰 음식물의 크기를 구해서 “10ra"를 외치지 않게 도와주자.
	*  
	*/
	
	static int[][] map = null;
	static boolean[][] visited = null;
	static int N = 0, M = 0, K = 0;
	
	static int tmpCnt = 0;
	
	static int dx[] = { 1,-1,0,0 };
	static int dy[] = { 0,0,1,-1 };
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		sc.nextLine();
		
		for(int k=1; k<=K; k++) {
			
			String mapStr = sc.nextLine();
			
			System.out.println(mapStr);
			
			String[] mapArr = mapStr.split(" ");
			
			int r = Integer.parseInt(mapArr[0])-1;
			int c = Integer.parseInt(mapArr[1])-1;
			
			map[r][c] = 1;
		}
				
		
				
		printMap();
		
		scan();

	}
	
	public static void scan() {
		
		int max = 0;
		
		for(int r=0; r<map.length; r++) {
			for(int c=0; c<map[0].length; c++) {
				
				if(visited[r][c] == true) {
					continue;
				}
				
				visited[r][c] = true;
				
				if(map[r][c] == 1) {
					tmpCnt = 1;
					findTrash(r, c);
					System.out.println("[새로 발견된 크기]: " + tmpCnt);
					if(tmpCnt >= max) {
						max = tmpCnt;						
					}
				}
				
			}
		}
		
		System.out.println("[최대 크기]: " + max);
	}
	
	public static void findTrash(int r, int c) {
		
		// 주변 탐색
		for(int i=0; i<dx.length; i++) {
			int nextR = r + dx[i];
			int nextC = c + dy[i];
			
			// 맵 범위 확인
			if(nextR < N && nextR >= 0 && nextC < M && nextC >= 0) {
				// 방문 확인 및 방문 처리
				if(visited[nextR][nextC] == true) {
					continue;
				}
				
				visited[nextR][nextC] = true;
				
				// 쓰레기 여부 확인
				if(map[nextR][nextC] == 1) {
					tmpCnt++;
					findTrash(nextR, nextC);
				}
				
			}
			
		}
		
	}
	
	public static void printMap() {		
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.print("\n");
		}
	}

}


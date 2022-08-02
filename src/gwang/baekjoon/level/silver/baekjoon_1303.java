package gwang.baekjoon.level.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon_1303 {

	/*
	 * BFS
	 * 
	 * 문제
	 * 전쟁은 어느덧 전면전이 시작되었다. 결국 전투는 난전이 되었고, 우리 병사와 적국 병사가 섞여 싸우게 되었다. 
	 * 그러나 당신의 병사들은 흰색 옷을 입고, 적국의 병사들은 파란색 옷을 입었기 때문에 서로가 적인지 아군인지는 구분할 수 있다. 
	 * 문제는 같은 팀의 병사들은 모이면 모일수록 강해진다는 사실이다.
	   N명이 뭉쳐있을 때는 N^2의 위력을 낼 수 있다. 과연 지금 난전의 상황에서는 누가 승리할 것인가? 
	     단, 같은 팀의 병사들이 대각선으로만 인접한 경우는 뭉쳐 있다고 보지 않는다.
	*  
	*  입력
	*  첫째 줄에는 전쟁터의 가로 크기 N, 세로 크기 M(1 ≤ N, M ≤ 100)이 주어진다. 
	*  그 다음 두 번째 줄에서 M+1번째 줄에는 각각 (X, Y)에 있는 병사들의 옷색이 띄어쓰기 없이 주어진다. 
	*  모든 자리에는 병사가 한 명 있다. 
	*  B는 파란색, W는 흰색이다. 당신의 병사와 적국의 병사는 한 명 이상 존재한다.
	*  	  
	*  출력
	*  첫 번째 줄에 당신의 병사의 위력의 합과 적국의 병사의 위력의 합을 출력한다.
	*  
	*  주의
	*  N,M x,y 가로 세로 제대로 확인해야함
	*  
	*/
	
	static String[][] map = null;
	static boolean[][] visited = null;
	static int wScore = 0, bScore = 0;
	
	static int N = 0, M = 0;	
	static int dx[] = { 1,-1,0,0 };
	static int dy[] = { 0,0,1,-1 };
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new String[M+1][N+1];
		visited = new boolean[M+1][N+1];
				
		for(int i=1; i<=M; i++) {
			
			String mapStr = sc.next();
			String[] mapArr = mapStr.split("");
			
			for(int j=0; j<mapArr.length; j++) {
				map[i][j+1] = mapArr[j];
			}
		}
				
		printMap();
		
		// map 전체를 확인하는 로직
		for(int i=1; i<map.length; i++) {
			for(int j=1; j<map[1].length; j++) {
				if(visited[i][j] == false) {
					bfs(i,j);	
				}				
			}
		}		

		System.out.println("[w]:"+wScore+"/[b]:"+bScore);
	}
		
	public static void bfs(int x, int y) {
		
		// 시작 노드 추가
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x,y));
		visited[x][y] = true;
		
		String team = map[x][y];
		
		// 총 합
		int number = 1;
		
		while(!queue.isEmpty()) {
			
			// 노드 하나를 가져옴
			Point nowP = queue.poll();
			
			for(int i=0; i<dx.length; i++) {
				
				int nextX = nowP.x + dx[i];
				int nextY = nowP.y + dy[i];
				
				// 맵의 내부인지 확인
				if(nextX > 0 && nextX <= M && nextY > 0 && nextY <= N) {
					
					// 같은 팀인지 확인 + 방문한 노드인지 확인
					if(team.equals(map[nextX][nextY]) && visited[nextX][nextY] == false) {
						// 뭉쳐진 인원수 추가
						number++;
						// 큐에 추가
						queue.add(new Point(nextX, nextY));
						// 방문 처리
						visited[nextX][nextY] = true;
					}					
				}
			}
		}
		
		// 제곱의 값을 합함
		if(team.equals("W")) {
			wScore += (number * number);
		} else {
			bScore += (number * number);
		}
	}
	
	public static void printMap() {		
		for(int i=1; i<map.length; i++) {
			for(int j=1; j<map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.print("\n");
		}
	}

}

class Point {
	int x;
	int y;
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

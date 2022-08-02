package gwang.baekjoon.level.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon_2178 {

	/*
	 * BFS
	 * 
	 * 문제
	 * N×M크기의 배열로 표현되는 미로가 있다.
		1	0	1	1	1	1
		1	0	1	0	1	0
		1	0	1	0	1	1
		1	1	1	0	1	1
	     미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 
	     이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는
	     최소의 칸 수를 구하는 프로그램을 작성하시오. 
	     한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
	     위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.
	*  
	*  입력
	*  첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 
	*  각각의 수들은 붙어서 입력으로 주어진다.
	*  	  
	*  출력
	*  첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.
	*  
	*/
	
	static int[][] map = null;
	static int[][] distance = null;
	static boolean[][] visited = null;
	static int N = 0, M = 0;
	
	static int dx[] = { 1,-1,0,0 };
	static int dy[] = { 0,0,1,-1 };
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N+1][M+1];
		distance = new int[N+1][M+1];
		visited = new boolean[N+1][M+1];
				
		for(int i=1; i<=N; i++) {
			
			String mapStr = sc.next();
			String[] mapArr = mapStr.split("");
			
			for(int j=0; j<mapArr.length; j++) {
				map[i][j+1] = Integer.parseInt(mapArr[j]);
			}
		}
				
		printMap();
		
		findTarget();

	}
	
	/*
	 *  BFS 활용 => 큐 사용
	 */
	public static void findTarget() {
		
		// 큐 생성, 첫 번째 노드 삽입
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(1,1));
		visited[1][1] = true;
		
		// 2. 인접한 길 확인
		while(!queue.isEmpty()) {
			
			Point nowPoint = queue.poll();
			distance[nowPoint.x][nowPoint.y] += 1;
			
			for(int i=0; i<dx.length; i++) {
				int nextX = nowPoint.x + dx[i];
				int nextY = nowPoint.y + dy[i];
				
				// 다음 길이 맵 내의 범위 인가?
				if(nextX > 0 && nextX <= N && nextY > 0 && nextY <= M) {
					
					// 다음 길이 갈 수 있는 곳인가? + 방문하지 않은 곳인가?
					if(map[nextX][nextY] != 0 && visited[nextX][nextY] == false) {
						// 신규 노드 큐에 삽입
						queue.add(new Point(nextX, nextY));
						// 시작으로부터 이동 거리
						distance[nextX][nextY] += distance[nowPoint.x][nowPoint.y];
						// 방문 처리
						visited[nextX][nextY] = true;
					}					
				}				
			}			
		}
		
		System.out.println("[최단 거리]: " + distance[N][M]);
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


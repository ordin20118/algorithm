package gwang.baekjoon.level.gold;

import java.util.*;
import java.io.*;

public class baekjoon_2636 {
	
	/**
	 * 처음에 바깥 공기와 안쪽 공기를 구별하려고 하다보니 문제를 해결하지 못했다.
	 * BFS로 바깥 공기의 연결된 모두를 visited에 표시하고 다시 치즈들의 위치를 확인해
	 * 바깥 공기와 인접해 있는 치즈만 녹이면 된다.
	 * 
	 * 	5 5
		0 0 0 0 0
		0 1 1 0 0
		0 1 0 1 0
		0 1 1 1 0
		0 0 0 0 0
		
		위의 경우 이전 치즈 개수가 0인 문제 있었음...
	 */
	
	static int dx[] = { 1,-1,0,0 };
	static int dy[] = { 0,0,1,-1 };
	
	static int[][] visited;

	static int[][] map;
	
	static int height, width;
	static int time = 0;
	static int leftCheese = 0;
	static boolean isFinish = false;
	
	public static void main(String[] args) {
				
		Scanner sc = new Scanner(System.in);
		
		height = sc.nextInt();
		width = sc.nextInt();
		sc.nextLine();
		
		map = new int[height][width];
		
		for(int i=0; i<height; i++) {
			String line = sc.nextLine();
			String[] tables = line.split(" ");
			for(int j=0; j<tables.length; j++) {				
				map[i][j] = Integer.parseInt(tables[j]);
			}			
		}
		
		while(!isFinish) {
			
			findOutsideAir();
			meltCheese();	
			
		}

	}
	
	// 바깥 공기를 모두 표시 => bfs
	public static void findOutsideAir() {
		
		Queue<Map> queue = new LinkedList<>();
		
		Map first = new Map(0,0);
		queue.add(first);
		
		int[][] visitedLocal = new int[height][width];
	
		while(!queue.isEmpty()) {
			
			Map now = queue.poll();
			
			if(map[now.row][now.col] == 0 && visitedLocal[now.row][now.col] != 1) {
				visitedLocal[now.row][now.col] = 1;
			} else {
				continue;
			}
			
			// add next node
			for(int i=0; i<dx.length; i++) {
				int nextRow = now.row + dy[i];
				int nextCol = now.col + dx[i];
				
				// map 범위 확인 
				if(nextRow >= 0 && nextRow < height
					&& nextCol >= 0 && nextCol < width) {
					
					Map next = new Map(nextRow, nextCol);
					queue.add(next);
					
				}				
			}
		}
		visited = visitedLocal;
	}
	
	// 치즈 녹이기
	public static void meltCheese() {
		
		time++;
		
		int total = 0;
		int melted = 0;
		
		Queue<Map> deleteQueue = new LinkedList<>();
		
		// scan
		for(int r=0; r<height; r++) {
			for(int c=0; c<width; c++) {
				if(map[r][c] == 1) {
					total++;
					// 바깥 공기와 인접한지 확인
					boolean findAir = false;
					for(int i=0; i<dx.length; i++) {
						if(visited[r+dy[i]][c+dx[i]] == 1) {
							findAir = true;
							break;
						}
					}
					if(findAir) {						
						deleteQueue.add(new Map(r,c));
					}
				}
			}
		}
		
		// melt
		while(!deleteQueue.isEmpty()) {
			melted++;
			Map xy = deleteQueue.poll();
			map[xy.row][xy.col] = 0;
		}

		int prevLeftCheese = leftCheese;
		leftCheese = total - melted;
		
		if(leftCheese == 0) {
			isFinish = true;
			System.out.println(time);
			if(prevLeftCheese == 0) {
				System.out.println(melted);	
			} else {
				System.out.println(prevLeftCheese);
			}
		}
		
	}
	
	static class Map {
		int row;
		int col;
		Map(int row, int col) {
			this.row = row; this.col = col;
		}
	}

}

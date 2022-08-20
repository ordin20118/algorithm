package gwang.baekjoon.level.silver;

import java.util.*;
import java.io.*;

public class baekjoon_4963 {
	
	static int w, h; 
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = {-1,1,0,0,-1,1,-1,1};
	static int[] dy = {0,0,-1,1,-1,1,1,-1};
	
	static int count = 0;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = null;
		while((line = br.readLine()) != null) {
			
			
			String[] sizeArr = line.split(" ");
			w = Integer.parseInt(sizeArr[0]);
			h = Integer.parseInt(sizeArr[1]);
			
			map = new int[h][w];
			visited = new boolean[h][w];
			count = 0;
			
			
			
			if(w == 0 && h == 0) break;
			
			for(int i=0; i<h; i++) {
				String[] arr = br.readLine().split(" ");
				for(int j=0; j<w; j++) {
					map[i][j] = Integer.parseInt(arr[j]);
				}
			}
			
			
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						bfs(i, j);
					}
				}
			}
			
			System.out.println("" + count);	
			
		}

	}
	
	public static void bfs(int row, int col) {
		
		count++;
		
		Queue<Step> queue = new LinkedList<>();
		
		Step first = new Step(row, col, map[row][col]);
		visited[row][col] = true;
		queue.add(first);
		
		
		while(!queue.isEmpty()) {
			
			Step now = queue.poll();
			
			if(now.val == 0) {
				continue;
			}
			
			for(int i=0; i<dx.length; i++) {
				int nRow = now.row + dy[i];
				int nCol = now.col + dx[i];
				
				if(validate(nRow, nCol) && map[nRow][nCol] != 0 && !visited[nRow][nCol]) {
					Step next = new Step(nRow, nCol, map[nRow][nCol]);
					visited[nRow][nCol] = true;
					queue.add(next);
					
				}
			}
			
		}
		
	}
	
	public static boolean validate(int row, int col) {
		if(row >= 0 && row < h && col >= 0 && col < w) {
			return true;
		}
		return false;
	}
	
	static class Step {
		int row;
		int col;
		int val;
		Step(int row, int col, int val) {
			this.row = row; this.col = col; this.val = val;
		}
	}

}

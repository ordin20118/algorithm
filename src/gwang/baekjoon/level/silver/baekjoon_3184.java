package gwang.baekjoon.level.silver;

import java.util.*;
import java.io.*;

public class baekjoon_3184 {
	
	/**
	 * 
	 * 
	 * 문제
	 * 
	 * 미키의 뒷마당에는 특정 수의 양이 있다. 그가 푹 잠든 사이에 배고픈 늑대는 마당에 들어와 양을 공격했다.
	 * 마당은 행과 열로 이루어진 직사각형 모양이다. 글자 '.' (점)은 빈 필드를 의미하며, 글자 '#'는 울타리를, 
	 * 'o'는 양, 'v'는 늑대를 의미한다.
	 * 한 칸에서 수평, 수직만으로 이동하며 울타리를 지나지 않고 다른 칸으로 이동할 수 있다면, 두 칸은 같은 영역 안에 속해 있다고 한다. 마당에서 "탈출"할 수 있는 칸은 어떤 영역에도 속하지 않는다고 간주한다.
	 * 다행히 우리의 양은 늑대에게 싸움을 걸 수 있고 영역 안의 양의 수가 늑대의 수보다 많다면 이기고, 늑대를 우리에서 쫓아낸다. 
	 * 그렇지 않다면 늑대가 그 지역 안의 모든 양을 먹는다.
	 * 맨 처음 모든 양과 늑대는 마당 안 영역에 존재한다.
	 * 아침이 도달했을 때 살아남은 양과 늑대의 수를 출력하는 프로그램을 작성하라.
	 * 
	 * 
	 * 입력
	 * 첫 줄에는 두 정수 R과 C가 주어지며(3 ≤ R, C ≤ 250), 각 수는 마당의 행과 열의 수를 의미한다.
	 * 다음 R개의 줄은 C개의 글자를 가진다. 이들은 마당의 구조(울타리, 양, 늑대의 위치)를 의미한다.
	 * 
	 * 출력
	 * 하나의 줄에 아침까지 살아있는 양과 늑대의 수를 의미하는 두 정수를 출력한다.
	 * 
	 * 
	 */

	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static int R;
	static int C;
	static String[][] map;
	static boolean[][] visited;
	
	static int sheep;
	static int wolf;
	
	public static void main(String[] args) throws IOException {

		sheep = 0; wolf = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] arr = br.readLine().split(" ");
		R = Integer.parseInt(arr[0]);	C = Integer.parseInt(arr[1]);
		
		map = new String[R][C];
		visited = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			String[] colArr = br.readLine().split("");
			for(int j=0; j<C; j++) {
				map[i][j] = colArr[j];
			}
		}
		
//		for(int i=0; i<R; i++) {
//			for(int j=0; j<C; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println(" ");
//		}
//		System.out.println(" ");
		
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(!visited[i][j] && !map[i][j].equals("#") ) {
					dfs(i,j);
				}
			}
		}
		
		System.out.println(sheep+" "+wolf);
		
	}
	
	public static void dfs(int row, int col) {
		
		Queue<Info> queue = new LinkedList<>();
		
		Info first = new Info(row, col, map[row][col]);
		queue.add(first);
		visited[row][col] = true;
		
		int sCnt = 0, wCnt = 0;
		
		while(!queue.isEmpty()) {
			
			Info now = queue.poll();
			
			if(now.val.equals("o")) {
				sCnt++;
			} else if(now.val.equals("v")) {
				wCnt++;
			} else if(now.val.equals("#")) {
				continue;
			}
			
			for(int i=0; i<dx.length; i++) {
				int nextRow = now.row + dy[i];
				int nextCol = now.col + dx[i];
				
				if(validate(nextRow, nextCol) && !visited[nextRow][nextCol]) {
					Info next = new Info(nextRow, nextCol, map[nextRow][nextCol]);
					queue.add(next);
					visited[nextRow][nextCol] = true;
				}
			}
		}
		
		if(sCnt > wCnt) {
			sheep += sCnt;
		} else {
			wolf += wCnt;
		}
		
		
	}
	
	public static boolean validate(int row, int col) {
		if(row >= 0 && row < R && col >= 0 && col < C) {
			return true;
		}
		return false;
	}
	
	static class Info {
		int row;
		int col;
		String val;
		Info(int row, int col, String val) {
			this.row = row; this.col = col; this.val = val;
		}
	}

}

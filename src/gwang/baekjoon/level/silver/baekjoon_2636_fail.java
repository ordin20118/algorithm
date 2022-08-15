package gwang.baekjoon.level.silver;

import java.util.ArrayList;
import java.util.Scanner;

public class baekjoon_2636_fail {
	
	static int dx[] = { 1,-1,0,0 };
	static int dy[] = { 0,0,1,-1 };

	public static void main(String[] args) {
				
		Scanner sc = new Scanner(System.in);
		
		int height = sc.nextInt();
		int width = sc.nextInt();
		sc.nextLine();
		
		int[][] map = new int[height][width];
		
		for(int i=0; i<height; i++) {
			String line = sc.nextLine();
			String[] tables = line.split(" ");
			for(int j=0; j<tables.length; j++) {				
				map[i][j] = Integer.parseInt(tables[j]);
			}			
		}
		
		
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				System.out.print(map[i][j]);
			}		
			System.out.println("");
		}
		
		
		boolean go = true;
		int prevCheeseCnt = 0;
		int hour = 0;
		while(go) {
			
			int cheeseCnt = 0;			
			ArrayList<Integer> deleteX = new ArrayList<>();
			ArrayList<Integer> deleteY = new ArrayList<>();
			for(int i=1; i<height-1; i++) {
				for(int j=1; j<width-1; j++) {		
					
					if(map[i][j] == 0) {
						continue;
					}
										
					cheeseCnt++;	// 치즈 개수 카운트
					
					// 상하좌우 확인 후 빈곳이 있거나 끝이라면 녹음										
					for(int t=0; t<4; t++) {
						int y = i + dy[t];
						int x = j + dx[t];
						
						if(y <= 1 || y <= 1 || x >= (width-1) || y >= (height-1) || map[y][x] == 0) {
							// 녹게 될 위치 저장
							deleteX.add(j);
							deleteY.add(i);
							//System.out.println("녹을 위치:"+);
							break;							
						}						
					}					
				}
			} // end check
			
			// 치즈 녹임
			hour++;
			for(int d=0; d<deleteX.size(); d++) {
				//System.out.print(map[deleteY.get(d)][deleteX.get(d)] + "=>");
				map[deleteY.get(d)][deleteX.get(d)] = 0;
				//System.out.println(map[deleteY.get(d)][deleteX.get(d)] + "");
			}
			
			// for debug
			System.out.println("");
			for(int i=0; i<height; i++) {
				for(int j=0; j<width; j++) {
					System.out.print(map[i][j]);
				}		
				System.out.println("");
			}
			
			// 남은 치즈 확인
			int leftCnt = cheeseCnt - deleteX.size();
			
			if(leftCnt == 0) {
				go = false;
				System.out.printf(hour+"\n"+cheeseCnt);				
			}
			
		} // end while
		
		

	}

}

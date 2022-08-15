package gwang.baekjoon.level.gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon_14226 {
	
	/**
	 * 문제
	 * 영선이는 매우 기쁘기 때문에, 효빈이에게 스마일 이모티콘을 S개 보내려고 한다.
	 * 영선이는 이미 화면에 이모티콘 1개를 입력했다. 이제, 다음과 같은 3가지 연산만 사용해서 이모티콘을 S개 만들어 보려고 한다.
	 * 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
	 * 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
	 * 화면에 있는 이모티콘 중 하나를 삭제한다.
	 * 모든 연산은 1초가 걸린다. 또, 클립보드에 이모티콘을 복사하면 이전에 클립보드에 있던 내용은 덮어쓰기가 된다. 
	 * 클립보드가 비어있는 상태에는 붙여넣기를 할 수 없으며, 일부만 클립보드에 복사할 수는 없다. 
	 * 또한, 클립보드에 있는 이모티콘 중 일부를 삭제할 수 없다. 
	 * 화면에 이모티콘을 붙여넣기 하면, 클립보드에 있는 이모티콘의 개수가 화면에 추가된다.
	 * 영선이가 S개의 이모티콘을 화면에 만드는데 걸리는 시간의 최솟값을 구하는 프로그램을 작성하시오.
	 * 
	 * 입력
	 * 첫째 줄에 S (2 ≤ S ≤ 1000) 가 주어진다.
	 * 
	 * 출력
	 * 첫째 줄에 이모티콘을 S개 만들기 위해 필요한 시간의 최솟값을 출력한다.
	 *
	 * 힌트 
	 * 화면의 임티 개수와 클리보드의 개수 상태가 같은 상황이 이미 있었다면 최소가 아님.
	 * 
	 */
	
	static int clipBoard = 0;
	static int screen = 1;
	static int minCount = Integer.MAX_VALUE;
	static int S = 0;
	static boolean[][] visited; 

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);		
		S = sc.nextInt();
		visited = new boolean[2001][2001];
		bfs();
		System.out.println(minCount);

	}
	
	public static void bfs() {
		
		Queue<Step> queue = new LinkedList<>();
		
		// 첫 번째 노드 추가
		Step firstN = new Step(1, 0, 0);
		queue.add(firstN);
		
		// 방문 처리
		visited[1][0] = true;
		
		while(!queue.isEmpty()) {

			Step now = queue.poll();
			
			// 현재 화면의 이모티콘 개수 확인
			if(now.screen == S) {
				// 최소값 비교
				minCount = Math.min(minCount, now.time);
				continue;
			}
			
			// 이미 최소값보다 횟수가 넘은 경우
			if(now.time >= minCount) {
				continue;
			}				
			
			// 현재 상황에서 할 수 있는 것 확인 			
			// 1.클립 보드에 복사
			if(now.screen != 0 && now.screen < 2000 
				&& visited[now.screen][now.screen] == false) {
				visited[now.screen][now.screen] = true;
				Step next = new Step(now.screen, now.screen, now.time + 1);
				queue.add(next);
			}
			
			// 2.화면에 붙여넣기
			if(now.clipboard != 0 && now.screen + now.clipboard < 2000 
				&& visited[now.screen+now.clipboard][now.clipboard] == false) {
				visited[now.screen+now.clipboard][now.clipboard] = true;
				Step next = new Step(now.screen + now.clipboard, now.clipboard, now.time + 1);
				queue.add(next);
			}
			
			// 3.화면에서 하나 삭제
			if(now.screen > 0 && visited[now.screen-1][now.clipboard] == false) {
				visited[now.screen-1][now.clipboard] = true;
				Step next = new Step(now.screen - 1, now.clipboard, now.time + 1);
				queue.add(next);
			}
			
		}
		
	}

	
	static class Step {
		int screen;
		int clipboard;
		int time;
		
		Step(int sc, int clip, int t) {
			this.screen = sc; this.clipboard = clip; this.time = t;
		}
		
		public String toString() {
			return this.screen + "/" + this.clipboard + "/" + this.time;
		}
	}

	
}



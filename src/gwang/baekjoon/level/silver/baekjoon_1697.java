package gwang.baekjoon.level.silver;

import java.util.*;
import java.io.*;

public class baekjoon_1697 {
	
	/**
	 * 
	 * 문제 
	 * 수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 
	 * 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다. 
	 * 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 
	 * 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
	 * 수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
	 * 
	 * 입력
	 * 첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.
	 * 
	 * 출력 
	 * 수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.
	 *
	 */

	static int N;
	static int K;
	
	static Step[] visited;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		visited = new Step[100001];
		
		bfs();
		
		System.out.println(visited[K].time);

	}

	public static void bfs() {

		Queue<Step> queue = new LinkedList<>();
		
		// 첫번재 위치 삽입
		Step first = new Step(N, 0);
		queue.add(first);
		visited[N] = first;
		
		while(!queue.isEmpty()) {
			
			Step now = queue.poll();	
			
			
			// 방문 확인
			if(visited[now.position] != null) {
				if(visited[now.position].time >= now.time) {
					visited[now.position] = now;	
				} else {
					continue;
				}
			} else {
				visited[now.position] = now;
			}
			
			// 목적지 도달
			if(now.position == K) {
				continue;
			}
			
			if(visited[K] != null && now.time >= visited[K].time) {
				continue;
			}
			
			// -1
			if(now.position != 0) {
				Step next = new Step(now.position - 1, now.time + 1);
				visited[N] = next;
				queue.add(next);
			}
			
			// +1
			if(now.position < 100000) {
				Step next = new Step(now.position + 1, now.time + 1);
				visited[N] = next;
				queue.add(next);				
			}
			
			// *2
			if(now.position * 2 <= 100000) {
				Step next = new Step(now.position * 2, now.time + 1);
				visited[N] = next;
				queue.add(next);				
			}
		}
		
	}
	
	static class Step {
		int position;
		int time;
		Step (int position, int time) {
			this.position = position; this.time = time;
		}
	}
}

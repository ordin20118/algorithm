package gwang.baekjoon.level.silver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon_1260 {
	
	/* 
	 * BFS, DFS
	 * 
	 * 문제
	 * 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 
	 * 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 
	 * 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
	 * 
	 * 입력
	 * 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 
	 * 탐색을 시작할 정점의 번호 V가 주어진다. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 
	 * 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 
	 * 입력으로 주어지는 간선은 양방향이다.
	 * 
	 * 출력
	 * 첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. 
	 * V부터 방문된 점을 순서대로 출력하면 된다.
	 */
	
	static int[][] nodes = null;
	static boolean visited[] = null;
	static ArrayList<Integer> bfsRes = new ArrayList<>();
	static ArrayList<Integer> dfsRes = new ArrayList<>();

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		
		nodes = new int[N+1][N+1];
		
		// M의 수 많큼 라인 읽기
		for(int i=0; i<M; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();			
			nodes[start][end] = 1;
			nodes[end][start] = 1;
		}
		
		//printNodes();		
		
		visited = new boolean[N+1];		
		bfs(V);
		
		visited = new boolean[N+1];
		dfs(V);
		
		System.out.println("[DFS]: " + dfsRes);
		System.out.println("[BFS]: " + bfsRes);
				
		printRes(dfsRes);
		printRes(bfsRes);
				
	}
	
	public static void printRes(List<Integer> list) {
		for(int i=0; i<list.size(); i++) {
			if((i+1) == list.size()) {
				System.out.print(list.get(i)+"\n");
			} else {
				System.out.print(list.get(i)+" ");	
			}			
		}
	}
	
	/*
	 * 스택을 사용해서 구현 => 재귀함수 사용
	 */
	public static void dfs(int startNum) {
		
		// 1. 방문 처리
		visited[startNum] = true;
		dfsRes.add(startNum);

		// 2. 방문하지 않은 인접 노드 확인
		for(int i=0; i<nodes[startNum].length; i++) {
			if(nodes[startNum][i] == 1 && visited[i] == false) {
				dfs(i);
			}
		}		
	}
	
	
	/*
	 * 큐를 사용해서 구현
	 */
	public static void bfs(int startNum) {		
		// 1. 큐에 초기 시작 노드를 넣는다.		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(startNum);
		visited[startNum] = true;
		bfsRes.add(startNum);
		
		// 반복문 시작
		while(!queue.isEmpty()) {
			//	1. 큐에서 하나의 노드를 꺼낸다.
			Integer nowNode = queue.poll();
			//	2. 해당 노드와 연결되고 방문하지 않은 노드를  방문 처리하고 큐에 넣는다.
			for(int i=0; i<nodes[nowNode].length; i++) {
				if(nodes[nowNode][i] == 1 && visited[i] == false) {
					visited[i] = true;
					queue.add(i);
					bfsRes.add(i);
				}
			}
		}		
	}
	
	
	public static void printNodes() {
		
		for(int i=0; i<nodes.length; i++) {
			for(int j=0; j<nodes[i].length; j++) {
				System.out.print(nodes[i][j] + " ");
			}
			System.out.print("\n");
		}
	}

}

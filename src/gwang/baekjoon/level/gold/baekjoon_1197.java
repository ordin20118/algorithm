package gwang.baekjoon.level.gold;

import java.util.*;
import java.io.*;

public class baekjoon_1197 {
	
	/**
	 * 
	 * 문제 
	 * 그래프가 주어졌을 때, 그 그래프의 최소 스패닝 트리를 구하는 프로그램을 작성하시오.
	 * 최소 스패닝 트리는, 주어진 그래프의 모든 정점들을 연결하는 부분 그래프 중에서 그 가중치의 합이 최소인 트리를 말한다.
	 * 
	 * 입력 
	 * 첫째 줄에 정점의 개수 V(1 ≤ V ≤ 10,000)와 간선의 개수 E(1 ≤ E ≤ 100,000)가 주어진다. 
	 * 다음 E개의 줄에는 각 간선에 대한 정보를 나타내는 세 정수 A, B, C가 주어진다. 
	 * 이는 A번 정점과 B번 정점이 가중치 C인 간선으로 연결되어 있다는 의미이다. C는 음수일 수도 있으며, 
	 * 절댓값이 1,000,000을 넘지 않는다.
	 * 그래프의 정점은 1번부터 V번까지 번호가 매겨져 있고, 임의의 두 정점 사이에 경로가 있다. 
	 * 최소 스패닝 트리의 가중치가 -2,147,483,648보다 크거나 같고, 2,147,483,647보다 작거나 같은 데이터만 입력으로 주어진다.
	 * 
	 * 출력
	 * 첫째 줄에 최소 스패닝 트리의 가중치를 출력한다.
	 * 
	 * kruskal, union find
	 */

	public static int V;
	public static int E;
	
	public static int[] nodes;
	public static Edge[] edges;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] lineArr = br.readLine().split(" ");
		V = Integer.parseInt(lineArr[0]);
		E = Integer.parseInt(lineArr[1]);
		
		nodes = new int[V+1];
		edges = new Edge[E];
		
		for(int i=0; i<E; i++) {
			String[] arr = br.readLine().split(" ");
			edges[i] = new Edge(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
		}
		
		// 오름차순 정렬
		Arrays.sort(edges, (c1, c2) -> Integer.compare(c1.weight,c2.weight));
		
		int finalWeight = 0;
		int root = 0;
		for(Edge e : edges) {
			
			// set
			if(nodes[e.nodeA] == 0) {
				nodes[e.nodeA] = e.nodeA;
			}
			if(nodes[e.nodeB] == 0) {
				nodes[e.nodeB] = e.nodeB;
			}
			
			boolean isUnion = union(e.nodeA, e.nodeB);
			
			if(isUnion) {
				finalWeight += e.weight;
			}
		}
		
		System.out.println(finalWeight);

	}
	
	public static void unionSet(int x) {
		nodes[x] = x;
	}
	
	public static int find(int x) {
		if(nodes[x] == x) {
			return x;
		} else {
			return nodes[x] = find(nodes[x]);
		}
	}

	public static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x == y) return false;
		
		if(x < y) {
			nodes[x] = y;
		} else {
			nodes[y] = x;
		}
		return true;
	}
	
	static class Edge {
		int nodeA;
		int nodeB;
		int weight;
		Edge(int nodeA, int nodeB, int weight) {
			this.nodeA = nodeA;
			this.nodeB = nodeB;
			this.weight = weight;
		}
		
		int getWeight() {
			return this.weight;
		}
	}

}

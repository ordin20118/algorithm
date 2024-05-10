package gwang.programmers.level2;

import java.util.*;

public class programmers_greedy_섬_연결하기 {

	/**
	 * 
	 * 
	 * MST
	 * 
	 * 
	 */
	
	static Edge[] edges;
	static int[] root = new int[100];
	
	public static void main(String[] args) {
		
		int[][] costs = {{0,1,1}, {0,2,2}, {1,2,5}, {1,3,1}, {2,3,8}};
		int answer = 0;
		
		edges = new Edge[costs.length];
		
		for(int i=0; i<costs.length; i++) {
			edges[i] = new Edge(costs[i][0], costs[i][1], costs[i][2]);
			System.out.println(edges[i]);
		}
		
		// 오름차순
		Arrays.sort(edges, (a, b) -> Integer.compare(a.cost, b.cost));
		
		for(int i=0; i<edges.length; i++) {
			Edge nowE = edges[i];
			
			if(root[nowE.nodeA] == 0) {
				setUnion(nowE.nodeA);
			}
			
			if(root[nowE.nodeB] == 0) {
				setUnion(nowE.nodeB);
			}
			
			boolean isUnioned = union(nowE.nodeA, nowE.nodeB);
			
			if(isUnioned) {
				answer += nowE.cost;
			}
		}
		
		System.out.println(answer);
	}
	
	public static void setUnion(int x) {
		root[x] = x;
	}

	public static int find(int x) {
		if(x == root[x]) {
			return x;
		} else {
			return root[x] = find(root[x]);
		}
	}
	
	public static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x == y) {
			return false;
		} else {
			if(x < y) {
				root[x] = y;
			} else {
				root[y] = x;
			}
			return true;
		}
	}
	
	
	static class Edge {
		int nodeA;
		int nodeB;
		int cost;
		public Edge(int nodeA, int nodeB, int cost) {
			this.nodeA = nodeA;
			this.nodeB = nodeB;
			this.cost = cost;
		}
	}
}

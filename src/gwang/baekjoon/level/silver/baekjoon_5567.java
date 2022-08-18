package gwang.baekjoon.level.silver;

import java.util.*;

import java.io.*;

public class baekjoon_5567 {
	
	/**
	 * 
	 * 문제 
	 * 상근이는 자신의 결혼식에 학교 동기 중 자신의 친구와 친구의 친구를 초대하기로 했다. 상근이의 동기는 모두 N명이고, 
	 * 이 학생들의 학번은 모두 1부터 N까지이다. 상근이의 학번은 1이다.
	 * 상근이는 동기들의 친구 관계를 모두 조사한 리스트를 가지고 있다. 이 리스트를 바탕으로 결혼식에 초대할 사람의 수를 구하는 프로그램을 작성하시오.
	 * 
	 * 입력
	 * 첫째 줄에 상근이의 동기의 수 n (2 ≤ n ≤ 500)이 주어진다. 둘째 줄에는 리스트의 길이 m (1 ≤ m ≤ 10000)이 주어진다. 
	 * 다음 줄부터 m개 줄에는 친구 관계 ai bi가 주어진다. (1 ≤ ai < bi ≤ n) ai와 bi가 친구라는 뜻이며, bi와 ai도 친구관계이다. 
	 * 
	 * 출력
	 * 첫째 줄에 상근이의 결혼식에 초대하는 동기의 수를 출력한다.
	 * 
	 * 쉬운 문제임에도 성급하게 class를 만들고 관계에 대한 데이터를 넣고 진행함. DFS, BFS 중에 어떤 것으로 풀지에 대한 판단도 대충함.
	 * 간단하게 2차원 배열로 해결 가능한 문제임
	 * 배열 크기에 대한 생각과 예외처리에 대해서 신중하게 생각하는 능력이 모자람..
	 * 
	 * 
	 */

	static int N;
	static int M;
	
	static boolean[] visited;
	static boolean[] sFriend;
	static int[][] relation;
	static int count = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		visited = new boolean[N+1];
		sFriend = new boolean[N+1];
		relation = new int[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			String[] lineArr = br.readLine().split(" ");
			int a = Integer.parseInt(lineArr[0]);
			int b = Integer.parseInt(lineArr[1]);
			relation[a][b] = 1;
			relation[b][a] = 1;
		}
		
		count();
		System.out.println(count);
	}
	
	static public void count() {
		
		// 상근이 친구
		for(int j=2; j<N+1; j++) {
			if(relation[1][j] == 1)  {
				visited[j] = true;
				sFriend[j] = true;
				count++;
			}
		}
		
		
		// 친구의 친구
		for(int s=2; s<N+1; s++) {
			if(sFriend[s]) {
				for(int j=2; j<N+1; j++) {
					if(relation[s][j] == 1 && !visited[j] && s != j)  {
						visited[j] = true;
						count++;
					}
				}
			}
		}
		
		
	}
	

}

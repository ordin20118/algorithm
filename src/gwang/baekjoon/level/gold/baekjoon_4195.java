package gwang.baekjoon.level.gold;

import java.util.*;
import java.io.*;

public class baekjoon_4195 {
	
	/**
	 * 
	 * 문제
	 * 민혁이는 소셜 네트워크 사이트에서 친구를 만드는 것을 좋아하는 친구이다. 우표를 모으는 취미가 있듯이, 
	 * 민혁이는 소셜 네트워크 사이트에서 친구를 모으는 것이 취미이다.
	 * 어떤 사이트의 친구 관계가 생긴 순서대로 주어졌을 때, 두 사람의 친구 네트워크에 몇 명이 있는지 구하는 프로그램을 작성하시오.
	 * 친구 네트워크란 친구 관계만으로 이동할 수 있는 사이를 말한다.
	 * 
	 * 입력
	 * 첫째 줄에 테스트 케이스의 개수가 주어진다. 각 테스트 케이스의 첫째 줄에는 친구 관계의 수 F가 주어지며, 
	 * 이 값은 100,000을 넘지 않는다. 다음 F개의 줄에는 친구 관계가 생긴 순서대로 주어진다. 
	 * 친구 관계는 두 사용자의 아이디로 이루어져 있으며, 알파벳 대문자 또는 소문자로만 이루어진 길이 20 이하의 문자열이다.
	 * 
	 * 출력
	 * 친구 관계가 생길 때마다, 두 사람의 친구 네트워크에 몇 명이 있는지 구하는 프로그램을 작성하시오.
	 * 
	 */

	static Map<String, Node> root;	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		root = new HashMap<>();
		
		for(int i=0; i<T; i++) {
			
			root.clear();
			
			int F = Integer.parseInt(br.readLine());
			
			for(int f=0; f<F; f++) {
				String line = br.readLine();
				String[] rel = line.split(" ");
				
				for(int r=0; r<rel.length; r++) {
					if(!root.containsKey(rel[r])) {
						unionSet(rel[r]);
					}
				}
				
				union(rel[0], rel[1]);
				
				System.out.println(root.get(find(rel[0])).nodeCnt);
			}			
		}

	}
	
	public static void unionSet(String x) {
		root.put(x, new Node(x, 0, 1));
	}
	
	public static String find(String x) {
		if(root.get(x).parent.equals(x)) { 	// 자신이 루트이면
			return x;
		} else {			 
			return root.get(x).parent = find(root.get(x).parent);
		}
	}
	
	public static void union(String x, String y) {
		x = find(x);
		y = find(y);
		
		if(x.equals(y)) return;
		
		if(root.get(x).height < root.get(y).height) {
			root.get(x).parent = y;
			root.get(y).nodeCnt = root.get(y).nodeCnt + root.get(x).nodeCnt;
			root.get(x).nodeCnt = 1;
		} else {
			root.get(y).parent = x;		
			root.get(x).nodeCnt = root.get(x).nodeCnt + root.get(y).nodeCnt;
			root.get(y).nodeCnt = 1;
			
			if(root.get(x).height == root.get(y).height) {
				root.get(x).height++;
			}
		}
	}
	
	static class Node {
		String parent;
		int height;
		int nodeCnt;
		Node(String parent, int height, int nodeCnt) {
			this.parent = parent;
			this.height = height;
			this.nodeCnt = nodeCnt;
		}
	}

}

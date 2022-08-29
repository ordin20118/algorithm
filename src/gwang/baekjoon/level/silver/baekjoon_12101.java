package gwang.baekjoon.level.silver;

import java.util.*;
import java.io.*;

public class baekjoon_12101 {
	
	static int n;
	static int k;
	static int[] pick = {1, 2, 3};
	static List<String> combi;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		combi = new ArrayList<>();
		
		String[] inputArr = br.readLine().split(" ");
		n = Integer.parseInt(inputArr[0]);
		k = Integer.parseInt(inputArr[1]);

		dfs("", 0);
		
		//System.out.println("" + combi);
		
		
		if(combi.size() < k) {
			System.out.println(-1);
			return;
		}

		String kCombi = combi.get(k-1);
		String[] combiArr = kCombi.split("");
		System.out.print("" + combiArr[0]);
		for(int i = 1; i<combiArr.length; i++) {
			System.out.print("+" + combiArr[i]);		
		}
		
	}
	
	public static void dfs(String hist, int sum) {
		
		// 
		if(sum == n) {
			combi.add(hist);
			return;
		} else if(sum > n) {
			return;
		}
		
		
		// 1
		dfs(hist + "1", sum + 1);
		// 2
		dfs(hist + "2", sum + 2);
		// 3
		dfs(hist + "3", sum + 3);
		
	}
	

}

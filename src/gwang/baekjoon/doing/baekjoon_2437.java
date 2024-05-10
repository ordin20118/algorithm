package gwang.baekjoon.doing;

import java.util.*;
import java.io.*;

public class baekjoon_2437 {

	static int N;
	static int[] weight;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		weight = new int[N];
		
		String[] weightArr = br.readLine().split(" "); 
		for(int i=0; i<N; i++) {
			weight[i] = Integer.parseInt(weightArr[i]);
		}
		
		Arrays.sort(weight);
		
		int targetNum = 0;
		boolean isEnd = false;
		while(!isEnd) {
			targetNum++;
			isEnd = !solution(0, 0, targetNum);
		}
		
		System.out.println(targetNum);

	}
	
	static public boolean solution(int depth, int sum, int targetNum) {
		
		if(sum > targetNum || depth == weight.length) {
			return false;
		}
		
		if(sum == targetNum) {
			return true;
		}
		
		boolean res1 = solution(depth+1, sum + weight[depth], targetNum);
		
		boolean res2 = solution(depth+1, sum, targetNum);
		
		return res1 || res2;
	}

}

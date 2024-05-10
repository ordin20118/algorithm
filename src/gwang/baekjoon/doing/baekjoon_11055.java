package gwang.baekjoon.doing;

import java.io.*;
import java.util.*;

public class baekjoon_11055 {

	
	static int N;
	static int[] seq;
	static int[] dp;
	static int maxSum = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		seq = new int[N];
		dp = new int[N];
		
		String[] strArr = br.readLine().split(" ");
	
		for(int i=0; i<strArr.length; i++) {
			seq[i] = Integer.parseInt(strArr[i]); 
		}

		
		dp[0] = seq[0];
		for(int i=1; i<seq.length; i++) {
			
			dp[i] = seq[i];	// dp 초기화
			
			for(int j=0; j<i; j++) {
				
				if(seq[j] < seq[i] && dp[i] < (dp[j] + seq[i])) {
					dp[i] = dp[j] + seq[i];
				}
				
			}
			
		}
		
		for(int i=0; i<dp.length; i++) {
			if(maxSum < dp[i]) maxSum = dp[i];
		}
		
		System.out.println(maxSum);

	}
	
	

}

package gwang.baekjoon.doing;

import java.io.*;
import java.util.*;

public class baekjoon_11055 {

	
	static int N;
	static int[] seq;
	static int[] sumSeq;
	static int maxSum = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		seq = new int[N];
		sumSeq = new int[N];
		
		String[] strArr = br.readLine().split(" ");
	
		for(int i=0; i<strArr.length; i++) {
			seq[i] = Integer.parseInt(strArr[i]);
		}
		
		for(int i=0; i<seq.length; i++) {
			solution(0, i, 0, ""+seq[i]);
		}
		
		System.out.println(maxSum);

	}
	
	public static void solution(int before, int depth, int sum, String hist) {
		
		if(depth == N) {
			if(maxSum <= sum) {
				maxSum = sum;
				System.out.println(hist);
			}
			return;
		}
	
		
		
		int now = seq[depth]; 
		int nowSum = sum + now;

		if(sumSeq[depth] >= nowSum){
			return;
		}
	
		
		if(before < now) {
			solution(now, depth+1, nowSum, hist+"/"+now);	
		}
		solution(before, depth+1, sum, hist);
		
	}

}

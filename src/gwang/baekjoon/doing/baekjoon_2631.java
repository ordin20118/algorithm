package gwang.baekjoon.doing;

import java.util.*;
import java.io.*;

public class baekjoon_2631 {
	
	static int N;
	static int[] children;
	static int[] dp;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		children = new int[N];
		dp = new int[N];
		
		for(int i=0; i<N; i++) {
			children[i] = Integer.parseInt(br.readLine());
		}
		
		oN2();
		nLogN();

	}
	
	// 각 위치 이전의 배열에서 작은 값을 가지는 수를 확인해서 LIS 길이를 알아낸다.
	public static void oN2() {
		
		dp[0] = 1;
		
		for(int i=1; i<N; i++) {
			dp[i] = 1;
			for(int j=0; j<i; j++) {
				if(children[j] < children[i] && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			if(count < dp[i]) {
				count = dp[i];
			}
		}
		System.out.println(N-count);	// N(총 길이) - LIS(최장 증가 수열) = 정렬 시키는 최소 비용
		
	}
	
	public static void nLogN() {
		
		ArrayList<Integer> dpList = new ArrayList<>();
		
		// LIS
		for(int num : children) {
			
			if(dpList.size() == 0 || dpList.get(dpList.size()-1) < num) {
				dpList.add(num);
			} else {
				
				// 이진탐색 + lower bound => 마지막 수가 작을수록 길다.
				int i = 0;
				int j = dpList.size() - 1;
				
				while(i < j) {
					
					int mid = (i + j)/2;
					
					if(dpList.get(mid) < num) {
						i = mid + 1;
					} else {
						j = mid;
					}
					
				}
				
				dpList.set(j, num);
				
			}
			
			System.out.println("["+num+"] => " + dpList);
			
		}
		
		System.out.println(dpList);
		System.out.println(N - dpList.size());
		
	}

}

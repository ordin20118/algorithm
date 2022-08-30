package gwang.baekjoon.level.silver;

import java.util.*;
import java.io.*;

public class baekjoon_12101 {
	
	/**
	 * 
	 * 
	 * 문제
	 * 정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.
	 * 1+1+1+1
	 * 1+1+2
	 * 1+2+1
	 * 2+1+1
	 * 2+2
	 * 1+3
	 * 3+1
	 * 
	 * 이를 사전순으로 정렬하면 다음과 같이 된다.
	 * 1+1+1+1
	 * 1+1+2
	 * 1+2+1
	 * 1+3
	 * 2+1+1
	 * 2+2
	 * 3+1
	 * 정수 n과 k가 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법 중에서 k번째로 오는 식을 구하는 프로그램을 작성하시오.
	 * 
	 * 
	 * 입력
	 * 첫째 줄에 정수 n과 k가 주어진다. n은 양수이며 11보다 작고, k는 231-1보다 작거나 같은 자연수이다.
	 * 
	 * 출력
	 * n을 1, 2, 3의 합으로 나타내는 방법 중에서 사전 순으로 k번째에 오는 것을 출력한다. k번째 오는 식이 없는 경우에는 -1을 출력한다.
	 * 
	 */
	
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

package gwang.baekjoon.level.gold;

import java.util.*;
import java.io.*;

public class baekjoon_1092 {
	
	/**
	 * 
	 * 문제
	 * 지민이는 항구에서 일한다. 그리고 화물을 배에 실어야 한다. 모든 화물은 박스에 안에 넣어져 있다. 
	 * 항구에는 크레인이 N대 있고, 1분에 박스를 하나씩 배에 실을 수 있다. 모든 크레인은 동시에 움직인다.
	 * 각 크레인은 무게 제한이 있다. 이 무게 제한보다 무거운 박스는 크레인으로 움직일 수 없다. 
	 * 모든 박스를 배로 옮기는데 드는 시간의 최솟값을 구하는 프로그램을 작성하시오.
	 *
	 * 입력
	 * 첫째 줄에 N이 주어진다. N은 50보다 작거나 같은 자연수이다. 둘째 줄에는 각 크레인의 무게 제한이 주어진다. 
	 * 이 값은 1,000,000보다 작거나 같다. 셋째 줄에는 박스의 수 M이 주어진다. M은 10,000보다 작거나 같은 자연수이다. 
	 * 넷째 줄에는 각 박스의 무게가 주어진다. 이 값도 1,000,000보다 작거나 같은 자연수이다.
	 * 
	 * 출력
	 * 첫째 줄에 모든 박스를 배로 옮기는데 드는 시간의 최솟값을 출력한다. 
	 * 만약 모든 박스를 배로 옮길 수 없으면 -1을 출력한다.
	 * 
	 */
	
	static int N;						// 크레인의 수 
	static int M;						// 박스의 수
	static int[] limit;					// 크레인의 무게 제한
	static ArrayList<Integer> weight;	// 박스의 무게
	
	static int cnt;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		String[] limitArr = br.readLine().split(" ");
		limit = new int[limitArr.length];
		for(int i=0; i<limitArr.length; i++) {
			limit[i] = Integer.parseInt(limitArr[i]);
		}
		
		M = Integer.parseInt(br.readLine());
		
		String[] weightArr = br.readLine().split(" ");
		weight = new ArrayList<>();
		for(int i=0; i<weightArr.length; i++) {
			weight.add(Integer.parseInt(weightArr[i]));
		}
		
		cnt = 0;
		
		Arrays.sort(limit);
		Collections.sort(weight, Collections.reverseOrder());
		
		solution();

	}
	
	public static void solution() {
			
		while(true) {
			int failCnt = 0;
			for(int i=0; i<limit.length; i++) {
				
				int nowLimit = limit[i];
				boolean isFind = false;
				
				for(int j=0; j<weight.size(); j++) {
					if(nowLimit >= weight.get(j).intValue()) {
						isFind = true;
						weight.remove(j);
						break;
					}
				}
				
				if(!isFind) failCnt++;
			}
			cnt++;
			if(weight.isEmpty()) {
				System.out.println(cnt);
				return;
			}
			
			if(failCnt == N) {
				System.out.println(-1);
				return;
			}
			
					
		}
		
	}
	
}

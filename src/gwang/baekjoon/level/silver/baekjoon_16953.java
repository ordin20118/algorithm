package gwang.baekjoon.level.silver;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class baekjoon_16953 {

	/*
	 * A -> B
	 * 
	 * 문제
	 * 정수 A를 B로 바꾸려고 한다. 가능한 연산은 다음과 같은 두 가지이다.
	 * 2를 곱한다.
	 * 1을 수의 가장 오른쪽에 추가한다. 
	 * A를 B로 바꾸는데 필요한 연산의 최솟값을 구해보자.
	 * 
	 * 입력
	 * 첫째 줄에 A, B (1 ≤ A < B ≤ 10^9)가 주어진다.
	 * 
	 * 출력
	 * A를 B로 바꾸는데 필요한 연산의 최솟값에 1을 더한 값을 출력한다. 만들 수 없는 경우에는 -1을 출력한다.
	 * 
	 */
	
	static Map<Long, Long> visited = new HashMap<>();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		long A = sc.nextLong();
		long B = sc.nextLong();
		
		calc(A, B);
		
	}
	
	public static void calc(long A, long B) {
		
		Queue<Long> queue = new LinkedList<>();
		queue.add(A);
		visited.put(A, 1l);
		
		boolean isFind = false;
		while(!queue.isEmpty()) {
						
			Long nowNode = queue.poll();
			
			long next1 = nowNode * 2;
			if(next1 == B) {
				isFind = true;
				visited.put(B, visited.get(nowNode) + 1);
				break;
			}
			
			long next2 = addOneAtBack(nowNode);
			if(next2 == B) {
				isFind = true;
				visited.put(B, visited.get(nowNode) + 1);
				break;
			}
			
			// 방문 하지 않았다 + B보다 작다 => 큐에 넣기
			if(next1 < B && visited.get(next1) == null) {
				queue.add(next1);
				visited.put(next1, visited.get(nowNode) + 1);
			}
			
			if(next2 < B && visited.get(next2) == null) {
				queue.add(next2);
				visited.put(next2, visited.get(nowNode) + 1);
			}			
			
		}

		if(isFind) {
			System.out.println(visited.get(B));
		} else {
			System.out.println(-1);
		}
				
	}
	
	public static long addOneAtBack(long num) {
		String tmp = Long.toString(num);
		tmp = tmp + "1";
		return Long.parseLong(tmp);
	}

}

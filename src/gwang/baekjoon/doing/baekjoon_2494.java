package gwang.baekjoon.doing;

import java.util.*;

public class baekjoon_2494 {
	
	/**
	 * 
	 * 문제
	 * 아래 그림과 같이 N개의 회전이 가능한 숫자 나사가 아래위로 연결되어 있다. 
	 * 가장 위에 있는 숫자나사는 숫자나사 1이고 가장 아래에 있는 숫자나사는 숫자나사 N이다. 
	 * 모든 숫자나사는 각각 10개의 면을 가지고 있고, 각 면에는 오른쪽 방향으로 0, 1, 2, 3, …, 9까지의 숫자가 하나씩 순서대로 적혀 있다. 
	 * 하나의 숫자나사를 왼쪽으로 회전 시키면, 이 나사보다 아래에 위치한 모든 나사는 같이 따라서 돌게 되지만, 나사를 오른쪽으로 회전시키면, 
	 * 다른 나사는 함께 돌지는 않는다. 정면에서 보아 위에서부터 아래쪽으로 숫자를 읽어 내려간다고 할 때, 현재의 상태에서 가장 적은 칸수의 
	 * 움직임으로 원하는 숫자를 만들기 위한 방법을 출력하는 프로그램을 작성하라.
	 * 예를 들어 세 개의 숫자나사가 주어졌을 때, 정면에서 보는 현재 상태가 326이고 원하는 상태는 446이라면 최소 회전 칸수는 4이다. 
	 * 먼저 숫자나사 1을 왼쪽으로 한 칸 돌리면 437이 되고, 숫자나사 2를 역시 왼쪽으로 한 칸 돌리면 448이 되며, 마지막으로 숫자나사 3을 
	 * 오른쪽으로 두 칸 돌리면 446이 된다.
	 * 
	 * 
	 * 입력
	 * 첫째 줄에는 숫자나사의 개수 N이 주어지고, 둘째 줄에는 현재의 상태가, 셋째 줄에는 원하는 상태가 주어진다. N은 3 이상이고 10,000 이하이다.
	 * 
	 * 출력 
	 * 첫째 줄에는 현재 상태에서 원하는 상태로 도달하는데 필요한 최소 회전 칸수를 출력한다. 
	 * 다음 줄부터는 회전 순서대로 각 줄에 하나의 숫자나사 번호와 회전 칸수를 빈칸을 사이에 두고 출력한다. 
	 * 회전 칸수는 왼쪽을 기준으로 하여 출력한다. 만일 왼쪽으로 4칸 회전한다면 4를, 오른쪽으로 3칸 회전한다면 -3을 출력한다. 
	 * 답이 여러 개이면 그 중에 하나만 출력한다.
	 * 
	 */

	public static int N; // 숫자나사의 개수 
	public static String now;
	public static String target;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		sc.nextLine();
		now = sc.nextLine();
		target = sc.nextLine();
		
		dfs(now);

	}
	
	public static void dfs(String state) {
		
		Map<String, Integer> visited = new HashMap<>(); // state, cnt
		Queue<Step> queue = new LinkedList<>();
		
		Step first = new Step(state, 0, 0, 0, 0);
		queue.add(first);
		visited.put(state, 0);
		
		int minCnt = 100000;
		Step minStep = null;
		
		while(!queue.isEmpty()) {
			
			Step now = queue.poll();
			
			//System.out.println(now.state+"/cnt:"+now.cnt);
			
			// 제약 사항
			if(now.state.equals(target)) {
				if(now.cnt < minCnt) {
					minCnt = now.cnt;
					minStep = now;
					//System.out.println("[[FIND]]"+now.state+"/cnt:"+now.cnt);
				}
				continue;
			}
			
			if(now.cnt >= minCnt) continue;
			
			if(visited.containsKey(now.state)) {
				if(visited.get(now.state) < now.cnt) continue;
			}
			
			
			// 다음 스텝			
			// 1 - 왼, 오
			String fl = rotate(now.state, 1, 1);
			queue.add(new Step(fl, now.first+1, now.second, now.third, now.cnt+1));	
			visited.put(fl, now.cnt+1);
			
			String fr = rotate(now.state, 1, -1);
			queue.add(new Step(fr, now.first-1, now.second, now.third, now.cnt+1));
			visited.put(fr, now.cnt+1);
			
			// 2 - 왼, 오
			String sl = rotate(now.state, 2, 1);
			queue.add(new Step(sl, now.first, now.second+1, now.third, now.cnt+1));	
			visited.put(sl, now.cnt+1);
			
			String sr = rotate(now.state, 2, -1);
			queue.add(new Step(sr, now.first, now.second-1, now.third, now.cnt+1));
			visited.put(sr, now.cnt+1);
			
			
			// 3 - 왼, 오
			String tl = rotate(now.state, 3, 1);
			queue.add(new Step(tl, now.first, now.second, now.third+1, now.cnt+1));	
			visited.put(tl, now.cnt+1);
			
			String tr = rotate(now.state, 3, -1);
			queue.add(new Step(tr, now.first, now.second, now.third-1, now.cnt+1));
			visited.put(tr, now.cnt+1);
		
			
			
			
			
			
			
			
//			String fl = rotate(now.state, 1, 1);
//			if(!visited.containsKey(fl)) {
//				queue.add(new Step(fl, now.first+1, now.second, now.third, now.cnt+1));	
//				visited.put(fl, true);
//			}
//			String fr = rotate(now.state, 1, -1);
//			if(!visited.containsKey(fr)) {
//				queue.add(new Step(fr, now.first+1, now.second, now.third, now.cnt+1));
//				visited.put(fr, true);
//			}
//			
//			// 2 - 왼, 오
//			String sl = rotate(now.state, 2, 1);
//			if(!visited.containsKey(sl)) {
//				queue.add(new Step(sl, now.first, now.second+1, now.third, now.cnt+1));	
//				visited.put(sl, true);
//			}
//			String sr = rotate(now.state, 2, -1);
//			if(!visited.containsKey(sr)) {
//				queue.add(new Step(sr, now.first, now.second+1, now.third, now.cnt+1));
//				visited.put(sr, true);
//			}
//			
//			// 3 - 왼, 오
//			String tl = rotate(now.state, 3, 1);
//			if(!visited.containsKey(sl)) {
//				queue.add(new Step(tl, now.first, now.second, now.third+1, now.cnt+1));	
//				visited.put(tl, true);
//			}
//			String tr = rotate(now.state, 3, -1);
//			if(!visited.containsKey(sr)) {
//				queue.add(new Step(tr, now.first, now.second, now.third+1, now.cnt+1));
//				visited.put(tr, true);
//			}
			
			
		}
		
		System.out.println(minStep);
		
	}
	
	// idx - 나사 번호
	// way - 1:왼, -1:오
	public static String rotate(String now, int idx, int way) {
		String[] arr = now.split("");
		
		
		idx = idx -1;
		if(way == 1) {	// 왼
			for(int i=0; i<arr.length; i++) {
				if(i >= idx) {
					arr[i] = Integer.toString((Integer.parseInt(arr[i]) + way)%10);		
				}
			}	
		} else {	// 오 
			arr[idx] = Integer.toString(Math.abs(Integer.parseInt(arr[idx]) + way));
		}
		return arr[0] + arr[1] + arr[2];
	}

	static class Step{
		String state;
		int first;
		int second;
		int third;
		int cnt;
		Step(String state, int first, int second, int third, int cnt) {
			this.state = state;
			this.first = first; this.second = second;
			this.third = third; this.cnt = cnt;
		}	
		
		public String toString() {
			return this.cnt + "\n" + "1 " + this.first + "\n2 " + this.second + "\n3 " + this.third;
		}
	}
}

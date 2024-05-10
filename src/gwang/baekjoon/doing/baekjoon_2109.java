package gwang.baekjoon.doing;

import java.io.*;
import java.util.*;

public class baekjoon_2109 {

	/**
	 * 
	 * 문제
	 * 한 저명한 학자에게 n(0 ≤ n ≤ 10,000)개의 대학에서 강연 요청을 해 왔다. 
	 * 각 대학에서는 d(1 ≤ d ≤ 10,000)일 안에 와서 강연을 해 주면 p(1 ≤ p ≤ 10,000)만큼의 강연료를 지불하겠다고 알려왔다. 
	 * 각 대학에서 제시하는 d와 p값은 서로 다를 수도 있다. 이 학자는 이를 바탕으로, 가장 많은 돈을 벌 수 있도록 순회강연을 하려 한다. 
	 * 강연의 특성상, 이 학자는 하루에 최대 한 곳에서만 강연을 할 수 있다.
	 * 예를 들어 네 대학에서 제시한 p값이 각각 50, 10, 20, 30이고, d값이 차례로 2, 1, 2, 1 이라고 하자. 
	 * 이럴 때에는 첫째 날에 4번 대학에서 강연을 하고, 둘째 날에 1번 대학에서 강연을 하면 80만큼의 돈을 벌 수 있다.
	 * 
	 * 
	 * 입력
	 * 첫째 줄에 정수 n이 주어진다. 다음 n개의 줄에는 각 대학에서 제시한 p값과 d값이 주어진다.
	 * 
	 * 
	 * 출력
	 * 첫째 줄에 최대로 벌 수 있는 돈을 출력한다.
	 * 
	 * 
	 * 힌트
	 * d일 안에 강연을 해주면 되는것이기 때문에 딱 d일에 강연을 할 필요가 없다.
	 * => d일 이내에 언제든지 하면 된다.
	 * 
	 */
	
	static int N;
	static Lecture[] lecture;
	static int[] pay;
	static int maxIncome = 0;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		pay = new int[10001];
		lecture = new Lecture[N];
	
		for(int i=0; i<N; i++) {
			String[] strArr = br.readLine().split(" ");	
			int p = Integer.parseInt(strArr[0]);
			int d = Integer.parseInt(strArr[1]);
			Lecture lec = new Lecture(d, p);
			lecture[i] = lec;
		}
		
		// pay 기준 내림차순 정렬
		Arrays.sort(lecture, (o1, o2) -> Integer.compare(o2.p, o1.p));
		
		for(int i=0; i<lecture.length; i++) {
			Lecture now = lecture[i];
			for(int j=now.d; j>0; j--) {
				if(pay[j] < now.p) {
					maxIncome -= pay[j];
					maxIncome += now.p;
					pay[j] = now.p;
					break;
				}
			}
			
		}
		
		System.out.println(maxIncome);

	}
	
	static class Lecture {
		int d;
		int p;
		public Lecture(int d, int p) {
			this.d = d;
			this.p = p;
		}
		public String toString() {
			return "p:"+this.p+"/d:"+this.d;
		}
	}
	

}

package gwang.baekjoon.doing;

import java.io.*;
import java.util.*;

public class baekjoon_2109 {

	
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

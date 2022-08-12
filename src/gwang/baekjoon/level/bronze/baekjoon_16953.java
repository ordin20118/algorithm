package gwang.baekjoon.level.bronze;

import java.util.Scanner;

public class baekjoon_16953 {
	
	static int min = 1000000000;
	static boolean isFind = false;

	public static void main(String[] args) {		
		
		Scanner sc = new Scanner(System.in);		
		int a = sc.nextInt();
		int b = sc.nextInt();		
		calc(a, b, 0);
		if(isFind) {
			System.out.println(min+1);	
		} else {
			System.out.println(-1);
		}
		
	}
	
	
	public static void calc(int a, int b, int count) {
				
		// 같으면 최소 count 확인
		if(a == b) {
			isFind = true;
			chckMin(count);			
		}
		
		// a가 b보다 크면 return
		if(a > b) {
			return;
		}
		
		calc(a*2, b, count+1);		
		calc(a*10+1, b, count+1);
		
	}
	
	public static void chckMin(int count) {
		if(min >= count) {
			min = count;
		}
	}
	
}

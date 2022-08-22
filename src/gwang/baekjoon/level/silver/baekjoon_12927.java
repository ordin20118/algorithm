package gwang.baekjoon.level.silver;

import java.util.*;
import java.io.*;

public class baekjoon_12927 {
	
	/**
	 * 
	 * 문제
	 * 강호는 전구 N개를 가지고 있다. 전구는 1번부터 N번까지 번호가 매겨져 있으며, 일렬로 놓여져 있다. 전구는 켜져있거나 꺼져있다.
	 * 강호는 모든 전구를 끄려고 한다. 강호는 전구를 켜고 끌 수 있는 스위치 N개를 가지고 있고, 스위치도 1번부터 N번까지 번호가 매겨져 있다. 
	 * i번 스위치는 i의 배수 번호를 가지는 전구의 상태를 모두 반전시킨다.
	 * 현재 전구의 상태가 주어졌을 때, 모든 전구를 끄기 위해서 스위치를 몇 번 눌러야하는지 구하는 프로그램을 작성하시오.
	 * 
	 * 입력
	 * 첫째 줄에 전구의 상태가 1번 전구부터 차례대로 주어진다. Y는 전구가 켜 있는 경우, N은 전구가 꺼져있는 경우이다. 
	 * 전구의 개수는 1보다 크거나 같고 1,000보다 작거나 같은 자연수이다.
	 * 
	 * 출력
	 * 모든 전구를 끄기 위해서 스위치를 몇 번 눌러야 하는지 출력한다. 만약, 모든 전구를 끌 수 없다면 -1을 출력한다.
	 * 
	 * 
	 */

	static boolean[] bulb;
	static int cnt;
	static int len;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] arr = input.split("");
		
		len = arr.length;
		bulb = new boolean[len+1];
		cnt = 0;
		
		for(int i=1; i<=len; i++) {
			if(arr[i-1].equals("Y")) {
				bulb[i] = true;	
			} else {
				bulb[i] = false;
			}
		}
		
		for(int i=1; i<=len; i++) {
			
			if(bulb[i]) {
				cnt++;
				int j = 1;
				for(int o=i; o<=len; o=i*j) {
					if(bulb[o]) {
						bulb[o] = false;
					} else {
						bulb[o] = true;
					}
					j++;
				}
			}
		}
		
		for(int i=0; i<len; i++) {
			if(bulb[i]) {
				System.out.println(-1);
				return;
			}
		}
	
		
		System.out.println(cnt);
		
	}

}

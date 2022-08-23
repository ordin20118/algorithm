package gwang.baekjoon.doing;

import java.util.*;
import java.io.*;

public class baekjoon_11509 {
	
	static int N;
	static Integer[] balloon;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		String[] ballonArr = br.readLine().split(" ");
		int len = ballonArr.length;
		balloon = new Integer[len];
		for(int i=0; i<ballonArr.length; i++) {
			balloon[i] = Integer.parseInt(ballonArr[i]);
		}
		
		int deadCnt = 0;
		int startIdx = 0;
		int prevDeadIdx = 0;
		while(true) {
		
			int passIdx = 1000001;
			int lastDead = 0;
			int h = balloon[startIdx];
			//System.out.println("[shoot]:"+h);
			// 화살 한 번의 처리 
			for(int i=startIdx; i<balloon.length; i++) {
				
				if(h == 0) break;
				
				if(balloon[i] == 0) continue;
				
				if(balloon[i] == h) {
					balloon[i] = 0;
					deadCnt++;
					lastDead = i;
					h--;
				} else {
					if(i <= passIdx) {
						passIdx = i;
					}
				}
				
				//h--;
			}
			
			count++;
			prevDeadIdx = lastDead;
			
			if(len == deadCnt) break;
			if(passIdx <= lastDead+1) {
				startIdx = passIdx;	
			} else {
				startIdx = lastDead+1;
			}
			
			//System.out.println("[dead]:"+deadCnt+"/[next]:" + startIdx);
		}
		
		System.out.println(count);
		
	}

}

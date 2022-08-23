package gwang.baekjoon.doing;

import java.util.*;
import java.io.*;

public class baekjoon_11509_2 {
	
	static int N;
	static List<Integer> balloon;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		String[] ballonArr = br.readLine().split(" ");
		int len = ballonArr.length;
		balloon = new ArrayList<>();
		for(int i=0; i<ballonArr.length; i++) {
			balloon.add(Integer.parseInt(ballonArr[i]));
		}
		
		while(!balloon.isEmpty()) {
			
			ArrayList<Integer> deleteIdx = new ArrayList<>();
		
			int h = balloon.get(0);
			//System.out.println("[shoot]:"+h);
			
			// 화살 한 번의 처리 
			for(int i=0; i<balloon.size(); i++) {
				
				if(h == 0) break;
		
				if(balloon.get(i) == h) {
					deleteIdx.add(i);
					h--;
				}
			}
			
			count++;
			
			//Collections.sort(deleteIdx, Collections.reverseOrder());
			for(int i=deleteIdx.size()-1; i>=0; i--) {
				int idx = deleteIdx.get(i);
				balloon.remove(idx);
			}
			
			//System.out.println(balloon);
			
		}
		
		System.out.println(count);
		
	}

}

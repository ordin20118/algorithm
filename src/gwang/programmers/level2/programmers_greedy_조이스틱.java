package gwang.programmers.level2;

import java.util.*;

public class programmers_greedy_조이스틱 {

	//static String[] alpah = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N"};
	
	static int minCnt = 9999999;
	static int changeCnt = 0;
	static boolean[] visited;
	
	public static void main(String[] args) {
		
		// 위, 아래 	- 알파벳 변경
		// 좌, 우 	- 알파벳 위치 변경
		
		String name = "JEROEN";
		
        
        
        System.out.println("[J]" + (int)'J' + " => " + calcMinStep('J'));
        System.out.println("[N]" + (int)'N' + " => "  + calcMinStep('N'));
        System.out.println("[O]" + (int)'O' + " => "  + calcMinStep('O'));
        System.out.println("[C]" + (int)'C' + " => "  + calcMinStep('C'));
        System.out.println("[Z]" + (int)'Z' + " => "  + calcMinStep('Z'));
        

	}
	
	
	public static int calcMinStep(char target) {
		
		int minStep = 0;
		int targetN = (int)target;
		int aT = targetN - 65;
		int zT = 90 - targetN + 1;
		
		if(aT >= zT) {
			minStep = -zT;
		} else if(aT < zT) {
			minStep = aT;
		}
		return minStep;
	}
	
	static class Step {
		int idx;
		int step;
		public Step(int idx, int step) {
			this.idx = idx;
			this.step = step;
		}
	}

}

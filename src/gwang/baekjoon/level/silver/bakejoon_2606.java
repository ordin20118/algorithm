package gwang.baekjoon.level.silver;

import java.util.ArrayList;
import java.util.Scanner;

public class bakejoon_2606 {
	
	static ArrayList<Computer> computerList = null;
	static int infectCnt = 0;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		computerList = new ArrayList<>();
		for(int i=0; i<N; i++) {
			Computer newCom = new Computer();
			computerList.add(newCom);
		}
		
		// 연결 설정
		for(int i=0; i<M; i++) {			
			int A = sc.nextInt();
			int B = sc.nextInt();			
			computerList.get(A-1).connectList.add(B-1);
			computerList.get(B-1).connectList.add(A-1);			
		}
		
		// 1번 컴퓨터가 바이러스에 걸림
		infect(computerList.get(0));	
		
		System.out.println(infectCnt-1);
		
	}
	
	public static void infect(Computer computer) {
		
		for(int i=0; i<computer.connectList.size(); i++) {
			System.out.print((computer.connectList.get(i)+1)+"/");
		}		
		System.out.println("");
		
		computer.isInfected = true;
		infectCnt++;
		
		for(int i=0; i<computer.connectList.size(); i++) {
			if(computerList.get(computer.connectList.get(i)).isInfected == false) {
				infect(computerList.get(computer.connectList.get(i)));
			}
		}		
	}

}

class Computer {
	
	boolean isInfected;
	ArrayList<Integer> connectList;
	
	public Computer() {
		isInfected = false;
		connectList = new ArrayList<>();
	}
}

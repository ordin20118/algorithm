package gwang.baekjoon.level.silver;

import java.util.*;
import java.io.*;

public class baekjoon_1946 {
	
	/**
	 * 
	 * 문제
	 * 언제나 최고만을 지향하는 굴지의 대기업 진영 주식회사가 신규 사원 채용을 실시한다. 인재 선발 시험은 1차 서류심사와 2차 면접시험으로 이루어진다. 
	 * 최고만을 지향한다는 기업의 이념에 따라 그들은 최고의 인재들만을 사원으로 선발하고 싶어 한다.
	 * 그래서 진영 주식회사는, 다른 모든 지원자와 비교했을 때 서류심사 성적과 면접시험 성적 중 적어도 하나가 다른 지원자보다 떨어지지 않는 자만 선발한다는 원칙을 세웠다. 
	 * 즉, 어떤 지원자 A의 성적이 다른 어떤 지원자 B의 성적에 비해 서류 심사 결과와 면접 성적이 모두 떨어진다면 A는 결코 선발되지 않는다
	 * 이러한 조건을 만족시키면서, 진영 주식회사가 이번 신규 사원 채용에서 선발할 수 있는 신입사원의 최대 인원수를 구하는 프로그램을 작성하시오.
	 * 
	 * 입력 
	 * 첫째 줄에는 테스트 케이스의 개수 T(1 ≤ T ≤ 20)가 주어진다. 각 테스트 케이스의 첫째 줄에 지원자의 숫자 N(1 ≤ N ≤ 100,000)이 주어진다. 
	 * 둘째 줄부터 N개 줄에는 각각의 지원자의 서류심사 성적, 면접 성적의 순위가 공백을 사이에 두고 한 줄에 주어진다. 
	 * 두 성적 순위는 모두 1위부터 N위까지 동석차 없이 결정된다고 가정한다.
	 * 
	 * 출력
	 * 각 테스트 케이스에 대해서 진영 주식회사가 선발할 수 있는 신입사원의 최대 인원수를 한 줄에 하나씩 출력한다.
	 * 
	 */
	
	static int T;
	static int N;
	
	static Score[] scores;
	static int passCnt;

	public static void main(String[] args) throws IOException  {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
		
			N = Integer.parseInt(br.readLine());
			
			scores = new Score[N];
			passCnt = N;
			
			for(int n=0; n<N; n++) {
				String[] score = br.readLine().split(" ");
				scores[n] = new Score(Integer.parseInt(score[0]), Integer.parseInt(score[1]));
			}
			
			solution();
			System.out.println("" + passCnt);
		}

	}
	
	public static void solution() {
		
		// 정렬 후 바로 다음 녀석만 비교
		Arrays.sort(scores, (c1, c2) -> Integer.compare(c1.doc, c2.doc));
		for(Score s : scores) {
			System.out.println("["+s.doc+"]["+s.speak+"]");
		}
		System.out.println("");
		
		int minSpk = scores[0].speak;
		
		for(int i=1; i<N; i++) {
			if(scores[i].speak > minSpk) {
				passCnt--;
			} else {
				minSpk = scores[i].speak;
			}
		}
		
	}
	
	static class Score {
		int doc;
		int speak;
		Score(int doc, int speak) {
			this.doc = doc; this.speak = speak;
		}
	}

}

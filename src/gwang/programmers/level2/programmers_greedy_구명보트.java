package gwang.programmers.level2;

import java.util.*;

public class programmers_greedy_구명보트 {

	public static void main(String[] args) {
		
		int[] people = {70, 50, 80, 50};
		int limit = 100;
		int answer = 0;
	        
		
        Arrays.sort(people);    // 오름차순 정렬
        
        int firstIdx = people.length - 1;
        int secondIdx = 0;
   
        while(firstIdx > secondIdx) {
            if(people[firstIdx] + people[secondIdx] <= limit) {
                firstIdx--;
                secondIdx++;
                answer++;
            } else {
                firstIdx--;
                answer++;
            }
        }
        
        if(firstIdx == secondIdx) {
            answer++;
        }
        
        System.out.println(answer);
	}

}

package gwang.programmers.level1;

public class programmers_타겟_넘버 {

	static int cnt = 0;
	static int[] signs = {0,1};
	
	public static void main(String[] args) {

		int[] numbers = {4,1,2,1};
		solution(numbers, 4);
		
	}
	
	static public int solution(int[] numbers, int target) {
		
		int answer = 0;        
        dfs(numbers, 0, target, 0);        
        answer = cnt;
        System.out.println("answer:" + answer);
        return answer;
	}
	
	static public void dfs(int[] numbers, int depth, int target, int sum) {
        
        if(depth == numbers.length) {
            if(sum == target) {
                cnt++;
            }            
            return;
        }
        
        for(int i=0; i<signs.length; i++) {
            int sign = signs[i];
            if(sign == 0) {
                sum += numbers[depth];
            } else {
                sum -= numbers[depth];
            }            
            
            dfs(numbers, depth+1, target, sum);
            
            if(sign == 0) {
                sum -= numbers[depth];
            } else {
                sum += numbers[depth];
            }            
        }
        
    }

}

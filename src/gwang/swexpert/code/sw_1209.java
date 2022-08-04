package gwang.swexpert.code;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class sw_1209 {

	public static void main(String[] args) throws FileNotFoundException {
		
		//System.setIn(new FileInputStream("C:\\Users\\GwangA\\Documents\\workspace\\all_alcohol\\src\\main\\java\\gwang\\allalcohol\\web\\test\\algorithm\\input_file\\SW_1209.txt"));
		System.setIn(new FileInputStream("/Users/gwanga/git/algorithm/src/gwang/swexpert/file/sw_1209_input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = 0;
		
        while(sc.hasNext()) {

            T = sc.nextInt();
            
            int[] columnSum = new int[100];
            int[] rowSum = new int[100];
            int[] diagonal1 = new int[1];
            int[] diagonal2 = new int[1];
            int[] total = new int[columnSum.length + rowSum.length + diagonal1.length + diagonal2.length];
            
            
            // 데이터 수신
            for(int i=0; i<100; i++) {
            	for(int j=0; j<100; j++) {
            		
            		int next = sc.nextInt();
                    
                    // column
                    columnSum[j] += next;
                    
                    // row
                    rowSum[i] += next;
                    
                    // diagonal1
                    if(i == j) {
                    	diagonal1[0] += next;
                    }
                    
                    // diagonal2
                    if((i+j) == 100) {
                    	diagonal2[0] += next;
                    }
            	}                
            }
            
            // 배열 합치기
            System.arraycopy(columnSum, 0, total, 0, columnSum.length);
            System.arraycopy(rowSum, 0, total, columnSum.length, rowSum.length);
            System.arraycopy(diagonal1, 0, total, (columnSum.length + rowSum.length), diagonal1.length);
            System.arraycopy(diagonal2, 0, total, (columnSum.length + rowSum.length + diagonal1.length), diagonal2.length);


            int max = findMax(total);
            System.out.println("#"+T+" "+max);
            
            //break;
            
        }
	}
	
	public static int findMax(int[] arr) {
	
		int max = 0;
		
		for(int sum : arr) {
			if(max <= sum) {
				max = sum;
			}
		}
		
		return max;
		
	}
	
	
}

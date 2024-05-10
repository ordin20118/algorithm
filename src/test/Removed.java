package test;

import java.util.*;
import java.io.*;

public class Removed {

	static Map<String, Integer> map = new HashMap<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int n = 3, k = 5;
		
		int[] answer = {};
        answer = new int[n];
        
        List<Integer> nums = new ArrayList<>();
        
        long allCase = 1;
        for(int i=1; i<=n; i++)  {
            allCase *= i;
            nums.add(i);
        }
       
        
        long tK = k;
        long tCase = allCase;
        for(int i=n; i>0; i--) {
            
        	System.out.println("===========");
        	System.out.println("[k]:"+tK);
        	
            long perRow = (int)(tCase/i);
            
            int numIdx;
            if(tK/perRow == 0) {
                numIdx = (int)(tK/perRow);
            } else if(k%perRow == 0) {
                numIdx = (int)(tK/perRow) - 1;
            } else {
                numIdx = (int)(tK/perRow);
            }
            
            answer[n-i] = nums.get(numIdx);
            
            print(nums);
            System.out.println("remove idx:"+numIdx+"=>"+nums.get(numIdx));
            nums.remove(numIdx);
            
            tCase = perRow;
            
            //int rIdx = numIdx-1 < 0 ? 0 : numIdx-1;
            tK = tK - (numIdx * perRow);
        }
        
        print(answer);
		
	}
	
	public static void print(List<Integer> list) {
		for(int i : list) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}
	
	public static void print(int[] list) {
		for(int i : list) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}
	

}

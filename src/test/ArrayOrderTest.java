package test;

import java.util.Arrays;

public class ArrayOrderTest {

	public static void main(String[] args) {

		int[] arr = {6,1,2,3,4,5};
		int[] tmpArr = null;
		
		
		tmpArr = arr.clone();
		
		Arrays.sort(tmpArr);
		
		
		for(int i : arr) {
			System.out.print(i+" ");	
		}
		
		System.out.println(" ");
		
		for(int i : tmpArr) {
			System.out.print(i+" ");	
		}
		

	}

}

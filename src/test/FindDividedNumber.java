package test;

import java.util.Random;

public class FindDividedNumber {

	public static void main(String[] args) throws InterruptedException {

		int leftNum = makeDividendNumber(3, 2);
		
//		System.out.println("피제수:["+leftNum+"]");
//		
//		int rightNum = findDivisorNumber(leftNum, 1);
//		
//		System.out.println("=> " + leftNum + "/" + rightNum);
		
	}
	
	public static int makeDividendNumber(int leftLen, int rightLen) throws InterruptedException {
       
		int leftNum = 1;
		int rightNum = 1;
        int[] multiplicandArr = {2,3,5,7};
        Random random = new Random();
        
        int debugCnt = 0;
    
        //System.out.println("[나누어 떨어지는 숫자 찾기]:"+(++debugCnt));
        int randIdx = random.nextInt(multiplicandArr.length-1);
        int multiplicand = multiplicandArr[randIdx];
        int multiplier = 1;
        if(multiplicand == 2) {
            if(rightLen == 1) {
                multiplier = random.nextInt(3) + 1;
            } else if(rightLen == 2) {
                multiplier = random.nextInt(44) + 5;
            } else if(rightLen == 3) {
                multiplier = random.nextInt(449) + 50;
            }
        } else if(multiplicand == 3) {
            if(rightLen == 1) {
                multiplier = random.nextInt(2) + 1;
            } else if(rightLen == 2) {
                multiplier = random.nextInt(30) + 3;
            } else if(rightLen == 3) {
                multiplier = random.nextInt(299) + 34;
            }
        } else if(multiplicand == 5) {
            if(rightLen == 1) {
                multiplier = 1;
            } else if(rightLen == 2) {
                multiplier = random.nextInt(13) + 2;
            } else if(rightLen == 3) {
                multiplier = random.nextInt(179) + 20;
            }
        } else if(multiplicand == 7) {
            if(rightLen == 1) {
                multiplier = 1;
            } else if(rightLen == 2) {
                multiplier = random.nextInt(12) + 2;
            } else if(rightLen == 3) {
                multiplier = random.nextInt(127) + 15;
            }
        }

        rightNum = multiplicand * multiplier;
       
        System.out.println("제수:["+rightNum+"]");
        
        while(true) {
        	if(leftLen == 3) {
        		int tmpLeftNum = (random.nextInt(99)+2) * rightNum; 
        		String numStr = Integer.toString(tmpLeftNum);
        		System.out.println("["+tmpLeftNum+"]/["+rightNum+"]");
        		if(numStr.length() == leftLen) {
        			leftNum = tmpLeftNum;
        			break;
        		}
        	}
        	Thread.sleep(30);
        }
        
        System.out.println("=> ["+leftNum+"]/["+rightNum+"]");
        
        return leftNum;
    }
	

}

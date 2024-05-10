package test;

import java.util.*;

public class UpperLowerCaseTest {

	public static void main(String[] args) {
		String test = "aBc";
		String answer = "";
        for(int i=0; i<test.length(); i++) {
            int cNum = (int)test.charAt(i);
            if(65 <= cNum && cNum <= 90) {
                answer += (char)(cNum + 32);
            } else if(97 <= cNum && cNum <= 122) {
                answer += (char)(cNum - 32);
            }
        }
        System.out.println(answer);

	}

}

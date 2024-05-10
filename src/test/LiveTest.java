package test;

public class LiveTest {

	public static void main(String[] args) {
		int n = 1201;

		//if(n < 10) return n;
        
        long num1 = 9;
        long num2 = 1;
        long sum = 9;
        
        while(n >= (num1 * 10) * (num2 + 1)){
            num1 *= 10;
            num2 += 1;
            sum += num1 * num2;
        }
 
        n -= (sum + 1);
        
        System.out.println(""+ n);
        System.out.println("이전 자리 수 까지 개수"+ num1);
        System.out.println("이전 자리 수"+ num2);
        
        String str = String.valueOf( (int)Math.pow(10, num2) + n / (num2 + 1));        
        
        System.out.println("");
        System.out.println(str);
        System.out.println((int)Math.pow(10, num2) + n / (num2 + 1));
        
        System.out.println("");
        System.out.println("idx:"+(n % ((int)num2 + 1)));
        System.out.println(str.charAt(n % ((int)num2 + 1)));
        
        
        System.out.println("" + (str.charAt(n % ((int)num2 + 1)) - '0') );
        int a = str.charAt(n % ((int)num2 + 1)) - '0';
        System.out.println(a);

	}

}

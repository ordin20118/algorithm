package gwang.java.grammer;

import java.util.Scanner;

public class ScannerExample {
	
	/*
	 *  # next + {자료형}()
	 *	예시에서는 대표적으로 nextInt()와 nextDouble() 을 사용하였다. 뒤에 사용한 자료형에 맞는 값을 받을 수 있다.
	 *
	 *	# nextLine()	 
	 *	한 줄을 통째로 받아온다. 근데 nextLine()은 개행문자까지 받을 수 있기 때문에 위에서 buffer라는 변수에 nextLine()을 받아주지 않는다면
	 *  앞에서 남은 개행을 받아와 자기소개는 입력을 받지 못하게 된다. 
	 *  따라서 buffer 변수로 한 번 더 받아줌으로서 이 문제를 해결하였다.	
	 *  
	 *  # next() 
	 *  화이트 스페이스를 기준으로 한 단어를 받아온다.	  
	 */

	public static void main(String[] args) {
		String name;
		int age;
		double height;
		String intro;
		String buffer;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력하세요");
		name = sc.next();
		System.out.println("나이를 입력하세요");
		age = sc.nextInt();
		System.out.println("키를 입력하세요");
		height = sc.nextDouble();
		System.out.println("자기소개를 입력하세요");
		buffer = sc.nextLine();
		intro = sc.nextLine();
		
		System.out.println("이름은 "+name+"나이는 "+age+",키는 "+height+"입니다.");
		System.out.println(intro);

	}

}

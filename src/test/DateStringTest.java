package test;

public class DateStringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String day = "09";
		System.out.println(Integer.parseInt(day));
		System.out.println(Integer.parseInt(day.replaceAll("0", "")));
		
		
		Integer m = 15;
		System.out.println(m%12);
		if(m>12 && m%12 > 0) {
			System.out.println(m/12+"/"+m%12);
		}
		System.out.println(""+(m -1));
		
//		int[] answer = {};
//		answer[0] = 1;
//		answer[1] = 2;
//		answer[2] = 3;
//		
//		for(int i=0; i<answer.length; i++) {
//			System.out.println(answer[i]);	
//		}
	}

}

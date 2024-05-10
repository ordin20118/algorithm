package gwang.java.grammer;

public class StreamExample {

	public static void main(String[] args) {
		
		
		String name = "abc";
		
		String subName = name.substring(0, 1);
		System.out.println(subName);
		
		subName = name.substring(2, name.length());
		System.out.println(subName);
		
		System.out.println(name.charAt(0));
		
		if(name.charAt(0) == name.charAt(1)) {
			System.out.println("same");	
		} else {
			System.out.println("not same");
		}
		

	}

}

package test;

import java.util.*;

public class StackTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		        
		while (sc.hasNext()) {
			String input = sc.next();
			
			Stack<String> stack = new Stack();
			
			System.out.println(input);
            
            boolean res = true;
            String[] arr = input.split("");            
            for(String item : arr) {
                if(item.equals("(") || item.equals("{") || item.equals("[")) {
                    stack.push(item);
                }
                
                if(item.equals(")") || item.equals("}") || item.equals("]")) {
                	
                	if(stack.size() == 0) {
                		res = false;
                		break;
                	}
                	
                    String poped = stack.pop();
                    if(item.equals(")")) {
                        if(!poped.equals("(")){
                            res = false;
                            break;
                        }
                    }
                    
                    if(item.equals("}")) {
                        if(!poped.equals("{")){
                            res = false;
                            break;
                        }
                    }
                    
                    if(item.equals("]")) {
                        if(!poped.equals("[")){
                            res = false;
                            break;
                        }
                    }
                }
            }
            
            if(stack.size() > 0) {
            	System.out.println("false");	
            } else {
            	System.out.println(res);	
            }
            
		}
		
	}

}

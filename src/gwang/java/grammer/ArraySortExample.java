package gwang.java.grammer;

import java.util.*;
import java.util.stream.Collectors;

public class ArraySortExample {

	public static void main(String[] args) {
		
		int[] numbers = {3, 30, 34, 5, 9};
        Arrays.sort(numbers); // 오름차순 정렬
        System.out.println(Arrays.toString(numbers));
        System.out.println("=============================");
        
        // 기본형 배열을 리스트로 변경 후 내림차순 하는 방법
        List<Integer> intList = Arrays.stream(numbers).boxed().collect(Collectors.toList());
        Collections.reverse(intList);
        int[] justReversed = intList.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(justReversed));        
        System.out.println("=============================");
        
        // 내림차순으로 정렬하기 위해 배열을 리스트로 변환 후 뒤집고 다시 배열로 변환
        int[] reversedNumbers = Arrays.stream(numbers)
                                      .boxed()
                                      .sorted(Collections.reverseOrder())
                                      .mapToInt(Integer::intValue)
                                      .toArray();
        
        System.out.println(Arrays.toString(reversedNumbers));
        System.out.println("=============================");
        
        // 문자열을 정렬하는 방법
        String[] stringNumbers = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);
        //Arrays.sort(stringNumbers, Collections.reverseOrder());
        Arrays.sort(stringNumbers);
        System.out.println(Arrays.toString(stringNumbers));
	}
	
}

/**
 * boxed
boxed() 메서드는 기본형 스트림을 해당 기본형의 래퍼(wrapper) 클래스로 변환하는 메서드입니다. 
기본형 스트림을 박싱(boxing)하여 해당 기본형 값을 객체로 포장합니다. 이렇게 하면 기본형 스트림에서 제공하는 기능 외에도 객체 스트림에서 제공하는 다양한 기능을 사용할 수 있습니다.

예를 들어, 기본형 스트림에서는 mapToInt(), mapToDouble(), mapToLong() 등을 사용하여 기본형 값을 다른 기본형으로 매핑할 수 있습니다. 
그러나 이러한 매핑 후에는 다시 원래의 기본형 스트림으로 돌아가기 어렵습니다. 그렇기 때문에 boxed() 메서드를 사용하여 기본형 스트림을 객체 스트림으로 변환하여 다양한 객체 스트림 기능을 활용할 수 있습니다.

위 예시에서는 boxed() 메서드를 사용하여 기본형 int 배열을 Integer 객체로 박싱하여 스트림을 생성하고, 이후에 sorted() 메서드를 사용하여 내림차순으로 정렬하는 과정에서 사용되었습니다.
**/

package algorithm5_Stack_Queue;

import java.util.*;
import java.util.Map.Entry;

public class exam1 {
	
//	1. 올바른 괄호
//	설명
//
//	괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.
//
//	(())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.
//
//
//	입력
//	첫 번째 줄에 괄호 문자열이 입력됩니다. 문자열의 최대 길이는 30이다.
//
//
//	출력
//	첫 번째 줄에 YES, NO를 출력한다.
//
//
//	예시 입력 1 
//
//	(()(()))(()  12 34  5  :  ( 가 6  ) 가 5
//	예시 출력 1
//
//	NO   (()()))
	
	//괄호는 한쌍을 이루어야 한다. 
	
	//앞에 입력된 괄호 갯수가 짝순지 홀순지 짝수라면. 
	
	// 괄호가 닫혀야 입력 되는 시점 에서 앞의 '(' 가 짝수 ')' 갯수가 짝수라면 
	
	public static void main(String[] args) {

		exam1 exam1 = new exam1(); 
		Scanner in = new Scanner(System.in);
		
		String str1 = in.next();
		
		System.out.print(exam1.solution(str1));
	}
	public String solution(String str1) {
		String answer = "NO";
		int left = 0;
		int right = 0;
		int count = 0;
		
		for(char ch : str1.toCharArray()) {
			if(ch == '(') {
				left ++;
					if(right >= 1) {
						right --;
						left --;
						count ++;
					}
			}else {
				right++;
				if(left >= 1) {
					left --;
					right --;
					count ++;
				}
			}
		}
		
		if(str1.length() / 2 == count ) {
			answer = "YES";
		}
	
		return answer;
	}
		
		
}

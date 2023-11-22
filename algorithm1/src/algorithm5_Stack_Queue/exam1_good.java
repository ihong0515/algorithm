package algorithm5_Stack_Queue;

import java.util.*;
import java.util.Map.Entry;

public class exam1_good {
	
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
	
	
	//stack의 이해 
	
	// 재영이는 코딩 테스트 공부를 하고 있다.
	
	// 그런데  코딩 테스트 공부 끝내기 전에 DB공부 먼저 해달라고 부탁이 들어왔다. 
	
	//그래서 DB공부 하고 있었는데 네트워크 공부를 먼저 끝내 달라고 연락이 왔다. 
	
	// 그래서 DB 공부 끝냈으면 다음 할일은?
	
	// 우선순위가 더 높아진 일을 처리 할떄 기존 갚을 스텍 자료 구조 아래로 넣어두고 위에 쌓인거 부터 먼저 해결 해 갈 수 있는 것.
	
	//이 스택 자료 구조 하면 문자열 뒤집기도 가능하고, 인터넷뒤로 가기 앞으로 가기 버튼도 가능하다. 
	
	
	//스택 비어 있을때 pop 하면 empty stack Exception 발생 시킬 수 있다. 
	
	
	//스택은 출입구가 하나 뿐인 구멍이라고 이해 했습니다. 따라서 나오기 위에선 나중에 들어간 것이 아랫것을 밟고 올라오는 수 밖에 없는 구조로 이해 하였습니다. 
	
	
	//큐는 눕혀진 원통 먼저 들어간 값이 눕혀진 반대쪽으로 나온다. 
	public static void main(String[] args) {

		exam1_good exam1 = new exam1_good(); 
		Scanner in = new Scanner(System.in);
		
		String str1 = in.next();
		
		System.out.print(exam1.solution(str1));
	}
	public String solution(String str1) {
		String answer = "NO";
		Stack<Character> st = new Stack<>();
		
		for(char a : str1.toCharArray()) {
			
			if(a == '(') {
				st.push(a);
			//닫는 괄호를 만나면 스택에 먼저 들어가 있던(그와중에서도 제일 위에 쌓인 -> 나중에 들어왔다면)
				//짝궁 여는 괄호를 스택에서 날려 버린다. 한쌍 지어 질떄마다 나중에 들어간 여는 괄호 부터 날라간다.  왜 나중에 들어간 여는 괄호 부터 뺴냐? 괄호는 안쪽 부터 잠기기 떄문.
			}else {
				if(st.isEmpty()) {
					//왼쪽 여는 괄호가 없는데 오른쪽 괄호만 나오는것은 안봐도 뻔한 상황  어미가 없는데 자식이 어째 있을까 더 볼 필요 없다 반복문 끝내 버린다. 
					return "NO";
				}
				st.pop();
			}
		}
		//닫 는 괄호가 없는데 여는 괄호만 남아 있으면 무얼 하겠는가. 
		if(st.size() == 0) {
			answer ="YES";
		}
		return answer;
	}
		
		
}

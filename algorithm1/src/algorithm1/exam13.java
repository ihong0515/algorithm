package algorithm1;

import java.util.*;

public class exam13 {
//	12. 암호
//	설명
//
//	현수는 영희에게 알파벳 대문자로 구성된 비밀편지를 매일 컴퓨터를 이용해 보냅니다.
//
//	비밀편지는 현수와 영희가 서로 약속한 암호로 구성되어 있습니다.
//
//	비밀편지는 알파벳 한 문자마다 # 또는 *이 일곱 개로 구성되어 있습니다.
//
//	만약 현수가 “#*****#”으로 구성된 문자를 보냈다면 영희는 현수와 약속한 규칙대로 다음과 같이 해석합니다.
//
//	1. “#*****#”를 일곱자리의 이진수로 바꿉니다. #은 이진수의 1로, *이진수의 0으로 변환합니다. 결과는 “1000001”로 변환됩니다.
//
//	2. 바뀐 2진수를 10진수화 합니다. “1000001”을 10진수화 하면 65가 됩니다.
//
//	3. 아스키 번호가 65문자로 변환합니다. 즉 아스크번호 65는 대문자 'A'입니다.
//
//	참고로 대문자들의 아스키 번호는 'A'는 65번, ‘B'는 66번, ’C'는 67번 등 차례대로 1씩 증가하여 ‘Z'는 90번입니다.
//
//	현수가 4개의 문자를 다음과 같이 신호로 보냈다면
//
//	#****###**#####**#####**##**
//
//	이 신호를 4개의 문자신호로 구분하면
//
//	#****## --> 'C'
//
//	#**#### --> 'O'
//
//	#**#### --> 'O'
//
//	#**##** --> 'L'
//
//	최종적으로 “COOL"로 해석됩니다.
//
//	현수가 보낸 신호를 해석해주는 프로그램을 작성해서 영희를 도와주세요.
//
//
//	입력
//	첫 줄에는 보낸 문자의 개수(10을 넘지 안습니다)가 입력된다. 다음 줄에는 문자의 개수의 일곱 배 만큼의 #또는 * 신호가 입력됩니다.
//
//	현수는 항상 대문자로 해석할 수 있는 신호를 보낸다고 가정합니다.
//
//
//	출력
//	영희가 해석한 문자열을 출력합니다.
//
//
//	예시 입력 1 
//
//	4
//	#****## #**#### #**#### #**##** 
//	예시 출력 1
//
//	COOL
	
	//2진번 1000001 -> 오른 쪽 첫자리가 2^0 으로 시작해서 1이면 2 ^ 그 자릿수 해서 더하고 아니면 안더한다   이거는 2 ^0 + 2 & 6 65이다.
	//첫줄에 숫자 입력 받고 입력 받은 수만큼 반복 돌려서 스트링 배열로 암호들을 입력 받는다.
	//함수에서는 암호들이 입력된 배열을 파라미터로 받아서 해독된 값을 반환한다.
	
	//함수 내보에서는 우선 배열 만큼 반복을 돈다
	//반복을 돌면서 한 배열의 한 원소에 대해서 # = 1 * 은 0 으로 바꿔준다 replace 이용해서
	
	//다시 반복 돌면서 이 배열의 한 원소에 대해서 인티절 .passer int (문자열,2)
	public static void main(String[] args) {
		exam13 exam1 = new exam13(); 
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		String str = in.next();
		System.out.println(exam1.solution(n,str));
		
	}
	public String solution(int n,String str) {
		
		String answer = "";
		int count = str.length() / n;
			
		str = str.replaceAll("#","1");
		//replace는 스트링을 다른 스트링으로 바꿔주는데 스트리은 변하지 않고 새로 저장된다는 특성이 있음 따라서 이거쓰면 새로 저장해서 초기화 해주어야함
		//그리고 * 이런거 쓸거면 앞에 이스케이프 문자 \\써줘야 특수문자로 인식한다이.
		str = str.replaceAll("\\*","0");
		
		
		
		for(int i = 0; i < n; i++) {
			//문자열을 몇도막 씩 으로 일정하게 쪼개고 싶다 할때 사용 하면 좋은 로직
			//반복을 쪼개고 싶은 도막으로 돌리고 
			//start는 첫 인덱스는 어짜피 0 이니까 첫바퀴는 0부터 그다음은 * 최초로 지정한 쪼개고 싶은 도막 으로 곱해주면 해두면 그만큼씩 점프 하게 된다
			//마지막 도막은 점프한 지점에서 원하는 도막만큼 이동한 지점의 문자 좌표가 되는 것이다.
			
			//이거 말고사용한 문자열을 도려내는 방법도 있다 str을  앞에 substring 한부분 도려내기
			//str을 substring(7) 도려낸 마지막 글자 부터 마지막 까지로 잘라서 다시 저장해 준다.
			int start = i * count;
			int end = start + count;
			
			if(end > str.length()) {
				end = str.length();
			}
			
			String secret = str.substring(start,end);
			// 정수 char로 캐스트 해버리면 유니코드로 인식해서 알파벳으로 바꿀 수가 있다.
			//pasreInt 뒷 파라미터는 들어가는 수의 진법을 나타낸다.
			char ch = (char)Integer.parseInt(secret,2);
			answer += ch;
		}
		
		
		
		
		return answer;
	}
}


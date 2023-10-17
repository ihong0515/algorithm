package algorithm1;

import java.util.*;

public class exam9 {
	/*
	 * 설명
	 * 
	 * 문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만듭니다.
	 * 
	 * 만약 “tge0a1h205er”에서 숫자만 추출하면 0, 1, 2, 0, 5이고 이것을 자연수를 만들면 1205이 됩니다.
	 * 
	 * 추출하여 만들어지는 자연수는 100,000,000을 넘지 않습니다.
	 * 
	 * 
	 * 입력 첫 줄에 숫자가 섞인 문자열이 주어집니다. 문자열의 길이는 100을 넘지 않습니다.
	 * 
	 * 
	 * 출력 첫 줄에 자연수를 출력합니다.
	 */
	public static void main(String[] args) {
		exam9 exam9 = new exam9(); 
		Scanner in = new Scanner(System.in);
		String str = in.next();
		System.out.println(exam9.solution(str));
	}
	public int solution(String str) {
		
		int answer = 0;
		String tmp = "";
		
		for(char ch : str.toCharArray()) {
			if(Character.isDigit(ch)) {
				tmp += ch;
			}
		}
		answer = Integer.parseInt(tmp);
		return answer;
	}
	//다른 방법 문자의 아스키 코드를 이용한 방법
	/*
	 * 1.answer를 0으로 초기화 해둔다 x >= 48 && x <= 57 character은 원래 정수형이다 아스키가 48 ~ 57 사이에
	 * 있으면 아스키 48 ~ 57 숫자 0~9이다 character은 원래 정수형이다. 2. answer = answer * 10 +
	 * (회문문자의 아스키 - 48) 이렇게 계속 갱신해준다. ( 아 십진법이어서 ㅋㅋㅋㅋㅋ)이렇게 갱신해서 더해지고 십진법으로 숫자 나태낼 수
	 * 있게 되는 것이다.
	 */
	
		//(ch - 48) 부분:

		//여기서 48은 '0'의 ASCII 코드값입니다. 따라서, ch - 48는 문자가 '0'일 경우 0, '1'일 경우 1, ..., '9'일 경우 9라는 숫자 값을 반환합니다. 예를 들어, 문자 '5'의 ASCII 코드값은 53입니다. 따라서, 53 - 48 = 5로, 문자 '5'를 숫자 5로 변환합니다.
		// 아스키 코드에서 '0'의 아스키 코드(48)를 뺀 값은 해당 문자가 나타내는 숫자와 동일합니다 십진수
	public int solution2(String str) {
		
		int answer = 0;
		
		for(char ch : str.toCharArray()) {
			if(ch >= 48 && ch <= 57) {
				answer = answer * 10 + (ch - 48); // 아스 키로 연산이 된다.
			}
		}
		return answer;
	}
}

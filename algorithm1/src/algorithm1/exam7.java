package algorithm1;

import java.util.*;

public class exam7 {
	/*
	 * 7. 회문 문자열 설명
	 * 
	 * 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.
	 * 
	 * 문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력하는 프로그램을 작성하세요.
	 * 
	 * 단 회문을 검사할 때 대소문자를 구분하지 않습니다.
	 * 
	 * 
	 * 입력 첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.
	 * 
	 * 
	 * 출력 첫 번째 줄에 회문 문자열인지의 결과를 YES 또는 NO로 출력합니다.
	 * 
	 * 
	 * 예시 입력 1
	 * 
	 * gooG 예시 출력 1
	 * 
	 * YES
	 */
	public static void main(String[] args) {
		exam7 exam7 = new exam7(); 
		Scanner in = new Scanner(System.in);
		String str = in.next();
		System.out.println(exam7.solution(str));
	}
	//먼저혼자 풀어 본거 애초에 같은지 아닌지는 기본값으로 하나 해놓고 아닐떄 그걸로 리턴 시켜 버리는 것도 나쁜 방법은 아니다. 
	public String solution(String str) {
		String answer = "";
		StringBuilder sb = new StringBuilder(str);
		str = str.toUpperCase();
		sb = sb.reverse();
			if(str.equals(sb.toString().toUpperCase())) {
				answer = "YES";
			}else {
				answer = "NO";
			}
			
		return answer;
	}
	//stringBuilder 안쓰고 문자열을 반으로 나눠서 반까지만 인덱스로 돌고 도는 차수내에서 매칭되는 끝자리랑 비교 해 보는 것
	//length를 미리변수로 선언 해주어야 한다 그래서 
	public String solution2(String str) {
		String answer = "YES";
		str = str.toUpperCase();
		int len = str.length();
		
		for(int i = 0; i < len/2; i++) {
			//배열에서 대칭되는 인덱스 구하려면 전체 길이 -1 최초의 인덱스 
			if(str.charAt(i) != str.charAt(len - i -1)) {
				answer = "NO";
			}
		}
		
			
		return answer;
	}
	//대소문자 구분 안하는 equls 있다. equalsignoreCase  하면 배소 문자 무시 해준다.
	public String solution3(String str) {
		String answer = "YES";
		
		String tmp = new StringBuilder(str).reverse().toString();
		
		if(str.equalsIgnoreCase(tmp)) {
			answer = "NO";
		}
			
		return answer;
	}	
}

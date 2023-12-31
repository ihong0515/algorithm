package algorithm1;

import java.util.*;

public class exam2 {
	/*
	 * 2. 대소문자 변환 설명
	 * 
	 * 대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.
	 * 
	 * 
	 * 입력 첫 줄에 문자열이 입력된다. 문자열의 길이는 100을 넘지 않습니다.
	 * 
	 * 문자열은 영어 알파벳으로만 구성되어 있습니다.
	 * 
	 * 
	 * 출력 첫 줄에 대문자는 소문자로, 소문자는 대문자로 변환된 문자열을 출력합니다.
	 */
	public static void main(String[] args) {
		exam2 exam2 = new exam2(); 
		Scanner in = new Scanner(System.in);
		String str = in.next();
		System.out.println(exam2.solution(str));
	}
	public String solution(String str) {
		//대소문자 변경해서 반환 할 값.
		String answer = "";
		for(char i : str.toCharArray()) {
			if(Character.isUpperCase(i)){
				answer += Character.toLowerCase(i);
			}else {
				answer += Character.toUpperCase(i);
			}	
		}
		return answer;
	}
	//toCharArray 메서드 : 는 문자열을 한 글자씩 쪼개서
	
	
	/*
	 * 문자열에서 향상 반복 문 돌릴때 문자열을 단어들의 배열로 바꿀때 많이 쓴다. 이를 char타입의 배열에 집어넣어주는 친절한 메소드이다.
	 * 추가로, char형 배열을 합쳐서 하나의 String(문자열)로 만들 수 있다. String s2 = new String(charArr);
	 */
	
	//향상된 for문
	/*
	 * ArrayList 원소 출력이나 배열 원소를 출력하는 상황에서 사용되게 된다. 혹은 배열의 길이만큼 코드를 반복하는 데 사용한다. 일반
	 * for문과 다르게 배열에 저장된 값이 변수에 저장된 후에 차례대로 출력되게 된다. for(자료형 변수명 : 배열) <- 변수명의 배열의
	 * 처음의 원소부터가 저장되면서 반복문에 들어가게 된다.
	 */
	//해당 배열에서 해당 char를 대소문자 변경 했으면 바로 꽂아주던가 저장해줘야 쓴다이.
}

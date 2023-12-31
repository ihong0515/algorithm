package algorithm1;

import java.util.*;

public class exam1 {
	/*
	 * 설명
	 * 
	 * 한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성하세요.
	 * 
	 * 대소문자를 구분하지 않습니다.문자열의 길이는 100을 넘지 않습니다.
	 * 
	 * 
	 * 입력 첫 줄에 문자열이 주어지고, 두 번째 줄에 문자가 주어진다.
	 * 
	 * 문자열은 영어 알파벳으로만 구성되어 있습니다.
	 * 
	 * 
	 * 출력 첫 줄에 해당 문자의 개수를 출력한다.
	 * 
	 * 
	 * 예시 입력 1
	 */
	public static void main(String[] args) {
		// 홍재영 알고리즘 1일차 공부입니다.
		exam1 exam1 = new exam1(); 
		Scanner in = new Scanner(System.in);
		String str = in.next();
		char ch1 = in.next().charAt(0);
		System.out.println(exam1.solution(str, ch1));
	}
	public int solution(String str,char ch1) {
		
		//문자열의 개수
		int count = 0;
		//비교 해줄거면 대소문자 통일 해주기
		str = str.toUpperCase();
		
		ch1 = Character.toUpperCase(ch1);
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == ch1) {
				count += 1;
			}
		}
		return count;
	}
	//문자열을 입력 받고 문자가 이 문자열에 몇번 포함 되었는지 풀때는 일단 대소문자 둘중 하나로 통일하고 문자열 자체를 반복문을 돌려서 해당 문자열의 i 번째 문자가 주어진 문자열과 일치하는지 비교후
	//카운트 변수를 증감 시켜 주면 된다.
}

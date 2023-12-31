package algorithm1;

import java.util.*;

/*3. 문장 속 단어
설명

한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.

문장속의 각 단어는 공백으로 구분됩니다.


입력
첫 줄에 길이가 100을 넘지 않는 한 개의 문장이 주어집니다. 문장은 영어 알파벳으로만 구성되어 있습니다.


출력
첫 줄에 가장 긴 단어를 출력한다. 가장 길이가 긴 단어가 여러개일 경우 문장속에서 가장 앞쪽에 위치한

단어를 답으로 합니다.*/
public class exam3 {
	public static void main(String[] args) {
		exam3 exam3 = new exam3(); 
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		System.out.println(exam3.solution(str));
	}
	public String solution(String str) {
		String [] arr = str.split(" ");
		String answer = "";
		
		for(String i : arr) {
			if(i.length() > answer.length()){
				answer = i;
			}
		}
		return answer;
	}
	//접근법
	
	/*
	 * 1.가장큰거 찾아서 최종으로 반환 시키고 싶을떄는 제일작은걸로 일단 최초 값을세팅 해놓고 그거 보다 크면 그 변수에 계속 갈아 끼우는
	 * 식으로 접근하면 된다. 2.공백 포함 문자열 입력 받을때는 scanner.nextline으로 3.spit으로 하면 파라미터인 문자 기준으로
	 * 한요소씩 쪼개서 배열로 만들어준다 그래서 배열로 선언해 주면서 변수로 받아줘도 되지
	 */
}

package algorithm1;

import java.util.*;

public class exam12 {
//	11. 문자열 압축
//	설명
//
//	알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
//
//	문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
//
//	단 반복횟수가 1인 경우 생략합니다.
//
//
//	입력
//	첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
//
//
//	출력
//	첫 줄에 압축된 문자열을 출력한다.
//
//
//	예시 입력 1 
//
//	KKHSSSSSSSE
//	예시 출력 1
//
//	K2HS7E
//	예시 입력 2 
//
//	KSTTTSEEKFKKKDJJGG
//	예시 출력 2
//
//	KST3SE2KFK3DJ2G2
	public static void main(String[] args) {
		// 홍재영 알고리즘 1일차 공부입니다.
		exam12 exam1 = new exam12(); 
		Scanner in = new Scanner(System.in);
		String str = in.next();
		System.out.println(exam1.solution(str));
	}
	public String solution(String str) {
		//count 증감조건을 차수와 차수 다음 문자가 같은지로 비교 할것이기떄문에 마지막바퀴의 차수 다음 인덱스가하나 필요함
		str = str + " ";
		
		String answer = "";
		
		int count = 1;
		
		for(int i = 0; i <str.length() -1; i++) { //반복돌면서
			if(str.charAt(i) == str.charAt(i+1)) {  //해당 차수와 뒷차수가 같ㄷ면 ?
				count ++;              //증감 변수 증가 시키기
			}else {            //해당차수와 뒷자리 문자 다르다면
				answer += str.charAt(i); //해당 차수 문자추가 하고
				if(count > 1) {  //누적 되어있던게 1이상이라면
					answer += String.valueOf(count);  //그 1이상 누적된 숫자 도 붙여주라
					count = 1;
				}
			}				
		}
		return answer;
	}
}


/* 잘못 짰던 코드 */

/* 놓쳤던포인트 */

// 아래 풀이는문자열 내에서 총 반복 되는횟수를 카운팅한건데 이 문제에서는 애초에 연속 되서 반복되는 경우에만 옆에다가숫자 붙여서쓰라고했음 이중 반복을 돌릴 필요가 없는것

//String answer = "";
//int count = 0;   --> 첫 회문이어도 무조건 하나가있긴하잖아 count 를 1로 두고 시작했어야했어
//char ch = 0;
//for(int i = 0; i < str.length(); i++) {
//	
//	//해당차수의 문자
//	ch = str.charAt(i);
//	//해당문자 출현숫자
//	count = 0;
//	//answer에 이미 해당 차수에 문자가 들어가있지 않거나 첫 회문 일때 
//	answer += ch;
//	//중복인경우에만
//	if(str.indexOf(str.charAt(i)) == i) {
//		for(int j = 0; j < str.length(); j++) {
//			if(ch == str.charAt(j)) {
//				count ++;
//			}
//		}
//		
//		if(count > 1) {
//			answer += count;
//		}
//	}
//}
//return answer;
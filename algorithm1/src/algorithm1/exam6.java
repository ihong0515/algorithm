package algorithm1;

import java.util.*;

/*6. 중복문자제거
설명

소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.

중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.


입력
첫 줄에 문자열이 입력됩니다. 문자열의 길이는 100을 넘지 않는다.


출력

1. 반복 문돌면서 문자열의 한글자씩조회
2. 반복문의그 한글자를조회하는 차수 내에서 왼쪽 부터 한번 오른쪽 부터 한번 다 조회 해서 일치 하는게 있는지 확인 없다면 문자열 answer에 추가해주기

--> 위 방법은 어림도 없었음 옳은 풀이

반복문 돌면서 해당 차수의 문자가 인덱스 오브(차수) 한 문자 와 일치하는가 일치 한다면 중복이 없는 거지

해당 문자가 처음 등장하는 인덱스 번호와 현재 해당 문자가 존재하는 인덱스가 같으면 그 문자는 중복되지 않는 문자인 것이다.

--> 현 재 바퀴에서 의 문자를 찾은 인덱스가  그 문자를 문자열에서 최초롤 발견한 인덱스랑 같으면 그게 곧 그건인거지

    반면에 현재 바퀴에서 찾은 문자열의 인덱스와 최초 index of 로 찾은 인덱스가 다르다면 최초로 찾아지고 한번 더 찾아 졌다는 뜻이 되는 것임. ㅇㅋ?
*/
public class exam6 {
	
	public static void main(String[] args) {
		exam6 exam6 = new exam6(); 
		Scanner in = new Scanner(System.in);
		String str = in.next();
		System.out.println(exam6.solution(str));
	}
	public String solution(String str) {
		//제거 하고 반환 할문자열
		//앞부터 돌면서 한칸씩 이동하며 서브스트링으로 다읽어야 함
		//하 인덱스 of쓰면 이런거 안해 도 되는데 오바 했다.
		String answer = "";
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < str.length(); i++) {
			
			if(str.indexOf(str.charAt(i)) == i) {
				sb.append(str.charAt(i));
			}
		}
		answer = sb.toString();
		
	   return answer;
	   
	}
	/*
	 * indexOf 메서드 사용법 
	 * 스트링.indexOf() 메서드 --> 파라미터는 char자료형으로 들어가고 문자열 내에서 그 문자의 인덱스를 int로 반환해준다. 
	 * 스트링.indexOf(String s)
	 *  스트링.indexOf(int 아스키 코드) 
	 *  스트링.indexOf(String s,int 시작할 인덱스) --> 지정한 인덱스부터 최초로 발견되는 문자의위치를 반환해 준다. 
	 * 스트링.indexOf(int 아스키 코드,int 시작할 인덱스) --> 지정한 인덱스부터 최초로 발견되는 문자의위치를 반환해 준다.
	 * 
	 */
	//String문자열.charAt(인덱스)  -> 해당 문자열에ㅓ 해당 인덱스에 있는 char문자 반환해 준다. 
}

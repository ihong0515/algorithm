package algorithm1;

import java.util.*;

/*6. 중복문자제거
설명

소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.

중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.


입력
첫 줄에 문자열이 입력됩니다. 문자열의 길이는 100을 넘지 않는다.


출력
*/
public class exam6 {
	
	public static void main(String[] args) {
		exam6 exam1 = new exam6(); 
		Scanner in = new Scanner(System.in);
		String str = in.next();
		System.out.println(exam1.solution(str));
	}
	public String solution(String str) {
		//제거 하고 반환 할문자열
		//앞부터 돌면서 한칸씩 이동하며 서브스트링으로 다읽어야 함
		String answer = "";
		char [] arr = str.toCharArray();
		int lt = 0,rt = arr.length - 1;
		
		while(lt < rt) {
			if(arr[lt] == arr[rt]) {
				answer += arr[lt];
			}
			else {
				
			}
		}
	   return answer;
	}
	//문자열을 입력 받고 문자가 이 문자열에 몇번 포함 되었는지 풀때는 일단 대소문자 둘중 하나로 통일하고 문자열 자체를 반복문을 돌려서 해당 문자열의 i 번째 문자가 주어진 문자열과 일치하는지 비교후
	//카운트 변수를 증감 시켜 주면 된다.
}

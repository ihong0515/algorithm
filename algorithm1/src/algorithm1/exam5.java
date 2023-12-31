package algorithm1;

import java.util.*;

/*5. 특정 문자 뒤집기
설명

영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,

특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.


입력
첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.


출력
첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.


예시 입력 1 

a#b!GE*T@S
예시 출력 1

S#T!EG*b@a*/
public class exam5 {
	
	public static void main(String[] args) {
		// 홍재영 알고리즘 1일차 공부입니다.
		exam5 exam5 = new exam5(); 
		Scanner in = new Scanner(System.in);
		String str = in.next();
		System.out.println(exam5.solution(str));
	}
	public String solution(String str) {
		
		char [] arr = str.toCharArray();
		int lt = 0,rt = arr.length - 1;
		//왼쪽 오른쪽이 각각 영언지 특수문잔지 가각 확인하고  이동 그쪽 만 이동해야지
		//착각 했던 부분 안바꾸건 바꾸건 간에 자리이동은 해주어야함
		//위에다가 조건절을 배치한 이유는 이동을 먼저 시키고 바꾸는 작업 을시키고 한번더 이동 시킬라고 그랬던거
		while(lt < rt) {
			//알파벳이 아닌지??? 확인 
			if(!Character.isAlphabetic(arr[lt])) {
				lt++;
			}else if(!Character.isAlphabetic(arr[rt])){
				rt--;
			}else {
				char check = arr[lt];
				arr[lt] = arr[rt];
				arr[rt] = check;
				lt++;
				rt--;
			}
		}
		String answer = String.valueOf(arr);
		return answer;
	}

}

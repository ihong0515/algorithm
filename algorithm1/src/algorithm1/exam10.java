package algorithm1;

import java.util.*;

public class exam10 {
	/*
	 * 10. 가장 짧은 문자거리 설명
	 * 
	 * 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
	 * 
	 * 
	 * 입력 첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
	 * 
	 * 문자열의 길이는 100을 넘지 않는다.
	 * 
	 * 
	 * 출력 첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.
	 * 
	 * 
	 * 예시 입력 1
	 * 
	 * teachermode e 예시 출력 1
	 * 
	 * 1 0 1 2 1 0 1 2 2 1 0
	 */
	
	//반복문 돌면서 그 문자와 일치 하는 indexof(문자,시작 문자) 로 인덱스 번호를 추출해서 문자열에 추가 해준다. 
	public static void main(String[] args) {
		exam10 exam10 = new exam10(); 
		Scanner in = new Scanner(System.in);
		String str = in.next();
		char ch1 = in.next().charAt(0);
		for(int a : exam10.solution(str, ch1) ) {
			System.out.println(a);
		}
		
	}
	public int [] solution(String str,char ch1) {
		int [] answer = new int [str.length()];
		int distance = 1000;
		
		for(int i =0; i <str.length(); i++) {
			if(str.charAt(i) == ch1) {
				distance = 0;
				answer[i] = distance;
			}else {
				distance ++;
				answer[i] = distance;
			}
		
		}
		distance = 1000;
		
		for(int i = str.length() - 1; i >= 0; i--) {
			if(str.charAt(i) == ch1) {
				distance = 0;
			}else {
				distance ++;
				answer[i] = Math.min(answer[i],distance); // 이게 1001 1000도 날려주긴한다.
			}
		}
		return answer;
	}
	//distance 변수는 왜 주어진 문자를 만나면 0 이 되는가  -> 0이 된다는것 그 단어가 그 0 이된 지점에있다는것을 알려 줌과 동시에 그 지점에서 1씩 증가하는것은 그 지점과 반복문 해당 차수 단어의 거리가 그만큼 벌어짐을 의미 한다.
	//그리고 그렇게 거리를 구해서 배열 요소로 담았는데 조건이 하나 충족 되지 않음 더 가까운 쪽에서 출몰한 문자와의 거리를 적어야 한다는 것.
	//따라서 왼쪽에서 반복 한번 우측에서 반복 한번더 돌려 준다 어느 방향먼저 하는지는 상관이 없는데 마지막으로 반복 돈것에서 배열에 담겨있는 거리 값과 그 반복문에서의 거리 크기를 비교해서 저 작은 크기의 거리를 최종 배열 요소로 넣어주어야 한다.
	//최초에 거리 변수는 터무니 없게 큰 값으로 설정해야함 왜냐하면 왼쪽에서 시작할때는 앞에 아무값도 없어서 그지점이 0 인거 아니면 우측 반복으로 비교 돌릴때 문제가 생긴다
	
	
	
//	Math 의 min 메서드  min 메서드는 파라미터두개 들어가는데 두 인자값중에 정수 롱 실수 더블 에서 작은 값을리턴 하는함수 이다.
//
//	distance는 왜 1000으로 두는 이유는?
//			
//			이 설명의 핵심은 문자열의 시작 지점에서 문자열 외부로 "무한히 멀리" 떨어져 있다고 가정하고 문제를 접근하는 것입니다.
//			
//			첫 바퀴는 왼쪽의 발견된 문자 ch1으로 부터 멀어진 거리를각각 나타내는것 ,  오른쪽 기준 첫바퀴는 우측의 ch1을 기준으로 부터 떨어진 거리를 측정한다는것 
//			
//			이 문자열 외부는 해당사항이 아니니 무수히 멀다로  가장 하는것이 옳다.
//			
//			그니까 첫 차수 왼쪽에 아무것도 없고 오른쪽에서 부터 의 기준점이 문자열 밖인데 무수히 멀겠지 니가어케 아냐 걍 크게 둬라 이렇게 인식하자.
}

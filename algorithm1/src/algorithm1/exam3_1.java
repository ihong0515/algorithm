package algorithm1;

import java.util.*;

/*3. 문장 속 단어(subString 으로 풀기)
설명

한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.

문장속의 각 단어는 공백으로 구분됩니다.


입력
첫 줄에 길이가 100을 넘지 않는 한 개의 문장이 주어집니다. 문장은 영어 알파벳으로만 구성되어 있습니다.


출력
첫 줄에 가장 긴 단어를 출력한다. 가장 길이가 긴 단어가 여러개일 경우 문장속에서 가장 앞쪽에 위치한

단어를 답으로 합니다.*/
public class exam3_1{
	public static void main(String[] args) {
		exam3_1 exam3_1 = new exam3_1(); 
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		System.out.println(exam3_1.solution(str));
		System.out.println(exam3_1.solution2(str));
	}
	public String solution(String str) {
		
		int m = Integer.MIN_VALUE;
		String [] arr = str.split(" ");
		
		String answer = "";
		
		for(String i : arr) {
			//여기서는길이를따로 뺴주나 보다
			int length = i.length();
			if(length > m) {	
				//기준이 되는 m도 최신화 해주어야 한다.
				m = length;
				answer = i;
			}
		}
		return answer;
	}
	//subString 을 이용한 접근 방법
	//문자열.substring(시작인덱스,끝인덱스 - 1) 끝인덱스로 지칭한거에서 한칸 앞까지 반환 해준다잉
	public String solution2(String str) {
		String answer = "";
		int m = Integer.MIN_VALUE ,pos;
		//pos자체는 띄어쓰기가 발견되는 위치이다.
		//indexOf는 해당글자가 발견이 안되면 -1을 반환 한다이
		//빠져나갈 조건을 어떻게 증감 시켜 줄 것인가  -> 필요 한거 쓰면 문자열을 쓴거 도려낸걸로 변경 해주면 된다.
		while((pos = str.indexOf(" ")) != -1){
			//첫바퀴는처번째 공백 발견 전까지 발견이 된다.
			String tmp= str.substring(0,pos);
			int len = tmp.length();
			if(len > m) {
				m = len;
				answer = tmp;
			}
			//앞에 쓴 공백과 공백 앞 도맥을 도려낸다.
			//이제그 이후 다음의빈공백을 찾겠지.
			str = str.substring(pos + 1);
			//그치만 마지막 단어만 남았을때는 뒤에 공백이 없으니까 적용을 못하겠지
			
		}
		//마지막한도막만 남았을떄는 그것만 따로 비교를 해줘야 하니까?
		if(str.length() > m) {
			answer = str;
		}
		return answer;
	}
	//접근법
	
	/*
	 * while문을 잘안써서 사용이 익숙치 않았던 것 같다
	 * 
	 * while문은 주로 증감 변수 밖에 다가 초기화 해주고 반복문 내에서 증감 시켜서 조건이 언젠간 거짓이 될수 있도록 해준다. 물론 조건은
	 * 특정 크키 보다 작은조건 하에서가 될것
	 */
	
}

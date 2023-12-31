package algorithm1;

import java.util.*;

/*4. 단어 뒤집기
설명

N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.


입력
첫 줄에 자연수 N(3<=N<=20)이 주어집니다.

두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되어 있습니다.


출력
N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력합니다.*/
public class exam4 {
	public static void main(String[] args) {
		exam4 exam4 = new exam4(); 
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String [] arr = new String [n];
		for(int i =0; i < n; i++) {
			arr[i] = in.next();
		}
		for(String x : exam4.solution(n,arr)) {
			System.out.println(x);
		}
	}
	//String builder 쓰고 뒤집기. 
	public ArrayList<String> solution(int n ,String[] str) {
		
		ArrayList<String> answer = new ArrayList<>();
		for(String x : str) {

			StringBuilder sb = new StringBuilder(x);
			answer.add(sb.reverse().toString());
		}
		return answer;
	}
	//특정문자만 뒤집고 싶다.???
	//ex good   g와 d o 와 o 
	public ArrayList<String> solution2(int n , String [] str) {
		
		ArrayList<String> answer = new ArrayList<>();
		
		for(String x : str) {
			char [] cArr = x.toCharArray(); //cArr은 문자배열이다.
			
			//왼쪽 첫 인덱스 lt  끝글자 인덱스를 rt 
			//이렇게지정해서 lt는오를쪽으로 증가 rt는 좌측으로 감소 while 문 조건이 lt < rt가디면 되려나
			
			int lt = 0 , rt = cArr.length - 1;
			
			//입력 받은 문자열 들이 있는 배열의반복 문 안에서 한 차수 안에서 그 문자열을 단어 배열로 쪼개서 while문을 한번더 돌리는것이다.
			while(lt < rt) {
				//이렇게 사이드에서오면서 바꾸는 거 알때는 맨처음 값을 체크해놓을 통 하나는 준비해야한다이.
				char check = cArr[lt];
				cArr[lt] = cArr[rt];
				cArr[rt] = check;
				
				//왼쪽 증가
				//오른쪽 감소 
				lt ++;
				rt --;
			}
			String tmp = String.valueOf(cArr);
			answer.add(tmp);
		}
		return answer;
	}
	//String 은새로 객체 생성이라 변경이 아님 그래서 그냥 빌더러 바꾸어서 만들고 추가 시킨다음 스트링바꾸는게 낭비가 없다이.
	//문자여로 이루어진 배열 내부에서 반복문 돌기
	//반복문 내에서 각문자열 마다 단어배열로 만들어 주고 그 안에서 while 반복문 다시 돌려주기 왼쪽 끝 오른쪽 끝 맞춰서 하나씩 좁혀오면서 바꿔주기 조건은 왼쪽 끝 인덱스가 오른쪽 끝 인덱스ㅗ 보다 작을때
	
}

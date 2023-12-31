package algorithm2;

import java.util.*;

public class exam6 {
//	6. 뒤집은 소수
//	설명
//
//	N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램을 작성하세요.
//
//	예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 그러면 23을 출력한다. 단 910를 뒤집으면 19로 숫자화 해야 한다.
//
//	첫 자리부터의 연속된 0은 무시한다.
//
//
//	입력
//	첫 줄에 자연수의 개수 N(3<=N<=100)이 주어지고, 그 다음 줄에 N개의 자연수가 주어진다.
//
//	각 자연수의 크기는 100,000를 넘지 않는다.
//
//
//	출력
//	첫 줄에 뒤집은 소수를 출력합니다. 출력순서는 입력된 순서대로 출력합니다.
//
//
//	예시 입력 1 
//
//	9
//	32 55 62 20 250 370 200 30 100
//	예시 출력 1
//
//	23 2 73 2 3
	
	//스트링 빌더를 반복문 차수에서 생성 그리고 reverse 로 뒤집기.
	//스트링 빌더 parstint로 정수 체크 
	//소수 체크떻게 해지
	//뒤집고 parseint 해서 정수 만들고 소수인지 체크 ( 소수 체크용 배열 만들기) 
	//소수 체크를 어떻게 하냐 반복문을 그 배열의 크기 만큼 2부터 시작해서 자기자신 전까지 돌도록 반복문 돌리고 해당 숫자를 해당 차수로 나눈 나머지가 0인게 하나도 없어야 소수로 판별 flag 변수 하나 생성해도 되고
//	if 문을 (차수 숫자 % 인덱스 == 0){
//		아무것도 안한
//	}else {
//		반환할 배열에 해당 값 집어 넣음
//	}
	//첫번째가 소수라면 체크 배열 반복
	public static void main(String[] args) {
		// 홍재영 알고리즘 1일차 공부입니다.
		exam6 exam1 = new exam6(); 
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String [] arr = new String [n];
		
		for(int i =0; i < n; i++) {
			arr[i] = in.next();
		}
		for(int a : exam1.solution(n,arr)) {
			System.out.print(a + " ");
		}
		
	}
	public ArrayList<Integer>  solution(int n,String [] arr) {
		ArrayList<Integer> answer = new ArrayList<>();
		int flag = 0;
		
		for(int i =0;  i < arr.length; i++) {
			StringBuilder sb = new StringBuilder(arr[i]);
			int r_num = Integer.parseInt(sb.reverse().toString());
			
			for(int j = 2; j < r_num; j++) {
				if(r_num % j == 0) {
					flag ++;
				}
				
			}
			if(flag == 0 &&  r_num != 1) {
				answer.add(r_num);
			}
			flag = 0;
		}
		return answer;
	 }
	//다른 로직 문자열 말고 정수인상태로 뒤집는방법 10을 나눈 나머지와 10으로 나눈 몫을 이용하는 방법
	public ArrayList<Integer>  solution(int n,int [] arr) {
		ArrayList<Integer> answer = new ArrayList<>();
		
		for(int i =0;  i < arr.length; i++) {
			int tmp = arr[i];
			int res = 0;
			
			while(tmp == 0) {        
				int t = tmp % 10;      //모든 정수는 10으로 나눈 나머지는 한자리 수가 나온다.
				res = res * 10 + t;    //나온 한자리 수를 뒤집은거 담을 통으로 준비한 res 에 10을 곱하고 담는다. 10을 곱하는것은 최초 0일때가 아니라면 한자리왼쪽으로 밀어내기 위함 이런식으로 밀어내면서 반대로 뒤집는것
				tmp = tmp / 10;        //우측 한자리 10으로 나눠서 소거하고 통에 담았으니까 소거 해야 한다. 정수를 10으로 나눈 몫을 구하면 한자리가 소거 된다.
											// -> 이런식으로 tmp 가 10씩 나눈 몫으로 초기화 되다가 10보다 작은 상태에서 나누어 지게 되면 몫이 0 이나오니까 tmp = 0 이 된다. 이시점에서 while문 종료 된다.
			}
			//소수 판별 메서드를 boolean방식으로 반환하도록 따로 생성해서 사용하기
			if(isSosu(res)) {
				answer.add(res);
			}
		}
		return answer;
	 }
	public boolean isSosu(int res) {
		
		for(int i = 2; i < res; i++) { // 0,1 은 애초에 소수가 아니다이 2부터 돌면서 들어온 수의 약수가 있는지를 찾아봐야지 범위가 2부터 해당 숫자 전까지 수중에 약수가 있으면 소수가 아닌것이다.
			if(res == 1) {
				return false;
			}
			
			if(res % i == 0 ) {
				return false;
			}
			
		}
		return true;
	}
}

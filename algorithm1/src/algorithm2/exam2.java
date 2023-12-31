package algorithm2;

import java.util.*;

public class exam2 {
//	2. 보이는 학생
//	설명
//
//	선생님이 N명의 학생을 일렬로 세웠습니다. 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때, 맨 앞에 서 있는
//
//	선생님이 볼 수 있는 학생의 수를 구하는 프로그램을 작성하세요. (앞에 서 있는 사람들보다 크면 보이고, 작거나 같으면 보이지 않습니다.)
//
//
//	입력
//	첫 줄에 정수 N(5<=N<=100,000)이 입력된다. 그 다음줄에 N명의 학생의 키가 앞에서부터 순서대로 주어진다.
//
//
//	출력
//	선생님이 볼 수 있는 최대학생수를 출력한다.
//
//
//	예시 입력 1 
//
//	8
//	130 135 148 140 145 150 150 153
//	예시 출력 1
//
//	5
	
	
	/* 로직 */
	//앞에 보이는 학생들 보다 크면 보이는 수로 카운트 되는 거니까 지나간 앞차수 번애들중에서 제일 큰게 플래그로 남아 있어야 되겠구나.
	//앞의 문자와 달라진 점은 앞의 문제는 앞에 보다 크면 일단 증가 시키고 플래그도 무조건 앞에꺼로 바꿔 줬는데
	//얘는 현재 까지 나온것중에 최대 값이어야 하니까if 조건으로 나왔던 것들 보다 크면?  flag를 갱신해 주어야 하는 것이지.
	
	
	public static void main(String[] args) {
		// 홍재영 알고리즘 1일차 공부입니다.
		exam2 exam2 = new exam2(); 
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int [] arr = new int [n];
		for(int i =0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		System.out.print(exam2.solution(n, arr));
	}
	public int  solution(int n,int [] arr) {
		int answer = 0;
		
		int flag = Integer.MIN_VALUE;
		
		for(int i =0;  i < arr.length; i++) {
			
			if( flag < arr[i]) {
				
				flag = arr[i];
				answer ++;
			}
			//해당 차수를 초기화 해주는데 해당 차수의 값으로 저장해도으면 다음 차수의 비교식에서는 이전 차수의 값으로 남아 있을 수가 있다.
			
		}
		return answer;
	}	
}

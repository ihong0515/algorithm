package algorithm2;

import java.util.*;

public class exam1 {
	/*
	 * 1. 큰 수 출력하기 설명
	 * 
	 * N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.
	 * 
	 * (첫 번째 수는 무조건 출력한다)
	 * 
	 * 
	 * 입력 첫 줄에 자연수 N(1<=N<=100)이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.
	 * 
	 * 
	 * 출력 자신의 바로 앞 수보다 큰 수만 한 줄로 출력한다.
	 * 
	 * 
	 * 예시 입력 1
	 * 
	 * 6 7 3 9 5 6 12 예시 출력 1
	 * 
	 * 7 9 6 12
	 */
	
	
	/* 로직설명 */
	
//	반복 통해서 입력받아배열에 저장하고 배열을 파라미터로 넘겨서 함수를 진행 시키고 함수의 answer을 arrayList로 반환한다(그냥 배열은 크기가 가변적이기 않기 때문이다.)
//	
//	함수로직
//	
//	반복문을 통해서 돌며 해당 차수의 배열 순서 값이 앞자리랑 비교했을대 큰지 아닌지에 따라서 반환되는 어레이 리스트에 담는다.
//	
//	단 이때 첫번째 차수일 경우 앞자리 값이 존재 하지 않기 때문에 최초 비교 값은 Integer.minValue를 통해서 제일 작게 세팅하고 시작한다.
//	
//	그리고 첫 반복 문 이후에 해당 기준 값응 비교 문 아래에다가 arr[i] 로 초기화 해서 다음 비교 문 직전 까지 이전 변수를 담고 있을 수 있도록 저장해 준다.
	public static void main(String[] args) {
		// 홍재영 알고리즘 1일차 공부입니다.
		exam1 exam1 = new exam1(); 
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int [] arr = new int [n];
		for(int i =0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		for(int a : exam1.solution(n,arr)) {
			System.out.print(a + " ");
		}
		
	}
	public ArrayList<Integer>  solution(int n,int [] arr) {
		ArrayList<Integer> answer = new ArrayList<>();
		int flag = Integer.MIN_VALUE;
		
		for(int i =0;  i < arr.length; i++) {
			
			if(flag < arr[i]) {
				answer.add(arr[i]);
			}
			//해당 차수를 초기화 해주는데 해당 차수의 값으로 저장해도으면 다음 차수의 비교식에서는 이전 차수의 값으로 남아 있을 수가 있다.
			flag = arr[i];
		}
		return answer;
	}	
}

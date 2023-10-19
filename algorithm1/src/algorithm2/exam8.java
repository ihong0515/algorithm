package algorithm2;

import java.util.*;

public class exam8 {
	/*
	 * 8. 등수구하기 설명
	 * 
	 * N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램을 작성하세요.
	 * 
	 * 같은 점수가 입력될 경우 높은 등수로 동일 처리한다.
	 * 
	 * 즉 가장 높은 점수가 92점인데 92점이 3명 존재하면 1등이 3명이고 그 다음 학생은 4등이 된다.
	 * 
	 * 
	 * 입력 첫 줄에 N(3<=N<=100)이 입력되고, 두 번째 줄에 국어점수를 의미하는 N개의 정수가 입력된다.
	 * 
	 * 
	 * 출력 입력된 순서대로 등수를 출력한다.
	 * 
	 * 
	 * 예시 입력 1
	 * 
	 * 5 87 89 92 100 76 예시 출력 1
	 * 
	 * 4 3 2 1 5
	 */
	public static void main(String[] args) {

		exam8 exam7 = new exam8(); 
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int [] arr = new int [n];
		for(int i =0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		for(int a : exam7.solution(n, arr)) {
			System.out.print(a + " ");
		}
		
	}
	public ArrayList<Integer>  solution(int n,int [] arr) {
		ArrayList<Integer> answer = new ArrayList<>();
		
		//등수 라는것을 구별할게 다 입력되있고, 그 순서도 배열에 담겨져 있다면
		//등수 통을하나  지정하고 그 해당 점수가 해당되는 배열의 차수에서 그 점수를 지정하고
		//그 지정된 점수를 다시한번 배열 돌려서 그 배열의 점수들이랑 다음꺼 비교 다음꺼 비교 이렇게 해보는거지
		//배열에서 더 높은 점수가있다면 등수는 하나씩 뒤로 밀려나니까 1씩증가하겠지 지가 더크면 그 자릴 유지하고
		//그리고 최초 배열 차수에서 그반환된 등수를 배열에 추가해주면 되는 것이다.
		
		for(int i =0;  i < arr.length; i++) {
			int rank = 1;
			int score = arr[i];

			for(int j = 0; j < arr.length; j++) {
				
				if(score < arr[j]) {
					//등수는 뒤에 애가 클때 마다하나씩 증가 하면 되겠네 
					rank ++; 
				}
			}
			answer.add(rank);
		}
		return answer;
	}	
}

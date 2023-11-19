package algorithm3_two_pointer;

import java.util.*;

public class exam3 {
	/*2. 공통원소 구하기
	설명

	A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.


	입력
	첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어집니다.

	두 번째 줄에 N개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.

	세 번째 줄에 집합 B의 크기 M(1<=M<=30,000)이 주어집니다.

	네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.

	각 집합의 원소는 1,000,000,000이하의 자연수입니다.


	출력
	두 집합의 공통원소를 오름차순 정렬하여 출력합니다.


	예시 입력 1 

	5
	1 3 9 5 2
	5
	3 2 5 7 8
	예시 출력 1

	2 3 5*/
	public static void main(String[] args) {
		// 홍재영 알고리즘 1일차 공부입니다.
		exam3 exam1 = new exam3(); 
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int k = in.nextInt();
		int[]arr1 = new int[n];
		
		
		for(int i = 0; i < n; i++) {
			arr1[i] = in.nextInt();
		}
		
		System.out.println(exam1.solution(arr1,k));
	}
	public int solution(int[] arr1, int k) {
		
		int answer = Integer.MIN_VALUE;
		int left = 0;
		int right = 0;
		
		while(left < arr1.length && right < arr1.length) {
			int sum = 0;
			
			if(right - left == k) {
				
				for(int i = left; i <= right; i++) {
					 sum = sum + arr1[i];
				}
				if(sum > answer) {
					answer = sum;
				}
				right ++;
				
			}else if(left == arr1.length){
				
				left  ++;
				right = 0; 
			
			}else {
				
				right ++;
				
			}
			
			
		}
		
		return answer;
			
	}
		
		
}

package algorithm3_two_pointer;

import java.util.*;

public class exam4 {
	/*
	 * 4. 연속 부분수열 설명
	 * 
	 * N개의 수로 이루어진 수열이 주어집니다.
	 * 
	 * 이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을 작성하세요.
	 * 
	 * 만약 N=8, M=6이고 수열이 다음과 같다면
	 * 
	 * 1 2 1 3 1 1 1 2
	 * 
	 * 합이 6이 되는 연속부분수열은 {2, 1, 3}, {1, 3, 1, 1}, {3, 1, 1, 1}로 총 3가지입니다.
	 * 
	 * 
	 * 입력 첫째 줄에 N(1≤N≤100,000), M(1≤M≤100,000,000)이 주어진다.
	 * 
	 * 수열의 원소값은 1,000을 넘지 않는 자연수이다.
	 * 
	 * 
	 * 출력 첫째 줄에 경우의 수를 출력한다.
	 * 
	 * 
	 * 예시 입력 1
	 * 
	 * 8 6 1 2 1 3 1 1 1 2 예시 출력 1
	 * 
	 * 3
	 */
	public static void main(String[] args) {
		exam4 exam1 = new exam4(); 
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		int[]arr1 = new int[n];
		
		
		for(int i = 0; i < n; i++) {
			arr1[i] = in.nextInt();
		}
		
		System.out.println(exam1.solution(arr1,n,m));
	}
	public int solution(int[] arr1,int n ,int m) {
		
		int answer = 0;
		int right = 0;
		int left = 0;
		int sum = 0;
		
		while(left < n && right < n) {
			
			sum  = sum + arr1[right];
			
			if(right - left >= 2 && sum == m) {
				answer ++;
				left ++;
				right = left;
				sum = 0;
			}else if(sum > m) {
				left ++;
				right = left;
				sum = 0;
			}else if(right == n-1 && sum < m) {
				left ++;
				right = left;
				sum = 0;
			}else{
				right ++;
			}
		}
		
		return answer;
			
	}
		
	// sum = sum + sum[right] 가 else 문에 있을땐 오답 나옴
	// 이렇게 안해주면 증감을 구분할 대상이 맨위에 항상 주어져야 조건문이 도는거지 언제는 주어지고 언제는 안주어지면 될까??
}

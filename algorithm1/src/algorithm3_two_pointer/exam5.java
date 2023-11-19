package algorithm3_two_pointer;

import java.util.*;

public class exam5 {
//	6. 최대 길이 연속부분수열
//	설명
//
//	0과 1로 구성된 길이가 N인 수열이 주어집니다. 여러분은 이 수열에서 최대 k번을 0을 1로 변경할 수 있습니다. 여러분이 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.
//
//	만약 길이가 길이가 14인 다음과 같은 수열이 주어지고 k=2라면
//
//	1 1 0 0 1 1 0 1 1 0 1 1 0 1
//
//	여러분이 만들 수 있는 1이 연속된 연속부분수열은
//
//	Image1.jpg
//
//	이며 그 길이는 8입니다.
//
//
//	입력
//	첫 번째 줄에 수열의 길이인 자연수 N(5<=N<100,000)이 주어집니다.
//
//	두 번째 줄에 N길이의 0과 1로 구성된 수열이 주어집니다.
//
//
//	출력
//	첫 줄에 최대 길이를 출력하세요.
//
//
//	예시 입력 1 
//
//	14 2
//	1 1 0 0 1 1 0 1 1 0 1 1 0 1
//	예시 출력 1
//
//	8
	public static void main(String[] args) {
		exam5 exam1 = new exam5(); 
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		
		
		System.out.println(exam1.solution(n));
	}
	public int solution(int n ) {
		int answer = 0;
		int sum = 0;
		int left = 1;
		
		for(int right = 1; right <= n; right++) {
			sum+=right;
			
			if(right - left >= 2 && sum == n) {
				answer ++;
			}
			while(sum >= n) {
				sum -= left;
				left++;
				if(right - left >= 2 && sum == n) {
					answer ++;
				}
			}
		}
		
		return answer;
			
	}
		
	// sum = sum + sum[right] 가 else 문에 있을땐 오답 나옴
	// 이렇게 안해주면 증감을 구분할 대상이 맨위에 항상 주어져야 조건문이 도는거지 언제는 주어지고 언제는 안주어지면 될까??
}

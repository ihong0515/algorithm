package algorithm2;

import java.util.*;

public class exam4_1 {
	//피보나치 재귀함수 결과 담을 배열 미리 선언 해주기
	int [] arr ;
	
	public static void main(String[] args) {
		// 홍재영 알고리즘 1일차 공부입니다.
		exam4_1 exam4_1 = new exam4_1(); 
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		exam4_1.arr = new int [n];  //무조건 돌리고 싶은 수 기준  100번 돌리고 싶으면 101이 되야 하는것
		//함수의 반환을 미리 선언 해둔 변수를 초기화 값에 맞게 저장해 두었다면 그냥 이렇게 실행만 해주어도 ㄱㅊ
		exam4_1.solution(n - 1); //배열 길이 끝자리는 하나 뺴야하는거 알지?
		
		for(int a : exam4_1.arr) {
			System.out.print(a + " ");
		}
		
	}
	//재귀 함수를 사용하는 방법
	public int solution(int n) {
		//핵심은 피보나치는 맨앞 두개가 주어져야 한다 안그러면 피보나치 만들수가 없음 
		//그래서 두개를 미리지정해주고 반복을 그 두개 다음 배열 인덱스부터 시작한다.
		//네, 맞습니다. fibo 함수가 호출될 때마다 해당 값 k에 대한 피보나치 수가 계산되고, 그 결과는 memo 배열의 k 번째 요소로 저장됩니다.

/*		아래는 단계별로 어떻게 진행되는지 설명입니다:
		
		fibo(99) 호출: memo[99]를 계산하기 위해 fibo(98)과 fibo(97) 	호출.
		fibo(98) 호출: memo[98]를 계산하기 위해 fibo(97)과 fibo(96) 호출.
		fibo(97) 호출: memo[97]를 계산하기 위해 fibo(96)과 fibo(95) 호출.
		... (계속된 재귀 호출) ...
		
		끝내, fibo(2)와 fibo(1)은 각각 1을 반환하고, 그 이후로 호출된 fibo 함수들은 이전에 계산된 값을 사용하여 결과를 계산하고 memo 배열에 저장합니다.
		
		따라서 fibo(99) 호출이 완료되면, memo 배열은 인덱스 1부터 99까지 피보나치 수열의 값들로 채워집니다. 그리고 main 메서드에서 memo 배열의 값을 출력합니다.*/
		
		//초기값 인덱스 배열의 [0] [1] 을 초기화 안해 놓았던 상황임을 인지 못했다.
		// 일반 수열의 첫번쨰 두번쨰는 배열에서 0,1 번쨰라는 단순한 사실을간과 하였다
		//배열의길이가 일반 숫자와 같아지기위해선 배열의길이에서 1뺴야 한다는 단순한 사실을간과 하였다.
			if(arr[n] != 0) {
				return arr[n];
			}
			if(n == 0) {
				arr[n] = 1;
			}else if(n == 1) {
				arr[n] = 1;
			}
			else if(n >= 2) {
				arr[n] = solution(n - 2) + solution(n - 1);  //함수 내에서 재귀 하무로 호출 할떄는 인스턴스생성안해도 된다.
				
			}
			
			return arr[n];
	}	
}

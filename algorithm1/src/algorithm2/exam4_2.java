package algorithm2;

import java.util.*;

public class exam4_2 {
	int [] arr;
	public static void main(String[] args) {
		exam4_2 exam4_2 = new exam4_2(); 
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		exam4_2.arr = new int [n];  //무조건 돌리고 싶은 수 기준  100번 돌리고 싶으면 101이 되야 하는것
		//함수의 반환을 미리 선언 해둔 변수를 초기화 값에 맞게 저장해 두었다면 그냥 이렇게 실행만 해주어도 ㄱㅊ
		exam4_2.solution(n - 1); //배열 길이 끝자리는 하나 뺴야하는거 알지?
		
		for(int a : exam4_2.arr) {
			System.out.print(a + " ");
		}
	}
	//재귀 함수 없이 사용하는 방법
	public int solution(int n) {
		
		//핵심은 피보나치는 맨앞 두개가 주어져야 한다 안그러면 피보나치 만들수가 없음 
		//그래서 두개를 미리지정해주고 반복을 그 두개 다음 배열 인덱스부터 시작한다.
		if(arr[n] != 0) {
			return arr[n];
		}
		
		if(n < 2) {
			arr[n] = 1;
		}else if(n >= 2) {
			arr[n] = solution(n-2) + solution(n-1);
		}  
		return arr[n];
	}	
}

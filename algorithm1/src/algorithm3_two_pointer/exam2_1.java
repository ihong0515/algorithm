package algorithm3_two_pointer;

import java.util.*;

public class exam2_1 {
//	2. 공통원소 구하기
//	설명
//
//	A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.
//
//
//	입력
//	첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어집니다.
//
//	두 번째 줄에 N개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
//
//	세 번째 줄에 집합 B의 크기 M(1<=M<=30,000)이 주어집니다.
//
//	네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
//
//	각 집합의 원소는 1,000,000,000이하의 자연수입니다.
//
//
//	출력
//	두 집합의 공통원소를 오름차순 정렬하여 출력합니다.
//
//
//	예시 입력 1 
//
//	5
//	1 3 9 5 2
//	5
//	3 2 5 7 8
//	예시 출력 1
//
//	2 3 5
	
	
//	조회 할떄 타 배열 대상으로 비교 한다 쳤을떄 같은거 찾는 거는 뒷부분까지 탐색 해줘야하는데  대소 비교  경우는 일단 정렬 상태 확인 해보고, 되있는 사태면 그렇게 까지 안ㅇ해 줘도 된다. 
	
	//이건 좀 그러니까 받고 각각 배열 정렬 시켜 주자.
	
	public static void main(String[] args) {

		exam2_1 exam2 = new exam2_1(); 
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[]arr1 = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr1[i] = in.nextInt();
		}
		int m = in.nextInt();
		int[]arr2 = new int[m];
		
		for(int i = 0; i < m; i++) {
			arr2[i] = in.nextInt();
		}
		/*
		 * for(int i = 0; i < m; i++) { System.out.println(arr1[i]);
		 * System.out.println(arr2[i]); }
		 */
		
		for(int a : exam2.solution(arr1,arr2,n, m)) {
			System.out.print(a + " ");
		}
	}
	public ArrayList<Integer> solution(int[] arr1,int[] arr2,int m, int n) {
		
		ArrayList<Integer> answer = new ArrayList<>();
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		int left = 0;
		int right = 0;
		
		//하나라도 포인터가배열 포인터에 도달하면 멈춘다.
	      while(left < n && right < m){
	          
	          if(arr1[left] == arr2[right]){
	             
	        	  answer.add(arr1[left]);
	             
	             right++;
	             
	          } else if(right == m -1){
	             left++;
	             right = 0;
	          } else{
	             right ++;
	          }
	          

		
		
			
	      }
	      return answer;
	}		
}

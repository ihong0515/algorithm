package algorithm3_two_pointer;

import java.util.*;

public class exam1 {
	/*
	 * 1. 두 배열 합치기 설명
	 * 
	 * 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.
	 * 
	 * 
	 * 입력 첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
	 * 
	 * 두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
	 * 
	 * 세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
	 * 
	 * 네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
	 * 
	 * 각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.
	 * 
	 * 
	 * 출력 오름차순으로 정렬된 배열을 출력합니다.
	 * 
	 * 
	 * 예시 입력 1
	 * 
	 * 3 1 3 5 5 2 3 6 7 9 예시 출력 1
	 * 
	 * 1 2 3 3 5 6 7 9
	 */
	
//	arr1 left 와  arr2의 right를 비교하여서, arr[left ] < arr[right]  면 arr[left] 를 배열에 넣는다. 
//	
//	넣은쪽은 포인터 증가한다. 더작은 쪽을 결과배열에넣고 들어간 쪽 포인터를 하나씩증가 시킨다. 
//	
//	짧은 쪽 하나가 배열 길이 끝나 버린다.  n ,m 개중에  p1 < n   p2 < m  둘중에 누구하나 멈출떄 까지 
//	
//	남은 쪽은 쭉넣어버리면된다.
//	간과 한 부분 각 배열은이미 오름 차순이 정렬 된 상태라한 포인터에서비교 할때 그이후꺼까지 볼 필요가 없음
	
//	원인 :
//		
//		한포인터끼리비교 할떄 뒤에도 비교해 봐야 한다고 착각한거 
//
//		print ln으로 찍어서 오답난거 
	public static void main(String[] args) {

		exam1 exam1 = new exam1(); 
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
		
		
		for(int a : exam1.solution(arr1,arr2,n, m)) {
			System.out.println(a);
		}
	}
	public ArrayList<Integer> solution(int[] arr1,int[] arr2,int m, int n) {
		
		ArrayList<Integer> answer = new ArrayList<>();
		int left = 0;
		int right = 0;
		
		//하나라도 포인터가배열 포인터에 도달하면 멈춘다.
		while(left < arr1.length && right < arr2.length) {
			
			if(arr1[left] < arr2[right]) {
				
				answer.add(arr1[left]);
				left ++;
				
			}else if(arr1[left] > arr2[right]) {  //요건 써줄 필요 없는
				
				answer.add(arr2[right]);
				right ++;
				
			}else {
				answer.add(arr2[right]);
				answer.add(arr1[left]);
				right ++;
				left ++;
			}
		}
		//둘중 하나라도 아직 배열 끝 포인터에 도달 하지못했다면 도달할떄 까지.
		while(left < arr1.length || right < arr2.length) {
			
			if(left < arr1.length) {
				answer.add(arr1[left]);
				left++;
			}
			if(right < arr2.length) {
				answer.add(arr2[right]);
				right++;
			}
		}
		return answer;
			
	}
		
		
}

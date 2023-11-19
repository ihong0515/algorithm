package sort_algorithm;

import java.util.*;



public class bubble_sort {
	/* 버블정렬 알고리즘 구현 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int [] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		};
		bubble_sort bs = new bubble_sort();
		
		for(int a : bs.bubble_sort(arr)) {
			System.out.println(a);
		}
		
	}

	/*
	 * 시간 효율성에서 n은 처리해야 할 데이터 항목의 총 수를 나타낸다. O(n^2): 제곱 시간 복잡도. 입력 크기가 두 배가 되면 실행
	 * 시간은 대략 네 배가 됩니다. 최악의 경우 버블 정렬 별로 안좋은 잘 안쓴다. 최악의 경우  n-1)번의 비교를 n바퀴 돌아야 하기 떄문에 
	 */
	public int [] bubble_sort(int[]arr) {
		//자리 바꿀때 보관통
		int check = 0;
		//내림차순으로 정렬 할거면 크면 j - 1인덱스 자리에 큰수가 오도록 
		for(int i = 0; i < arr.length; i++) {
			//앞에수부터 배열로 시작해서 뒤에 숫자랑 비교해서 큰 수를 오름차순이면 뒤에 내림차순이면 앞에 놓는다.
			//첫 번째 반복 후에는 가장 큰 원소가 배열의 마지막 위치로 이동합니다. 두 번째 반복 후에는 두 번째로 큰 원소가 마지막에서 두 번째 위치로 이동하게 됩니다.
			for(int j = 1; j < arr.length - i; j++) { // 반복 수 가 - i 인 이유는 한바퀴 돌떄마다 한자리는 이미 고정 된다 내림이면 맨 왼쪽 오름이면 맨 오른쪽으로  나머지 돌고 남은 -i 의 자릴 놓고 반복해야함
				if(arr[j] < arr[j - 1] ) {
					check = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = check;
				}
			}
		}
		return arr;
	}
}

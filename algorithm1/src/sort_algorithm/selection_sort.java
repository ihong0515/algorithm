package sort_algorithm;

import java.util.*;



public class selection_sort {
	/* 선택정렬 알고리즘 구현 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int [] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		};
		selection_sort ss = new selection_sort();
		
		for(int a : ss.selection_sort(arr)) {
			System.out.println(a);
		}
		
	}

	// 얘또 n-1 n-2 n-3 의 비교를 계쏙 해야하므로 o(n^2)의 시간 복잡도를 갖느다.
	public int [] selection_sort(int[]arr) {
		int minIndex = 0;
		int temp = 0;
		
		for(int i = 0; i < arr.length; i++) {
			
			minIndex = i;
			
			for(int j = i + i; j < arr.length; j++) { // 반복 수 가 - i 인 이유는 한바퀴 돌떄마다 한자리는 이미 고정 된다 내림이면 맨 왼쪽 오름이면 맨 오른쪽으로  나머지 돌고 남은 -i 의 자릴 놓고 반복해야함
				if(arr[j] < arr[minIndex] ) {
					minIndex = j;  //그 바퀴에서 정해 놓은 수보다 더 작은 수가 있으면 그작은 수가 있는 위치로 인덱스를 지정해서 첫바퀴에는 제일 작은 수가 위치한 인덱스가 남도록 한다.
				}
			}
			temp = arr[i];  //이중 반복을 통해 최소값의 인덱스가 도출 되고 해당 차수의 인덱스 에 대가 그 최소 인덱스 자리 값을 넣고 기존의 있던 인덱스의 값을 그 최소 값이 발견된 인덱스로 넣고 다시 비교대상에 넣는다.
			arr[i] = arr[minIndex]; // 첫바퀴는 제일 작은거 둘쨰 바퀴는 두번쨰로 작은게 된다.
			arr[minIndex] = temp;
		}
		return arr;
	}
}

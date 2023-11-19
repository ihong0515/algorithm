package sort_algorithm;

import java.util.*;



public class heap_sort {
	/* 버블정렬 알고리즘 구현 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int [] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		};
		heap_sort hs = new heap_sort();
		
		for(int a : hs.heapSort(arr,n)) {
			System.out.println(a);
		}
		
	}
	public int [] heapSort(int[]arr,int n) {
		
		//1 .힙구조로 바꿔 주는 과정 배열과 전체 길이를 받는다.
		heapify(arr,n);
		
		//크기를줄이고 힙을만들어 주고 이 과정을 원소 갯수 만큼 반복 한다면 
		for(int i = n-1; i >= 0; i--) {
			
			swap(arr,0,i); //전체 루트 노드와 가장 뒤에 있는 값을 지속 해서 바꾼다 계속 가장 큰 값을 맨 뒤로 보내 주기만 한다면 오름 차순 정렬이 완성 되는 것이다.
			
			heapify(arr,i); //그리고 다시 힙 구성해주고
		}
		return arr; 
	}
	//애초에 이 함수는 대장 노드 0은 반복 범위에 들어 가지가 않는다.
	public int [] heapify(int[]arr, int length) {
		//힙구조는 0은 루트 노드 말고 왼쪽 첫번쨰 자식 노드 먼저 비교 하기 시작해야 하니까 1부터시작
		for(int i =1; i < length; i++) {
			int child = i;// 0다음이니까 자식 이지 ㅇ건
			
			while(child > 0) {  //자식 노드가 부모 노드로 오기 전까지? while문에서 child 를 이전 원소 인덱스인 parent로바꿔서 while문에서재귀적인호출이 가능하도록함
								//바깥 포문의 차수는 증가해서 다음 인덱스 위치의값을 조회했지만 while문에서 이전 변동된 값과의 비교를 최종 노드인 0 까지 거슬러 올라 갈 수 있도록 하는장치이다.
				int parent = (child - 1)/2;
				
				if(arr[parent] < arr[child] ) {
					swap(arr,child,parent);
				}
				//만약에 arr[child] 가 arr[parent] 보다 커서 교체가 일어 나면  //자식 인덱스는 첫번쨰 바퀴 기준 0 이 될것이고 
				child = parent;  //바뀐 자식 노드를 부모노드로 바꾸어 준다. 첫 바퀴 기준 child 가 0 이 되서 while문 탈출
								 //하지만 i가 2로 증가한 상태에서 
			}
		}
		return arr;
	}
	public int [] swap(int[]arr,int child,int parent) {
		int temp = arr[child];
		arr[child] = arr[parent];
		arr[parent] = temp;
		
		return arr;
	} 
}

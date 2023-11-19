package sort_algorithm;

import java.util.*;



public class merge_sort {

	public int[] mergeSort(int[]arr) {
		//복사할 임시 배열 공간
		int[] tmp = new int[arr.length];
		arr = mergeSort(arr,tmp,0,arr.length-1);
		return arr;
	}
	
	public int[] mergeSort(int[]arr,int[]tmp,int start,int end) {
		
		//우측 끝이 왼쪽 끝 보다 크다 쪼갤게 남아있다.
		//같거나 커야 못들어오는데 요소가하나 있을때 
		if(start < end) { 
			//반으로 자르기 전에 기준이 될 가운데 인덱스
			int mid_index = (start + end) / 2;
			
			//시작 부터 중간 값 까지 쪼개요 왼쪽
			//이게 계속 호출 되다가 나중엔 왼쪽 배열 원소는 하나만 남게 되서 START >= END 0 >= 0 
			//되서 IF문 조건 안타고 무시 하게 되는데 여기서 끝날게 아니라 맨 최초의 불렀던 함수의 진행중에 있었음
			//그래서 아래 우측 배열에 대한 작업도 진행이 되어야지
			//근데 위의 완쪽 배열에 대한 분할이 다끝난 시점에서의 MID_INDEX는 0이고 
			mergeSort(arr,tmp,start,mid_index);
			
			//위의 MID_INDEX가 0인 상태에서 아래 재귀 호출이 시작되는것 
			//중간값으로 정한 다음값 부터  끝까지 쪼개요 오른쪽  
			mergeSort(arr,tmp,mid_index + 1,end);
			
			//범위가 쪼개져서 오면 이것을 병합 시켜요
			merge(arr,tmp,start,mid_index,end);
			//여기서 리스트 반환되면 다시 이전 차수 재귀로 반환
		}
		return arr;
	}
	
	public int[]  merge(int arr[],int[] tmp,int start,int mid_index,int end) {
		for(int i = start; i<= end; i++) {
			tmp[i] = arr[i];
		}
		//앞쪽 배열의 시작점
		int partition1 = start;
		//뒷쪽 배열의 시작점
		int partition2 = mid_index + 1;
		//복사한 배열에서 작은 값을찾았으면 그걸 배열의 어디에 넣을지 판단하는 변수 하나씩 늘려준다.
		int index = start;
		
		//앞배열과 뒷배열을 같이 돌린다.하나씩 포인터 증가시키면서
		while(partition1 <= mid_index && partition2 <= end) {
			//앞배열의 맨 앞 갚이 제일 작으면
			if(tmp[partition1] <= tmp[partition2]) {
				arr[index] = tmp[partition1];
				partition1++;
			}else {
				arr[index] = tmp[partition2];
				partition2++;
			}
			index++;
		}
		//if else 조건 다 타고 돌았는데 partition1 범위 배열들이 계쏙 작지 못해서 증가를 못했을 경우
		// 앞쪽 배열은 자리 못잡고 남은 것이고 이 값은 우측 배열의 값들 보다 당연히 큰값들임
		for(int i = 0; i <= mid_index - partition1; i++) {
			arr[index + i] = tmp[partition1 + i];
		}
		//이게 원배열에서 포인터만 갖고 정렬 뒤집기 하는 거라서 뒷배열이 남았다면 그건 이미 뒤에 붙어있음
		return arr;
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		merge_sort qs = new merge_sort();
		int n = sc.nextInt();
		int [] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		};
		
		
		for(int a : qs.mergeSort(arr)) {
			System.out.println(a);
		}
		
	}
}

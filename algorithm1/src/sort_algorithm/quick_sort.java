package sort_algorithm;

import java.util.*;



public class quick_sort {
	/* 퀵정렬 알고리즘 구현 */
	//기준 점인 pivot을 정해서그거기준으로 작은거왼쪽  큰거오른쪽으로 보내서 반환한다.
	// o(nlongn) 평균  최악 o n^2
	// 한번 돌떄마다 검색할 데이터가 절반씩 떨어지니까 log n * n횟수
	
	/* 퀵정렬 하는법 */
	
//	1.중간값 정하기
//	이게 가장 작거나 큰 값 걸리면 o n^ 2되뻐림 
	
	
	/* partion 함수 */
//	2. 기준값 기준으로 배열에 start end 포인트정한다. 
//	start 포인트는 작은 값을을 무시하면서 우측으로 ++ 될것이고
//	end 포인트는 pivot 보다 큰 값들을 무시하면서 왼쪽으로 나아갈 것이다. ( 그 이유는 작은건 왼쪽에 있어야 하는게 맞고 큰건 오른쪽에 있어야 하는게 맞으니까)
//	이 과정을 겪다가 둘이 만나게 되거나 지나치게 되면  while문이 종료해야하는것이지.
//	
//	start는 작지 않은 값 만나면 포인터 멈춰 오른쪽 크지 않은값 만나면 스탑하고 둘다 스탑 한 구간에서 
//	두개 값을 바꿔준다.
//	이러다가 포인터가 반복문 조건에 걸리고 루프 나오게 되는 것
//	
//	3. 스타트가 가르키고 있는게 배열 위치가 두번쨰 파티션의 첫번쨰 배열 인덱스다.
//	이 두번쨰 배열의 첫 인덱스를 반환한다.
//	이 두번쨰 배열 보다 작은 배열 큰배열 두개로 쪼개진것
//	배열 인덱스가 하나 면 정렬 할 필요 없으니까 멈춰야해  
	
//	4. 이것은 재귀를 타는데 배열이 이 실제로 분할되어서 저장되는게 아니라 반복 차수를 통해서 조회범위를 분할해서 좁히는 과정을
//	재귀 호출을 진행해서 구현하고 조회 범위가 중간 값 기준으로 왼쪽의 하나만 오른쪽의 하나만 남게 됬을 시점까지 
//	재귀 호출을 진행하는 것이다. 왼쪽에 하나만 남았다는 것 오른쪽에 하나만 남았다는 것은 각각 그 영역에서의 정렬작업이 더 필요하지 안음을
//	의미한다.
	
	//이거 오버로딩인지 물어보기
	public int[] quickSort(int[]arr) {
		arr = quickSort(arr,0,arr.length-1);
		return arr;
	}
	public int[] quickSort(int[]arr,int start,int end) {
		//토막 배열에서
		//피벗 기준으로 분할된 오른쪽 큰수들만 보인 배열의 첫번쨰 인덱스가 반환된다.
		int partition_index =  partition(arr,start,end);
		
		//제일 피벗 기준으로 앞쪽 배열의 마지막 인덱스가 원 배열의 시작 인덱스 보다 큰경우
		//분할된 왼쪽 배열이 남아 있으니까 왼쪽 배열은 이조건문 타면된다.
		//start랑 partion_index가 같아 졌다? -> pivot기준으로 왼쪽 토막 배열은 하나만 남았다.
		if(start < partition_index - 1) {
			quickSort(arr,start,partition_index - 1);
		}
		//분할된 오른쪽 배열의 첫 인덱스가 원배열의 최종 인덱스 보다 작은 경우 
		//분할된 배열이 남아있고 정렬 되어야 하기때문에 이조건 타면 된다.
		//두개가 같아 진다는것 피벗기준으로 오른쪽 배열의 원소가 하나만 남았다.
		if(partition_index < end) {
			quickSort(arr,partition_index,end);
		}
		
		return arr;
		//quickSort 함수에서 호출 되어지는partion 함수를 통해서 계속 피벗 기준 우측 도막 배열의
		//첫 인덱스가 반환 되어지고 
		
		// 이 첫 인덱스 기준으로 앞 배열 뒷배열로 쪼개 지는데 우측 첫배열의 - 1 까지의 인덱스 지점으로 하는 왼쪽 배열은 
		//정렬 할 배열 길이가 남으면 위의 조건문을 탈것이고
		
		//오른쪽 첫배열 인덱스 부터 원 배열의 마지막 인덱스 까지로 하는 배열은 
		//정렬할 배열 길이가 남으면 아래 두번쨰 조건문을 탈것이다.
		
		//모든 범위 배열의 조회 가 끝나고 swap 작업도 끝나서 피벗기준으로 앞뒤 배열의
		//조회와 swap 범위가 한자리만 남으면 작업이 다끝나서 조건문 안타니까 내부 호출은 멈추게 된다.
		
		
	}
	//pivot 기준으로 왼쪽엔 작은 값이 오도록, 오른쪽엔 큰값이 오도록
	public int partition(int arr[],int start,int end) {
		int pivot = arr[(start + end)/2];
		
		while(start <=  end) {
			while(arr[start] < pivot) {
				start++;
			}
			while(arr[end] > pivot) {
				end--;
			}
			if(start <= end) {
			swap(arr,start,end);
			//바꿔도 바깥 와일문 조건까진 돌아야하니까 갈길 가야지
			start ++;
			end--; 
			}
		}
		return start;
	}
	public void swap(int[]arr,int start,int end) {
		int tmp = arr[start];
		arr[start] = arr[end];
		arr[end] = tmp;
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		quick_sort qs = new quick_sort();
		int n = sc.nextInt();
		int [] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		};
		
		
		for(int a : qs.quickSort(arr)) {
			System.out.println(a);
		}
		
	}
}

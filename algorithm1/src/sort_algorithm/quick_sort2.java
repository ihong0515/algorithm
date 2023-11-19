package sort_algorithm;

import java.util.*;



public class quick_sort2 {

	public int[] quickSort(int[]arr) {
		arr = quickSort(arr,0,arr.length-1);
		return arr;
	}
	
	public int[] quickSort(int[]arr,int start,int end) {
		
		int partition_index =  partition(arr,start,end);
		
		if(start < partition_index - 1) {
			quickSort(arr,start,partition_index - 1);
		}
		if(partition_index < end) {
			quickSort(arr,partition_index,end);
		}
		
		return arr;
		
	}
	
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
		quick_sort2 qs = new quick_sort2();
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

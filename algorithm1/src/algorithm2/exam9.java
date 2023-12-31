package algorithm2;

import java.util.*;

public class exam9 {
//	10. 봉우리
//	설명
//
//	지도 정보가 N*N 격자판에 주어집니다. 각 격자에는 그 지역의 높이가 쓰여있습니다.
//
//	각 격자판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다. 봉우리 지역이 몇 개 있는 지 알아내는 프로그램을 작성하세요.
//
//	격자의 가장자리는 0으로 초기화 되었다고 가정한다.
//
//	만약 N=5 이고, 격자판의 숫자가 다음과 같다면 봉우리의 개수는 10개입니다.
//
//	Image1.jpg
//
//
//	입력
//	첫 줄에 자연수 N이 주어진다.(2<=N<=50)
//
//	두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.
//
//
//	출력
//	봉우리의 개수를 출력하세요.
//
//
//	예시 입력 1 
//
//	5
//	5 3 7 2 3
//	3 7 1 6 1
//	7 2 5 3 4
//	4 3 6 4 1
//	8 7 3 5 2
//	예시 출력 1
//
//	10
	public static void main(String[] args) {

		exam9 exam7 = new exam9(); 
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int [][] arr = new int [n][n];
		for(int i =0; i < n; i++) {
			
			for(int j = 0; j < n; j++) {
				arr[i][j] = in.nextInt();
			}
		}
		System.out.println(exam7.solution(arr));
		
	}
	public int  solution(int [][] arr) {
		//발견될 때마다 하나씩 증감 시키기
		int answer = 0;
		
		int up_index = 0;
		int left_index = 0;
		int right_index = 0;
		int bottom_index = 0;
		
		for(int i =0;  i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				
				int num = arr[i][j];
				
				//인덱스 행이 0일때 
				if(i == 0) {
					//인덱스행이 0이면 위의 값이
					up_index = 0;
					if(j == 0) {
						left_index = 0;
						right_index = arr[i][j+1];
					}else if(j == arr.length - 1) {
						left_index = arr[i][j-1]; 
						right_index = 0;
					}else {
						left_index = arr[i][j-1]; 
						right_index = arr[i][j+1];
					}
					bottom_index = arr[i + 1][j];
				//인덱스 행이  마지막 행일때
				}else if(i == arr.length - 1) {
					bottom_index = 0;
					if(j == 0) {
						left_index = 0;
						right_index = arr[i][j+1];
					}else if(j == arr.length - 1) {
						left_index = arr[i][j-1]; 
						right_index = 0;
					}else {
						left_index = arr[i][j-1]; 
						right_index = arr[i][j+1];
					}
					up_index = arr[i -1][j];
				//첫쨰 행이 아니거나 마지막 행이 아닐떄 이떄는 열이 맨처음 열인지 맨 마지막 열인지만 구분 해주면 된다.
				}else {
					up_index = arr[i -1][j];
					bottom_index = arr[i + 1][j];
					
					if(j == 0) {
						left_index = 0;
						right_index = arr[i][j+1];
					}
					else if(j == arr.length - 1) {
						left_index = arr[i][j-1]; 
						right_index = 0;
					}else {
						left_index = arr[i][j-1]; 
						right_index = arr[i][j+1];
					}
				}
				//이렇게 해버리면 무조건 참이 되버릴수 밖에 없다하네...ㅅㅂ
				
				
				if(num > up_index && num > left_index && num > right_index && num > bottom_index) {
					answer ++;
				}
			}
		}
		return answer;
	}	
}

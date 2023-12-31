package algorithm2;

import java.util.*;

public class exam8_1 {
//	9. 격자판 최대합
//	설명
//
//	5*5 격자판에 아래롸 같이 숫자가 적혀있습니다.
//
//	Image1.jpg
//
//	N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합니다.
//
//
//	입력
//	첫 줄에 자연수 N이 주어진다.(2<=N<=50)
//
//	두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.
//
//
//	출력
//	최대합을 출력합니다.
//
//
//	예시 입력 1 
//
//	5
//	10 13 10 12 15
//	12 39 30 23 11
//	11 25 50 53 15
//	19 27 29 37 27
//	19 13 30 13 19
//	예시 출력 1
//
//	155
	public static void main(String[] args) {

		exam8_1 exam7 = new exam8_1(); 
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
		int answer = Integer.MIN_VALUE;
		int row_sum = 0;
		int col_sum = 0;
		int right_sum = 0;
		int left_sum = 0;
		
		for(int i =0;  i < arr.length; i++) {
			
			left_sum += arr[i][i];
			
			//우측 대각에서의합
			right_sum += arr[i][arr[i].length -1 - i];
			//해당 열의합
			for(int k = 0; k < arr[i].length; k++) {
				//열의 합 구하려면 열은 해당 차수에서는 고정이어야지 그니까 차수가 [][열]로 들어가고 앞에 행이 증가 하면서 더해지면 열이 구해지겠지
				//아 이거 열 고정 한답시고 k 를 차수의 i 로 초기화 하고 반복 돌려서 오류 났었음. 어짜피 그 차수는 동일하기떄문에굳이안그래도 되고 그 해당 차수는 동일하게 0으로 돌리되 
				//그 차수가 열로 고정되게 누적해서더해주기만 했으면 되는것.
				//행의 합을 구한다 -> 하수에서 행고정 열증가 찻수가 행에 고정되서 누적합으로 더해진다.
				//열의 합을 구한다 -> 차수에서 열고정 행증가 찻수가 열로 들어가서 고정되고 누적합으로 더해진다.
				col_sum += arr[k][i];
			}
			//해당 행에서의합
			for(int j = 0; j < arr[i].length; j++) {
				row_sum += arr[i][j];
			}
			
			if(answer < col_sum) {
				answer = col_sum;
			}
			if(answer < row_sum) {
				answer = row_sum;
			}
			if(answer < left_sum) {
				answer = left_sum;
			}
			if(answer < right_sum) {
				answer = right_sum;
			}
			col_sum = 0;
			row_sum = 0;
		}
		return answer;
	}	
}

package algorithm4_HashSet;

import java.util.*;
import java.util.Map.Entry;

public class exam3_good {
//	3. 매출액의 종류
//	설명
//
//	현수의 아빠는 제과점을 운영합니다. 현수아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 매출액의 종류를
//
//	각 구간별로 구하라고 했습니다.
//
//	만약 N=7이고 7일 간의 매출기록이 아래와 같고, 이때 K=4이면
//
//	20 12 20 10 23 17 10
//
//	각 연속 4일간의 구간의 매출종류는
//
//	첫 번째 구간은 [20, 12, 20, 10]는 매출액의 종류가 20, 12, 10으로 3이다.
//
//	두 번째 구간은 [12, 20, 10, 23]는 매출액의 종류가 4이다.
//
//	세 번째 구간은 [20, 10, 23, 17]는 매출액의 종류가 4이다.
//
//	네 번째 구간은 [10, 23, 17, 10]는 매출액의 종류가 3이다.
//
//	N일간의 매출기록과 연속구간의 길이 K가 주어지면 첫 번째 구간부터 각 구간별
//
//	매출액의 종류를 출력하는 프로그램을 작성하세요.
//
//
//	입력
//	첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
//
//	두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.
//
//
//	출력
//	첫 줄에 각 구간의 매출액 종류를 순서대로 출력합니다.
//
//
//	예시 입력 1 
//
//	7 4
//	20 12 20 10 23 17 10
//	예시 출력 1
//
//	3 4 4 3
	
	
	//
	public static void main(String[] args) {

		exam3_good exam1 = new exam3_good(); 
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int k = in.nextInt();
		int arr[] = new int[n];
		
		for(int i =0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		for(int a : exam1.solution(n, k, arr)) {
			System.out.print(a + " ");
		}
	}
	public ArrayList<Integer> solution(int n,int k,int[] arr) {
		
		//배열 원소로 해쉬 맵을넣어 보자 . 
		//다 끝나고 arr[left]에 해당 하는 키값을 빼고 left를증가 시켜 보자  
		//다 더 하다가 k 로 나눈 몫이 되는 기점 마다. 사이즈를 배열에 넣을까 그리고 그 시점에 그 시점 인덱스 값을 hash에서 지우고 새로 시작할까 
		
		//특정 시점 될 때만 그 해쉬 맵 넣어 두던걸 배열 값으로 넣고, 넣으면 배열 갱신해주고 새로 받다고 다시 그 특정 인덱스 되면 배열 원소로 넣어주고, 
		
		
		ArrayList<Integer> answer = new ArrayList<>();
		int left = 0;
		HashMap<Integer,Integer> hm = new HashMap<>();
		
		//윈도우 창보다 하나 작게 미리 세팅 해놔라 윈도우슬라이드 할떄
		for(int i = 0; i < k - 1; i++) {
			hm.put(arr[i], hm.getOrDefault(arr[i], 0));
		}
		
		
		for(int right = k - 1; right < n; right++) {
			hm.put(arr[right],hm.getOrDefault(arr[right], 0) + 1 );
				//이거돌아 가는 시점을 일단 윈도우 창이 꽉 찬 시점이니까 일단 넣어줘
				hm.put(arr[right], hm.getOrDefault(arr[right], 0) + 1);
				answer.add(hm.size());
				//기본적으로 슬라이딩 윈도우는 칸밀고 가는거니까 넘어 갈때 맨왼쪽 애는 우측기중 한번 나온거 + 맨왼쪽 중에 나온거니까 하나 차감 해주는게 맞다.
				// 왼쪽은 저 뒤에 있는거고 현재 오른쪽 시점에서 보이는  애만 카운트로 인정해함 밀고 가서 왼쪽은 이제 안보일 거니까 차감 시켜 주는게 맞지.
				//그렇게 해서  0 이되고  안보이면 그 부분배열엔 arr[left] 키에 해당하는 숫자가 없는거지. 
				
				hm.put(arr[left], hm.get(arr[left]) - 1);  //밀고 간다~
				//밀었는데 0이 되버리면그 부분배열엔 존재 하지 않는다 hm에서 뺴준다. 
				if(hm.get(arr[left]) == 0) {
					hm.remove(arr[left]);
				}
				
				left++;
				// 얘가 계속 한칸 씩 밀고 가는 거야 그 바퀴에서 
			}
				
		return answer;
	}
	//아 앞에 블럭 직전 까지 반복 돌린다음 그다음 바퀴 부터 반복문 돌려 줘야 겠네	
		
}

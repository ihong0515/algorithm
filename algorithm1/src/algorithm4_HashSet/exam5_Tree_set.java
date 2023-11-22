package algorithm4_HashSet;

import java.util.*;
import java.util.Map.Entry;

public class exam5_Tree_set {
//	5. K번째 큰 수
//	설명
//
//	현수는 1부터 100사이의 자연수가 적힌 N장의 카드를 가지고 있습니다. 같은 숫자의 카드가 여러장 있을 수 있습니다.
//
//	현수는 이 중 3장을 뽑아 각 카드에 적힌 수를 합한 값을 기록하려고 합니다. 3장을 뽑을 수 있는 모든 경우를 기록합니다.
//
//	기록한 값 중 K번째로 큰 수를 출력하는 프로그램을 작성하세요.
//
//	만약 큰 수부터 만들어진 수가 25 25 23 23 22 20 19......이고 K값이 3이라면 K번째 큰 값은 22입니다.
//
//
//	입력
//	첫 줄에 자연수 N(3<=N<=100)과 K(1<=K<=50) 입력되고, 그 다음 줄에 N개의 카드값이 입력된다.
//
//
//	출력
//	첫 줄에 K번째 수를 출력합니다. K번째 수가 존재하지 않으면 -1를 출력합니다.
//
//
//	예시 입력 1 
//
//	10 3
//	13 15 34 23 45 65 33 11 26 42
//	예시 출력 1
//
//	143
	
	//n 장에서 32
	
	//set 자료 구조는 키 값을 중복 하질 않는다. 따라서 중복 제거 할떈 최고
	//tree set은 정렬 까지 제공하고 중복제거도 해준다. 부모 기준 작은거 왼쪽 큰거 오른쪽으로 가는 이진트리 형식으로 저장된다. 
	//TreeSet<> (Collerction.reverseOrder()) 하면내림차순으로 
	//정렬된 상태에서 몇번쨰는 그 차수의 시점으로 결정 하겠지?
	
	
	/*tree set 메서드*/
//	tr.remove() -> 이 값으 지우기 tr에서 
//	tr.size 안에 키가 몇개 있느냐.
//	tr.first 오름차순에서는 제일작은거 위처럼내림차순으로 생성한 treeset에서는 최대값
//	tr.last() 오름일땐 젤큰거, 낮으면 작은거.
	public static void main(String[] args) {

		exam5_Tree_set exam1 = new exam5_Tree_set(); 
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[]arr = new int[n];
		int k = in.nextInt();
		
		for(int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		
		System.out.print(exam1.solution(n, arr , k));
	}
	public int solution(int n, int[] arr,int k) {
		
		int answer = 0;
		TreeSet<Integer>tr = new TreeSet<Integer>();
		
		ArrayList<Integer>SumArr = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			for(int j = i+1; j  < n; j++) { // i 가 뽑혔는데 j가 중복으로 뽑음 안된다.
				for(int l = j+1; l < n; l++) {  // j 가 뽑혔는데  l 이 중복으로 뽑음 안된다. 
					SumArr.add(arr[i] + arr[j] + arr[l]);
				}
			}
		}
		
		for(int x : SumArr) {
			tr.add(x);
			//System.out.println(x);
		}
		//최대 크기??,,,ㅇㅇ...아 모르겠다 
		//애초에 저장된 개수가 ...몇번쨰 보다 많으면 그 몇번쨰가 젤 큰거지 비교할 필요가 있을까?
		
		if(tr.size() < k) {
			answer = -1;
		}else {
			Iterator <Integer>it = tr.descendingIterator();
			int count = 0;
			while(it.hasNext()) {
				//iterator.next()의 호출이 현재 요소를 반환하고, 동시에 Iterator를 다음 요소로 이동시킨다.
				int current = it.next();
				//따라서next호출 뒤에 지점 따라서포인터도 이동해 주는 거지.
				count ++;
				
				//그래서 원래 증가 하기 전 지점은  0부터 시작했기 떄문에 k - 1 차수가 원래 k 번쨰 지점 인데 다음으로 넘어가면 아까 포인터넘어가기전 값저장한걸넣고, while문 종료
				if(count == k) {
					answer =  current;
					break;
					
				}
				
			}
		}	
		//트리셋 순회 하면서 그 차수가 전체 길이 - k 일떄 시점의 값을 빼서 answer로 반환 해주면 된다. 
		//Iterator는 "인덱스"를 기반으로 작동하지 않습니다. 즉, iterator.next()는 인덱스를 기반으로 한 위치가 아니라, 현재 Iterator가 가리키고 있는 요소를 반환합니다. 그리고 이 메소드를 호출할 때마다 Iterator는 다음 요소로 이동합니다.	
		
		return answer;
	}
		
		
}

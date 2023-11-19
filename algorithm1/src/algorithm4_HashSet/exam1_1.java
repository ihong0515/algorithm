package algorithm4_HashSet;

import java.util.*;
import java.util.Map.Entry;

public class exam1_1 {
	/*
	 * 1. 학급 회장(해쉬) 설명
	 * 
	 * 학급 회장을 뽑는데 후보로 기호 A, B, C, D, E 후보가 등록을 했습니다.
	 * 
	 * 투표용지에는 반 학생들이 자기가 선택한 후보의 기호(알파벳)가 쓰여져 있으며 선생님은 그 기호를 발표하고 있습니다.
	 * 
	 * 선생님의 발표가 끝난 후 어떤 기호의 후보가 학급 회장이 되었는지 출력하는 프로그램을 작성하세요.
	 * 
	 * 반드시 한 명의 학급회장이 선출되도록 투표결과가 나왔다고 가정합니다.
	 * 
	 * 
	 * 입력 첫 줄에는 반 학생수 N(5<=N<=50)이 주어집니다.
	 * 
	 * 두 번째 줄에 N개의 투표용지에 쓰여져 있던 각 후보의 기호가 선생님이 발표한 순서대로 문자열로 입력됩니다.
	 * 
	 * 
	 * 출력 학급 회장으로 선택된 기호를 출력합니다.
	 * 
	 * 
	 * 예시 입력 1
	 * 
	 * 15 BACBACCACCBDEDE 예시 출력 1
	 * 
	 * C
	 */
	
	
	
		//해쉬가 뭐냐 
	
	
//		HashMap
//		: key - value를 묶어 하나의 entry로 저장, hash이기 때문에 검색에 빠른 속도를 보임
//	
//		* key 는 중복 불가, value null 사용 가능
//	
//		* 멀티스레드는 hashmap 을 사용할수 없다 ( hashtable 사용 )
	public static void main(String[] args) {

		exam1_1 exam1 = new exam1_1(); 
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		String election = in.next();
		
		System.out.println(exam1.solution(n,election));
	}
	public String solution(int n,String election) {
		
		String answer = "";
		String [] arr = election.split("");
		
		HashMap<String,Integer> hm = new HashMap<>();
		int max = 0;
		
		for(String result : arr) {
			//이게 이쁨 받는 카운팅 로직 이구나. 
			hm.put(result,hm.getOrDefault(result, 0) + 1);   // getOrDefault  result 라는 키가 있으면  그 result 키의 value 갖고 오고, 아니면 0을 리턴해라. 
															 // put 할떄 키값 없으면 만들고 있으면 그 키에 value 갱신해서 넣는거 . 
		}
		
		//이제 돌면서 키의 value 꺼내 보고 맨처음 값이랑 비교해서 갱신해서 도출 해 내면 된다. 
		//if 문 타고 갱신 되는 시점에서의 key값을 배서 answer에 저장한다. 
		for(Entry<String, Integer> entry : hm.entrySet()) {
			if(entry.getValue() >  max) {
				max = entry.getValue();
				answer = entry.getKey();
			} 
		}
		
		for(String x : hm.keySet()) {
			//keySet 쓰면 하나 하나 순차적으로 키를 조회 한다. 
			System.out.println(x);
			System.out.println();
			//value는 그 구한 키로 value 조회 하면 되겠네
			System.out.println(hm.get(x));
			
		}
		//hashMap에 특정 키가 있는지 조회 하는 법..
		//hm.containsKy("A")   -> 이것은 true or false 를 반환한다. 
		//hm.size()  ->  그 자료구조 안에 담긴 키의 종류 갯수를 알려준다. 
		//해쉬맵은 키 주복 안되는거 알지?
		//hm.remove("A") A라는 특정 키와 그 값을 삭제 해버린다. size 하면 그러면 하나 줄어 불겠제  remove 하면 그 삭제된 value를 리턴 한다. 
		
		return answer;
	}
		
		
}

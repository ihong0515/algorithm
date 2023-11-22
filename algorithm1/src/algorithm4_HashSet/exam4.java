package algorithm4_HashSet;

import java.util.*;
import java.util.Map.Entry;

public class exam4 {
//	4. 모든 아나그램 찾기
//	설명
//
//	S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
//
//	아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.
//
//
//	입력
//	첫 줄에 첫 번째 S문자열이 입력되고, 두 번째 줄에 T문자열이 입력됩니다.
//
//	S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같습니다.
//
//
//	출력
//	S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력합니다.
//
//
//	예시 입력 1 
//
//	bacaAacba
//	abc
//	예시 출력 1
//
//	3
	
	
	//아  hm1.equals(hm2)요 메서드 쓰면 두 맵이 같은지 확인이 가능하다...ㄷㄷㄷ....
	//슬라이딩 윈도우는 right 하나 증가 할떄 left  하나 감소 시키는게 핵심 해쉬맵이면 그 left 키값 감소 배열 , 이 면 그 인덱스 제거,  합이면 그 위치 값만큼 뺴기 
	//문자열은 웬만하면 charAt으로 쪼개자.
	
	
	public static void main(String[] args) {

		exam4 exam1 = new exam4(); 
		Scanner in = new Scanner(System.in);
		
		String str1 = in.next();
		String str2 = in.next();
		
		System.out.print(exam1.solution(str1, str2));
	}
	public int solution(String str1, String str2) {
		
		int answer = 0;
		HashMap<String,Integer> hm = new HashMap<>(); 
		HashMap<String,Integer> hm2 = new HashMap<>(); 
		String[]arr1 = str1.split("");
		String[]arr2 = str2.split("");
		int count = 0;
		//hm 에 다 들어가 있어야 할거 arr2  
		
		//그리고 전체 순회 하면서 
		//rigth를 다시 그 hm 에 넣었을때  
		
		for(int i = 0; i < arr2.length; i++) {
			hm2.put(arr2[i], hm.getOrDefault(arr2[i],0)+ 1);
		}
		
		for(int i = 0; i < arr2.length - 1; i++) {
			hm.put(arr1[i], hm.getOrDefault(arr1[i],0)+ 1);
			
		}
		int left = 0;
	
		for(int right = arr2.length - 1; right < arr1.length; right++) {
			hm.put(arr1[right], hm.getOrDefault(arr1[right],0)+ 1);
			
			if(right - left == arr2.length - 1) {
				if(hm.equals(hm2)) {
					answer++;
				}
				
				hm.put(arr1[left], hm.getOrDefault(arr1[left],0) - 1);
				
				if(hm.get(arr1[left]) == 0) {
					hm.remove(arr1[left]);
				}
				left++;
			}
			
			if(count == arr2.length) {
				answer ++;
			}
		}
		return answer;
	}
		
		
}

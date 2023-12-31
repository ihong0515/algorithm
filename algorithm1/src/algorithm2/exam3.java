package algorithm2;

import java.util.*;

public class exam3 {
//	3. 가위 바위 보
//	설명
//
//	A, B 두 사람이 가위바위보 게임을 합니다. 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력합니다.
//
//	가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.
//
//	예를 들어 N=5이면
//
//	Image1.jpg
//
//	두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력하는 프로그램을 작성하세요.
//
//
//	입력
//	첫 번째 줄에 게임 횟수인 자연수 N(1<=N<=100)이 주어집니다.
//
//	두 번째 줄에는 A가 낸 가위, 바위, 보 정보가 N개 주어집니다.
//
//	세 번째 줄에는 B가 낸 가위, 바위, 보 정보가 N개 주어집니다.
//
//
//	출력
//	각 줄에 각 회의 승자를 출력합니다. 비겼을 경우는 D를 출력합니다.
//
//
//	예시 입력 1 
//
//	5
//	2 3 3 1 3
//	1 1 2 2 3
//	예시 출력 1
//
//	A
//	B
//	A
//	B
//	D
	public static void main(String[] args) {
		// 홍재영 알고리즘 1일차 공부입니다.
		exam3 exam1 = new exam3(); 
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int [] a = new int [n];
		int [] b = new int [n];
		for(int i =0; i < n; i++) {
			a[i] = in.nextInt();
		}
		for(int i =0; i < n; i++) {
			b[i] = in.nextInt();
		}
		for(String answer : exam1.solution(n,a,b)) {
			System.out.println(answer);
		}
		
	}

	/* 가위바위보 로직 */
	
//	경우는 a가 이기거나 b가 이기거나
//	
//	조건들
//	a가 이기는 조건 가위내서 이기는 조건, 바위내서 이기는조건, 보자기 내서 이기는조건
//	b가 이기는 조건 가위내서 이기는 조건, 바위내서 이기는조건, 보자기 내서 이기는조건
//	비기는 경우  a,b 둘다 아닌경우가 되는것
	
//와 로직 다르게 짠거 보소
//	if 조건을 비기는거 먼저
//	else if a가 가위, 바위 ,보 각각 내서 이기는 경우 && 로
//	else 이러면 나머지는 다 b가 이기는 경우니까 조건 적는게 훨신 줄어 버리는데 ...ㄷㄷ
//	
//	조건ㅇㄹ 간략하게 적을수를 있는지를 좀 생각을 해보자.
//	
	public ArrayList<String> solution(int n,int [] a,int [] b) {
		ArrayList<String> answer = new ArrayList<>();
		
		for(int i =0;  i < a.length; i++) {
			
			if(a[i] == 3 && b[i] == 2) {
				answer.add("A");
			}else if(a[i] == 2 && b[i] == 1) {
				answer.add("A");
			}else if(a[i] == 1 && b[i] == 3) {
				answer.add("A");
			}else if(b[i] == 3 && a[i] == 2) {
				answer.add("B");
			}else if(b[i] == 2 && a[i] == 1) {
				answer.add("B");
			}else if(b[i] == 1 && a[i] == 3) {
				answer.add("B");
			}else {
				answer.add("D");
			}
		}
		return answer;
	}	
}

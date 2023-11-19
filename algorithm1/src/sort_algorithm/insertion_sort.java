package sort_algorithm;
import java.util.*;

public class insertion_sort {
	//삽입 정렬 로직 구현 하세요
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int [] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		};
		insertion_sort ss = new insertion_sort();
		
		for(int a : ss.insertion_sort(arr)) {
			System.out.println(a);
		}
		
		
		
	}
	public int[] insertion_sort(int[]arr) {
		
		int temp = 0;
		int prev = 0;
		
		for(int index = 1; index < arr.length; index++) {
			temp = arr[index]; // 맨앞 다음 자리 부터반복 돌기시작할건데 아래 와일문 결과에서 앞자리에 터 큰 값이  존재할 경우 그 앞자리 값을 오른쪽으로 다 밀어내고 남은 자리에 이번 비교값을 넣어야 하니까 temp에 담아둔다..
			prev = index - 1;   // 현재 인덱스에서 비교할 앞자리의 인덱스르 구한다.
			
			while(prev >= 0 && arr[prev] > temp) {  //앞자리 인덱스가 0보다 크거나 갔되(-되면 탈출 조건으로)  이전 현제 인덱스 이전값이 위의반복에서 현재인덱스값으로 지정한 temp 보다 크다면
				arr[prev + 1] = arr[prev];            //앞자리가 더 크면 그 앞지리 숫자 인덱스를우측으로 한칸 밀어버린다 (이 순간 부터 temp는 붕떠서 자리 날떄까지 비교신세로 전락)
														  //여분 앞자리로 계속 조회해 가면서 이전 자리값 비교해서 이전자리가 temp보다 크면 일단 +1칸으로 밀어 버린다.
					
				prev --;							//그리고이전 인덱스 변수를 감소 시킨다. 
			}
			arr[prev + 1] = temp;			//while문에서는 기존 temp 랑 비교해서  기존에 비교한 앞자리보다 더 앞자리 중에 더 큰게 있을때 
											//끝없이  우측으로 밀어 내게 되고 최종적으로 비게 되는 자리의 인덱스를만들기 위한 값인 prev를 반환한다.
		
											//arr[prev + 1] 을 해주는 경우 최초 차수의 인덱스앞자리를 비교 했고 더 앞자리들을 temp와 비교 했을떄 더큰 수들이 계속 있어서 맨 배열 최대 앞짜리 까지 가게 된경우
											//에는  0을 만들고 적절하게 찾은 인덱스에서 -1 가르키던걸 들어갈 인덱스로 만들어 주는 작업이다.
											//prev가 0이라면 temp 인덱스 1 앞인 0 에 temmp보다 큰 값이 없다는 증거인것. while문을 안탔으니까
			
		}
		return arr;
	}
}

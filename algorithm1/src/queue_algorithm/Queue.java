package queue_algorithm;

import java.util.*;



public class Queue {
	/* 선택정렬 알고리즘 구현 */
	//생성자로 배열 길이 받아서 배열 초기화 한다.

    private Integer array[];
    private int front;
    private int back;
    private int size;

    public Queue(int size) {
        this.size = size;
        this.array = new Integer[size];
        this.front = -1;
        this.back = -1;
    }

    //입력 연산은 후방에서 이루어지기 때문에 뒷구멍 인덱스를 하나 증가 시켜서 뒤에 입력되게 한다. 
    //전위 연산으로 뒷인덱스 증가
    void push(int data) {
        back++;
        
        //배열 인덱스가 넘치면 경계 범위 예외처리 던져 주고 
        if (back >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        //추가 된 배열 뒷부분에 데이터 추가
        array[back] = data;
        //추가 했는데 front가 -1이라면? - >들어온 첫 데이터니까 바로 나갈 수 있게 끝인덱스를 곧 첫 인덱스로 
        if(front == -1) front = back;
    }
    
    int pop() {
    	//하나 들어 와 있는게 배열 길이랑 같거나 크다면 혹은 아무것도 안들어와서 -1 이라면
        if (front >= size || front < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
    	//아니라면 맨앞에 있는 녀석 뺴주고 후위 연산으로 증가 시킨다. 다음 프론트가 나올 수 있게 
        return array[front++];
    }
	
	
	public static void main(String[] args) {
		
	
		
	}


}

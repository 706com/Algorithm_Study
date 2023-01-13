package 백준;
//[백준]10845 : 큐 - JAVA(자바)

//<새로 알게된 것>
//queue 는 선언할 때 new Queue 가 아닌, new LinkedList 사용
//queue.offer = 맨 뒤에 삽입  ,  queue.push = 맨 앞에 삽입
//queue 메소드는 인덱스 접근이 불가능.

//<궁금한 것>
//Queue 의 인덱스 접근이 불가능하다면, 가운데 값 뽑아내기 위해선 LinkedList 로 구현해야 할까?

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _10845_큐 {
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int num = 0;
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            String command = st.nextToken();

            switch(command){
                case "push":
                    num = Integer.parseInt(st.nextToken());
                    push(num);
                    break;

                case "pop":
                    sb.append(pop()).append("\n");
                    break;

                case "size":
                    sb.append(size()).append("\n");
                    break;

                case "empty":
                    sb.append(empty()).append("\n");
                    break;

                case "front":
                    sb.append(front()).append("\n");
                    break;

                case "back":
                    sb.append(back(num)).append("\n");
                    break;
            }
        }
        System.out.println(sb);

    }
    public static void push(int num){
        q.offer(num);
    }
    public static int pop(){
        if(q.isEmpty()){
            return -1;
        }
        else{
            return q.poll();
        }
    }
    public static int size(){
        return q.size();
    }
    public static int empty(){
        if(q.isEmpty()){
            return 1;
        }
        else{
            return 0;
        }
    }

    //front = 가장 처음에 push 된 값
    public static int front(){
        if(q.isEmpty()){
            return -1;
        }
        else{
            return q.peek();
        }
    }

    //back = 가장 마지막에 push 된 값
    //사실 main 문에서 해결을 해야하지만, 형식을 지키기 위해 이렇게 작성
    public static int back(int num){
        if(q.isEmpty()){
            return -1;
        }
        else{
            return num;
        }
    }
}

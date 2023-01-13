package 백준;
//[백준]10866 : 덱 - JAVA(자바)

//<새로 알게된 것>
//덱 : 앞 뒤 어디서든지 삽입과 삭제가 가능한 양방향 자료구조


//<궁금한 것>

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _10866_덱 {
    static Deque<Integer> deq = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int num = 0;
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            String command = st.nextToken();

            switch(command){
                case "push_front":
                    num = Integer.parseInt(st.nextToken());
                    push_front(num);
                    break;

                case "push_back":
                    num = Integer.parseInt(st.nextToken());
                    push_back(num);
                    break;

                case "pop_front":
                    sb.append(pop_front()).append("\n");
                    break;

                case "pop_back":
                    sb.append(pop_back()).append("\n");
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
                    sb.append(back()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }

    public static void push_front(int num){
        deq.addFirst(num);
    }
    public static void push_back(int num){
        deq.addLast(num);
    }

    public static int pop_front(){
        if(deq.isEmpty()){
            return -1;
        }
        else{
            return deq.pollFirst();
        }
    }
    public static int pop_back(){
        if(deq.isEmpty()){
            return -1;
        }
        else{
            return deq.pollLast();
        }
    }

    public static int size(){
        return deq.size();
    }

    public static int empty(){
        if(deq.isEmpty()){
            return 1;
        }
        else{
            return 0;
        }
    }

    public static int front(){
        if(deq.isEmpty()){
            return -1;
        }
        else{
            return deq.peekFirst();
        }
    }
    public static int back(){
        if(deq.isEmpty()){
            return -1;
        }
        else{
            return deq.peekLast();
        }
    }
}

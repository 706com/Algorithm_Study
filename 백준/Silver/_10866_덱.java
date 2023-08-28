package 백준.Silver;
//[백준]10866 : 덱 - JAVA(자바)

//<새로 알게된 것>
//덱 : 앞 뒤 어디서든지 삽입과 삭제가 가능한 양방향 자료구조

//<궁금한 것>

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.LinkedList;

public class _10866_덱 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deq = new LinkedList<>();

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            String command = st.nextToken();

            switch(command){
                case "push_front":
                    int frontnum = Integer.parseInt(st.nextToken());
                    deq.addFirst(frontnum);
                    break;
                case "push_back":
                    int backnum = Integer.parseInt(st.nextToken());
                    deq.addLast(backnum);
                    break;
                case "pop_front":
                    if(deq.isEmpty()){
                        sb.append("-1").append('\n');
                        break;
                    }
                    sb.append(deq.pollFirst()).append('\n');
                    break;
                case "pop_back":
                    if(deq.isEmpty()){
                        sb.append("-1").append('\n');
                        break;
                    }
                    sb.append(deq.pollLast()).append('\n');
                    break;
                case "size":
                    sb.append(deq.size()).append('\n');
                    break;
                case "empty":
                    if(deq.isEmpty()){
                        sb.append("1").append('\n');
                    }
                    else{
                        sb.append('0').append('\n');
                    }
                    break;
                case "front":
                    if(deq.isEmpty()){
                        sb.append("-1").append('\n');
                        break;
                    }
                    sb.append(deq.peekFirst()).append('\n');
                    break;
                case "back":
                    if(deq.isEmpty()){
                        sb.append("-1").append('\n');
                        break;
                    }
                    sb.append(deq.peekLast()).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }
}

//    static Deque<Integer> deq = new LinkedList<>();
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        int N = Integer.parseInt(br.readLine());
//
//        int num = 0;
//        for(int i=0; i<N; i++){
//            StringTokenizer st = new StringTokenizer(br.readLine()," ");
//            String command = st.nextToken();
//
//            switch(command){
//                case "push_front":
//                    num = Integer.parseInt(st.nextToken());
//                    push_front(num);
//                    break;
//
//                case "push_back":
//                    num = Integer.parseInt(st.nextToken());
//                    push_back(num);
//                    break;
//
//                case "pop_front":
//                    sb.append(pop_front()).append("\n");
//                    break;
//
//                case "pop_back":
//                    sb.append(pop_back()).append("\n");
//                    break;
//
//                case "size":
//                    sb.append(size()).append("\n");
//                    break;
//
//                case "empty":
//                    sb.append(empty()).append("\n");
//                    break;
//
//                case "front":
//                    sb.append(front()).append("\n");
//                    break;
//
//                case "back":
//                    sb.append(back()).append("\n");
//                    break;
//            }
//        }
//        System.out.println(sb);
//    }
//
//    public static void push_front(int num){
//        deq.addFirst(num);
//    }
//    public static void push_back(int num){
//        deq.addLast(num);
//    }
//
//    public static int pop_front(){
//        if(deq.isEmpty()){
//            return -1;
//        }
//        else{
//            return deq.pollFirst();
//        }
//    }
//    public static int pop_back(){
//        if(deq.isEmpty()){
//            return -1;
//        }
//        else{
//            return deq.pollLast();
//        }
//    }
//
//    public static int size(){
//        return deq.size();
//    }
//
//    public static int empty(){
//        if(deq.isEmpty()){
//            return 1;
//        }
//        else{
//            return 0;
//        }
//    }
//
//    public static int front(){
//        if(deq.isEmpty()){
//            return -1;
//        }
//        else{
//            return deq.peekFirst();
//        }
//    }
//    public static int back(){
//        if(deq.isEmpty()){
//            return -1;
//        }
//        else{
//            return deq.peekLast();
//        }
//    }

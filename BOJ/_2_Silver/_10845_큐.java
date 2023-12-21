package BOJ._2_Silver;
//[백준]10845 : 큐 - JAVA(자바)

//소요시간 : 7분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _10845_큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> q = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command  = st.nextToken();

            switch (command){
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    q.offer(num);
                    break;
                case "pop":
                    if(q.isEmpty()){
                        System.out.println("-1");
                        break;
                    }
                    System.out.println(q.pollFirst());
                    break;
                case "size":
                    System.out.println(q.size());
                    break;
                case "empty":
                    if(q.isEmpty()){
                        System.out.println("1");
                        break;
                    }
                    System.out.println("0");
                    break;
                case "front":
                    if(q.isEmpty()){
                        System.out.println("-1");
                        break;
                    }
                    System.out.println(q.peekFirst());
                    break;
                case "back":
                    if(q.isEmpty()){
                        System.out.println("-1");
                        break;
                    }
                    System.out.println(q.peekLast());
                    break;
            }
        }
    }
}

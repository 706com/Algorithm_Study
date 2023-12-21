package BOJ;

//소요시간 : 6분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _10845_큐2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
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
                        sb.append("-1").append('\n');
                        break;
                    }
                    sb.append(q.pollFirst()).append('\n');
                    break;
                case "size":
                    sb.append(q.size()).append('\n');
                    break;
                case "empty":
                    if(q.isEmpty()){
                        sb.append("1").append('\n');
                        break;
                    }
                    sb.append("0").append('\n');
                    break;
                case "front":
                    if(q.isEmpty()){
                        sb.append("-1").append('\n');
                        break;
                    }
                    sb.append(q.peekFirst()).append('\n');
                    break;
                case "back":
                    if(q.isEmpty()){
                        sb.append("-1").append('\n');
                        break;
                    }
                    sb.append(q.peekLast()).append('\n');
                    break;
            }
        }
        System.out.println(sb);
    }
}

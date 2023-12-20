package BOJ._2_Silver;
//[백준]10828 : 스택 - JAVA(자바)

//소요시간 : 7분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _10828_스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command){
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    stack.push(num);
                    break;
                case "pop":
                    if(!stack.isEmpty()){
                        sb.append(stack.pop()).append("\n");
                        break;
                    }
                    sb.append("-1").append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    if(!stack.isEmpty()){
                        sb.append("0").append("\n");
                        break;
                    }
                    sb.append("1").append("\n");
                    break;
                case "top":
                    if(!stack.isEmpty()){
                        sb.append(stack.peek()).append("\n");
                        break;
                    }
                    sb.append("-1").append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}

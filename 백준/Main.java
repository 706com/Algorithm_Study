package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        int start =0;

        while(N -- > 0){

            int now = Integer.parseInt(br.readLine());

            if(now > start) {
                for (int i = start+1; i <= now; i++) {
                    stack.push(i);
                    sb.append('+').append('\n');
                }
                start = now;
            }

            else if(stack.peek() != now){
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append("-").append('\n');
        }

        System.out.println(sb);
    }
}
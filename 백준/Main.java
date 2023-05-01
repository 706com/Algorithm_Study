package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        Deque<Integer> deq = new LinkedList<>();

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(),"[],");

            for(int i=0; i<n; i++){
                deq.add(Integer.parseInt(st.nextToken()));
            }

            AC(p,deq);
        }
        System.out.println(sb);
    }
    static void AC(String command,Deque<Integer> deq){

        boolean leftToRight = true;

        for(char cmd : command.toCharArray()){
            //방향 뒤집기 : R
            if(cmd == 'R'){
                leftToRight = !leftToRight;
                continue;
            }

            //제거하기 : D
            if(cmd == 'D'){
                //방향 왼->오
                if(leftToRight){
                    if(deq.isEmpty()){
                       sb.append("error").append("\n");
                       return;
                    }
                    //첫번째 요소 제거
                    else{
                        deq.pollFirst();
                    }
                }

                //방향 오->왼
                else{
                    if(deq.isEmpty()){
                        sb.append("error").append("\n");
                        return;
                    }
                    //마지막 요소 제거
                    else{
                        deq.pollLast();
                    }
                }
            }
        }
        PrintResult(deq,leftToRight);
    }
    static void PrintResult(Deque<Integer> deq, boolean leftToRight){

        sb.append('[');

        //deq 요소 모두 꺼내오기
        while(!deq.isEmpty()){
            //1) 왼-> 오  일 경우
            if(leftToRight){
                sb.append(deq.pollFirst());
            }

            //2) 오->왼 일 경우
            else{
                sb.append(deq.pollLast());
            }
            sb.append(',');
        }

        //마지막 ',' 지워주기
        if(sb.charAt(sb.length()-1) == ',') {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append(']').append('\n');
    }
}
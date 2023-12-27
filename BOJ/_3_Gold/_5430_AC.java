package BOJ._3_Gold;
//[백준]5430 : AC - JAVA(자바)

//소요시간 : 25분 -> (실패)반례있음
//소요시간 : 12분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _5430_AC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            StringBuilder sb = new StringBuilder();
            Deque<Integer> deq = new LinkedList<>();
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());
            boolean leftToRight = true;
            boolean skip = false;

            //덱에 숫자 넣기
            StringTokenizer st = new StringTokenizer(br.readLine(),",[]");
            while(st.hasMoreTokens()){
                deq.offer(Integer.parseInt(st.nextToken()));
            }

            for(int i=0; i<command.length(); i++){
                //뒤집기
                if(command.charAt(i) == 'R'){
                    leftToRight = !leftToRight;
                }
                //뽑기
                else if(command.charAt(i) == 'D'){
                    //배열이 비어있는데 D를 사용한 경우에는 에러가 발생한다. (탈출)
                    if(deq.isEmpty()){
                        sb.append("error");
                        skip = true;
                        break;
                    }
                    else{
                        //제거방향 : 좌->우
                        if(leftToRight){
                            deq.pollFirst();
                        }
                        //제거방향 : 우->좌
                        else{
                            deq.pollLast();
                        }
                    }
                }
            }
            //에러출력 후 스킵
            if(skip){
                System.out.println(sb);
                continue;
            }
            //출력방향 : 좌->우
            if(leftToRight){
                sb.append('[');
                while(!deq.isEmpty()){
                    sb.append(deq.pollFirst()).append(',');
                }
                if(sb.charAt(sb.length()-1)==','){
                    sb.deleteCharAt(sb.length()-1);
                }
                sb.append(']');
            }
            //출력방향 : 우->좌
            else{
                sb.append('[');
                while(!deq.isEmpty()){
                    sb.append(deq.pollLast()).append(',');
                }
                if(sb.charAt(sb.length()-1)==','){
                    sb.deleteCharAt(sb.length()-1);
                }
                sb.append(']');
            }
            System.out.println(sb);
        }
    }
}

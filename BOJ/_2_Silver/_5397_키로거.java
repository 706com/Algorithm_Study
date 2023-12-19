package BOJ._2_Silver;

//소요시간 : 13분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _5397_키로거 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            StringBuilder sb = new StringBuilder();
            
            Stack<Character> ls = new Stack<>();    //왼쪽 스택
            Stack<Character> rs = new Stack<>();    //오른쪽 스택
            
            //입력 배열
            char[] command = br.readLine().toCharArray();
            
            for(int i=0; i<command.length; i++){
                char c = command[i];
                
                switch (c) {
                    case '<':   //왼쪽 스택 오른쪽으로 이동
                        if(ls.isEmpty()){
                            break;
                        }
                        rs.push(ls.pop());  
                        break;
                    case '>':   //오른쪽 스택 왼쪽으로 이동
                        if(rs.isEmpty()){
                            break;
                        }
                        ls.push(rs.pop());  
                        break;
                    case '-':   //왼쪽 스택에서 하나 제거
                        if(ls.isEmpty()){
                            break;
                        }
                        ls.pop();
                        break;
                    default:
                        ls.push(c);
                        break;
                }
            }

            //command 끝나면 왼쪽스택 모두 오른쪽으로 이동
            while(!ls.isEmpty()){
                rs.push(ls.pop());
            }

            //출력 (오른쪽 스택 꺼내기)
            while(!rs.isEmpty()){
                sb.append(rs.pop());
            }
            System.out.println(sb);
        }
    }
}

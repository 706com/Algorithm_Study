package BOJ._2_Silver;
//[백준]1406 : 에디터 - JAVA(자바)

//소요시간 : 30분 (시간초과) -> 실패 -> 정답보기
//소요시간 : 15분

//< 나의 알고리즘 >
// 일단은 단순 문자열+포인터로 접근하여 문제를 풀어보자.
// 처음에 문자열로 하려 했으나, 인덱스 접근 및 넣고 빼기에 용이한 arraylist로 변경!
// -> 시간초과

//< 답안 알고리즘 >
// Stack 을 이용하여 풀어야함!
// (Right Stack , LeftStack) 을 나누어서 마치 커서가 움직이는 것 처럼 표현하기


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _1406_에디터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int N = Integer.parseInt(br.readLine());

        Stack<Character> ls = new Stack<>();    // Left Stack
        Stack<Character> rs = new Stack<>();    // Right Stack

        for(int i=0; i<str.length(); i++){
            ls.push(str.charAt(i));
        }

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            char ch;
            switch (command){
                case "L":
                    if(ls.isEmpty()){
                        break;
                    }
                    ch = ls.pop();
                    rs.push(ch);
                    break;
                case "D":
                    if(rs.isEmpty()){
                        break;
                    }
                    ch = rs.pop();
                    ls.push(ch);
                    break;
                case "B":
                    if(ls.isEmpty()){
                        break;
                    }
                    ls.pop();
                    break;
                case "P":
                    ch = st.nextToken().charAt(0);
                    ls.push(ch);
                    break;
            }
        }
        int size = ls.size();
        for(int i=0; i<size; i++){
            rs.push(ls.pop());
        }

        size = rs.size();
        for(int i=0; i<size; i++){
            sb.append(rs.pop());
        }
        System.out.println(sb);
    }
}

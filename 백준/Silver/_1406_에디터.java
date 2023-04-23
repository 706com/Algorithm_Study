package 백준.Silver;
//[백준]1406 : 에디터 - JAVA(자바)

//< 나의 알고리즘 >
// 일단은 단순 문자열+포인터로 접근하여 문제를 풀어보자.
// 처음에 문자열로 하려 했으나, 인덱스 접근 및 넣고 빼기에 용이한 arraylist로 변경!

//< 답안 알고리즘 >

//< 새로 알게된 것 >

//< 궁금한 것 >

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1406_에디터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        ArrayList<Character> answer = new ArrayList<>();

        for(char c : str.toCharArray()){
            answer.add(c);
        }

        int cursor = answer.size(); //N
        int M = Integer.parseInt(br.readLine());

        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            String command = st.nextToken();
            switch(command){
                case ("L"):
                    if(cursor == 0){
                        break;
                    }
                    cursor--;
                    break;
                case ("D"):
                    if(cursor == answer.size()){
                        break;
                    }
                    cursor++;
                    break;
                case ("B"):
                    if(cursor == 0){
                        break;
                    }
                    answer.remove(cursor-1);
                    cursor--;
                    break;
                case ("P"):
                    char c = st.nextToken().charAt(0);
                    answer.add(cursor,c);
                    cursor++;
                    break;
            }
        }

        for(char c : answer){
            sb.append(c);
        }
        System.out.println(sb);
    }
}

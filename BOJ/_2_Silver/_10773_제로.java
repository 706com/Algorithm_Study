package BOJ._2_Silver;
//[백준]10773 : 제로 - JAVA(자바)

//<새로 알게된 것>
//char 은 비교할 때 != '0' 형식 ' ' 작은 따옴표
//String은 비교할 때 equals 형식 " " 큰 따옴표

//소요시간 : 5분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _10773_제로 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> st = new Stack<>();
        int K = Integer.parseInt(br.readLine());

        for(int i=0; i<K; i++){
            int num = Integer.parseInt(br.readLine());
            if(num != 0){
                st.push(num);
                continue;
            }
            st.pop();
        }

        int result = 0;
//        int n = st.size();
//        for(int i=0; i<n; i++){
//            result += st.pop();
//        }

        // 위보다 이게 더 편한방법
        while(!st.isEmpty()){
            result += st.pop();
        }
        System.out.println(result);
    }
}
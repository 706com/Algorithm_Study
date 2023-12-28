package BOJ._2_Silver;

//소요시간 : 6분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _3986_좋은_단어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;

        while(N-->0){
            Stack<Character> stk = new Stack<>();
            String str = br.readLine();

            for(int i=0; i<str.length(); i++){
                char c = str.charAt(i);

                if(stk.isEmpty()) {
                    stk.push(c);
                    continue;
                }

                if(stk.peek() == c){
                    stk.pop();
                }
                else{
                    stk.push(c);
                }
            }
            if(stk.isEmpty()){
                count++;
            }
        }
        System.out.println(count);
    }
}

package BOJ._2_Silver;

//소요시간 : 8분
//[250930] : 15분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _9012_괄호 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while(N-->0) {
            String result = "";
            boolean failFlag = false;
            String str = br.readLine();
            Stack<Character> stk = new Stack<>();

            for(int i=0; i<str.length(); i++){
                char c = str.charAt(i);

                if(c=='('){
                    stk.push(c);
                }else{
                    // 실패조건 1 : ( 가 없음
                    if(stk.isEmpty()){
                        System.out.println("NO");
                        failFlag = true;
                        break;
                    }
                    stk.pop();
                }
            }
            if(failFlag){
                continue;
            }
            //실패조건 2 : 끝났는데 ( 가 남아있음
            if(!stk.isEmpty()){
                System.out.println("NO");
                continue;
            }
            System.out.println("YES");
        }
    }
}

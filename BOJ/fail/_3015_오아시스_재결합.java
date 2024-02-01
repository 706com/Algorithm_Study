package BOJ.fail;

//소요시간 : 40분 (실패) : 반례 해결 실패
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _3015_오아시스_재결합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stk = new Stack<>();
        int N = Integer.parseInt(br.readLine());

        long result = 0;
        while(N-->0){
            int num = Integer.parseInt(br.readLine());

            if(stk.isEmpty()){
                stk.push(num);
                continue;
            }

            if(stk.peek() <= num){
                if(stk.peek() == num){
                    result++;
                    stk.push(num);
                    continue;
                }
                while(true){
                    stk.pop();
                    result++;
                    if(stk.isEmpty() || stk.peek() > num){
                        break;
                    }
                }
                result+=stk.size();
                stk.push(num);
            }
            else{
                result++;
                stk.push(num);
            }
        }
        System.out.println(result);
    }
}

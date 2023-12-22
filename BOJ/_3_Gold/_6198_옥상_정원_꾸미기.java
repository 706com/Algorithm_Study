package BOJ._3_Gold;

//소요시간 : 25분 (시간초과) : 답봄
//소요시간 : 20분

// Solution
// 문제 접근 : 스택
// 접근을 해당 빌딩이 쳐다보는 개수가 아닌, 해당 빌딩을 "쳐다봐지는" 개수 로 생각하면 이해가 쉽다.
// 빌딩수 * 빌딩높이를 고려하여 long 형 선언 필수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _6198_옥상_정원_꾸미기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stk = new Stack<>();

        long result = 0;
        while(N-->0){
            int currentBuilding = Integer.parseInt(br.readLine());

            if(!stk.isEmpty()) {
                if (stk.peek() <= currentBuilding) {
                    while (true) {
                        stk.pop();
                        if (stk.isEmpty() || stk.peek() > currentBuilding) {
                            break;
                        }
                    }
                } else if (stk.peek() > currentBuilding) {
                    //아무행동 x
                }
            }
            result += stk.size();
            stk.push(currentBuilding);
        }
        System.out.println(result);
    }
}

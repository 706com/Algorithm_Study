package BOJ._2_Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//< 알고리즘 유형 >
// 스택

//< 알고리즘 풀이 >
// 1) '(' 와 ')' 에 따른 stack 에 넣고 빼기!

public class _9012_괄호 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        boolean check;

        Stack<Character> stk = new Stack<>();

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            check = false;
            String str = br.readLine();

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch == '(') {
                    stk.push(ch);
                } else if (ch == ')') {
                    if (stk.isEmpty()) {
                        sb.append("NO").append('\n');
                        check = true; // 남아있는게 없는데 ) 나왔다.
                        break;
                    }
                    stk.pop();
                }
            }
            if (stk.isEmpty() && !check) {
                sb.append("YES").append('\n');
            } else if (!stk.isEmpty()) {
                sb.append("NO").append('\n');
                stk.removeAllElements();
            }
        }
    }
}

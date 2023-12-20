package BOJ._2_Silver;

//소요시간 : 36분 -> 실패
//소요시간 : 19분 -> 성공

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _1874_스택_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        int N = Integer.parseInt(br.readLine());

        //최초 초기화
        int[] arr = new int[N];
        int[] result = new int[N];
        int now = Integer.parseInt(br.readLine());
        int max = now;

        for(int i=1; i<=now; i++){
            st.push(i);
            sb.append('+').append('\n');
        }
        arr[0] = st.pop();
        result[0] = arr[0];
        sb.append('-').append('\n');

        for(int i=1; i<N; i++){
            now = Integer.parseInt(br.readLine());
            result[i] = now;
            // 스택 가장 상단이 현재 숫자보다 작을 때 push
            if(max<now) {
                for(int j = max + 1; j <= now; j++) {
                    st.push(j);
                    sb.append('+').append('\n');
                }
                max = now;
            }

            if(st.peek() == now){
                arr[i] = st.pop();
                sb.append('-').append('\n');
            }
        }

        for(int i=0; i<N; i++){
            if(result[i] != arr[i]){
                sb = new StringBuilder();
                sb.append("NO");
                break;
            }
        }

        System.out.println(sb);
    }
}

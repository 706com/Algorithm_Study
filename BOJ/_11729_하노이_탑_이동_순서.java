package BOJ;

//소요 시간 : 20분 (실패 :구현실패)
// ❓

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11729_하노이_탑_이동_순서 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        hanoi(N,1,2,3);
        int count = (int)Math.pow(2,N) - 1;

        System.out.println(count);
        System.out.println(sb);
    }

    static void hanoi(int N, int start, int mid,int to){
        if(N == 1){
            sb.append(start+ " " + to + "\n");
            return;
        }

        // N-1개를 A->B로 이동
        hanoi(N-1,start,to,mid);

        // 1개를 A->C로 이동
        sb.append(start+ " " + to + "\n");

        // N-1개를 B->C로 이동
        hanoi(N-1,mid,start,to);
    }
}

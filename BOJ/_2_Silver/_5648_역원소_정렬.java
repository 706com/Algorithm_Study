package BOJ._2_Silver;

//[250825] 50분 (입출력 삽질)

import java.util.*;
import java.io.*;

public class _5648_역원소_정렬 {
    public static void main(String[] args) throws IOException {
        // 오름차순 정렬
        PriorityQueue<Long> pq = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        //처음 숫자 넘기고 한번 더
        if(!st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }

        while(N > 0){
            while(st.hasMoreTokens()){
                String num = st.nextToken();

                String strNum = "";
                for(int i=num.length()-1; i>=0; i--){
                    strNum += num.charAt(i);
                }
                pq.add(Long.parseLong(strNum));
                N--;
            }
            if(N>0){
                st = new StringTokenizer(br.readLine());
            }
        }

        StringBuilder sb= new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(pq.poll()).append('\n');
        }
        System.out.println(sb);
    }
}

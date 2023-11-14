package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class _4466_최대_성적표_만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int count = 1;

        while(count<=T){
            StringTokenizer st =new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            List<Integer> arr = new ArrayList<>();
            st= new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                arr.add(Integer.parseInt(st.nextToken()));
            }

            arr.sort(Collections.reverseOrder());

            int sum = 0;
            for(int i=0;i<K; i++){
                sum+=arr.get(i);
            }
            System.out.printf("#%d %d\n",count,sum);
            count++;
        }
    }
}

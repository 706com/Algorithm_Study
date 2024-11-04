package BOJ._2_Silver;

// [241104] 3분

import java.io.*;
import java.util.*;

public class _11931_수_정렬하기_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list,Collections.reverseOrder());

        for(Integer x : list){
            sb.append(x).append('\n');
        }
        System.out.println(sb);
    }
}

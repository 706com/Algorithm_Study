package BOJ._2_Silver;

//[250102] : 5분

import java.util.*;
import java.io.*;

public class _17219_비밀번호_찾기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();

        for(int i=0;i<N; i++){
            st = new StringTokenizer(br.readLine());
            String site = st.nextToken();
            String password = st.nextToken();
            map.put(site,password);
        }

        for(int i=0; i<M; i++){
            String site = br.readLine();
            sb.append(map.get(site)).append('\n');
        }
        System.out.println(sb);
    }
}

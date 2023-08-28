package 백준.Silver;
//[백준]10815 : 숫자 카드 - JAVA(자바)

//< 나의 알고리즘 >
// 해쉬로 접근!

//< 답안 알고리즘 >

//< 새로 알게된 것 >

//< 궁금한 것 >

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _10815_숫자_카드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<Integer,Integer> hash = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            hash.put(num,hash.getOrDefault(num,0) +1);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<M; i++){
            int result = Integer.parseInt(st.nextToken());
            if(hash.containsKey(result)){
                sb.append("1").append(" ");
            }
            else{
                sb.append("0").append(" ");
            }
        }

        System.out.println(sb);
    }
}

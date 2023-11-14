package BOJ._2_Silver;
//[백준]14425 : 문자열 집합 - JAVA(자바)

//< 나의 알고리즘 >
// Hash 에 집합을 저장해서, 포함하는지 안하는지 알아보면 될 거 같다.

//< 답안 알고리즘 >

//< 새로 알게된 것 >

//< 궁금한 것 >

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _14425_문자열_집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count = 0;

        HashMap<String,Integer> map = new HashMap<>();

        // Hash 에 집합 저장
        for(int i=0; i<N; i++){
            String str = br.readLine();
            map.put(str, map.getOrDefault(str,0)+1);
        }

        // Hash 에 key(집합) 이 존재하는지 물어보고 , 존재한다면 count 증가
        for(int i=0; i<M; i++){
            String test = br.readLine();

            if(map.containsKey(test)){
                count++;
            }
        }
        System.out.println(count);
    }

}

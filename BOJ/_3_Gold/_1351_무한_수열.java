package BOJ._3_Gold;

//[241223] 🔍

import java.util.*;
import java.io.*;

// * dp로 풀 경우 메모리 초과할 듯
// * map.get(int num) map.get(long타입 num) 은 다른 결과가 나옴!

public class _1351_무한_수열 {
    static Map<Long,Long> map = new HashMap<>();
    static long P,Q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());

        map.put(0L,1L);
        solution(N);

//        for(long i=0; i<=N; i++){
//            System.out.println(i + " : " +map.get(i));
//        }
        System.out.println(map.get(N)); //N이 int 형이면 안됨!
    }
    static long solution(long num){
        if(num == 0){
            return map.get(num);
        }
        if(!map.containsKey(num)){
            map.put(num, solution(num/P) + solution(num/Q));
        }
        return map.get(num);
    }
}

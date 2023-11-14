package BOJ._2_Silver;

//< 알고리즘 유형 >
// Map , Set, 정렬

// < 알고리즘 풀이 >
// 1) map : 이미 존재하는 키면 , value 1 증가
// 2) list : 팔린 책의 수가 동일 할 때 정렬을 쓰기 위함.

// <Remember !>
// map.getOrDefault , map.keySet() 유용하니 잘 외워두자.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1302_베스트셀러 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<String,Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        int max = 0;

        for(int i=0; i<N; i++){
            String key = br.readLine();
            set.add(key);

            map.put(key, map.getOrDefault(key,0)+1);
        }

        for(String x : map.keySet()){
            if(map.get(x) > max){
                max = map.get(x);
            }
        }

        List<String> list = new ArrayList<>();

        for(String x : map.keySet()){
            if(max == map.get(x)){
                list.add(x);
            }
        }

        Collections.sort(list);

        System.out.println(list.get(0));
    }
}

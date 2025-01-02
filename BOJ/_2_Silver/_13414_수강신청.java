package BOJ._2_Silver;

//[250102] 20분 ( Map : Key정렬 , Value정렬 복습하기 )

import java.io.*;
import java.util.*;

public class _13414_수강신청 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(st.nextToken());   //수강 가능 인원
        int L = Integer.parseInt(st.nextToken());   //클릭 수

        Map<String,Integer> map = new HashMap<>();
        for(int i=0; i<L; i++){
            String idx = br.readLine();
            map.put(idx,i); //있으면 덮어씌워짐
        }

        // map -> value 기준 정렬
        List<Map.Entry<String,Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort((o1,o2)-> map.get(o1.getKey()) - map.get(o2.getKey()));

        for(Map.Entry<String,Integer> x : entryList){
            sb.append(x.getKey()).append('\n');
            K--;
            if(K==0){
                break;
            }
        }
        System.out.println(sb);
    }
}

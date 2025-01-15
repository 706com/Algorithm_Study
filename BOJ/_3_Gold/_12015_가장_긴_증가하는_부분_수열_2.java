package BOJ._3_Gold;

//[250116] 🔍

import java.util.*;
import java.io.*;

public class _12015_가장_긴_증가하는_부분_수열_2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        List<Integer> list = new ArrayList<>(); //삽입을 동적으로 하기 위해

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++){
            int num = arr[i];

            //비어있거나 가장 크면 "삽입"
            if(list.isEmpty() || list.get(list.size()-1) < num){
                list.add(num);
                continue;
            }

            //크지 않으면 탐색 후 본인보다 큰 값에 "대체"
            int left = 0;
            int right = list.size()-1;
            while(left <= right){
                int mid = (left + right) / 2;

                if(list.get(mid)<num){
                    left = mid + 1;
                } else{
                    right = mid -1;
                }
            }
//            System.out.println(left+" "+num);
            list.set(left,num);
//            System.out.println(list);
        }
        System.out.println(list.size());
    }
}

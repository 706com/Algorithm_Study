package 프로그래머스.Lv2;

//[250306] 23분

// 한자리수부터 찾고 배열화 시켜서 정렬

import java.util.*;

public class 튜플 {
    public int[] solution(String s) {

        String[] arr = s.split("},\\{");

        arr[0] = arr[0].substring(2);
        arr[arr.length-1] = arr[arr.length-1].substring(0,arr[arr.length-1].length()-2);
        // System.out.println(Arrays.toString(arr));

        Arrays.sort(arr,(o1, o2)-> o1.length() - o2.length());
        // System.out.println(Arrays.toString(arr));

        boolean[] check = new boolean[100001];
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<arr.length; i++){
            String[] checkNum = arr[i].split(",");
            for(int j=0; j<checkNum.length; j++){
                int num = Integer.parseInt(checkNum[j]);
                if(!check[num]){
                    check[num] = true;
                    list.add(num);
                }
            }
        }
        System.out.println(list);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}

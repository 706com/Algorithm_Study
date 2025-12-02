package 프로그래머스.Lv2;

//[250225] 1시간 📌
//[251202] 1시간 53분 🔎

import java.util.*;

public class 메뉴_리뉴얼 {
    Map<String,Integer> map = new HashMap<>();
    boolean[] visited;
    int minCourse;

    public String[] solution(String[] orders, int[] course) {
        for(int i=0; i<orders.length; i++){
            visited = new boolean[orders[i].length()];
            minCourse = course[0];

            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            String sortedOrder = new String(arr);

            combination(0,0,"",sortedOrder);
        }
        // 각 코스 요리 중, 최다 주문 횟수 발췌
        Map<Integer,Integer> mostOrderCount = new HashMap<>();
        for(int i=0; i<course.length; i++){
            for(String x : map.keySet()){
                if(x.length() == course[i]){
                    if(!mostOrderCount.containsKey(course[i])){
                        mostOrderCount.put(course[i],0);
                    }
                    int max = Math.max(mostOrderCount.get(course[i]),map.get(x));
                    mostOrderCount.put(course[i],max);
                }
            }
        }

        // for(int x : mostOrderCount.keySet()){
        //     System.out.println(x +" : "+ mostOrderCount.get(x));
        // }

        //만일, 코스요리의 최다 갯수에 포함이 된다면 result 담기
        //1명한테 받은건 안됨
        List<String> result = new ArrayList<>();
        for(String x : map.keySet()){
            if(map.get(x) == mostOrderCount.get(x.length()) && mostOrderCount.get(x.length()) != 1){
                result.add(x);
            }
        }

        Collections.sort(result);
        // System.out.println(result);

        return result.stream().toArray(String[]::new);
    }

    public void combination(int start,int depth, String now, String origin){
        if(depth > origin.length()){
            return;
        }
        // System.out.println(now);

        if(minCourse <= now.length()){
            map.put(now,map.getOrDefault(now,0)+1);
        }

        for(int i=start; i<origin.length(); i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            combination(i+1,depth+1,now+String.valueOf(origin.charAt(i)),origin);
            visited[i] = false;
        }
    }
}

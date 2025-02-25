package 프로그래머스.Lv2;

//[250225] 1시간 📌

import java.util.*;

public class 메뉴_리뉴얼 {
    Map<String,Integer> map = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        // String[] answer = {};

        for(int i=0; i<orders.length; i++){
            boolean[] visited = new boolean[orders[i].length()];
            //코스요리 알파벳 정렬
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = new String(arr);

            // 모든 조합 계산
            combination(0,"",orders[i],visited);
        }

        //value 기준 내림차순 정렬
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list,(o1,o2)->(map.get(o2)-map.get(o1)));

        List<String> answer = new ArrayList<>();

        //최소 2개 이상이여야 하고, course 수 중에서 가장 크거나 같은것
        for(int i=0; i<course.length; i++){
            int max = 2;
            for(String x : list){
                if(x.length() == course[i] && max <= map.get(x)){
                    max = map.get(x);
                    answer.add(x);
                }
            }
        }
        Collections.sort(answer);
        // System.out.println(answer);
        return answer.toArray(new String[0]);   //String List -> Arr
    }
    public void combination(int depth,String str, String order,boolean[] visited){
        // System.out.println(str);

        //2자리 이상
        if(str.length() != 1){
            map.put(str,map.getOrDefault(str,0)+1);
        }
        for(int i=depth; i<order.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                combination(i+1,str+order.charAt(i),order,visited);
                visited[i] = false;
            }
        }
    }
}

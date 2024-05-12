package 프로그래머스.Lv1;

//소요시간
//[240512] : 9:11 ~ 9:55

import java.util.*;

public class 달리기_경주 {
    class Solution {
        public String[] solution(String[] players, String[] callings) {
            String[] answer = {};
            HashMap<String,Integer> nameKey = new HashMap<>();
            HashMap<Integer,String> gradeKey = new HashMap<>();

            for(int i=0; i<players.length; i++){
                nameKey.put(players[i],i+1);
                gradeKey.put(i+1,players[i]);
            }

            for(int i=0; i<callings.length; i++){
                String name = callings[i];   //이름 불린 선수
                int grade = nameKey.get(name);  //이름불린 선수 기존 등수
                nameKey.put(name,nameKey.getOrDefault(name,0)-1);   //이름불린 선수 등수 변경

                String changeName = gradeKey.get(grade-1);  //바뀐 순위 선수 추출
                int changeGrade = nameKey.get(changeName);

                // System.out.println("name : " + name + ", changeName : " + changeName);

                nameKey.put(changeName,nameKey.getOrDefault(changeName,0)+1);   //역전 당한 선수 등수 변경

                gradeKey.put(grade,changeName);
                gradeKey.put(changeGrade,name);

                // System.out.println(gradeKey.get(grade)+" " + gradeKey.get(changeGrade));
            }

            // for(String name : nameKey.keySet()){
            //     System.out.println(name + " " + nameKey.get(name));
            // }

            answer = new String[gradeKey.size()];

            for(int x : gradeKey.keySet()){
                answer[x-1] = gradeKey.get(x);
            }
            return answer;
        }
    }
}

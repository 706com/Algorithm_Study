package 프로그래머스.Lv1;

//[251125] 35분

import java.util.*;

public class 신고_결과_받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};

        Set<String> key = new HashSet<>(); // 중복 신고 방지
        Map<String,Integer> reportCountMap = new HashMap<>();   //신고량
        Map<String,List<String>> reporterListMap = new HashMap<>(); //신고자 목록

        Map<String,Integer> mailCountMap = new HashMap<>(); //메일량

        for(int i=0; i<report.length; i++){
            String keyString = report[i];
            String[] nameSplit = report[i].split(" ");

            String reporter = nameSplit[0];
            String reportee = nameSplit[1];

            // 중복 신고가 없을때만
            if(!key.contains(keyString)){
                key.add(keyString);

                //신고당한 횟수 기록
                reportCountMap.put(reportee,reportCountMap.getOrDefault(reportee,0)+1);

                //신고한 사람들 목록 기록
                if(!reporterListMap.containsKey(reportee)){
                    List<String> reporterList = new ArrayList<>();
                    reporterListMap.put(reportee,reporterList);
                }
                reporterListMap.get(reportee).add(reporter);
            }
        }

        // 신고 받은 횟수 k개 이상 멤버 추출
        List<String> suspendList = new ArrayList<>();
        for(String x : reportCountMap.keySet()){
            if(reportCountMap.get(x)>=k){
                suspendList.add(x);
            }
        }
        // System.out.println(suspendList);

        //신고한 사람들 추출 및 카운트 세기
        for(String x : suspendList){
            List<String> reporter = reporterListMap.get(x);

            for(String name : reporter){
                mailCountMap.put(name,mailCountMap.getOrDefault(name,0)+1);
            }
        }

        // id_list 별 최종 값 산출 -> 메일 못받으면 0
        List<Integer> result = new ArrayList<>();
        for(String x : id_list){
            if(mailCountMap.containsKey(x)){
                result.add(mailCountMap.get(x));
            } else{
                result.add(0);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}

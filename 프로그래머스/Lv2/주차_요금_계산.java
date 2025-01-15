package 프로그래머스.Lv2;

//[250115] 22분

import java.util.*;

public class 주차_요금_계산 {
    public int[] solution(int[] fees, String[] records) {
        int[] answer;

        Map<String,Integer> map = new HashMap<>();

        Map<String,Integer> result = new HashMap<>();

        int baseTime =fees[0];
        int baseFee=fees[1];
        int perTime=fees[2];
        int perFee=fees[3];

        // 입차 - 출차 시간 관리
        for(int i=0; i<records.length; i++){
            StringTokenizer st = new StringTokenizer(records[i]);
            StringTokenizer stt;
            String timeStr = st.nextToken();
            stt = new StringTokenizer(timeStr,":");

            int time = Integer.parseInt(stt.nextToken())*60 + Integer.parseInt(stt.nextToken());

            String number = st.nextToken();
            String IO = st.nextToken();

            //입차
            if(IO.equals("IN")){
                map.put(number,time);
            }
            //출차
            else{
                int startTime = map.get(number);
                map.remove(number);

                int resultTime = time - startTime;

                result.put(number,result.getOrDefault(number,0)+resultTime);
            }
            // System.out.println(time);
        }

        //입차 기록만 있는 차 추출 후 시간 중첩
        for(String number : map.keySet()){
            int endTime = 23 * 60 + 59;
            int resultTime = endTime - map.get(number);
            result.put(number,result.getOrDefault(number,0)+resultTime);
        }

        // 오름차순 관리
        List<String> list = new ArrayList<>();
        for(String x : result.keySet()){
            list.add(x);
        }
        Collections.sort(list);

        // 누적된 시간 기반으로 가격 책정
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            int allTime = result.get(list.get(i));

            //누적 주차 시간이 기본 시간 이하라면, 기본 요금을 청구
            if(allTime <= baseTime){
                answer[i] = baseFee;
            }
            // 초과 금액 청구
            else{
                // System.out.println(Math.ceil((double)(allTime-baseTime) / perTime));
                answer[i] = baseFee + (int)(Math.ceil((double)(allTime-baseTime) / perTime) * perFee);
            }
        }

        return answer;
    }
}

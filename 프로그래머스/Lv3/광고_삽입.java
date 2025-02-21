package 프로그래머스.Lv3;

//[250220] 🔍📌

//슬라이딩 윈도우

import java.util.*;

public class 광고_삽입 {
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";

        int playTime = convertTime(play_time);
        int advTime = convertTime(adv_time);

        // System.out.println(playTime);
        // System.out.println(advTime);

        // if(playTime == advTime){
        //     return "00:00:00";
        // }

        //Time 배열에 재생시간 기록
        int[] times = new int[360000];  // 99:59:59
        for(String log : logs){
            StringTokenizer st = new StringTokenizer(log,"-");
            int startTime = convertTime(st.nextToken());
            int endTime = convertTime(st.nextToken());

            // System.out.println(startTime+" "+endTime);

            for(int i=startTime; i<endTime; i++){
                times[i]++;
            }
        }

        int startTime = 0;
        long totalTime = 0;
        long maxTotalTime = 0;

        for(int i=0; i<advTime; i++){
            totalTime += times[i];
        }
        maxTotalTime = totalTime;
        //슬라이딩 윈도우
        for(int i=advTime; i<playTime; i++){
            totalTime += times[i] - times[i-advTime];
            if(totalTime > maxTotalTime){
                maxTotalTime = totalTime;
                startTime = i - advTime + 1;
            }
        }

        String timeStr = convertTimeStr(startTime);
        // System.out.println(timeStr);

        return timeStr;
    }
    public int convertTime(String time){
        StringTokenizer st = new StringTokenizer(time,":");
        return Integer.parseInt(st.nextToken()) * 3600 + Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
    }
    public String convertTimeStr(int time){
        int h = time / 3600;
        int m = (time % 3600) / 60;
        int s = time % 3600 % 60;


        String H = h>=10 ? String.valueOf(h) : "0"+String.valueOf(h);
        String M = m>=10 ? String.valueOf(m) : "0"+String.valueOf(m);
        String S = s>=10 ? String.valueOf(s) : "0"+String.valueOf(s);

        return H+":"+M+":"+S;
    }
}

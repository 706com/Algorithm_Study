package 프로그래머스.Lv3;
//[프로그래머스] 디스크 컨트롤러 - JAVA(자바)

//< 알고리즘 유형 >
// 힙

//< 알고리즘 풀이 >
//

//< 새로 알게된 것 >

//< 궁금한 것 >

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 디스크_컨트롤러 {
    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[1]- o2[1]);

        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        //pq 에 클래스단위로 넣기.

        int index = 0;
        int count = 0;
        int total = 0;
        int end = 0;

        while(count < jobs.length){
            while(index < jobs.length && jobs[index][0] <= end){
                pq.add(jobs[index]);
                index++;
            }

            if(pq.isEmpty()){
                end = jobs[index][0];
            }
            else{
                int[] cur = pq.poll();
                total += cur[1] + end - cur[0];
                end += cur[1];
                count++;
            }
        }
        answer = total / jobs.length;
        return answer;
    }
    public static void main(String[] args) {
//        int[][] jobs = {{0,3},{1,9},{2,6}};
        int[][] jobs = {{0,9},{1,6},{2,3}};

        디스크_컨트롤러 sol = new 디스크_컨트롤러();
        sol.solution(jobs);

    }
//    static class Job{
//        int start;
//        int spend;
//        Job(int start, int spend){
//            this.start=start;
//            this.spend=spend;
//        }
//    }
}

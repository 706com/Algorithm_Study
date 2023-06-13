package 프로그래머스.Lv3;
//[프로그래머스] 디스크 컨트롤러 - JAVA(자바)

//< 알고리즘 유형 >
// 힙

//< 알고리즘 풀이 >
//

//< 새로 알게된 것 >

//< 궁금한 것 >

import java.util.PriorityQueue;

public class 디스크_컨트롤러 {
    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<Job> pq = new PriorityQueue<>();

        //pq 에 클래스단위로 넣기.
        for(int i=0; i<jobs.length; i++){
            Job job = new Job(jobs[i][0],jobs[i][1]);
            pq.offer(job);
        }

        return answer;
    }
    public static void main(String[] args) {
        int[][] jobs = {{0,3},{1,9},{2,6}};

        디스크_컨트롤러 sol = new 디스크_컨트롤러();
        sol.solution(jobs);

    }
    static class Job{
        int start;
        int spend;
        Job(int start, int spend){
            this.start=start;
            this.spend=spend;
        }
    }
}

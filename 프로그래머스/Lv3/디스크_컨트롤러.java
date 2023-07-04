package 프로그래머스.Lv3;
//[프로그래머스] 디스크 컨트롤러 - JAVA(자바)

//< 알고리즘 유형 >
// 힙

//< 알고리즘 풀이 >
// 1. 요청시간을 오름차순 정렬한다.
// 2. 처리시간이 오름차순으로 정렬되는 큐에 넣는다.


//< 새로 알게된 것 >

//< 궁금한 것 >

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 디스크_컨트롤러 {
    public int solution(int[][] jobs) {
        int answer = 0;
        int jobIndex = 0;
        int end = 0;


        Arrays.sort(jobs,(o1,o2)-> o1[0]-o2[0] );

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[1]-o2[1]);

        while(){
            while(jobIndex < jobs.length && jobs[jobIndex][0] <= end){
                pq.add(jobs[jobIndex]);
                jobIndex++;
            }
        }


        return answer;
    }

    public static void main(String[] args) {
//        int[][] jobs = {{0,3},{1,9},{2,6}};
        int[][] jobs = {{0,9},{1,6},{2,3}};

        디스크_컨트롤러 sol = new 디스크_컨트롤러();
        sol.solution(jobs);

    }
}

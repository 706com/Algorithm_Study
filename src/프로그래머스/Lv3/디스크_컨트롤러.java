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
        int end = 0;
        int jobsIndex = 0;
        int count = 0;

        // 처리시간 기준으로 오름차순 정렬되는 우선순위 큐(Heap)
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)-> o1[1]-o2[1]);

        //요청순서대로 배열 오름차순 정렬
        Arrays.sort(jobs , (o1,o2)-> o1[0]-o2[0]);

        while(count < jobs.length){

            //하나의 작업이 완료되는 시점(end)까지 들어온 모든 요청을 큐에 넣기
            while(jobsIndex < jobs.length && jobs[jobsIndex][0] <= end){
                pq.offer(jobs[jobsIndex]);
                jobsIndex++;
            }

            // 큐가 비어있다면 작업 완료(end) 이후에 다시 요청이 들어온다는 의미
            // (end를 요청의 가장 처음으로 맞춰줌)
            if (pq.isEmpty()){
                end = jobs[jobsIndex][0];
            }
            // 작업이 끝나기 전(end 이전) 들어온 요청 중 가장 수행시간이 짧은 요청부터 수행
            else{
                int[] temp = pq.poll();
                answer += temp[1] + end - temp[0];
                end += temp[1];
                count++;
            }
        }

        // 소수점 버림
        return (int) Math.floor(answer / jobs.length);
    }

    public static void main(String[] args) {
        int[][] jobs = {{0,3},{1,9},{2,6}};
//        int[][] jobs = {{0,9},{1,6},{2,3}};

        디스크_컨트롤러 sol = new 디스크_컨트롤러();
        sol.solution(jobs);

    }
}

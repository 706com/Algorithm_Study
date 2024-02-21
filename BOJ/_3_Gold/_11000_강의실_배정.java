package BOJ._3_Gold;

//소요시간 : 20분 (실패 : 시간초과)
//소요시간 : 31분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _11000_강의실_배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        //정렬 재정의
        Arrays.sort(arr, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                //시작시간이 같으면, 종료시간 빠른순(오름차순)
                if(o1[0]==o2[0]){
                    return o1[1] - o2[1];
                }
                //시작시간 빠른순(오름차순)
                return o1[0]-o2[0];
            }
        });

//        for(int[] x : arr){
//            System.out.println(Arrays.toString(x));
//        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //(정렬된)강의실 종료시간 담기
        pq.add(arr[0][1]);

        for(int i=1; i<N; i++){
            //종료시각이 현재 강의 시작시간과 같거나 작다면 교체
            if(pq.peek()<=arr[i][0]){
                pq.poll();
            }
            pq.offer(arr[i][1]);
        }
        System.out.println(pq.size());
    }
}

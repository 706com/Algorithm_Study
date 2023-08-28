package 백준.Silver;
//[백준]1931 : 회의실 배정 - JAVA(자바)

//< 나의 알고리즘 >
// dp 알고리즘..? 같긴한데 잘 모르겠다 감이 안잡힌다.

//< 답안 알고리즘 >
// 그리디 알고리즘  -> 동적 알고리즘의 업그레이드

// 그리디 알고리즘은 동적 프로그래밍 사용 시 지나치게 많은 일을 한다는 것에서 착안하여 고안된 알고리즘입니다.
// 그리디 알고리즘은 탐욕 알고리즘 또는 욕심쟁이 알고리즘이라고도 불리는데요.
// 미래를 생각하지 않고 각 단계에서 가장 최선의 선택을 하는 기법

// 그리디 알고리즘이 통하는 문제 : 1.활동 선택문제 (강의실) , 2. 분할 가능 배낭 문제


//< 새로 알게된 것 >
// 그리디 알고리즘

//< 궁금한 것 >

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _1931_회의실_배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    //1 ≤ N ≤ 100,000


        int[][] arr = new int[N][2];

        //입력
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        //정렬
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //종료시점이 같으면 시작시간으로 오름차순
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }

                //종료시간에 맞춰 오름차순
                return o1[1] - o2[1];
            }
        });

//        for(int i=0; i<N; i++){
//            System.out.println(arr[i][0] +" " +arr[i][1]);
//        }

        int count = 0;
        int startTime = 0;

        for(int i=0; i<N; i++){

            // 종료시간이 다른 회의의 시작 시간보다 작거나 같다면 갱신
            if(startTime <= arr[i][0]){
                startTime = arr[i][1];
//                System.out.println("startTime :"+ startTime);
                count++;
            }
        }

        System.out.println(count);
    }
}

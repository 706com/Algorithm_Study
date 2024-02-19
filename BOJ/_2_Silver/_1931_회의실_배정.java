package BOJ._2_Silver;
//[백준]1931 : 회의실 배정 - JAVA(자바)

//소요시간 : 31M

// 그리디 알고리즘은 동적 프로그래밍 사용 시 지나치게 많은 일을 한다는 것에서 착안하여 고안된 알고리즘입니다.
// 그리디 알고리즘은 탐욕 알고리즘 또는 욕심쟁이 알고리즘이라고도 불리는데요.
// 미래를 생각하지 않고 각 단계에서 가장 최선의 선택을 하는 기법
// 그리디 알고리즘이 통하는 문제 : 1.활동 선택문제 (강의실) , 2. 분할 가능 배낭 문제

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _1931_회의실_배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                //종료시간이 같으면, 시작시간 오름차순(빠른순) 정렬
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }
                //종료시간 기준 오름차순(빠른순) 정렬
                return o1[1] - o2[1];
            }
        });

        int count = 0;
        int endTime = 0;
        for(int i=0; i<N; i++) {
            if(endTime <= arr[i][0]){
                count++;
                endTime = arr[i][1];
            }
        }
        System.out.println(count);
    }
}

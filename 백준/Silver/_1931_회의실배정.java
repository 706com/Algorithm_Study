package 백준.Silver;
//[백준]1406 : 에디터 - JAVA(자바)

//< 나의 알고리즘 >
// 그리디 알고리즘.
// 끝나는시간 기점으로 A 와 B의 영향을 끼치지 않으니 사용가능.
// 단, 혹시라도 순간의 선택이 나중의 선택에 영향을 끼칠 가능성은 없는지 확인하고 구현할 것

//< 답안 알고리즘 >

//< 새로 알게된 것 >

//< 궁금한 것 >


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _1931_회의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());    //회의 개수
        int[][] meeting = new int[N][2];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            meeting[i][0] = Integer.parseInt(st.nextToken());
            meeting[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meeting, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                //시작 시간 같으면 오름차순 이유: 1 3 / 8 8 / 4 8
                if(o1[1] == o2[1])
                    return o1[0] - o2[0];

                else{
                    return o1[1] - o2[1];
                }
            }
        });

        int point = meeting[0][1];
        int result = 1;

        for(int i=1; i<N; i++){
            if(point <= meeting[i][0]){
                result++;
                point = meeting[i][1];
            }
        }

        System.out.println(result);

    }
}

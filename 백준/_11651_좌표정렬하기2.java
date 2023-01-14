package 백준;
//[백준]11651 : 좌표 정렬하기2 - JAVA(자바)

//<새로 알게된 것>

//<궁금한 것>


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _11651_좌표정렬하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] arr = new int[N][2];

        //배열에 입력받기
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<2; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //내가 원하는 방법으로 정렬 재정의
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //return 값 양수   : 뒤집기
                //return 값 음수,0 : 그대로
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        for(int i=0; i<N; i++) {
            System.out.println(arr[i][0] +" " + arr[i][1]);
        }
    }

}

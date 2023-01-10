package 백준;

//[백준]10814 : 나이순정렬 - JAVA(자바)

//<새로 알게된 것>
// Arrays.sort 사용법 및 Comparator<T>(), compare 함수 재정의 복기
// compare 함수 ->  양수:뒤집기 / 음수,0 : 그대로
// 다른 조건으로 정렬이 되더라도, 입력한 순서대로 냅두어진다.

//<궁금한 것>

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _10814_나이순정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] arr = new String[N][2];

        //배열에 나이와 이름 입력
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 2; j++) {
                arr[i][j] = st.nextToken();
            }
        }

        //정렬하기
        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            //return 값 양수   : 뒤집기
            //return 값 음수,0 : 그대로
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o1[0])-Integer.parseInt(o2[0]);
            }
        });

        for(int i=0; i<N; i++){
            System.out.println(arr[i][0]+" "+arr[i][1]);
        }
    }
}

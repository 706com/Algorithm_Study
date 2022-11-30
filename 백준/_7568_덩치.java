package 백준;
//[백준]4153 : 직각삼각형 - JAVA(자바)

//<새로 알게된 것>
//

//<궁금한 것>
//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _7568_덩치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][2];

        //입력받기
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<2; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //rank값 저장 시킬 배열 생성 (사람수만큼)
        int[] result = new int[N];


        for(int i=0; i<N; i++){
            int rank = 1;
            for(int j=0; j<N; j++) {

                //본인을 비교 할 필요는 없으므로 생략
                if(j==i){
                    continue;
                }

                //1. 몸무게를 비교한다 (0번지)
                //2. 키를 비교한다 (1번지)
                //3. 덩치등수 매기기 (rank) : 본인보다 덩치가 큰 사람이 있으면 rank가 +1 씩 늘어난다
                if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    rank++;
                }
            }
            result[i] = rank;
        }

        for(int i=0; i<N; i++) {
            System.out.print(result[i] + " ");
        }






    }
}

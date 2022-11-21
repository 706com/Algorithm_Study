package 백준;
//[백준]2805 : 나무자르기 - JAVA(자바)

//<새로 알게된 것>
//이분탐색
//UpperBound 완벽 이해하기 (숙제)


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
public class _2805_나무자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] tree = new int[N];
        int min = 0;
        int mid = 0;
        int max = 0;

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<N; i++){
            tree[i] = Integer.parseInt(st.nextToken());
            if(max < tree[i]){
                max = tree[i];
            }
        }

        while(min < max ){
            mid = (min + max) / 2;
            long sum = 0;               //int 형의 최댓값 : 21억 , M 의 최댓값 20억

            //만일 자르는 위치(mid) 가 나무의 길이보다 높아서 안자르게 된다면
            //treeheight - mid 는 음수가 나온다.
            //따라서 조건문으로 treeheight - mid > 0 일 때 해당.

            for(int treeheight : tree){
                if(treeheight - mid > 0){
                    sum += treeheight - mid;
                }
            }

            //만일 잘린 나무의 합 (sum) < 가져가야 할 나무 (M) 이면 = 자르는 위치를 낮춰야 한다
            if(sum < M){
                max = mid;
            }
            //만일 잘린 나무의 합 (sum) >= 가져가야 할 나무 (M) 이면 = 자르는 위치를 높여야 한다
            else if(sum >= M){
                min = mid + 1;
            }
        }

        System.out.println(min -1);
    }
}

package BOJ._2_Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _12018_Yonsei_TOTO {
    static int[] minArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   //과목 수
        int m = Integer.parseInt(st.nextToken());   //마일리지
        minArr= new int[n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());   // 신청한 사람 수
            int L = Integer.parseInt(st.nextToken());   // 과목 수강인원

            int[] arr = new int[P];
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<P; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            searchMin(arr,L,i);
        }

        //오름차순 정렬
        Arrays.sort(minArr);
        int sum = 0;
        int count = 0;
        for(int i=0; i<n; i++){
            //주어진 마일리지보다 초과하지 않는 만큼의 수강가능 갯수 세주기
            sum += minArr[i];
            if(sum>m){
                break;
            }
            count ++;
        }
        System.out.println(count);

//        for(int x : minArr){
//            System.out.print(x+" ");
//        }
//        System.out.println();
    }
    static void searchMin(int[] arr,int L, int index) {
        //신청인원이 수강인원보다 작으면 1 넣고 수강가능
        if(arr.length<L){
            minArr[index] = 1;
            return;
        }
        Arrays.sort(arr);
        // L번째의 최댓값이 성준이가 신청했을 때 들을 수 있는 최솟값
        minArr[index] = arr[arr.length-L];
    }
}

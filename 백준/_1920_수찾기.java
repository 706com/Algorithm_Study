package 백준;//1920 : 수찾기
//깨달은 것
//BufferedReader , readLine()
//StringTokenizer , nextToken()

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _1920_수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr1 = new int[N];

        //공백단위 토큰화
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        for(int i=0; i<arr1.length; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] arr2 = new int[M];

        st = new StringTokenizer(br.readLine()," ");

        for(int i=0; i<arr2.length; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        //이분탐색 하기 위해서는 배열이 무조건 정렬 되어 있어야함!
        Arrays.sort(arr1);

        int key;

        for(int i=0; i<arr2.length; i++) {
            //binary 함수에 arr1배열과 key 값을 전달
            boolean rst = binary(arr1, arr2[i]);

            if(rst){
                System.out.println("1");
            }
            else{
                System.out.println("0");
            }
        }
    }

    public static boolean binary(int[] arr,int key){
        int low=0;
        int high=arr.length-1;

        int mid = 0;

        //low 값이 high를 넘어서는 순간까지 반복
        while(low<=high){
            mid = (low+high) / 2;

            if(key < arr[mid]){
                high = mid-1;
            }
            else if(key > arr[mid]){
                low = mid +1;
            }
            else{
                //찾을 경우 true 반환
                return true;
            }
        }

        //반복문이 끝날 때 까지 못찾으면 false 반환
        return false;
    }
}

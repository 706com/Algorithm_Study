package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Deque;
import java.util.LinkedList;

public class _1240_단순_2진_암호코드 {

    static String[] code= {"0001101","0011001","0010011","0111101","0100011","0110001","0101111","0111011","0110111","0001011"};
    static int N,M;
    static Deque<Integer> deq = new LinkedList<>();
    static int[][] arr;
    static int[] trueNumber;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int count = 1;

        while(count<=T) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new int[N][M];
            trueNumber = new int[9];

            for(int i=0; i<N; i++){
                String str = br.readLine();
                for(int j=0; j<M; j++){
                    int n = Character.getNumericValue(str.charAt(j));
                    arr[i][j] = n;
                }
            }

            boolean check = false;
            // 1 나오는 해당 줄 추출
            for(int i=0; i<N; i++){
                for(int j= 0; j<M; j++){
                    if(arr[i][j] == 1){
                        checkLineAndExtractPassword(i);
                        check = true;
                    }
                    if(check){
                        break;
                    }
                }
                if(check){
                    break;
                }
            }

            // 실제 숫자 추출
            makeNumber();

            //검증
            int result = validate();

            System.out.printf("#%d %d",count, result);
            System.out.println();
            count++;
        }
    }

    public static void checkLineAndExtractPassword(int n){
        int[] subArr = new int[M];
        for(int i=0; i<M; i++){
            subArr[i] = arr[n][i];
        }

        int firstPoint = 0;
        boolean checkFirst = false;
        int lastPoint = 0;

        // 끝자리 1 찾기
        for(int i=0; i<M; i++){
            if(subArr[i] == 1){
                // 첫번째 1의 포인트 지정
                if(!checkFirst) {
                    firstPoint = i;
                    checkFirst = true;
                }
                // 마지막 1의 포인트 지정
                lastPoint = i;
            }
        }

        //시작 1지점 부터 끝 1 지점까지 잘라서 저장
        for(int i=firstPoint; i<=lastPoint; i++){
            deq.offerLast(subArr[i]);
        }

        // 56 될 때까지 앞에 0 붙여넣기
        while(deq.size() != 56){
            deq.offerFirst(0);
        }

//        for(int i=1; i<=56; i++){
//            System.out.print(deq.poll());
//            if(i%7==0){
//                System.out.println();
//            }
//        }
    }

    public static void makeNumber(){
        String temp = "";
        int count = 0;
        int index = 1;
        for(int i=0; i<56; i++){
            temp += String.valueOf(deq.poll());
            count++;
            if(count % 7 == 0){
                for(int j=0; j<=9; j++){
                    if(temp.equals(code[j])){
                        trueNumber[index] = j;
                        break;
                    }
                }
                index++;
                temp = "";
            }
        }

//        for(int i=1; i<=8; i++){
//            System.out.print(trueNumber[i]+" ");
//        }
//        System.out.println();
    }
    public static int validate(){
        int odd = 0;
        int even = 0;
        int result = 0;
        for(int i=1; i<=8; i++){
            if(i%2 == 1){
                odd += trueNumber[i];
            }
            else{
                even += trueNumber[i];
            }
            result += trueNumber[i];
        }
        if((odd * 3 + even) % 10 ==0){
            return result;
        }
        else{
            return 0;
        }
    }
}

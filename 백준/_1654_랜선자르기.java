package 백준;//1654 : 랜선자르기
//새로 알게된 것
//이분탐색 : Upper Bound -> 이분탐색 할 때에는 정렬이 필수 but 이번 문제는 특정 인덱스값 찾는것이 아니므로 생략
//int 와 long 의 차이 : 정수형 표현범위 차이 : int = 2^32 (약 21억) , long = 2^64

//그리고 가장 중요한 점이 있다.
//
//mid가 0이게 되면 그 다음 for문 안에
//count += (arr[i] / mid) 부분에서 mid 가 0이라 0으로 나눗셈되는 불상사가 일어나게 된다.

//그렇다면 해결 방법은 매우 간단하다. 자연수 탐색 범위를 0 ~ max 가 아닌 0 ~ max + 1 범위에서 탐색하면 된다.
//즉, 우리는 입력 받는 랜선에서 최대 길이 + 1 을 max값으로 잡아야 한다는 것이다

//https://st-lab.tistory.com/269 출처

import java.util.Scanner;

class _1654_랜선자르기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        int N = sc.nextInt();

        int[] arr = new int[K];

        long max = 0;

        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
            if(max<arr[i]){
                max= arr[i];
            }
        }

        //길이는 0이 아닌 1부터 시작하므로 +1
        max++;

        long mid = 0;
        long min = 0;

        while(min<max){

            mid = (min+max) /2;

            long count = 0;

            for(int i=0; i<arr.length; i++){
                count += arr[i] / mid;
            }

            //Upper Bound 방식
            // mid 길이로 잘랐을 때의 갯수(count)가 원하는 랜선의 갯수보다 작으면
            // 자르고자 하는 길이를 더 줄여야 하니까 최댓값 max 값을 낮춘다.
            // 그 외에는 자르고자 하는 길이를 늘려야 하니 최소길이 min 값을 늘린다

            if(count<N){
                max = mid;
            }
            else{
                min = mid+1;
            }
        }

        //Upper Bound를 통해 얻어진 값 min 에 -1 을 해줘야한다.
        System.out.println(min-1);
    }
}




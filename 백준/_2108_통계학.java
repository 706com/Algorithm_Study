package 백준;//2108 : 통계학
//새로 알게된 것
//카운팅정렬
//Math.round : 반올림을 시켜준다 (주의할 점은 double형 변환을 해줘야 원활하다)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2108_통계학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        //카운팅 정렬할 때 쓰기위한 배열
        //주의할 점: 입력값이 -4000~4000 이면 총 8001개이다
        int[] arr = new int[N];
        int[] counting = new int[8001];
        int[] result = new int[N];

        int max_count=0;

        //입력되는 정수의 절댓값은 4000을 넘지 않는다
        //인덱스에는 음수가 안되므로!! : -4000 입력시 -> 0 , 4000입력시 -> 8000
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine())+4000;
        }

        //카운팅정렬 step1 : array배열의 값이 곧 counting배열의 인덱스이다.
        // ex) araay[2] = 3 -> counting[3]++  : 갯수를 세기 위함
        for(int i=0; i<arr.length; i++){
            counting[arr[i]]++;
        }

        int where_is_second =0;
        int many=0;

        //중간에 최빈값을 구하기 위한 max_count 세기

        //현재 카운팅정렬의 인덱스 -4000->0 , 0->4000 , 4000->8000 이므로 최빈값 도출 할 때 에는-4000을 해준다.
        for(int i=0; i<counting.length; i++){
            if(max_count<counting[i]) {
                max_count = counting[i];
                many = i-4000;
            }
        }
        //
        // System.out.println("max_count: " +max_count );
        for(int i=0; i<counting.length; i++){
            //만약에 max_count가 가장 높은 값이 아닌, 겹치는 경우에는 두번째로 작은값을 찾아야한다.
            if(max_count == counting[i]){
                where_is_second++;
                if(where_is_second == 2){
                    many = i-4000;
                    break;
                }
            }
        }

        //카운팅정렬 step2 : 총 갯수를 파악하기 위해서 counting배열 을 중첩하여 저장한다.
        // (마지막 인덱스의 값이 array배열의 크기와 같으면 성공)

        for(int i=1; i<counting.length; i++){
            counting[i] += counting[i-1];
        }

        //카운팅정렬 step3
        //array[i]의 값 => counting배열의 인덱스
        //counting배열의 값-1 => 최종 정렬된 배열의 위치인덱스
        //+ 최종 result배열 인덱스로 가기위해선 -4000을 해줘야한다
        for(int i=arr.length-1; i>=0; i--){
            int value = arr[i];
            counting[value]--;
            result[counting[value]] = value-4000;
        }



        //정렬이 제대로 됐는지 확인하기. 문제 제출할 때에는 주석처리
        /*
        //------------------
        for(int i=0; i<result.length; i++){
            System.out.print(result[i]+"\t");
        }
        //------------------

         */


        //본격적인 통계학 문제 값 산출
        //1.산술평균 , 2.중앙값 , 3.최빈값(이미 구함) , 4.범위
        int average;
        int mid;
        int range;

        int sum = result[0];
        int max = result[0];
        int min = result[0];

        for(int i=1; i<result.length; i++){
            //모든수의 합 ->산술평균 산출을 위해
            sum+=result[i];

            //최댓값
            if(max<result[i]){
                max = result[i];
            }
            //최솟값
            if(min>result[i]){
                min = result[i];
            }
        }

        //1.산술평균
        //Math.round -> 빈올림 함수
        //double 형으로 변환 안하고 할 시 , 소수점을 버리고 가기 때문에 둘 중 하나라도 double형 으로 바꾼 뒤, 반올림 하여 소수점을 획득하고
        //다시 int 형으로 바꾼다
        average = (int)Math.round((double)sum / result.length);

        //2.중앙값
        mid = result[result.length/2];

        //4.범위
        range = max-min;

        System.out.println(average);
        System.out.println(mid);
        System.out.println(many);
        System.out.println(range);
    }
}

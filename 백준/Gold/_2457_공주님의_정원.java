package 백준.Gold;

// < 알고리즘 유형 >
// 그리디

// < 풀이 접근 >
// *. 회의실 배정과 비슷한 유형으로 보인다.
// 1. 날짜를 숫자 형식으로 재구성한다. ex) 3/1 : 301  10/5 : 1005
// 2. Node 안에 시작,끝 을 담는다.
// 3. 배열 정렬을 재구성시킨다. ( 시작일 낮은순 , 종료일 높은 순 )
// 4. 배열을 순차적으로 돌며, count 를 세준다.


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.Arrays;

public class _2457_공주님의_정원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Flower[] arr = new Flower[N];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startM = Integer.parseInt(st.nextToken());
            int startD = Integer.parseInt(st.nextToken());
            int endM = Integer.parseInt(st.nextToken());
            int endD = Integer.parseInt(st.nextToken());

            // 1. 날짜를 숫자 형식으로 재구성한다. ex) 3/1 : 301  10/5 : 1005
            int start = startM * 100 + startD;
            int end = endM * 100 + endD;
            // 2. Node 안에 시작,끝 을 담는다.
            arr[i] = new Flower(start,end);
        }

        // 3.배열 정렬을 재구성시킨다. ( 시작일 낮은순 , 종료일 높은 순 )
        Arrays.sort(arr, new Comparator<>(){
            @Override
            public int compare(Flower o1, Flower o2){
                // start 가 빠른 순

                // start 가 같으면 end가 늦은 순
                if (o1.start == o2.start){
                    return o2.end - o1.end;
                }
                return o1.start - o2.start;
            }
        });

//        // 출력 확인
//        for(Flower x : list){
//            System.out.println(x.start +" "+x.end);
//        }

        int startDay = 301;
        int endDay = 1201;
        int max  = 0;
        int index = 0;
        int count = 0 ;
        boolean check = false;

        // 만일 첫 시작부터 개화 시작일이 301 이후면 "0" 출력
        if(arr[0].start > startDay){
            System.out.println("0");
            return;
        }

        while(startDay<endDay){
            check = false;

            for(int i=index; i<N; i++){

                if(startDay >= arr[i].start) {
                    if (max < arr[i].end) {
                        max = arr[i].end;
                        index += 1;
                        check = true;
                    }
                } else{
                    break;
                }
            }
            if(check){
                startDay = max;
                count ++;
            }
            else {
                System.out.println("0");
                return;
            }
        }

        System.out.println(count);
    }
    static class Flower{
        int start;
        int end;

        Flower(int start,int end){
            this.start = start;
            this.end = end;
        }
    }
}


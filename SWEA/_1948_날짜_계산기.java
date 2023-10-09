package SWEA;

// < 알고리즘 유형 >
// 구현

// < 풀이 접근 >
// 1. 월마다의 일자수를 배열에 담는다.
// 2. 첫번째 날짜는 해당 월의 일자에서 빼서 도출한다. +1 필요 ( 달력을 생각해보면 앞의 일자는 필요없기 때문 )
// 3. 배열을 돌려서, 중간의 일자들을 더한다.
// 4. 마지막 날짜는 해당 날짜를 더한다 ( 달력을 생각해보면 해당일자 까지여서 뒤의 일자는 필요 없기때문 )
// -> 월이 같을때의 예외처리 필요

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class _1948_날짜_계산기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int count = 1;
        // 1. 월마다의 일자수를 배열에 담는다.
        int[] days = {0,31,28,31,30,31,30,31,31,30,31,30,31};

        while(count <=T){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int result = 0;

            int firstM = Integer.parseInt(st.nextToken());
            int firstD = Integer.parseInt(st.nextToken());
            int lastM = Integer.parseInt(st.nextToken());
            int lastD = Integer.parseInt(st.nextToken());

            // 2. 첫번째 날짜는 해당 월의 일자에서 빼서 도출한다. +1 필요 ( 달력을 생각해보면 앞의 일자는 필요없기 때문 )
            result = days[firstM] - firstD +1;

            // 3. 배열을 돌려서, 중간의 일자들을 더한다.
            for(int i=firstM+1; i<=lastM-1; i++){
                result+= days[i];
            }

            // 4. 마지막 날짜는 해당 날짜를 더한다 ( 해당일자 까지 이므로 뒤의 일자는 필요 없기때문 )
            // -> 월이 같을때의 예외처리 필요
            if(firstM != lastM) {
                result += lastD;
            }

            System.out.printf("#%d %d",count, result);
            System.out.println();
            count++;
        }

    }
}

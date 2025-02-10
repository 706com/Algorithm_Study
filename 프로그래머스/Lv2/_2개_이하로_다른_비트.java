package 프로그래머스.Lv2;

//[250210] 🔍

// 규칙에 따르면, 만일 숫자가 짝수면 +1 이 정답(끝이 0이므로)
// 숫자가 홀수면, 마지막부터 "0"을 찾고, 10 으로 변환하면 정답
// -> 0이 없으면 111 -> 1011 로 변환

//<문법>
// Long.toBinaryString(숫자) : Num을 바이너리 숫자로 변경
// 문자열.lastIndexOf("0") : String 형태의 문자에서 해당 마지막 인덱스 찾기
// Long.parseLong(숫자,2) : 숫자를 2진수로 변경
// list.stream().mapToLong(Long::longValue).toArray()  :  list to int

import java.util.*;

public class _2개_이하로_다른_비트 {
    public long[] solution(long[] numbers) {
        List<Long> list = new ArrayList<>();

        for(int i=0; i<numbers.length; i++){
            //짝수면, 주어진 값 +1
            if(numbers[i] % 2 == 0){
                list.add(numbers[i]+1);
            }
            //홀수면, 0찾기
            else{
                String binaryNum = Long.toBinaryString(numbers[i]);
                // System.out.println(binaryNum);
                int lastIndex = binaryNum.lastIndexOf("0");
                // System.out.println(lastIndex);
                // 0이 없으면, 가장 앞 변경
                if(lastIndex == -1){
                    String result = "10" + binaryNum.substring(1,binaryNum.length());
                    // System.out.println(result);
                    list.add(Long.parseLong(result,2));
                }
                // 발견된 위치로부터 10 변경
                // ex) 101 -> 110 , 1001 -> 1010
                else{
                    String result = binaryNum.substring(0,lastIndex)+ "10" + binaryNum.substring(lastIndex+2,binaryNum.length());
                    list.add(Long.parseLong(result,2));
                }
            }
        }
        return list.stream().mapToLong(Long::longValue).toArray();
    }
}

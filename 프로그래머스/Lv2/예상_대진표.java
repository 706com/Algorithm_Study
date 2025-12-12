package 프로그래머스.Lv2;

//[251212] 🔍

import java.util.*;

public class 예상_대진표 {
    public int solution(int n, int a, int b)
    {
        int count = 0;
        while(true){
            if((a==b) || (a==1 && b==1)){
                break;
            }
            a = a/2 + a%2;      //4 -> 2 -> 1 -> 1
            b = b/2 + b%2;      //7 -> 4 -> 2 -> 1
            count++;
        }

        return count;
    }
}

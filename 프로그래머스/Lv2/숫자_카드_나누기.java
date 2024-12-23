package 프로그래머스.Lv2;

//[241223] 🔍

import java.util.*;

public class 숫자_카드_나누기 {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        int getGcdA = 0;
        int getGcdB = 0;

        //유클리드 호제법 사용 (최대공약수 구하기)
        for(int i=0; i<arrayA.length; i++){
            getGcdA = gcd(getGcdA,arrayA[i]);
            getGcdB = gcd(getGcdB,arrayB[i]);
        }

        //배열마다 최대공약수로 나눠보기 (둘 다 나뉘어지면 0)
        if(!divisible(arrayA,getGcdB)){
            answer = Math.max(answer,getGcdB);
        }

        if(!divisible(arrayB,getGcdA)){
            answer = Math.max(answer,getGcdA);
        }
        return answer;
    }
    public int gcd(int a, int b){
        if(a%b==0){
            return b;
        }
        return gcd(b,a%b);
    }
    public boolean divisible(int[] arr, int gcd){
        for(int x : arr){
            if(x % gcd == 0){
                return true;
            }
        }
        return false;
    }
}

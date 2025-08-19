package 프로그래머스.Lv2;
//[프로그래머스] 전화번호 목록 - JAVA(자바)

//소요시간 : 26분 🔍📌
//[250208] 25분 🔍
//[250820] : 🔍

import java.util.*;

public class 전화번호_목록 {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();

        for(String x : phone_book){
            set.add(x);
        }
        for(String x : phone_book){
            for(int i=1; i<x.length(); i++){
                if(set.contains(x.substring(0,i))){
                    return false;
                }
            }
        }
        return true;
    }
}

package 프로그래머스.Lv2;

//소요시간 : 59분
//[240527] : 20분
//[250207] 🔍

import java.util.*;

class 모음사전 {
    static String[] alpha = {"A","E","I","O","U"};
    static String nWord;
    static boolean flag;

    static int result = -1;
    public int solution(String word) {
        nWord = word;
        dfs(0,"");

        return result;
    }
    static void dfs(int depth,String str){
        result++; // 새로운 단어를 생성할 때마다 카운트 증가
        if (str.equals(nWord)) {
            flag = true;
            return;
        }
        if (depth == 5) return;

        for (int i = 0; i < alpha.length; i++) {
            if (flag) return; // 단어를 찾았다면 더 이상 재귀 호출하지 않음
            dfs(depth + 1, str + alpha[i]);
        }
    }
}

/* [240527] */
//    static int N;
//    static String[] arr;
//    static String[] output;
//    static int count = 0;
//    static boolean end = false;
//    public int solution(String word) {
//        int answer = 0;
//        N = 5;
//        int len = word.length();
//        arr = new String[]{"A","E","I","O","U"};
//        output = new String[5];
//
//        dfs(0, 0,len,word);
//        return count -1;
//    }
//
//    public void dfs(int start, int depth, int len,String word){
//        if(end){
//            return;
//        }
//        count++;
//        if(depth == len){
//            String str = "";
//            for(int i=0; i<depth; i++){
//                str += output[i];
//            }
//            // System.out.println(str+" : "+count);
//            if(str.equals(word)){
//                end = true;
//                return;
//            }
//        }
//        if(depth == N){
//            // System.out.println(Arrays.toString(output)+" : "+count);
//            return;
//        }
//
//        for(int i=0; i<N; i++){
//            output[depth] = arr[i];
//            dfs(i,depth+1,len,word);
//            if(end){
//                return;
//            }
//        }
//    }
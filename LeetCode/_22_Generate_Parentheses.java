package LeetCode;

import java.util.*;

public class _22_Generate_Parentheses {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        int right = n;
        int left = n;
        recur(list,"(", n-1, left-1, right);
        return list;
    }
    public void recur(List<String> list, String str, int n, int left, int right){
        // 좌,우 다 사용하면 list 에 담기
        if(left==0 && right==0){
            list.add(str);
            return ;
        }
        // 좌 가 우보다 크면 균형 X
        if(left>right){
            return ;
        }

        if(left>0){
            recur(list,str+"(", n-1, left-1,right);
        }
        if(right>0){
            recur(list,str+")", n-1, left,right-1);
        }
    }
}
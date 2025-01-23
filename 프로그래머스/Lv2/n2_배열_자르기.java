package 프로그래머스.Lv2;

//[250123] 🔍

//100000000 * 100000000 (1차원 배열 접근 X)
// 행 , 열 비교했을 때 max 값 + 1
// 2차원 -> 1차원 접근
//   - row : i / n;
//   - col : i % n;

import java.util.*;

public class n2_배열_자르기 {
    public List<Long> solution(int n, long left, long right) {
        int[] answer = {};
        List<Long> list = new ArrayList<>();

        for(long i=left; i<=right; i++){
            long row = i/n;
            long col = i%n;
            list.add(Math.max(row,col)+1);
        }
        return list;
    }
}

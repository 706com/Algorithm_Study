package 프로그래머스.Lv1;

import java.util.*;

// 소요시간
// [240430] : 7분 -> 형 변환, 오버플로우 주의

public class x만큼_간격이_있는_n개의_숫자 {
    public long[] solution(int x, int n) {
        long[] answer = {};
        List<Long> list = new ArrayList<>();
        list.add((long)x);
        for(int i=2; i<=n; i++){
            Long num = (long)i* (long)x;
            list.add(num);
        }
        // System.out.println(list);
        return list.stream().mapToLong(Long::longValue).toArray();
    }
}

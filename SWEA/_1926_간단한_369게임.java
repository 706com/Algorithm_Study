package SWEA;

// 24분 소요

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class _1926_간단한_369게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Deque<Character> deq = new LinkedList<>();
        for(int i=1; i<=N; i++) {
            String str = String.valueOf(i);
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (c - '0' == 0) {
                    deq.add(c);
                    continue;
                }
                if ((c - '0') % 3 != 0) {
                    deq.add(c);
                } else {
                    deq.add('-');
                }
            }
            //deq 내용 판별
            // -> 369 가 들어가 있을 때
            if (deq.contains('-')) {
                while (!deq.isEmpty()) {
                    if (deq.peekFirst() == '-') {
                        deq.pollFirst();
                        sb.append('-');
                    } else {
                        deq.pollFirst();
                    }
                }
            } else {
                while (!deq.isEmpty()) {
                    sb.append(deq.pollFirst());
                }
            }
            sb.append(' ');
        }
        System.out.println(sb);
    }
}

//깔쌈 정답 코드
//import java.io.BufferedReader;
//        import java.io.IOException;
//        import java.io.InputStreamReader;
//
//public class _test {
//    static int n;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        n = Integer.parseInt(br.readLine());
//        for (int i = 1; i <= n; i++) {
//            String st = String.valueOf(i);
//            StringBuilder sb = new StringBuilder();
//            //System.out.println(sb.toString().isEmpty());
//            for (int j = 0; j < st.length(); j++) {
//                int x = st.charAt(j) - '0';
//                if (x % 3 == 0 && x != 0) {
//                    sb.append("-");
//                }
//            }
//
//            if (!sb.toString().isEmpty()) {
//                System.out.print(sb.toString() + " ");
//            } else {
//                System.out.print(i + " ");
//            }
//        }
//    }
//}
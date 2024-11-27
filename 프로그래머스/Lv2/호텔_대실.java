package 프로그래머스.Lv2;

//[241128] : 39분

import java.util.*;

public class 호텔_대실 {
    public int solution(String[][] book_time) {
        int answer = 0;

        StringTokenizer st;
        Integer[][] books = new Integer[book_time.length][2];
        boolean[] check = new boolean[book_time.length];

        for(int i=0 ; i<book_time.length; i++){
            for(int j=0; j<2; j++){
                st = new StringTokenizer(book_time[i][j], ":");
                int time = Integer.parseInt(st.nextToken())*60 + Integer.parseInt(st.nextToken());
                books[i][j] = time;
            }
        }

        // System.out.println(Arrays.deepToString(books));

        Arrays.sort(books,Collections.reverseOrder((o1,o2) -> o1[1]==o2[1] ? o1[0] - o2[0] : o1[1]-o2[1]));

        // System.out.println(Arrays.deepToString(books));

        boolean allCheck = false;
        while(!allCheck){
            allCheck = true;
            int endTime = Integer.MAX_VALUE;
            for(int i=0; i<books.length; i++){
                if(!check[i] && books[i][1] + 10 <= endTime){
                    endTime = books[i][0];
                    check[i] = true;
                    allCheck = false;
                }
                // System.out.println(endTime);
            }
            answer++;
        }
        return answer-1;
    }
}

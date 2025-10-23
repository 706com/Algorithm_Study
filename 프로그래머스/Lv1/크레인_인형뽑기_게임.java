package 프로그래머스.Lv1;

//소요시간 : 30분 (list안에 queue를 담는 방식 -> q[]배열 형식으로 변경)
//[251023] 17분

import java.util.*;

public class 크레인_인형뽑기_게임 {
    public int solution(int[][] board, int[] moves) {

        // 각 라인을 스택으로 형성
        List<Deque<Integer>> list = new ArrayList<>();
        for (int i = 0; i < board[0].length; i++) {
            list.add(new ArrayDeque<>());
        }

        //값 채우기
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    continue;
                }
                list.get(j).add(board[i][j]);
            }
        }

        // for(Deque x : list){
        //     System.out.println(x);
        // }

        //뽑기
        Deque<Integer> bucket = new ArrayDeque<>();
        int result = 0;
        for (int i = 0; i < moves.length; i++) {
            int pickLine = moves[i] - 1;
            //뽑는 라인이 비어있으면 다음
            if (list.get(pickLine).isEmpty()) {
                continue;
            }

            //인형 쌓기
            int doll = list.get(pickLine).pop();
            if (bucket.isEmpty() || bucket.peek() != doll) {
                bucket.push(doll);
            }
            //같으면 터뜨리기
            else if (bucket.peek() == doll) {
                bucket.pop();
                result += 2;
            }

        }

        return result;
    }

    /**
     * q배열 선언
     */
    public int solution_2(int[][] board, int[] moves) {
        int answer = 0;

        // 1. n*n 의 배열 중 n의 크기만큼 Q배열을 생성한다.
        Queue<Integer>[] qArr = new LinkedList[board.length + 1];
        qArr[0] = new LinkedList<>();

        //0 0 / 1 0 / 2 0 / 3 0 / 4 0 / 5 0
        //0 1 / 1 1 / 2 1 / 3 1 / 4 1 / 5 1
        for (int i = 0; i < board.length; i++) {
            int point = i;
            Queue<Integer> q = new LinkedList<>();
            for (int j = 0; j < board[i].length; j++) {
                if (board[j][point] == 0) {
                    continue;
                }
                q.offer(board[j][point]);
            }
            qArr[i + 1] = q;
        }

        for (Queue<Integer> x : qArr) {
            System.out.println(x);
        }

        // 2. 바구니 역할을 하는 스택을 생성한다.
        Stack<Integer> stk = new Stack<>();
        // 3. moves에 따라서 뽑아서 바구니에 담는다.
        // -> 비어있으면 무시한다.
        // -> 바구니에 담았을 때, 같은 그림이면 터뜨리고 값을 증가시킨다 +2

        for (int i = 0; i < moves.length; i++) {
            if (qArr[moves[i]].isEmpty()) {
                continue;
            }
            int pick = qArr[moves[i]].poll();
            if (stk.isEmpty() || stk.peek() != pick) {
                stk.push(pick);
            } else {
                stk.pop();
                answer += 2;
            }
        }
        return answer;
    }
}
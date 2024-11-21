package 프로그래머스.Lv2;

//[241122] 소요시간 : 1시간

// 실패조건
// O의 갯수가 항상 X와 같거나 +1 이어야한다.
// O가 일렬로 나열됐을 때, X는 -1개 이면서, X는 3개가 일렬로 나열이 되면 안된다.
// X가 일렬로 나열됐을 때, O의 갯수는 X와 동일해야하며, 일렬로 나열되면 안된다.

import java.util.Arrays;

public class 혼자서_하는_틱택토 {
    public int solution(String[] board) {
        int answer = -1;

        char[][] map = new char[3][3];

        int countO = 0;
        int countX = 0;

        for(int i=0; i<3; i++){
            String str = board[i];
            for(int j=0; j<3; j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'O'){
                    countO++;
                }
                else if(map[i][j] == 'X'){
                    countX++;
                }
            }
        }
        System.out.println(Arrays.deepToString(map));

        // 1) O의 갯수가 항상 X와 같거나 +1 이어야한다.
        if(!(countO == countX+1 || countO == countX)){
            return 0;
        }

        // O,X 일렬 판별
        System.out.println(isThree(map,'O'));
        System.out.println(isThree(map,'X'));

        // 2) O가 일렬로 나열됐을 때, X는 -1개 이면서, X는 3개가 일렬로 나열이 되면 안된다.
        if(isThree(map,'O')){
            if(countX + 1 == countO && !isThree(map,'X')){
                return 1;
            } else{
                return 0;
            }
        }
        // 3) X가 일렬로 나열됐을 때, O의 갯수는 X와 동일해야하며, 일렬로 나열되면 안된다.
        if(isThree(map,'X')){
            if(countO == countX && !isThree(map,'O')){
                return 1;
            } else{
                return 0;
            }
        }

        return 1;
    }
    boolean isThree(char[][] map, char key){
        boolean isTrue = true;
        //가로
        for(int i=0; i<3; i++){
            isTrue = true;
            for(int j=0; j<3; j++){
                if(map[i][j] != key){
                    isTrue = false;
                    break;
                }
            }
            if(isTrue){
                return true;
            }
        }

        //세로
        for(int i=0; i<3; i++){
            isTrue = true;
            for(int j=0; j<3; j++){
                if(map[j][i] != key){
                    isTrue = false;
                    break;
                }
            }
            if(isTrue){
                return true;
            }
        }

        //대각선(좌->우)
        for(int i=0; i<3; i++){
            isTrue = true;
            if(map[i][i] != key){
                isTrue = false;
                break;
            }
        }
        if(isTrue){
            return true;
        }

        //대각선(우->좌)
        int j = 2;
        for(int i=0; i<3; i++){
            isTrue = true;
            if(map[i][j] != key){
                isTrue = false;
                break;
            }
            j--;
        }
        if(isTrue){
            return true;
        }

        return false;
    }
}

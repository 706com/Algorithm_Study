package 프로그래머스.Lv2;

//소요시간 : 17분

//12 : 12 1 / 6 2 / 4 3
//9 : 9 1 / 3 3
//48 : 48 1 / 24 2 / 16 3 / 12 4 / 8 6

class 카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        for(int i=3; i<=total; i++){
            if((total) % i == 0 && total/i >= i){
                int row = total / i;
                int col = i;

                if((row-2) * (col-2) == yellow){
                    answer[0] = row;
                    answer[1] = col;
                    break;
                }
            }
        }
        return answer;
    }
}
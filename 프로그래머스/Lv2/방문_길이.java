package 프로그래머스.Lv2;

//소요시간 : 1시간 15분 🔍

//1. 좌표평면을 배열화시킨다.
//2. 움직임에 따른 방문여부를 표시한다.
//3. 방문했다면 값을 증가시키지 않는다.
//4. 좌표평면 범위를 넘어가는 곳이면 넘어간다.
//5. 3,4번을 통과했다면 값을 증가시킨다.

//실패1) 배열 방문여부로 체크했더니 선이 아닌 점으로 접근해서 방문기록이 의미가 없어졌다.
// -> 지나온 "길"을 기록해야하는데 어떻게 하지?
// -> set에 담아보자 (실패) : Integer자체로 담으려 해서 실패
// -> set에 담기 (성공) : String 으로 해결

import java.util.*;

public class 방문_길이 {
    //1. 좌표평면을 배열화시킨다.
    //1-1. 0,0 을 배열로 초기화
    static int[][] arr = new int[11][11];
    static int px = 5;
    static int py = 5;
    static Set<String> set = new HashSet<>();

    public int solution(String dirs) {
        int answer = 0;

        //2. 움직임에 따른 방문여부를 표시한다.
        for(int i=0; i<dirs.length(); i++){
            char command = dirs.charAt(i);
            //3. 좌표평면 범위를 넘어가는 곳이면 넘어간다.
            //4. 방문했다면 값을 증가시키지 않는다.
            int nx = px;
            int ny = py;
            switch (command){
                //위쪽으로 가기
                case 'U':
                    py--;
                    if(!checkRange(command)){
                        break;
                    }
                    if(set.contains(px+" "+ny+"->"+px+" "+py) ||
                            set.contains(px+" "+py+"->"+px+" "+ny)){
                        break;
                    }
                    //5. (3),(4)번을 통과했다면 값을 증가시킨다.
                    set.add(px+" "+ny+"->"+px+" "+py);
                    set.add(px+" "+py+"->"+px+" "+ny);
                    answer++;
                    break;
                //아래쪽으로 가기
                case 'D':
                    py++;
                    if(!checkRange(command)){
                        break;
                    }
                    if(set.contains(px+" "+ny+"->"+px+" "+py)||
                            set.contains(px+" "+py+"->"+px+" "+ny)){
                        break;
                    }
                    set.add(px+" "+ny+"->"+px+" "+py);
                    set.add(px+" "+py+"->"+px+" "+ny);
                    answer++;
                    break;
                //오른쪽으로 가기
                case 'R':
                    px++;
                    if(!checkRange(command)){
                        break;
                    }
                    if(set.contains(nx+" "+py+"->"+px+" "+py)||
                            set.contains(px+" "+py+"->"+nx+" "+py)){
                        break;
                    }
                    set.add(px+" "+py+"->"+nx+" "+py);
                    set.add(nx+" "+py+"->"+px+" "+py);
                    answer++;
                    break;
                //왼쪽으로 가기
                case 'L':
                    px--;
                    if(!checkRange(command)){
                        break;
                    }
                    if(set.contains(nx+" "+ py +"->"+px+" "+py)||
                            set.contains(px+" "+py+"->"+nx+" "+py)){
                        break;
                    }
                    arr[py][px] = 1;
                    set.add(nx+" "+ py +"->"+px+" "+py);
                    set.add(px+" "+ py +"->"+nx+" "+py);
                    answer++;
                    break;
            }
            // System.out.println("px : " + px + ",py : " + py + ", answer : " + answer);

        }

        return answer;
    }
    public boolean checkRange(char c){
        if(c == 'U'){
            if(py < 0){
                //범위 초과-> 원상태
                py++;
                return false;
            }
        } else if(c =='D'){
            if(py >= 11){
                py--;
                return false;
            }
        } else if(c=='L'){
            if(px < 0){
                px++;
                return false;
            }
        } else{
            if(px >= 11){
                px--;
                return false;
            }
        }
        return true;
    }

}

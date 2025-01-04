package BOJ._3_Gold;

//[250104] 3:52 ~

import java.util.*;
import java.io.*;

public class _16939_222_큐브 {
    static int[] cube;
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        cube = new int[25];

        for(int i=1; i<=24; i++){
            cube[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> list = searchFourLayer();
        //마주보는 면 2개가 없으면 불가능
        if(list == null){
            System.out.println("0");
        }
        clockLeft();

//        reverseClockLeft();

//        clockRight();

//        reverseClockRight();

//        clockDown();

//        reverseClockDown();

//        clockUp();

//        reverseClockUp();
    }

    static List<Integer> searchFourLayer(){
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=24; i+=4){
            int color = cube[i];
            int count =0;
            for(int j=0; j<4; j++){
                if(cube[i+j]==color){
                    count++;
                }
            }
            //1개면이 같음
            if(count == 4){
                list.add(i);
            }
        }
        System.out.println(list);
        if(list.size() == 2){
            if(list.get(0) == 1 && list.get(1)==9 ||
                list.get(0) == 5 && list.get(1)==21 ||
                list.get(0) == 13 && list.get(1)==17){

                return list;
            }
        }
        return null;
    }

    // 1 == 5
    // 3 == 7
    // 5 == 9
    // 7 == 11
    // 9 == 22
    // 11 == 24
    // 1 == 24
    // 3 == 21

    static void clockLeft(){
        int[] cloneCube = cube.clone();
        cloneCube[5] = cube[1];
    }
}

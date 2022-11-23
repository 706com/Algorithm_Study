package 백준;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int range = 1;
        int cnt =1;
        while(N>range){

            range = range + (6 * cnt);
            cnt++;
        }
        System.out.println(cnt);




    }
}

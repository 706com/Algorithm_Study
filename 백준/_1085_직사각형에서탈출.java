package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class _1085_직사각형에서탈출{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int x = Integer.parseInt(st.nextToken());   //left x
        int y = Integer.parseInt(st.nextToken());   //low y
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int rightX = w-x;
        int highY = h-y;

        int minX = Math.min(x,rightX);
        int minY = Math.min(y,highY);

        int result = Math.min(minX,minY);

        System.out.println(result);


    }
}



/*
//1085 : 직사각형에서 탈출(맨처음)
//새로 알게된 것 : Math.abs =>절댓값 표현

import java.util.Scanner;
public class Main{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        System.out.println(Rectangle(x,y,w,h));
    }

    public static int Rectangle(int x,int y,int w,int h){

        int resultx = Math.abs(w-x);
        int resulty = Math.abs(h-y);

        int tempx= 0;
        int tempy = 0;


        //x값 판별
        if(x <= resultx)
            tempx = x;
        else
            tempx = resultx;
        //y값 판별
        if(y <= resulty)
            tempy= y;
        else
            tempy= resulty;


        if(tempx<=tempy)
            return tempx;
        else
            return tempy;
    }
}

 */ //1085 : 직사각형에서 탈출
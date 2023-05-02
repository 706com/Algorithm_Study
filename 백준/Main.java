package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int num;

        PriorityQueue<Integer> positiveNum = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> negativeNum = new PriorityQueue<>();
        for(int i=-5; i<0; i++) {
            positiveNum.offer(i);
        }

        for(int i=1; i<5; i++) {
            System.out.println(positiveNum.poll());
        }
    }
}
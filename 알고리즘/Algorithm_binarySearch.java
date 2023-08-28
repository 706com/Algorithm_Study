package 알고리즘;

import java.util.Scanner;

public class Algorithm_binarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("key");

        int key = sc.nextInt();
        boolean check = false ;

        System.out.println("배열 수 , 배열내용");
        int arr[] = new int[sc.nextInt()];
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }

        int low, mid, high;
        low = 0;
        high = arr.length -1;

        while (low <= high){
            mid = (low+high) / 2;

            if(key == arr[mid]){
                check = true;
                break;
            }
            else if(key < arr[mid]){
                high = mid -1;
            }
            else if(key > arr[mid]){
                low = mid + 1;
            }
        }

        if(check){
            System.out.println("1");
        }
        else{
            System.out.println("0");
        }
    }
}

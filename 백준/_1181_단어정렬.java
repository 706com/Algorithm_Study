package 백준;
//1181 : 단어정렬

//<새로 알게된것>
//Arrays.sort(arr,new Comparator<String() {} ) ;  @Override compare :sort 재정의
//CompareTo : 사전순 비교(아스키코드 값을 이용)
//compare : 리턴값 양수,0,음수 일때  양수:뒤집기 , 음수,0 : 그대로
//equals : 문자 비교

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

class _1181_단어정렬{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for(int i=0; i<N; i++){
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2){   //양수 : 뒤집기 , 음수,0 : 그대로
                if(s1.length()==s2.length()){
                    return s1.compareTo(s2);
                }
                else{
                    return s1.length() - s2.length();
                }
            }
        });

        for(int i=0; i<N-1; i++){
            if(arr[i].equals(arr[i+1])){
                continue;
            }
            System.out.println(arr[i]);
        }
        //마지막값 출력
        System.out.println(arr[N-1]);



    }
}

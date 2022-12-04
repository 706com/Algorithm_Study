package 백준;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine()," ");

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int temp = 0;
        boolean check = false;

        Loop :
        for(int i=0; i<N-2; i++){
            for(int j=i+1; j<N-1; j++){
                for(int k=j+1; k<N; k++) {
                    if (arr[i] + arr[j] + arr[k] == M) {
                        System.out.println(M);
                        check = true;
                        break Loop;
                    }
                    else if (temp < arr[i] + arr[j] + arr[k] && arr[i] + arr[j] + arr[k] < M) {
                        temp = arr[i] + arr[j] + arr[k];
                    }
                }
            }
        }
        if(!check) {
            System.out.println(temp);
        }
    }
}


package 백준;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int day = (V-B) / (A-B);
        if((V-B) % (A-B) == 0){
            System.out.println(day);
        }
        else{
            System.out.println(day+1);
        }
    }
}





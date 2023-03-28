import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class src {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        for(int i=0; i<N; i++){
            Stack<Character> stack = new Stack<>();
            String str = br.readLine();
            boolean check = false;

            for(int j=0; j<str.length(); j++) {
                char c = str.charAt(j);

                if(c=='('){
                    stack.push(c);
                    continue;
                }

                else if(c==')'){
                    if(stack.isEmpty()) {
                        System.out.println("NO");
                        check = true;
                        break;
                    }
                    stack.pop();
                }

            }
            if(!check) {
                if (stack.isEmpty()) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}

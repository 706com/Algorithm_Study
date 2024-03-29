package 프로그래머스.Lv1;

class 문자열_내_p와_y의_개수 {
    boolean solution(String s) {
        String str = s.toLowerCase();
        System.out.println(str);

        int cntY = 0;
        int cntP = 0;
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c == 'p'){
                cntP++;
            }
            else if(c == 'y'){
                cntY++;
            }
        }
        if(cntP == cntY){
            return true;
        }
        else{
            return false;
        }
    }
}
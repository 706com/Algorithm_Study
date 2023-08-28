package 알고리즘;//카운팅정렬 알고리즘
//<장점>
//수의 범위가 적을때 사용하면 극강의 효율 달성
//과정 자체가 두 수를 비교하는 과정이 없기 때문에 빠른 배치가 가능하다.

//<단점>
//바로 counting 배열이라는 새로운 배열을 선언해주어야 한다는 점이다.
// 생각보다 이 단점이 꽤 클 수 있는데, array 안에 있는 max값의 범위에 따라 counting 배열의 길이가 달라지게 된다.
// 예로들어 10개의 원소를 정렬하고자 하는데, 수의 범위가 0~1억이라면 메모리가 매우 낭비가 된다.
//즉, Counting Sort가 효율적인 상황에서 쓰려면 수열의 길이보다 수의 범위가 극단적으로 크면 메모리가 엄청 낭비 될 수 있다는 것.
//
// 그렇기 때문에 각기 상황에 맞게 정렬 알고리즘을 써야하는데, 퀵 정렬이나 병합정렬 등이 선호되는 이유도 이에 있다.
//(Quick 정렬의 경우 시간복잡도 평균값이 𝚶(nlogn) 으로 빠른편이면서
// 배열도 하나만 사용하기 때문에 공간복잡도는 𝚶(𝑛) 으로 시간과 메모리 둘 다 효율적이라는 점이다.)

//출처 : https://st-lab.tistory.com/104

public class 알고리즘_카운팅정렬 {
    public static void main(String[] args){

        //array배열 , counting배열 ,result 배열 선언한다.
        //counting배열의 수는 array배열안에 들어있는 수 중 가장 큰 값+1 이 되어야 한다
        int[] array = new int[100];
        int[] counting = new int[31];
        int[] result = new int[100];

        //step1 array배열안에 수 입력
        //array 배열 안에 들어있는 수는 0~30 으로 지정해놓는다.
        for(int i=0; i<array.length; i++){
            array[i] = (int)(Math.random()*31);
        }

        //step2
        //1)array배열의 값이 곧 counting배열의 인덱스이다.
        //2)총 갯수를 파악하기 위해서 counting배열 을 중첩하여 저장한다. (마지막 인덱스의 값이 array배열의 크기와 같으면 성공)
        for(int i=0; i<array.length; i++){
            counting[array[i]]++;
        }
        for(int i=1; i<counting.length; i++){
            counting[i] += counting[i-1];
        }

        //step3
        //array[i]의 값 => counting배열의 인덱스
        //counting배열의 값-1 => 최종 정렬된 배열의 위치인덱스
        for(int i = array.length-1; i >= 0; i--){
            int value = array[i];
            counting[value]--;
            result[counting[value]]= value;
        }


        System.out.println("array[]");

        for(int i=0; i<array.length; i++){
            if(i%10 == 0){
                System.out.println();
            }
            System.out.print(array[i]+"\t");
        }
        System.out.println();
        System.out.println();

        System.out.println("counting[]");

        for(int i=0; i<counting.length; i++){
            if(i%10==0){
                System.out.println();
            }
            System.out.print(counting[i]+"\t");
        }
        System.out.println();
        System.out.println();

        System.out.println("result[]");

        for(int i=0; i<result.length; i++){
            if(i%10==0){
                System.out.println();
            }
            System.out.print(result[i]+"\t");
        }
        System.out.println();
        System.out.println();
    }
}

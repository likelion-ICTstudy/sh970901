import java.util.*;

public class P2748{
    static long[] dp = new long[91];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(solution(sc.nextInt()));
    }
    static long solution(int num) {
        if(num<=1) return dp[num]=num;
        if (dp[num] != 0) {
            return dp[num];
        }
        dp[num]=solution(num-2)+solution(num-1);
        return dp[num];
    }
}

//처음 작성한 코드 메모제이션을 쓰지 않아 시간복잡도 O(2^M) => 같은 함수를 중복 호출함
//DP를 사용하는 경우 1. 최적 부분 구조 : 상위 문제를 하위 문제로 나누어 풀 수 있을 때 2. 중복되는 부분 문제: 동일한 작은 문제를 반복적으로 해결해야 한다.
//DP 구현 방법은 Top-down(하향식): 상위문제를 해결하기 위해 하위문제를 재귀적 호출, Bottom-up(상향식): 하위에서부터 문제를 해결해나가는 방식
//import java.util.*;
//
//class Main{
//    public static int solution(int n){
//        if(n==0){
//            return 0;
//        }
//        else if(n==1){
//            return 1;
//        }
//        else{
//            return  solution(n-1)+solution(n-2);
//        }
//
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//            int num = sc.nextInt();
//            int result = solution(num);
//            System.out.println(result);
//    }
//}
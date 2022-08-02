import java.util.Scanner;

class P20154{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input =sc.nextLine();
        int[] num= {3, 2, 1, 2, 3, 3, 3, 3, 1, 1, 3, 1, 3, 3, 1, 2, 2, 2, 1, 2, 1, 1, 2, 2, 2, 1};
        int result = solution(num, input);
        if(result%2==0){
            System.out.println("You're the winner?");
        }else{
            System.out.println("I'm a winner!");
        }
    }
    static int solution(int[] num, String input){
        int sum=0;
        for(int i=0;i<input.length();i++) {
            //A(65)를 빼면 해당 num 배열의 인덱스번호에 접근할 수 있다.
            sum += num[(input.charAt(i) - 'A')];
        }
        return sum;
    }
}
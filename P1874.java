import java.util.Scanner;
import java.util.Stack;

class P1874{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];   //입력받은 값들을 담음
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        Stack stack = new Stack();

        int i=0;    //입력받은 값 인덱스
        int j=1;    //스택에 넣을 수
        stack.push(j);
        sb.append("+").append("\n");
        while(i<n){
            if((int)stack.peek() < arr[i]){
                stack.push(++j);
                sb.append("+").append("\n");
            }
            else if((int)stack.peek() >= arr[i]){
                stack.pop();
                sb.append("-").append("\n");
                i++;
                if(stack.isEmpty() && (i<n)){
                    stack.push(++j);
                    sb.append("+").append("\n");
                }
            }
        }
        if(stack.isEmpty()){
            System.out.println(sb);
        }else{
            System.out.println("NO");
        }
    }
}

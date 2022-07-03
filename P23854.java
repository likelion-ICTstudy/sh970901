import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class P23854{
    public static void solution(int a, int b){
        if(a % 3 == b % 3){
            System.out.println(a/3 + " "+ a%3 +" "+ b/3);
        }else{
            System.out.println("-1");
        }


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        br.close();
        solution(a,b);

    }
}

import java.util.Scanner;

class P15829{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputLen = sc.nextInt();
        String hashInput = sc.next();
        //입력 값 범위 지정
        if(inputLen<1 || inputLen>50){
            System.exit(0);
        }
        //입력 값과 범위가 같은지 확인
        if(hashInput.length()!=inputLen){
            System.exit(0);
        }
        int[] inputData= stingToIntArr(hashInput);
        int hashValue = (int)intArrToHashValue(inputData);

        System.out.println(hashValue);
    }

    //문자열을 넣으면 각 문자에 맞는 정수값으로 이루어진 배열을 리턴
    private static int[] stingToIntArr(String s){
        int[] arr = new int[s.length()];
        for(int i=0; i<s.length(); i++){
            arr[i] = s.charAt(i)-96;
        }
        return arr;
    }
    //정수로 이루어진 배열을 넣으면 해시함수를 거친 해시값을 리턴
    private static double intArrToHashValue(int[] arr) {
        double result = 0;
        for(int i=0; i<arr.length; i++){
            double pow = Math.pow(31,i);
            double hash = arr[i] * pow;
            result +=hash;
        }
        return result;
    }
}
import java.util.Scanner;

class P11582{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int storeNum = sc.nextInt();                    //치킨집 갯수
        int[] arr = new int[storeNum];
        for(int i=0; i<storeNum; i++){
            arr[i] = sc.nextInt();
        }
        int studentNum = sc.nextInt();                  //현재 정렬을 진행하는 회원 수

        int start_index = 0;
        int end_index = storeNum/studentNum;


        while(true){
            for(int i = start_index; i < end_index-1; i++){
                int k=0;
                for(int j = start_index; j < end_index-1-k; j++){
                    if(arr[j] > arr[j+1]){
                        int temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
                }
                k++;
            }

            start_index += storeNum/studentNum;

            end_index += storeNum/studentNum;

            if(end_index>storeNum){
                break;
            }
        }

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}


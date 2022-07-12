
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Coordinate{
    int x;
    int y;
    int jump;
    Coordinate(int x,int y, int jump){
        this.x = x;
        this.y = y;
        this.jump = jump;
    }
}
class P16173{
    static int matrix[][];
    static boolean visited[][];
    static Queue<Coordinate> que;
    static int gameSize;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        gameSize = sc.nextInt();
        //행렬 크기 초기화 
        matrix = new int[gameSize][gameSize];
        //방문한 곳의 여부를 담는 배열 크기 초기화
        visited = new boolean[gameSize][gameSize];

        que = new LinkedList<Coordinate>();

        //행렬 값 입력 받기
        for(int i=0; i<gameSize; i++){
            for(int j=0; j<gameSize; j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        //초기값 => 시작점
        visited[0][0] = true;
        que.add(new Coordinate(0,0, matrix[0][0]));

        int result = solution();
        if(result==1){
            System.out.println("HaruHaru");
        }
        if(result==0){
            System.out.println("Hing");
        }
    }
    public static int solution(){
        while(!que.isEmpty()){
            Coordinate coord = que.poll();
            //x축 좌표가 점프했을 때 행렬밖을 나가지 않으면서 && 점프할 곳이 방문한 곳이 아니면
            if(coord.x + coord.jump < gameSize && visited[coord.x+coord.jump][coord.y]==false){
                //도착점이면 1리턴
                if(coord.jump == -1){
                    return 1;
                }
                //방문했기때문에 true, 그리고 que에 넣어줌
                visited[coord.x+coord.jump][coord.y]=true;
                que.add(new Coordinate(coord.x+coord.jump, coord.y, matrix[coord.x+ coord.jump][coord.y]));

            }
            //y축 좌표가 점프했을 때 행렬밖을 나가지 않으면서 && 점프할 곳이 방문한 곳이 아니면
            if(coord.y + coord.jump < gameSize && visited[coord.x][coord.y+ coord.jump]==false){
                if(coord.jump == -1){
                    return 1;
                }
                //방문했기때문에 true, 그리고 que에 넣어줌
                visited[coord.x][coord.y+ coord.jump]=true;
                que.add(new Coordinate(coord.x, coord.y+ coord.jump, matrix[coord.x][coord.y+ coord.jump]));
            }
        }
        //큐가 비었는데 1을 리턴하지 못한다면 도달하지 못한다는 뜻
        return 0;

    }
}
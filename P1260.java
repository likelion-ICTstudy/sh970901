import java.util.*;
import java.io.*;

//간선 클래스
class Edge{
    int nodeA;
    int nodeB;
    Edge(int a, int b){
        nodeA = a;
        nodeB = b;
    }
}

class P1260 {
    static int start_node; //시작 노드
    static List<Edge> edges = new ArrayList<>(); //간선들이 담겨있는 리스트
    static Integer[] nodes; //중복(X) 노드들 담겨 있는 배열
    //------DFS-------------------------------------------
    static boolean visited_Dfs[]; //노드들 방문했는지 확인하는 배열DFS
    //각 노드와 방문 여부를 담는 Map DFS
    static Map<Integer,Boolean> visitedOfNodeDfs; //각 노드와 방문 여부
    static Stack stack;
    //-----------------------------------------------------
    //-------------BFS-------------------------------------
    static boolean visited_Bfs[];
    static Map<Integer,Boolean> visitedOfNodeBfs;
    static Queue<Integer> que;
    //-----------------------------------------------------

    public static void main(String[] args) throws IOException {

        stack = new Stack();
        que = new LinkedList<>();
        visitedOfNodeDfs = new HashMap<>();
        visitedOfNodeBfs = new HashMap<>();

        Scanner sc = new Scanner(System.in);
        int sum_node = sc.nextInt(); //정점의 갯수

        visited_Dfs = new boolean[sum_node];
        visited_Bfs = new boolean[sum_node];

        int sum_edge = sc.nextInt(); //간선의 갯수
        start_node = sc.nextInt(); //탐색을 시작할 정점의 번호

        HashSet<Integer> nodes_set = new HashSet<>(); //중복 제거를 위해 Set 활용
        for(int i=0; i<sum_edge; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            edges.add(new Edge(a,b));
            nodes_set.add(a);
            nodes_set.add(b);
        }
        nodes = nodes_set.toArray(new Integer[0]); //중복 제거한 값을 다시 배열에 넣음

        //-------------DFS------------------------------------
        for(int i=0; i<nodes.length; i++){
            visitedOfNodeDfs.put(nodes[i],visited_Dfs[i]);
        }

        stack.push(start_node);
        visitedOfNodeDfs.put(start_node, true);
        //----------------------------------------------------

        //-------------BFS------------------------------------
        for(int i=0; i<nodes.length; i++){
            visitedOfNodeBfs.put(nodes[i],visited_Bfs[i]);
        }
        que.add(start_node);
        visitedOfNodeBfs.put(start_node, true);
        //----------------------------------------------------

        dfs();
        System.out.println("");
        bfs();
    }

    //DFS - 자식 노드 스택에 푸시 => 이 때 Set으로 중복 제거 => List로 내림차순 정렬 후 푸시 왜? 값이 낮은 것 부터 출력되기 때문에
    static public void childNodePush(int node){
        //해당 node와 연결된 노드를 모두 set에 넣음으로 중복 제거 후 리스트로 캐스팅하여 정렬 후 스택에 푸시
        Set<Integer> set = new HashSet<>();
        for(Edge edge : edges){
            if(edge.nodeA == node){
                set.add(edge.nodeB);
            }
            if(edge.nodeB == node){
                set.add(edge.nodeA);
            }
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list, Collections.reverseOrder());
        for(int i=0; i<list.size(); i++){
            stack.push(list.get(i));
        }
    }

    static public void childNodeAddQue(int node){
        //해당 node와 연결된 노드를 모두 set ''''
        Set<Integer> set2 = new HashSet<>();
        for(Edge edge : edges){
            if(edge.nodeA == node){
                set2.add(edge.nodeB);
            }
            if(edge.nodeB == node){
                set2.add(edge.nodeA);
            }
        }
        List<Integer> list = new ArrayList<>(set2);
        Collections.sort(list);
        for(int i=0; i<list.size(); i++){
            que.add(list.get(i));
        }
    }

    public static void dfs(){
        childNodePush(start_node);
        System.out.print(start_node);
        while(!stack.isEmpty()){
            int item = (int) stack.pop();
            if(visitedOfNodeDfs.get(item)==false){
                System.out.print(" " + item);
                visitedOfNodeDfs.put(item, true);
                childNodePush(item);
            }
        }
    }

    public static void bfs(){
        childNodeAddQue(start_node);
        System.out.print(start_node);
        while(!que.isEmpty()){
            int item = que.poll();
            if(visitedOfNodeBfs.get(item)==false){
                System.out.print(" " + item);
                visitedOfNodeBfs.put(item, true);
                childNodeAddQue(item);
            }
        }
    }
}


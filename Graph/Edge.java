public class Edge {

    int src, dest;

    public static void main(String[] args){

        int V=3,E=3;
        Edge graph[]=new Edge[V];
        /* Let us create the following graph
        0
        | \
        |  \
        1---2 */
 
        // add edge 0-1
        graph[0].src = 0;
        graph[0].dest = 1;
 
        // add edge 1-2
        graph[1].src = 1;
        graph[1].dest = 2;
 
        // add edge 0-2
        graph[2].src = 0;
        graph[2].dest = 2;

        UnionFindAlgoToDetectCycleInUndirected detectcycle=new UnionFindAlgoToDetectCycleInUndirected();
        System.out.println(detectcycle.detectCycle(graph, V, E));
    }

}

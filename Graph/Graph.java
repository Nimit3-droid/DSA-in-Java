package Graph;

import java.util.*;
public class Graph {
    public static void main(String args[]){

        int n = 7;
        ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer> >();
		
		for (int i = 0; i < n; i++) 
			adj.add(new ArrayList<Integer>());
			
        // directed
		adj.get(0).add(1);
		adj.get(1).add(2);
		adj.get(1).add(3);
		adj.get(3).add(4);
		adj.get(4).add(0);
        adj.get(4).add(5);
        adj.get(4).add(6);
		adj.get(5).add(2);
		adj.get(5).add(6);
		adj.get(6).add(5);


        // undirected
        // 0 - 1 - 3 - 4    
        // \  /
        //  2
        // adj.get(0).add(1);
		// adj.get(1).add(0);

		// adj.get(0).add(2);
		// adj.get(2).add(0);

		// adj.get(1).add(2);
		// adj.get(2).add(1);

		// adj.get(1).add(3);
		// adj.get(3).add(1);

		// adj.get(3).add(4);
		// adj.get(4).add(3);




        // Tarjans_strongly_connected_components_algorithm scc=new Tarjans_strongly_connected_components_algorithm();
        // scc.dfs(adj, n);

        // edge_cut_algo eca=new edge_cut_algo();
        // eca.dfs(adj,n);

        // ArticulationPointUsingTarjansAlgo Ap=new ArticulationPointUsingTarjansAlgo();
        // Ap.dfs(adj,n);

        // kosaraju_strongly_connected_components_algorithm scck=new kosaraju_strongly_connected_components_algorithm();
        // scck.dfs(adj, n);
    }
}

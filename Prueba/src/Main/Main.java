package Main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    
	
	private static void findPrintMST(ArrayList<Edge> graph[]) {
        int n = graph.length;
        // parent array stores the parent vertex of the current vertex in MST
        int parent[] = new int[n];
        int minEdgeCut[] = new int[n];
        boolean includedMST[] = new boolean[n];
        // Initialise all minEdgeCut values as INFINITE and all vertices as not included in MST
        for (int i = 0; i < n; i++) {
            minEdgeCut[i] = Integer.MAX_VALUE;
            includedMST[i] = false;
        }
        // Initialise minEdgeCut value of first vertex as 0
        minEdgeCut[0] = 0;
        parent[0] = -1;
        // Create a min heap to pick the smallest minEdgeCut value at every step
        // Min heap of vertex and corresponding minEdgeCut value
        PriorityQueue<Element> minHeap = new PriorityQueue<>(new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                return Integer.compare(o1.minEdgeCutValue, o2.minEdgeCutValue);
            }
        });
        for (int i = 0; i < n; i++)
            minHeap.add(new Element(i, minEdgeCut[i]));
        // While all vertices are not included in MST
        while(!minHeap.isEmpty()) {
            // Select the vertex with minimum minEdgeCut value
            int u = minHeap.poll().vertex;
            // Update minEdgeCut value for all adjacent vertices
            for (int j = 0; j < graph[u].size(); j++) {
                Edge curr = graph[u].get(j);
                // If weight of edge u-v is less than the current minEdgeCut value of v
                // update the minEdgeCut value as weight of u-v
                if (minEdgeCut[curr.to] > curr.weight && !includedMST[curr.to]) {
                    minEdgeCut[curr.to] = curr.weight;
                    parent[curr.to] = u;
                }
            }
        }
        // Print MST
        for (int i = 1; i < n; i++) {
            System.out.println("Edge from " + parent[i] + " to " + i + " weight " + minEdgeCut[i]);
        }
    }
    public static void main(String[] args) {
        // Graph
        ArrayList<Edge> graph[] = new ArrayList[10];
        for (int i = 0; i < 10; i++)
            graph[i] = new ArrayList<>();
        // Make the graph in given example
        graph[0].add(new Edge(2, 2));
        graph[0].add(new Edge(1, 1));
        
        graph[1].add(new Edge(0, 1));
        graph[1].add(new Edge(2, 3));
        graph[1].add(new Edge(3, 7));
        graph[1].add(new Edge(5, 8));
        graph[1].add(new Edge(6, 2));
        graph[1].add(new Edge(7, 4));
        
        
        graph[2].add(new Edge(0, 2));
        graph[2].add(new Edge(1, 3));
        graph[2].add(new Edge(3, 10));
        
        graph[3].add(new Edge(2, 10));
        graph[3].add(new Edge(1, 7));
        graph[3].add(new Edge(7, 6));
        graph[3].add(new Edge(8, 7));
        
        graph[4].add(new Edge(6, 4));
        
        graph[5].add(new Edge(1, 8));
        graph[5].add(new Edge(6, 5));
        graph[5].add(new Edge(7, 1));
        
        graph[6].add(new Edge(1, 2));
        graph[6].add(new Edge(4, 4));
        graph[6].add(new Edge(5, 5));
        
        graph[7].add(new Edge(1, 4));
        graph[7].add(new Edge(3, 6));
        graph[7].add(new Edge(5, 1));
        graph[7].add(new Edge(8, 12));
             
        graph[8].add(new Edge(3, 7));
        graph[8].add(new Edge(7, 12));
       

        // Find MST using Prim's Algorithm and print it
        findPrintMST(graph);
    }
    // Class representing an edge in the graph
    static class Edge {
        int to;
        int weight;
        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    // Class representing pair of vertex and its minEdgeCut value
    // Used in minHeap in Prim's Algorithm for MST
    static class Element {
        int vertex;
        int minEdgeCutValue;
        public Element(int vertex, int minEdgeCutValue) {
            this.vertex = vertex;
            this.minEdgeCutValue = minEdgeCutValue;
        }
    }
}
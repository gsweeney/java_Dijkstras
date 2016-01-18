/*
 * Greg Sweeney, U78564659
 * CIS 4930 Artificial Intelligence
 * Assignment 1, Problem 3
 * 
 * 		this program inputs a weighted directed graph, 
 * 		and finds the shortest path between two given vertices of this graph
 */
import java.util.Scanner;

public class Hw1 {

	public static void main(String[] args) {

		// make new Graph from .txt file
		DirectedGraph myGraph = new DirectedGraph("input.txt");
				
		// print info about graph from input file
		System.out.println("\nthere are " + myGraph.edges.size() + " edges and " + myGraph.nodes.size() + " nodes\n");
				
		// get user input for start and end nodes
		Scanner scanner = new Scanner(System.in);
		Input input = new Input();
		
		System.out.print("Starting vertex: ");
		int start_vert = input.getInput(myGraph, scanner);
		
		System.out.print("Ending vertex: ");
		int end_vert = input.getInput(myGraph, scanner);
		scanner.close();
				
		// find the shortest path
		DijkstraAlgorithm alg = new DijkstraAlgorithm(myGraph, start_vert, end_vert);
		
		// print the results
		System.out.println("\nThe shortest path is:");
		alg.printMinPath(myGraph);
		
	}// close main()
}// close class


class Edge{
	int start;
	int end;
	int weight;
	
}// close class


class Node {
	int id;
	int cost;
	int predecessor;
	
	Node(int i){
		id = i;
		cost = 999999; // 'infinity'
	}

}

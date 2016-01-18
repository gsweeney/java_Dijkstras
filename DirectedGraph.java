/*
 * Greg Sweeney, U78564659
 * CIS 4930 Artificial Intelligence
 * Assignment 1, Problem 3
 * 
 * 		this program inputs a weighted directed graph, 
 * 		and finds the shortest path between two given vertices of this graph
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DirectedGraph {
	
	/**INSTANCE VARIABLES**/	
	// store Edges and Nodes from input.txt file 
	ArrayList<Edge> edges = new ArrayList<Edge>();
	ArrayList<Node> nodes = new ArrayList<Node>();
		
	// constructor reads data from input.txt
	DirectedGraph(String file){
					
		// store vertices i.d. (2, 13, 1, etc)
		ArrayList<Integer> vertices = new ArrayList<Integer>();
		
		try{
			// BufferedReader reads lines from file
			BufferedReader br = new BufferedReader(new FileReader(file));
				
			// store each line of text in a String, line
			String line;
			System.out.println("Weighted Directed Graph Is:\n");	
			
			// read lines until there are none
			while ((line = br.readLine()) != null) {
				System.out.println(line);
					
				// Scanner gets integers from a String to store in a new Edge object
				Scanner scanner = new Scanner(line);
					
				Edge edge = new Edge();
					
				while(scanner.hasNextInt()){
					// get the 2 vertices and the weight of its edge
					edge.start = scanner.nextInt();
					edge.end = scanner.nextInt();
					edge.weight = scanner.nextInt();
						
					// add edge to DirectedGraph
					edges.add(edge);
						
					// check if nodes of current edge have been previously found
					if(!(vertices.contains(edge.start))){
						//System.out.println("added node " + edge.start);
						vertices.add(edge.start);
						Node n = new Node(edge.start);
						nodes.add(n);
					}
				
					if(!(vertices.contains(edge.end))){
						//System.out.println("added node " + edge.end);
						vertices.add(edge.end);
						Node n = new Node(edge.end);
						nodes.add(n);
					}
				}// close inner while

			scanner.close();
			}// close outer while
		br.close();
				
		}// close try
		catch(IOException e)
		{
				e.printStackTrace();
		}
	}// close constructor
	
	// get the index of a node from ArrayList nodes
	int getNodeIndex(int id){
		int temp = -1;
		int i = 0;
		for(Node node: nodes){
			if(node.id == id)
				temp =  i;
			i++;
		}
		return temp;
	}
	
	// print the edges in the graph
	void printEdges(int c, int p){
		for(Edge edge: edges){
			if(edge.start == p && edge.end == c){
				System.out.print("Vertex " + edge.start + " to ");
				System.out.print("Vertex " + edge.end + ", (edge weight of " + edge.weight + ")\n");
			}	
		}
	}
	
}//close class
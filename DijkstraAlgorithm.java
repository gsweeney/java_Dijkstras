/*
 * Greg Sweeney, U78564659
 * CIS 4930 Artificial Intelligence
 * Assignment 1, Problem 3
 * 
 * 		this program inputs a weighted directed graph, 
 * 		and finds the shortest path between two given vertices of this graph
 */

import java.util.ArrayList;


public class DijkstraAlgorithm{
	
	boolean goalFound = false;
	int initial_id, goal_id;
	
	// vertices - VISITED
	ArrayList<Node> visited = new ArrayList<Node>();
	// vertices - NOT_VISITED
	ArrayList<Node> not_visited = new ArrayList<Node>();
	
	
	// constructor
	DijkstraAlgorithm(DirectedGraph myGraph, Integer i, Integer g){
		// set instance variables
		initial_id = i;
		goal_id = g;
		setCost(myGraph);
		
		// run dijkstra's algorithm on the graph
		dijkstra(myGraph);
	}
	
	// set cost of initial id to 0
	void setCost(DirectedGraph graph){
	
		for (Node node: graph.nodes) {
			if(node.id == initial_id){
				node.cost = 0;
			}
		}
	}
	
	// check if a node is adjacent to current search node
	boolean adjNotVisited(Edge edge, DirectedGraph graph, Node cur_node){
		boolean adjacent = false;
		
		for (Node node: graph.nodes) {
			if(node.id == edge.end){
				adjacent = true;
				
				// then check the path cost 
				int path_cost = edge.weight + cur_node.cost;
				
				// if it's a minimum path cost...
				if(path_cost < node.cost){
					// update that vertex's minimum path cost in cost[]
					node.cost = path_cost;
							
					// keep track of the predecessor vertex
					node.predecessor = cur_node.id;
				}
			}// close if
		}// close for
		
		return adjacent;
	}// close method
	
	// check if a node is in not_visited
	boolean inNotVisited(int edge_end){
		for(Node node : not_visited){
			if(node.id == edge_end){
				return true;
			}
		}
		return false;
	}
	
	// use dijkstra's algorithm - find shortest path between two vertices 
	void dijkstra(DirectedGraph graph){
	
		for (Node n: graph.nodes) {
			// initialize not_visited nodes
			if(n.id != initial_id){// do not add start node
				not_visited.add(n);
			}
			// initialize visited nodes
			if(n.id == initial_id){// add only the start node	
				visited.add(n);
			}
		}
				
		// for adjacent nodes
		boolean edgeFound;
		
		// while (all vertices not visited)
		while(!(not_visited.isEmpty())){
			
			edgeFound = false;
			
			// for each node in visited, examine all adjacent vertices that are in not_visited 
			for(Node cur_node: visited){
					
				for(Edge edge: graph.edges){
						
					if(edge.start == cur_node.id && inNotVisited(edge.end)){
						
						// check if the cur_node has adjacent unvisited nodes
						edgeFound = adjNotVisited(edge, graph, cur_node);
							
						if(edge.end == goal_id){
							goalFound = true;
						}
					}// close if
				}// close inner for
			}// close outer for
				
			// if no edge was found adjacent to nodes in the visited list, then no solution
			if(!edgeFound)
				break;
				
			// PRIORITY QUEUE STUFF
			// add the lowest cost vertex to the visited list and remove it from non_visited list
			int low_cost_index = 0;
			int low_cost = not_visited.get(0).cost;
			int i = 0 ;
		    for(Node node: not_visited){
		    	//System.out.println("path_cost is " + node.cost);
		    	if(node.cost < low_cost){
		    		low_cost = node.cost;
		    		low_cost_index = i;
		    	}
		    	i++;
		    }
		    
			Node temp = not_visited.remove(low_cost_index);
        	visited.add(temp);

		}// close while

	}// close
			
	// recursive print shortest path...work backwards from the goal
	void printPath(DirectedGraph graph, int cur_index, int pred_index){
		// base case (reached goal node)
		if(graph.nodes.get(pred_index).id == initial_id){
			graph.printEdges(graph.nodes.get(cur_index).id, graph.nodes.get(pred_index).id);// passing node.id 
		}
		// recursive case
		else{
			printPath(graph, pred_index, graph.getNodeIndex(graph.nodes.get(pred_index).predecessor));
			graph.printEdges(graph.nodes.get(cur_index).id, graph.nodes.get(pred_index).id);// passing node.id 
		}
	}
	
		// recursive print shortest path
		void printMinPath(DirectedGraph graph){
			if(goalFound){// print the path
				int goal_index = graph.getNodeIndex(goal_id);
				int pred_index = graph.getNodeIndex(graph.nodes.get(goal_index).predecessor);
				printPath(graph, goal_index, pred_index);
				System.out.println("Total Weight: " + graph.nodes.get(goal_index).cost);
			}
			else{// no solution was found
				System.out.println("No solution");
			}
		}
}// close class




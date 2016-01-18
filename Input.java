/*
 * Greg Sweeney, U78564659
 * CIS 4930 Artificial Intelligence
 * Assignment 1, Problem 3
 * 
 * 		this program inputs a weighted directed graph, 
 * 		and finds the shortest path between two given vertices of this graph
 */
import java.util.Scanner;

public class Input {

	// get input from user
	int getInput(DirectedGraph myGraph, Scanner scanner){
			
		boolean valid = false;
		boolean in_graph = false;
		int num = 0;
			
		while (!valid){
			if(scanner.hasNextInt()){// user entered an int
					
				// get the int that was entered
				num = scanner.nextInt();
					
				// check if the int is a vertex# in the graph
				for(Node node: myGraph.nodes){
					if(node.id == num){
						in_graph = true;
					}
				}
		
				if(in_graph){// accept the user's input
					valid = true;	
				}
				else{// prompt to try again
					System.out.println("    error - vertex not in directed graph");
					System.out.print("    Try Again: ");
				}				
			}else{// user did not enter an int
				System.out.println("    error - invalid input ");
				System.out.print("    Try Again: ");
					scanner.nextLine();
			}// close else
		}// close while		
		return num;
	}// close getInput()
}// close class

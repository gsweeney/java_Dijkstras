
READ ME
-------
this is a program that inputs a weighted directed graph, and finds 
the shortest path between two given vertices of this graph. 
-------

1. compile the .java files using the command:
	javac Hw1.java Input.java DirectedGraph.java DijkstraAlgorithm.java 

2. run the program: 
	java Hw1

3. the program assumes there is only 1 directed graph stored in input.txt. 
   the graph is stored as integer numbers with the format:

	<from vertex> <to vertex> <weight>
	<from vertex> <to vertex> <weight>
	<from vertex> <to vertex> <weight>
	...

4. the input file 'input.txt' must be in the same folder as the .java and .class files.  

5. the program will print the graph that is stored in input.txt

6. the user must enter a starting vertex for the shortest path search.  Validation is included.

7. the user must enter an ending vertex for the shortest path search.  Validation is included.

8. the program will output the shortest path, if a path exists between the start and end nodes. 
   if no path exists, it will output no solution


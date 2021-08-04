### Undirected Graph

Graphs which doesn't have any directed edges are undirected graphs. 

Example - Friends in a social network. If A is friend of B, then B is also friend of A.

![Undirected Graph](images/undirected_graph1.png "Undirected Graph")



#### Adjacency Matrix representation

If there's an edge between two nodes i and j, then array[ i ] [ j ] = 1 else 0

For undirected graphs, this is also symmetric. Bad to represent sparse graphs as most boxes would be filled with zeroes.

![Undirected Graph Adjacency Matrix](images/undirected_graph1_adjacency_matrix.jpg?raw=true "Undirected Graph Adjacency Matrix")

#### Adjacency List representation

![Undirected Graph Adjacency List](images/undirected_graph1_adjacency_list.jpg?raw=true "Undirected Graph Adjacency List")

#### Edge List representation

[[0,1] , [0,6] , [0,8] , [1,0] , [1,4] , [1,6] , [1,9] , [2,4] , [2,6] , [3,4] , [3,5] , [3,8] , [4,1] , [4,2] , [4,3] , [4,5] , [4,9] , [5,3] , [5,4] , [6,0] , [6,1] , [6,2] , [7,8] , [7,9] , [8,0] , [8,3] , [8,7] , [9,1] , [9,4] , [9,7]]


# Graphs
This section is for graphs problems.

## Representation

1- Adjacency List
  - O(V + E)
  - Pros: space 
  - Cons: Check all neighbors O(Nu)

2- Adjacency Matrix
  - O(V^2)  
  - Pros: Efficient check neighbors O(1)
  - Pros: space

2- Edge List
  - O(E)
  - Only used with low memory options with very large number of nodes and few edges.


## BFS

- Usually O(V+E) time and space
- Data Structure -> HashSet to detect cycles in recursion, also we may use Queue
- Works with directed and un-directed graphs

## DFS

- Usually O(V+E) time and space
- Data Structure -> HashSet to detect cycles in recursion, also we may use stack 
- Edge types: tree/back/forward/cross
- Graph is acyclic if no back edges

## Shortest Paths Algorithms

- Types
  - Single-Pair
  - Single-Destination
  - All-Sources

### Dijkstra 

- Can be implemented with arrays or heaps.
- DP - greedy approach
- Shortest path algorithm
- O(E log V)
- Example: Network Delay Time

### Bellman-Ford vs Dijkstra

- Travers from the source to the dest as many iterations as the longest path O(VE)
- Bellman-ford can deal with negative cycles, while in dijkstra it can't.
- Bellman-Ford is used with problems that needs at most K nodes to be used.

### DAG Shortest Paths

- Only with positive edges
- Greedy-Dp Approach
- Greedily picks the node with the smallest distance from the source & relaxes its edges
- Array/Min heaps

### All-Pairs Shortest Paths

- Bellman-ford O(V^2 E) if dense O(v^4)
- Dijkstra O(V^3)
- Floyd-warshall O(V^3) -> DP approach

## Minimum Spanning Tree

- Travelling Sales Man Problem
- Connect all vertices with minimum weights
- How many ways can I do this? |E| C |V| - 1 - num of cycles
- Follow greedy approach
- There exists 2 algorithms to solve these types of problems:
  - Prim: easier in implementation.
    - Used with priority queues and expanding current MST with the 
      minimum safe edge.
    - <b>Start with any node</b>
    - If graph is not connected we apply to all sub graphs
    - Steps: 
      - 1- start with any node and add it to the mst 
      - 2- expand the least safe edge (edge that the dst is not in the mst)
      - 3- add the dst to the mst and add all the edges with it
      - 4- repeat until all nodes are added in the mst
  - Kruskal
    - Used with the implementation of find set
    - edges must be sorted
    - always select min. on a condition that it doesn't make a cycle
    - can work with not connected graphs

## Union-Find

- Usually used with the problems that require to find redundant connections
- Must implement find() & union() functions.
- Use Rank [] Parent [] arrays which is the most efficient way to implement it
  - Rank is initialized with ones, While Parent is initialized with the nodes themselves
- O(N)
- Forest of trees.
- Example: Redundant connections / Find number of connected components.

## Topological Sort

- O(n) Built on top of DFS
- Use HashSet to detect cycles or status[] arr.
- Directed & No cycles 
- Example: Alien Dictionary - Course Schedule
- Steps: 
  - 1- 

## General Notes

- Some graph problems are solved by getting the inverse, for example if you are looking for a specific
  region it may be easier to look for the inverse region and mark it hence all the remaining 
  will be the region that we are interested in (etc. : 130. Surrounded Regions)
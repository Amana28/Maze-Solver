# Maze-Solver
A maze solving program which implements the depth-first search algorithm




https://user-images.githubusercontent.com/76058143/143163305-549abe4e-ab51-4bbf-8311-a49d645df01f.mp4



Depth First Strategy
  - Fix an order on possible neighbors of cells
  e.g., north, east, south, west

When visiting a cell:
  - Mark it as visited
  - Check if it is the goal
  - If not, visit “next” unvisited neighbor
  - If no unvisited neighbors, return to “parent” cell
  
This program together with a maze generation program can be used to quickly generate and solve mazes and can be implemented for a wide variety of uses.  

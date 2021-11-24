# Maze-Solver
A maze solving program which implements the depth-first search algorithm




Depth First Strategy
  fix an order on possible neighbors of cells
  e.g., north, east, south, west

When visiting a cell:
  mark it as visited
  check if it is the goal
  if not, visit “next” unvisited neighbor
  if no unvisited neighbors, return to “parent” cell
  
This program together with a maze generation program can be used to quickly generate and solve mazes and can be implemented for a wide variety of uses.  

import java.util.ArrayList;
import java.util.List;

public class MazeSolverRecursivo implements MazeSolver {

    @Override
    public List<Cell> getPath(boolean[][] grid, Cell start, Cell end) {
        List<Cell> path = new ArrayList<Cell>();
        if(grid == null || grid.length == 0) return path;
        if(findPath(grid,start,end,path)) return path;
        return new ArrayList<>();
    }

    private boolean findPath(boolean[][] grid, Cell start, Cell end, List<Cell> path) {
        //valido si la celda inicio su fila esta denteo de mi grill
        //valido si la celda inicio su row esta denteo de mi grill
        //valido si la celda es transitable == true
        int row= start.fila, col= start.columna;
        
        if(row >= grid.length || col >= grid[0].length || !grid[row][col]) return false;// Celda Transitable
        if(row == end.fila && col == end.columna) {// Que no sea el final
            path.add(start);
            return true;
        }

        if(findPath(grid, new Cell(row+1, col),end, path)){
            path.add(start);
            return true;
        }
        // Nos vamos para abajo
        if(findPath(grid, new Cell(row, col+1),end, path)){
            path.add(start);
            return true;
        }
        return false;
    }
    
    
}

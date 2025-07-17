import java.util.*;

public class MazeSolverRecursivoCompleto implements MazeSolver {

    private static final int[][] DIRECTIONS = {
        { -1,  0}, // arriba
        {  0,  1}, // derecha
        {  1,  0}, // abajo
        {  0, -1}  // izquierda
    };

    @Override
    public List<Cell> getPath(boolean[][] grid, Cell start, Cell end) {
        List<Cell> path = new ArrayList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        if (findPath(grid, start.getFila(), start.getColumna(), end, path, visited)) {
            Collections.reverse(path);
        }
        return path;
    }

    private boolean findPath(boolean[][] grid, int row, int col, Cell end,
                             List<Cell> path, boolean[][] visited) {
        // Validaciones básicas
        if (row < 0 || col < 0 
         || row >= grid.length 
         || col >= grid[0].length 
         || visited[row][col] 
         || !grid[row][col]) {
            return false;
        }
        visited[row][col] = true;
        // Si llegamos al final
        if (row == end.getFila() && col == end.getColumna()) {
            path.add(new Cell(row, col));
            return true;
        }
        // Exploro las 4 direcciones
        for (int[] d : DIRECTIONS) {
            if (findPath(grid, row + d[0], col + d[1], end, path, visited)) {
                path.add(new Cell(row, col));
                return true;
            }
        }
        return false;
    }
}

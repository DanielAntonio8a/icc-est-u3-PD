import java.util.*;

public class MazeSolverBFS implements MazeSolver {

    private static final int[][] DIRECTIONS = {
        { -1,  0}, { 0,  1}, { 1,  0}, { 0, -1}
    };

    @Override
    public List<Cell> getPath(boolean[][] grid, Cell start, Cell end) {
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Map<String, String> prev = new HashMap<>();
        Queue<Cell> queue = new LinkedList<>();
        String startKey = key(start.getFila(), start.getColumna());
        String endKey   = key(end.getFila(),   end.getColumna());

        visited[start.getFila()][start.getColumna()] = true;
        prev.put(startKey, null);
        queue.offer(start);

        while (!queue.isEmpty()) {
            Cell cur = queue.poll();
            String curKey = key(cur.getFila(), cur.getColumna());
            if (curKey.equals(endKey)) break;

            for (int[] d : DIRECTIONS) {
                int nr = cur.getFila() + d[0], nc = cur.getColumna() + d[1];
                String nKey = key(nr, nc);
                if (nr >= 0 && nc >= 0 && nr < rows && nc < cols
                 && grid[nr][nc] && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.offer(new Cell(nr, nc));
                    prev.put(nKey, curKey);
                }
            }
        }

        // Reconstruir ruta
        List<Cell> path = new ArrayList<>();
        String at = endKey;
        while (at != null) {
            String[] p = at.split(",");
            path.add(new Cell(Integer.parseInt(p[0]), Integer.parseInt(p[1])));
            at = prev.get(at);
        }
        Collections.reverse(path);
        return path;
    }

    private String key(int r, int c) { return r + "," + c; }
}

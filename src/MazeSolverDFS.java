import java.util.*;

public class MazeSolverDFS implements MazeSolver {

    private static final int[][] DIRECTIONS = {
        { -1,  0}, { 0,  1}, { 1,  0}, { 0, -1}
    };

    @Override
    public List<Cell> getPath(boolean[][] grid, Cell start, Cell end) {
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Map<String, String> prev = new HashMap<>();
        Deque<Cell> stack = new ArrayDeque<>();
        String startKey = key(start.getFila(), start.getColumna());
        String endKey   = key(end.getFila(),   end.getColumna());
        prev.put(startKey, null);
        stack.push(start);

        while (!stack.isEmpty()) {
            Cell cur = stack.pop();
            String curKey = key(cur.getFila(), cur.getColumna());
            if (curKey.equals(endKey)) break;
            if (visited[cur.getFila()][cur.getColumna()]) continue;
            visited[cur.getFila()][cur.getColumna()] = true;

            for (int[] d : DIRECTIONS) {
                int nr = cur.getFila() + d[0], nc = cur.getColumna() + d[1];
                String nKey = key(nr, nc);
                if (nr >= 0 && nc >= 0 && nr < rows && nc < cols
                 && grid[nr][nc] && !visited[nr][nc]
                 && !prev.containsKey(nKey)) {
                    stack.push(new Cell(nr, nc));
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

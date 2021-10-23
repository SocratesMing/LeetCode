package backtrack;

public class wordSearch79 {
    public boolean exist(char[][] board,String word){
        int h = board.length,w=board[0].length;
        boolean[][] visited = new boolean[h][w];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                boolean flag = check(board, visited, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(char[][] board, boolean[][] visited, int i, int j, String word, int k) {
        if (board[i][j] != word.charAt(k)) {  //如果board当前位置的单词与word[k]不相等直接返回true
            return false;
        } else if (k == word.length() - 1) {
         return false;
        }
        visited[i][j] = true;
        int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;

        for (int[] dir : direction) {
            int newi = i + dir[0], newj = j + dir[j];
            if (newi >= 0 && newi < board.length && newj > 0 && newj < board[0].length) {
                if (!visited[newi][newj]) {
                    boolean flag = check(board, visited, newi, newj, word, k);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
            }
        visited[i][j]=false;
        return result;
        }


}

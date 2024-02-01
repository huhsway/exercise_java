package LeetCode.Matrix;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        char[] wordChars = word.toCharArray();
        int wordLen = wordChars.length;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        return DFS(0, 0, 0, board, wordChars, wordLen, dx, dy);
    }

    private boolean DFS(int L, int x, int y, char[][] board, char[] wordChars, int wordLen, int[] dx, int[] dy) {
        if (L == wordLen) {
            return true;
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < board[0].length && ny < board.length) {
                    if (board[ny][nx] == wordChars[L]) {
                        char temp = board[ny][nx];
                        board[ny][nx] = '\0';

                        if (DFS(L + 1, nx, ny, board, wordChars, wordLen, dx, dy)) return true;
                        board[ny][nx] = temp;
                    }
                }
            }
        }
        return false;
    }
}

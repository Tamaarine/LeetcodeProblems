package _79;

public class WordSearch {
    public static void main(String[] args) {
        char board1[][] = {{'A', 'B', 'C', 'E'},
                            {'S', 'F', 'C', 'S'},
                            {'A', 'D', 'E', 'E'}};
        System.out.println(exist(board1, "ABCCED"));
        
        char board2[][] = {{'A'}};
        System.out.println(exist(board2, "B"));
    }
    
    public static boolean exist(char[][] board, String word) {
        if(word.isEmpty()) return true;
        
        boolean visited[][] = new boolean[board.length][board[0].length];
        
        for(int r=0;r<board.length;r++) {
            for(int c=0;c<board[0].length;c++) {
                // Mark the current cell visitied
                visited[r][c] = true;
                
                int length = 0;
                
                if(board[r][c] == word.charAt(0)) {
                    length = 1;
                }
                
                if(backtrack(length, word, board, visited, r, c)) {
                    return true;
                }
                // if this path doesn't work out then we will unmark this path for the
                // next iteration
                visited[r][c] = false;
            }
        }
        return false;
    }
    
    public static boolean backtrack(int workingLength, String word, char board[][], boolean visited[][], int r, int c)
    {
        if(workingLength == word.length()) {
            return true;
        }
        else if(r < 0 || r >= board.length || c < 0 || c >= board[0].length) {
            return false;
        }
        else {
            boolean left = false;
            boolean right = false;
            boolean top = false;
            boolean bot = false;
            // right
            if(c+1 < board[0].length && board[r][c+1] == word.charAt(workingLength) && !visited[r][c+1]) {
                visited[r][c+1] = true;
                right = backtrack(workingLength + 1, word, board, visited, r, c+1);
                visited[r][c+1] = false;
            }
            // left
            if(c - 1 >= 0 && board[r][c-1] == word.charAt(workingLength) && !visited[r][c-1]) {
                visited[r][c-1] = true;
                left = backtrack(workingLength + 1, word, board, visited, r, c-1);
                visited[r][c-1] = false;
            }
            // up
            if(r - 1 >= 0 && board[r-1][c] == word.charAt(workingLength) && !visited[r-1][c]) {
                visited[r-1][c] = true;
                top = backtrack(workingLength + 1, word, board, visited, r - 1, c);
                visited[r-1][c] = false;
            }
            // down
            if(r + 1 < board.length && board[r+1][c] == word.charAt(workingLength) && !visited[r+1][c]) {
                visited[r+1][c] = true;
                bot = backtrack(workingLength + 1, word, board, visited, r + 1, c);
                visited[r+1][c] = false;
            }
            return left || right || top || bot;
        }
    }
}

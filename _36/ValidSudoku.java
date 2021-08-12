package _36;

public class ValidSudoku {
    public static void main(String[] args) {
        char board[][] = 
            {{'5','3','.','.','7','.','.','.','.'}
            ,{'6','.','.','1','9','5','.','.','.'}
            ,{'.','9','8','.','.','.','.','6','.'}
            ,{'8','.','.','.','6','.','.','.','3'}
            ,{'4','.','.','8','.','3','.','.','1'}
            ,{'7','.','.','.','2','.','.','.','6'}
            ,{'.','6','.','.','.','.','2','8','.'}
            ,{'.','.','.','4','1','9','.','.','5'}
            ,{'.','.','.','.','8','.','.','7','9'}};
            
        System.out.println(isValidSudoku(board));
    }
    
    public static boolean isValidSudoku(char board[][]) {
        for(int r=0;r<board.length;r++) {
            for(int c=0;c<board[0].length;c++) {
                char currentChar = board[r][c];
                System.out.println(currentChar);
                if(currentChar != '.') {
                    if(!validRow(board, r, currentChar) || !validCol(board, c, currentChar) || !validSquare(board, r, c, currentChar)) {
                        return false;
                    }
                }
                
            }   
        }
        return true;
    }
    
    public static boolean validRow(char board[][], int row, char target) {
        // Same row but check all the columns
        int count = 0;
        for(int c=0;c<board[0].length;c++) {
            if(board[row][c] == target) {
                count++;
            }
            if(count == 2) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean validCol(char board[][], int col, char target) {
        // Same col but check all rows
        int count = 0;
        for(int r=0;r<board.length;r++) {
            if(board[r][col] == target) {
                count++;
            }
            if(count == 2) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean validSquare(char board[][], int row, int col, char target) {
        int roundedR = row / 3;
        int roundedC = col / 3;
        
        int count = 0;
        for(int r=roundedR;r<roundedR * 3 +3;r++) {
            for(int c=roundedC;c<roundedC * 3 +3;c++) {
                if(board[r][c] == target) {
                    count++;
                }
                
                if(count == 2) {
                    return false;   
                }
            }
        }
        return true;
    }
}

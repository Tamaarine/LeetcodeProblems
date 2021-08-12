package _73;
import java.util.ArrayList;
import java.util.Arrays;

public class SetMatrixZero {
    public static void main(String[] args) {
        int input1[][] = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        System.out.println(Arrays.deepToString(input1));
        setZeroes2(input1);
        System.out.println(Arrays.deepToString(input1));
    }
    
    public static void setZeroes2(int matrix[][]) {
        boolean firstRowMarked = false;
        boolean firstColMarked = false;
        
        for(int r=0;r<matrix.length;r++) {
            for(int c=0;c<matrix[0].length;c++) {
                if(matrix[r][c] == 0) {
                    if(r == 0) {
                        firstRowMarked = true;
                    }
                    if(c == 0) {
                        firstColMarked = true;
                    }
                    // set the first cell of the row to 0, and first cell of the column to 0
                    // to indicate that the row and column should be all 0 out
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;   
                }
            }
        }
        
        for(int r=1;r<matrix.length;r++) {
            for(int c=1;c<matrix[0].length;c++) {
                if(matrix[r][0] == 0 || matrix[0][c] == 0) {
                    matrix[r][c] = 0;
                }   
            }
        }
        
        if(firstColMarked) {
            for(int r=1;r<matrix.length;r++) {
                matrix[r][0] = 0;
            }
        }
        if(firstRowMarked) {
            for(int c=1;c<matrix[0].length;c++) {
                matrix[0][c] = 0;
            }
        }
    }
    
    public static void setZeroes(int[][] matrix) {
        ArrayList<Integer> rowsNeedEmpty = new ArrayList<>();
        ArrayList<Integer> colsNeedEmpty = new ArrayList<>();
        
        for(int r=0;r<matrix.length;r++) {
            for(int c=0;c<matrix[0].length;c++) {
                if(matrix[r][c] == 0) {
                    rowsNeedEmpty.add(r);
                    colsNeedEmpty.add(c);
                }
            }
        }
        
        for(int i=0;i<rowsNeedEmpty.size();i++) {
            emptyRow(matrix, rowsNeedEmpty.get(i));
            emptyCol(matrix, colsNeedEmpty.get(i));   
        }
        
    }
    
    public static void emptyCol(int matrix[][], int c) {
        int thisR = 0;
        while(thisR < matrix.length) {
            matrix[thisR][c] = 0;
            thisR++;
        }
    }
    
    public static void emptyRow(int matrix[][], int r) {
        int thisC = 0;
        while(thisC < matrix[0].length) {
            matrix[r][thisC] = 0;
            thisC++;
        }
    }
}

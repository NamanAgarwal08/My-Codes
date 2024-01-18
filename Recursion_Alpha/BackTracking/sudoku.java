public class sudoku {

    public static void main(String args[]) {
        int matrix[][]={{6,0,0,3,0,1,0,0,9},{0,0,3,7,4,9,5,0,0},{0,9,0,0,0,0,0,2,0},{0,6,0,0,0,0,0,5,0},{0,0,8,0,3,0,6,0,0},{0,5,0,0,0,0,0,3,0},{0,2,0,0,0,0,0,9,0},{0,0,4,2,9,6,7,0,0},{7,0,0,5,0,3,0,0,4}};
        sudokuSolver(matrix, 0, 0);
    }
    
    public static void sudokuSolver(int matrix[][], int row, int col) {
        if (row >= 9) {
            printSudoku(matrix);
            return;
        }

        int newRow = row ;
        int nextCol = col + 1;
        if (nextCol == 9) {
            newRow = row + 1;
            nextCol = 0;
        }

        if (matrix[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (isSafe(matrix, i, row, col)) {
                    matrix[row][col] = i;
                    sudokuSolver(matrix, newRow, nextCol);
                }
                matrix[row][col] = 0;
            }
            
        }
        else {
            sudokuSolver(matrix, newRow, nextCol);
        }
        
        return;

    }
    
    public static boolean isSafe(int matrix[][], int element, int row, int col) {
        // row
        for (int i = 0; i < 9; i++) {
            if (matrix[row][i] == element) {
                return false;
            }
        }

        // col
        for (int i = 0; i < 9; i++) {
            if (matrix[i][col] == element) {
                return false;
            }
        }

        // 3x3 grid
        int rowIdx = row / 3 * 3;
        int colIdx = col / 3 * 3;
        for (int i = rowIdx; i < rowIdx + 3; i++) {
            for (int j = colIdx; j < colIdx + 3; j++) {
                if (matrix[i][j] == element) {
                    return false;
                }
            }
        }

        return true;

    }
    
    public static void printSudoku(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    
}

public class nQuuens {

    public static void main(String args[]) {

    }
    
    public static void nQueens(int matrix[][], int row) {
        if (row >= 4) {
            printMatrix(matrix);
            return;
        }

        for (int i = 0; i < matrix.length; i++) {
            if (isSafe(matrix, row, i)) {
                matrix[row][i] = 1;
                nQueens(matrix, row + 1);
                matrix[row][i] = 0;
            }
        }
        return;

    }
    



















    public static void printMatrix(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    
}

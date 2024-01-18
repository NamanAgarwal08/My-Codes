public class diagonalSum {
    public static void main(String args[]) {
        int matrix[][] = { { 1, 2, 3}, { 5, 6, 7}, { 9, 10, 11} };
        System.out.println(diagonalSum(matrix)); 
    }

    public static int diagonalSum(int matrix[][]) {
        int sum = 0;

        //Time Complexity = O(n^2)

        // for (int i = 0, j = 0; i < matrix.length && j < matrix.length; i++, j++) {
        //     sum += matrix[i][j];
        // }
        // for (int i = 0, j = matrix.length - 1; i < matrix.length && j >= 0; i++, j--) {
        //     sum += matrix[i][j];
        // }
        // if (matrix.length % 2 == 1) {
        //     return sum - matrix[matrix.length / 2][matrix.length / 2];
        // } else {
        //     return sum;
        // }

        
    // Time Complexity O(n)
        
        for (int i = 0; i < matrix.length; i++) {
            //Primary Diagonal
            sum += matrix[i][i];

            //Secondary Diagonal
            if (i != matrix.length - 1 - i) {
                sum += matrix[i][matrix.length - 1 - i];
            }
        }
        return sum;

    }
}
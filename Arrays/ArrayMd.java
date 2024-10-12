public class ArrayMd {
    public static void main(String[] args) {
        //initialize matrix
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6, 7,9},
            {8, 9}
        };

        
        System.out.println("Length of the main array (matrix): " + matrix.length);

       //print the length of sub array
        for (int i = 0; i < matrix.length; i++) {
            System.out.println("Length of sub-array " + (i+1) + ": " + matrix[i].length);
        }

        //print the matrix in format
        System.out.println("Matrix elements:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();  
        }
    }
}

package org.eddydashcode.parallel_matrix_multiplication;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;


public class ParaMatrixMultiplication extends RecursiveAction {

    private static final int THRESHOLD = 60;

    private final int[][] matrix_A;
    private final int[][] matrix_B;
    private final int[][] matrix_C;
    private final int rowStart;
    private final int rowEnd;
    private final int columnStart;
    private final int columnEnd;

    public ParaMatrixMultiplication(int[][] matrix_A, int[][] matrix_B, int[][] matrix_C,
                                    int rowStart, int rowEnd,
                                    int columnStart, int columnEnd) {
        this.matrix_A = matrix_A;
        this.matrix_B = matrix_B;
        this.matrix_C = matrix_C;
        this.rowStart = rowStart;
        this.rowEnd = rowEnd;
        this.columnStart = columnStart;
        this.columnEnd = columnEnd;
    }

    @Override
    protected void compute() {

        // If the task is small enough, compute directly
        if (rowEnd - rowStart <= THRESHOLD || columnEnd - columnStart <= THRESHOLD) {
            multiplyDirectly();
            return;
        }

        // Otherwise, split the task into smaller subtasks
        int rowMid = (rowStart + rowEnd) / 2;
        int colMid = (columnStart + columnEnd) / 2;

        // Create subtasks for each quadrant
        invokeAll(
                new ParaMatrixMultiplication(matrix_A, matrix_B, matrix_C, rowStart, rowMid, columnStart, colMid),
                new ParaMatrixMultiplication(matrix_A, matrix_B, matrix_C, rowStart, rowMid, colMid, columnEnd),
                new ParaMatrixMultiplication(matrix_A, matrix_B, matrix_C, rowMid, rowEnd, columnStart, colMid),
                new ParaMatrixMultiplication(matrix_A, matrix_B, matrix_C, rowMid, rowEnd, colMid, columnEnd)
        );

    }

    /**
     * Direct multiplication for small tasks
     */
    private void multiplyDirectly() {
        int aColumns = matrix_A[0].length;

        for (int i = rowStart; i < rowEnd; i++) {
            for (int j = columnStart; j < columnEnd; j++) {
                int sum = 0;
                for (int k = 0; k < aColumns; k++) {
                    sum += matrix_A[i][k] * matrix_B[k][j];
                }
                matrix_C[i][j] = sum;
            }
        }
    }

    /**
     * Multiplies matrices A and B in parallel
     */
    public static int[][] multiply(int[][] A, int[][] B) {
        int aRows = A.length;
        int aColumns = A[0].length;
        int bColumns = B[0].length;

        // Check if matrices can be multiplied
        if (aColumns != B.length) {
            throw new IllegalArgumentException("Invalid matrix dimensions for multiplication");
        }

        // Create result matrix
        int[][] C = new int[aRows][bColumns];

        // Use common ForkJoin pool
        ForkJoinPool pool = ForkJoinPool.commonPool();

        // Create and execute the main task
        ParaMatrixMultiplication task = new ParaMatrixMultiplication(A, B, C, 0, aRows, 0, bColumns);
        pool.invoke(task);

        return C;
    }

    public static void main(String[] args) {

        int[][] matrix_A = {
                {1, 2, 3},
                {4, 5, 6},
        };
        int[][] matrix_B = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };

        int[][] matrix_C = multiply(matrix_A, matrix_B);

        System.out.println(Arrays.deepToString(matrix_C));
    }
}

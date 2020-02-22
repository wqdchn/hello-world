package other;

import sun.security.krb5.SCDynamicStoreConfig;

/**
 * @program: hello-world
 * @description: 实现一个稀疏矩阵
 * @author: wqdong
 * @create: 2020-02-22 12:00
 **/
public class q2 {

  public static void main(String[] args) {

    int[][] A = new int[][]{
        {0, 0, 0, 1, 2, 0},
        {3, 0, 0, 0, 0, 0},
        {0, 0, 4, 0, 0, 0},
        {5, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0}
    };

    int[][] B = AtoSparseMatrix(A);

    for (int i = 0; i < B.length; i++) {
      for (int j = 0; j < 3; j++) {
        System.out.print(B[i][j] + " ");
      }
      System.out.println();
    }

    System.out.println();

    int[][] A1 = SparseMatrixtoA(B);

    for (int i = 0; i < A1.length; i++) {
      for (int j = 0; j < A1.length; j++) {
        System.out.print(A1[i][j] + " ");
      }
      System.out.println();
    }

  }

  public static int[][] AtoSparseMatrix(int[][] A) {

    int notZeroCount = 0;

    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < A.length; j++) {
        if (A[i][j] != 0) {
          notZeroCount++;
        }
      }
    }

    int[][] SparseMatrix = new int[notZeroCount + 1][3];

    SparseMatrix[0][0] = A.length;
    SparseMatrix[0][1] = A.length;
    SparseMatrix[0][2] = notZeroCount;

    int row = 1;
    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < A.length; j++) {
        if (A[i][j] != 0) {
          SparseMatrix[row][0] = i;
          SparseMatrix[row][1] = j;
          SparseMatrix[row][2] = A[i][j];
          row++;
        }
      }
    }

    return SparseMatrix;
  }

  public static int[][] SparseMatrixtoA(int[][] SparseMatrix) {
    int A_length = SparseMatrix[0][0];
    int[][] A = new int[A_length][A_length];

    for (int i = 1; i < SparseMatrix.length; i++) {

      int Ai = SparseMatrix[i][0];
      int Aj = SparseMatrix[i][1];
      A[Ai][Aj] = SparseMatrix[i][2];

    }

    return A;
  }

}

package other;

/**
 * @program: hello-world
 * @description: https://www.nowcoder.com/questionTerminal/b0d2c7f3a5b1429ba41997dc935f2594?f=discussion
 *
 * ��ת����
 *
 * ��������:
 *
 * �����������飬������
 *
 * ��һ��Ϊ�ֱ�Ϊ��ʼ���̣�Ϊ4*4��������0��ʾ��ɫ���ӣ�1��ʾ��ɫ����
 *
 * �ڶ���Ϊ��תλ�ã����з�תλ�ù���3��
 *
 * �������:
 *
 * �뷵�ط�ת������̣�Ϊ4*4����
 *
 *
 * ʾ��1
 *
 * ����
 *
 * [[0,0,1,1],[1,0,1,0],[0,1,1,0],[0,0,1,0]] [[2,2],[3,3],[4,4]]
 *
 *
 * ���
 *
 * [[0,1,1,1],[0,0,1,0],[0,1,1,0],[0,0,1,0]]
 * @author: wqdong
 * @create: 2020-04-01 14:02
 **/

import java.util.*;

public class FlipChess {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    while (in.hasNext()) {

      // ����
      String str = in.nextLine().replaceAll("[^0-9]", "");
      int[][] board = new int[4][4];

      int index = 0;
      for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
          board[i][j] = Integer.parseInt(str.substring(index, index + 1));
          index++;
        }
      }

      // ������
      str = in.nextLine().replaceAll("[^0-9]", "");
      int[][] local = new int[3][2];

      index = 0;
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 2; j++) {
          local[i][j] = Integer.parseInt(str.substring(index, index + 1)) - 1;
          index++;
        }
      }

      // ��ת
      board = doReverse(board, local);

      // ���
      StringBuilder sb = new StringBuilder();
      sb.append("[");
      for (int i = 0; i < 4; i++) {
        sb.append("[");
        for (int j = 0; j < 4; j++) {
          if (j == 3) {
            sb.append(board[i][j]);
          } else {
            sb.append(board[i][j] + ",");
          }
        }
        if (i == 3) {
          sb.append("]");
        } else {
          sb.append("],");
        }
      }
      sb.append("]");

      System.out.println(sb.toString());
    }

  }

  private static int[][] doReverse(int[][] board, int[][] local) {

    for (int[] loc : local) {

      int row = loc[0];
      int col = loc[1];

      if (row > 0) {
        board[row - 1][col] = reverse(board[row - 1][col]);
      }

      if (row < 3) {
        board[row + 1][col] = reverse(board[row + 1][col]);
      }

      if (col > 0) {
        board[row][col - 1] = reverse(board[row][col - 1]);
      }

      if (col < 3) {
        board[row][col + 1] = reverse(board[row][col + 1]);
      }

    }

    return board;
  }

  private static int reverse(int color) {
    if (color == 1) {
      return 0;
    } else {
      return 1;
    }
  }

}

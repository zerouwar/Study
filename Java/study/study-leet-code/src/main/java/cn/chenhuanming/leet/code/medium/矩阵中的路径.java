package cn.chenhuanming.leet.code.medium;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 矩阵中的路径 {
    public static void main(String[] args) {
        矩阵中的路径 instance = new 矩阵中的路径();
        boolean result = instance.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCESEEEFS");
        System.out.println(result);
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board, new boolean[board.length][board[0].length], word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, boolean[][] table, String word, int i, int j, int idx) {
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || table[i][j] || word.charAt(idx) != board[i][j]) {
            return false;
        }
        if (idx == word.length() - 1) {
            return true;
        } else {
            table[i][j] = true;
            return exist(board, table, word, i - 1, j, idx + 1)
                    || exist(board, table, word, i + 1, j, idx + 1)
                    || exist(board, table, word, i, j - 1, idx + 1)
                    || exist(board, table, word, i, j + 1, idx + 1);
        }

    }
}

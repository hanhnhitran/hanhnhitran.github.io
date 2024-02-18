/**
 * CPSC 233 W24 Assignment 1 Starter to use to make Board.java
 * @author Jonathan Hudson
 * @email jwhudson@ucalgary.ca
 * @version 1.0
 *
 * name: Nhi Tran
 */


public class Board {

    /**
     * No piece in board (empty)
     */
    public static final int EMP = Game.EMP;
    /**
     * Connect-L Red Piece
     */
    public static final int RED = Game.RED;
    /**
     * Connect-L Blue Piece
     */
    public static final int BLU = Game.BLU;

    //Students should enter their functions below here
    public static int[][] createBoard(int n, int m){
        int[][] a = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                a[i][j] = 0;
            }
        }
        return a;
    }
    public static int rowCount(int[][] board){
        return board.length;
    }
    public static int columnCount(int[][] board){
        return board[0].length;
    }
    public static boolean valid(int[][] board, int x, int y){
        if(x < 0 || x >= rowCount(board) || y < 0 || y >= columnCount(board)) return false;
        return true;
    }
    public static boolean canPlay(int[][] board, int col){
        if(board[0][col] != 0) return false;
        return true;
    }
    public static int play(int[][] board, int column, int piece){
        int rw = rowCount(board);
        for(int i = rw - 1; i >= 0; i--){
            if(board[i][column] == 0){
                board[i][column] = piece;
                //System.out.println(i);
                return i;
            }
        }
        return -1;
    }
    public static int removeLastPlay(int[][] board, int column){
        int rw = rowCount(board);
        for(int i = 0; i < rw; i++){
            if(board[i][column] != 0){
                board[i][column] = 0;
                return i;
            }
        }
        return -1;
    }
    public static boolean full(int[][] board){
        int n = rowCount(board), m = columnCount(board);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 0) return false;
            }
        }
        return true;
    }
    public static boolean winInRow(int board[][], int row, int piece, int length){
        int temp = columnCount(board), temp2 = rowCount(board), streak = 0;
        for(int i = 0; i < temp; i++){
            if(board[row][i] == piece) streak++;
            else streak = 0;
            if(streak >= length){
                if(row > 0 && board[row - 1][i] == piece){
                    return true;
                }
                if(row > 0 && board[row - 1][i - length + 1] == piece){
                    return true;
                }
                if((row + 1) < temp2 && board[row + 1][i] == piece){
                    return true;
                }
                if((row + 1) < temp2 && board[row + 1][i - length + 1] == piece){
                    return true;
                }
            } 
        }
//        streak = 0;
        return false;
    }
    public static boolean winInColumn(int board[][], int column, int piece, int length){
        int temp = rowCount(board), temp2 = columnCount(board), streak = 0;
        for(int i = 0; i < temp; i++){
            if(board[i][column] == piece) streak++;
            else streak = 0;
            if(streak >= length){
                if(column > 0 && board[i][column - 1] == piece){
                    return true;
                }
                if(column > 0 && board[i - length + 1][column - 1] == piece){
                    return true;
                }
                if((column + 1) < temp2 && board[i][column + 1] == piece){
                    return true;
                }
                if((column + 1) < temp2 && board[i - length + 1][column + 1] == piece){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean winInDiagonalBackslash(int board[][], int piece, int length){
        int n = rowCount(board), m = columnCount(board);
        for(int diff = n - 1; diff >= -(m - 1); diff--){
            int streak = 0;
            for(int rw = 0; rw < n; rw++){
                int cl = diff + rw;
                if(cl < 0 || cl >= m) continue;
                if(board[rw][cl] == piece) streak++;
                else streak = 0;
                if(streak >= length){
                    if(valid(board, rw + 1, cl - 1) && board[rw + 1][cl - 1] == piece) return true;
                    if(valid(board, rw - 1, cl + 1) && board[rw - 1][cl + 1] == piece) return true;
                    if(valid(board, rw - streak + 2, cl - streak) && board[rw - streak + 2][cl - streak] == piece) return true;
                    if(valid(board, rw - streak, cl - streak + 2) && board[rw - streak][cl - streak + 2] == piece) return true;
                }
            }
        }
        return false;
    }
    public static boolean winInDiagonalForwardSlash(int board[][], int piece, int length){
        int n = rowCount(board), m = columnCount(board);
        for(int sum = 2; sum <= (n + m); sum++){
            int streak = 0;
            for(int rw = 0; rw < n; rw++){
                int cl = sum - rw;
                if(cl < 0 || cl >= m) continue;
                if(board[rw][cl] == piece) streak++;
                else streak = 0;
                if(streak >= length){
                    if(valid(board, rw - 1, cl - 1) && board[rw - 1][cl - 1] == piece) return true;
                    if(valid(board, rw + 1, cl + 1) && board[rw + 1][cl + 1] == piece) return true;
                    if(valid(board, rw - streak + 2, cl + streak) && board[rw - streak + 2][cl + streak] == piece) return true;
                    if(valid(board, rw - streak, cl + streak + 2) && board[rw - streak][cl + streak + 2] == piece) return true;
                }
            }
        }
        return false;
    }
    public static int[] hint(int board[][], int piece, int length){
        int n = rowCount(board), m = columnCount(board);
        int ans[] = new int[2];
        ans[0] = ans[1] = -1;
        for(int i = 0; i < m; i++){
            int pos = play(board, i, piece);
            board[pos][i] = piece;
            boolean ck = false;
            for(int j = 0; j < n; j++) ck |= winInRow(board, j, piece, length);
            for(int j = 0; j < m; j++) ck |= winInColumn(board, j, piece, length);
            ck |= winInDiagonalBackslash(board, piece, length);
            ck |= winInDiagonalForwardSlash(board, piece, length);
            if(ck == true){
                removeLastPlay(board, i);
                ans[0] = pos;
                ans[1] = i;
                break;
            }
            else{
                removeLastPlay(board, i);
            }
            board[pos][i] = 0;
        }
        return ans;
    }
    //Students should enter their functions above here
    /**
     * Is there a win in given board in any row of board
     *
     * @param board The 2D array board of size rows (dimension 1) and columns (dimension 2)
     * @param piece The piece to look for length in a row for any row
     * @return True if there is length in any row, False otherwise
     */
    private static boolean winInAnyRow(int[][] board, int piece, int length) {
        for (int row = 0; row < board.length; row++) {
            if (winInRow(board, row, piece, length)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Is there a win in given board in any column of board
     *
     * @param board The 2D array board of size rows (dimension 1) and columns (dimension 2)
     * @param piece The piece to look for length in a row for any column
     * @return True if there is length in any column, False otherwise
     */
    private static boolean winInAnyColumn(int[][] board, int piece, int length) {
        for (int col = 0; col < board[0].length; col++) {
            if (winInColumn(board, col, piece, length)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Is there a win in given board in any diagonal of board
     *
     * @param board The 2D array board of size rows (dimension 1) and columns (dimension 2)
     * @param piece The piece to look for length in a row for any diagonal
     * @return True if there is length in any diagonal /\, False otherwise
     */
    private static boolean winInAnyDiagonal(int[][] board, int piece, int length) {
        return winInDiagonalBackslash(board, piece, length) || winInDiagonalForwardSlash(board, piece, length);
    }

    /**
     * Has the given piece won the board
     *
     * @param board The 2D array board of size rows (dimension 1) and columns (dimension 2)
     * @param piece The piece to check for a win
     * @return True if piece has won
     */
    public static boolean won(int[][] board, int piece, int length) {
        return winInAnyRow(board, piece, length) || winInAnyColumn(board, piece, length) || winInAnyDiagonal(board, piece, length);
    }

    /**
     * This function determines if the game is complete due to a win or tie by either player
     *
     * @param board The 2D array board of size rows (dimension 1) and columns (dimension 2)
     * @return True if game is complete, False otherwise
     */
    public static boolean isGameOver(int[][] board, int length) {
        return full(board) || won(board, RED, length) || won(board, BLU, length);
    }
}

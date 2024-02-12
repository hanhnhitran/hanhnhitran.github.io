import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * CPSC 233 W24 Assignment 1 BoardTest Starter File
 * Holds a helper deep copy and example tests of deep copy
 * @author Jonathan Hudson
 * @email jwhudson@ucalgary.ca
 * @version 1.0
 */

/**
 * Nhi Tran, February 11th, Tutorial 04
 *
 */
public class BoardTest {

    /**
     * Used to make a copy of board before functions run, so that verify a function was non-destructive on board is easy
     * @param board The board to make deep copy of
     * @return A deep copy of given board
     */
    public int[][] deepCopy(int[][] board) {
        int[][] copy = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            copy[i] = Arrays.copyOf(board[i], board[i].length);
        }
        return copy;
    }

    // Test for createBoard

    @Test
    public void createBoardtest(){
        int[][] expected = new int[][]{
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP}
        };
        int[][] actual = Board.createBoard(4, 4);
        assertTrue(Arrays.deepEquals(expected, actual));
    }

    @Test
    public void createBoardtest1(){
        int[][] expected = new int[][]{
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP, Board.EMP,Board.EMP}
        };
        int[][] actual = Board.createBoard(5, 4);
        assertTrue(Arrays.deepEquals(expected, actual));
    }

    @Test
    public void createBoardtest2(){
        int[][] expected = new int[][]{
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP}
        };
        int[][] actual = Board.createBoard(7, 4);
        assertTrue(Arrays.deepEquals(expected, actual));
    }


    @Test
    public void createBoardtest3(){
        int[][] expected = new int[][]{
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP,Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP,Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP,Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP,Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP,Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP,Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP,Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP,Board.EMP,Board.EMP,Board.EMP,Board.EMP}
        };
        int[][] actual = Board.createBoard(8, 8);
        assertTrue(Arrays.deepEquals(expected, actual));
    }

    @Test
    public void createBoardtest4(){
        int[][] expected = new int[][]{
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP}
        };
        int[][] actual = Board.createBoard(6, 4);
        assertTrue(Arrays.deepEquals(expected, actual));
    }

    /**
     * Test for rowCount
     **/


    @Test
    public void rowCounttest1(){
        int[][] board = Board.createBoard(6,6);

        assertEquals(6, Board.rowCount(board));
    }

    @Test
    public void rowCounttest2(){
        int[][] board = Board.createBoard(8,8);

        assertEquals(8, Board.rowCount(board));
    }
    @Test
    public void rowCounttest3(){
        int[][] board = Board.createBoard(4,6);

        assertEquals(4, Board.rowCount(board));
    }

    @Test
    public void rowCounttest4(){
        int[][] board = Board.createBoard(5,6);

        assertEquals(5, Board.rowCount(board));
    }

    @Test
    public void rowCounttest5(){
        int[][] board = Board.createBoard(7,6);

        assertEquals(7, Board.rowCount(board));
    }

    /**
     *Test for colCount
     */


    @Test
    public void colCounttest1(){
        int[][] board = Board.createBoard(4, 5);
        assertEquals(5, Board.columnCount(board));
    }

    @Test
    public void colCounttest2(){
        int[][] board = Board.createBoard(4, 6);
        assertEquals(6, Board.columnCount(board));
    }

    @Test
    public void colCounttest3(){
        int[][] board = Board.createBoard(4, 5);
        assertEquals(5, Board.columnCount(board));
    }

    @Test
    public void colCounttest4(){
        int[][] board = Board.createBoard(8, 8);
        assertEquals(8, Board.columnCount(board));
    }

    @Test
    public void colCounttest5(){
        int[][] board = Board.createBoard(8, 5);
        assertEquals(5, Board.columnCount(board));
    }


    /**
     * Test for valid
     **/


    @Test
    public void validtest1(){
        int[][] board = Board.createBoard(6, 7);

        assertTrue(Board.valid(board, 0, 0));
    }

    @Test
    public void validtest2(){
        int[][] board = Board.createBoard(4, 7);

        assertFalse(Board.valid(board,5 , 8));
    }

    @Test
    public void validtest3(){
        int[][] board = Board.createBoard(8, 8);

        assertTrue(Board.valid(board, 4, 5));
    }

    @Test
    public void validtest4(){
        int[][] board = Board.createBoard(4, 7);

        assertFalse(Board.valid(board, 3, 7));
    }

    @Test
    public void validtest5(){
        int[][] board = Board.createBoard(8, 7);

        assertFalse(Board.valid(board, 8, 7));
    }

    /**
     * Test for canPlay
     * */


    @Test
    public void canPlaytest1(){
        int[][] board = Board.createBoard(8, 8);
        assertTrue(Board.canPlay(board, 0));
    }

    @Test
    public void canPlaytest2(){
        int[][] board = Board.createBoard(4, 4);
        for(int i = 0; i < 4; i++){
            Board.play(board, 0, Board.RED);
        }
        assertFalse(Board.canPlay(board, 0));
    }

    @Test
    public void canPlaytest3(){
        int[][] board = Board.createBoard(4, 4);
        for(int i = 0; i < 4; i++){
            Board.play(board, 2, Board.RED);
        }
        assertFalse(Board.canPlay(board, 2));
    }

    @Test
    public void canPlaytest4(){
        int[][] board = Board.createBoard(4, 4);
        for(int i = 0; i < 2; i++){
            Board.play(board, 0, Board.RED);
        }
        assertTrue(Board.canPlay(board, 0));
    }

    @Test
    public void canPlaytest5(){
        int[][] board = Board.createBoard(4, 4);
        for(int i = 0; i < 2; i++){
            Board.play(board, 0, Board.RED);
        }
        Board.play(board, 1, Board.BLU);
        assertTrue(Board.canPlay(board, 0));

    }






    /**
     * Test for play
     * */


    @Test
    public void test1(){
        int[][] board = Board.createBoard(8, 8);
        assertEquals(7, Board.play(board, 0, Board.RED));
    }




    @Test
    public void test2(){
        int[][] board = Board.createBoard(4, 8);
        //Play in column 0 three times
        for (int i = 0; i < 3; i++){
            Board.play(board, 0, Board.RED);
        }
        assertEquals(0, Board.play(board, 0, Board.RED));
    }

    @Test
    public void test3(){
        int[][] board = Board.createBoard(4, 8);

        for (int i = 0; i < 4; i++){
            Board.play(board, 0, Board.RED);
        }

        assertEquals(-1, Board.play(board, 0, Board.RED));
    }

    @Test
    public void test4(){
        int[][] board = Board.createBoard(4, 8);

        for (int i = 0; i < 4; i++){
            Board.play(board, 3, Board.RED);
        }

        assertEquals(-1, Board.play(board, 3, Board.RED));
    }

    @Test
    public void test5(){
        int[][] board = Board.createBoard(4, 8);
        //Play in column 3 two  times
        for (int i = 0; i < 2; i++){
            Board.play(board, 3, Board.RED);
        }
        assertEquals(1, Board.play(board, 3, Board.RED));
    }




    /**
     * Test for removeLastPlay
     * */


    @Test
    public void removeLastPlaytest1(){
        int[][] board = Board.createBoard(5,5);
        Board.play(board, 0, Board.RED);
        assertEquals(4, Board.removeLastPlay(board, 0));
    }

    @Test
    public void removeLastPlaytest2(){
        int[][] board = Board.createBoard( 5, 5);
        for (int i = 0; i < 3; i++){
            Board.play(board, 3, Board.RED);
        }
        assertEquals(2, Board.removeLastPlay(board, 3 ));
    }

    @Test
    public void removeLastPlaytest3(){
        int[][] board = Board.createBoard(6,7);
        assertEquals(-1, Board.removeLastPlay(board, 0));
    }

    @Test
    public void removeLastPlaytest4(){
        int[][] board = Board.createBoard(6, 7);
        for (int i = 0; i < 6; i++){
            Board.play(board, 5, Board.RED);
        }

        assertEquals(0, Board.removeLastPlay(board, 5));
    }

    @Test
    public void removeLastPlaytest5(){
        int[][] board = Board.createBoard(4,4);
        assertEquals(-1, Board.removeLastPlay(board, 3));
    }

    /**
     * Test for full
     * */


    @Test
    public void fulltest1(){
        int[][] board = Board.createBoard(5,5);
        assertFalse(Board.full(board));
    }

    @Test
    public void fulltest2(){
        int[][] board = Board.createBoard(5, 5);
        for(int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                Board.play(board, i, Board.BLU);
            }
        }
        assertTrue(Board.full(board));
    }

    @Test
    public void fulltest3(){
        int[][] board = new int[][]{
                {Board.RED,Board.BLU,Board.EMP,Board.RED},
                {Board.RED,Board.RED,Board.BLU,Board.RED},
                {Board.RED,Board.RED,Board.RED,Board.BLU},
                {Board.BLU,Board.BLU,Board.BLU,Board.RED},
                {Board.BLU,Board.BLU,Board.RED,Board.BLU},
                {Board.BLU,Board.RED,Board.BLU,Board.RED},
                {Board.RED,Board.BLU,Board.BLU,Board.BLU}
        };
        assertFalse(Board.full(board));
    }

    @Test
    public void fulltest4(){
        int[][] board = Board.createBoard(5, 4);
        Board.play(board, 3, Board.BLU);
        assertFalse(Board.full(board));
    }

    @Test
    public void fulltest5(){
        int[][] board = Board.createBoard(4, 4);
        Board.play(board, 3, Board.RED);
        assertFalse(Board.full(board));

    }




    /**
     * Test for winInRow
     */

    @Test
    public void winRowtest1(){
        int[][] board = Board.createBoard(8, 8);
        for (int i = 0; i < 3; i++){
            Board.play(board, i, Board.RED);
        }
        Board.play(board, 2, Board.RED);
        assertTrue(Board.winInRow(board, 7, Board.RED, 3));
    }

    @Test
    public void winRowtest2(){
        int[][] board = Board.createBoard(8, 8);
        for (int i = 0; i < 5; i++){
            Board.play(board, i, Board.RED);
        }
        Board.play(board, 4, Board.RED);
        assertTrue(Board.winInRow(board, 7, Board.RED, 3));

    }
    @Test
    public void winRowtest3(){
        int[][] board = Board.createBoard(8, 8);
        for (int i = 0; i < 3; i++){
            Board.play(board, i, Board.RED);
        }
        Board.play(board, 2, Board.RED);
        assertFalse(Board.winInRow(board, 7, Board.RED, 4));
    }
    @Test
    public void winRowtest4(){
        int[][] board = Board.createBoard(8, 8);
        for (int i = 0; i < 3; i++){
            Board.play(board, i, Board.BLU);
        }
        Board.play(board, 2, Board.RED);
        assertFalse(Board.winInRow(board, 7, Board.RED, 3));

    }
    @Test
    public void winRowtest5(){
        int[][] board = Board.createBoard(8, 8);
        for(int i = 0; i < Board.columnCount(board); i++){
            for(int j = 0; j < Board.rowCount(board) - 1; j++){
                Board.play(board, i, Board.BLU);
            }
        }

        Board.play(board, 0, Board.RED);
        assertFalse(Board.winInRow(board, 7, Board.RED, 3));

    }


    /**
     * Test for winInColumn
     */

    @Test
    public void winColumntest1(){
        int[][] board = Board.createBoard(8, 8);
        for(int i = 0; i < 3; i++){
            Board.play(board, 0, Board.RED);
        }
        Board.play(board, 1, Board.RED);

        assertTrue(Board.winInColumn(board, 0, Board.RED, 3));
    }

    @Test
    public void winColumntest2(){
        int[][] board = Board.createBoard(8, 8);
        for(int i = 0; i < 3; i++){
            Board.play(board, 0, Board.RED);
        }
        Board.play(board, 1, Board.BLU);

        assertFalse(Board.winInColumn(board, 0, Board.RED, 3));

    }

    @Test
    public void winColumntest3(){
        int[][] board = Board.createBoard(8, 8);
        for(int i = 0; i < 3; i++){
            Board.play(board, 0, Board.RED);
        }
        Board.play(board, 1, Board.BLU);
        Board.play(board, 1, Board.RED);

        assertFalse(Board.winInColumn(board, 0, Board.RED, 3));

    }

    @Test
    public void winColumntest4(){
        int[][] board = Board.createBoard(8, 8);
        for(int i = 0; i < 3; i++){
            Board.play(board, 7, Board.RED);
        }
        Board.play(board, 6, Board.RED);

        assertTrue(Board.winInColumn(board, 7, Board.RED, 3));

    }

    @Test
    public void winColumntest5(){
        int[][] board = Board.createBoard(8, 8);
        for(int i = 0; i < 3; i++){
            Board.play(board, 1, Board.RED);
        }
        Board.play(board, 0, Board.BLU);

        assertFalse(Board.winInColumn(board, 1, Board.RED, 3));

    }

    /**
     * Test for winInDiagonalbackslash
     */
    @Test
    public void winDiagonalbackstest1(){
        int[][] board = Board.createBoard(8, 8);

        Board.play(board, 0, Board.BLU);
        for(int i = 0; i < 3; i++){
            Board.play(board, 0, Board.RED);
        }
        Board.play(board, 1, Board.BLU);
        Board.play(board, 1, Board.RED);
        Board.play(board, 1, Board.BLU);

        Board.play(board, 2, Board.RED);
        Board.play(board, 2, Board.BLU);
        Board.play(board, 2, Board.RED);

        Board.play(board, 3, Board.BLU);
        assertTrue(Board.winInDiagonalBackslash(board, Board.BLU, 2));

    }

    @Test
    public void winDiagonalbackstest2(){
        int[][] board = new int[][]{
                {Board.BLU,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.BLU,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.BLU,Board.EMP},
                {Board.EMP,Board.BLU,Board.EMP,Board.BLU},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP}
        };
        assertTrue(Board.winInDiagonalBackslash(board, Board.BLU, 3));



    }
    @Test
    public void winDiagonalbackstest3(){
        int[][] board = new int[][]{
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.RED,Board.EMP},
                {Board.EMP,Board.RED,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.RED,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.RED}
        };
        assertTrue(Board.winInDiagonalBackslash(board, Board.RED, 2));


    }

    @Test
    public void winDiagonalbackstest4(){
        int[][] board = new int[][]{
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.BLU,Board.EMP,Board.EMP},
                {Board.RED,Board.RED,Board.EMP,Board.EMP},
                {Board.RED,Board.RED,Board.EMP,Board.EMP}
        };
        assertFalse(Board.winInDiagonalBackslash(board, Board.RED, 3));

    }

    @Test
    public void winDiagonalbackstest5(){
        int[][] board = new int[][]{
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.BLU,Board.EMP,Board.BLU,Board.EMP},
                {Board.EMP,Board.BLU,Board.EMP,Board.EMP},
                {Board.BLU,Board.EMP,Board.EMP,Board.EMP}
        };

        assertFalse(Board.winInDiagonalBackslash(board, Board.BLU, 2));

    }


    /**
     * Test for winInDiagonalForwardslash
     */

    @Test
    public void winDiagonalForwardstest1(){
        int[][] board = new int[][]{
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.RED,Board.EMP,Board.RED},
                {Board.EMP,Board.EMP,Board.RED,Board.EMP},
                {Board.EMP,Board.RED,Board.EMP,Board.EMP},
                {Board.RED,Board.EMP,Board.EMP,Board.EMP}
        };

        assertTrue(Board.winInDiagonalForwardSlash(board, Board.RED, 2));
    }
    @Test
    public void winDiagonalForwardstest2(){
        int[][] board = new int[][]{
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.RED},
                {Board.EMP,Board.EMP,Board.RED,Board.EMP},
                {Board.EMP,Board.RED,Board.EMP,Board.RED},
                {Board.RED,Board.EMP,Board.EMP,Board.EMP}
        };

        assertTrue(Board.winInDiagonalForwardSlash(board, Board.RED, 2));
    }
    @Test
    public void winDiagonalForwardstest3(){
        int[][] board = new int[][]{
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.RED},
                {Board.EMP,Board.EMP,Board.RED,Board.EMP},
                {Board.EMP,Board.RED,Board.EMP,Board.RED},
                {Board.RED,Board.EMP,Board.EMP,Board.EMP}
        };

        assertFalse(Board.winInDiagonalForwardSlash(board, Board.BLU, 3));
    }

    @Test
    public void winDiagonalForwardstest4(){
        int[][] board = new int[][]{
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.RED,Board.EMP,Board.RED},
                {Board.EMP,Board.EMP,Board.RED,Board.EMP},
                {Board.EMP,Board.RED,Board.EMP,Board.BLU},
                {Board.RED,Board.EMP,Board.EMP,Board.EMP}
        };

        assertTrue(Board.winInDiagonalForwardSlash(board, Board.RED, 2));
    }

    @Test
    public void winDiagonalForwardstest5(){
        int[][] board = new int[][]{
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.RED,Board.EMP,Board.RED},
                {Board.EMP,Board.EMP,Board.RED,Board.EMP},
                {Board.EMP,Board.RED,Board.EMP,Board.BLU},
                {Board.RED,Board.EMP,Board.EMP,Board.EMP}
        };

        assertTrue(Board.winInDiagonalForwardSlash(board, Board.RED, 2));
    }

    /**
     * Test for hint
     */

    @Test
    public void hinttest1(){
        int[][] board = new int[][]{
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.RED,Board.RED,Board.RED,Board.BLU}
        };
        int a = Board.hint(board, Board.RED, 3)[0];
        int b = Board.hint(board, Board.RED, 3)[1];
        assertTrue(a == 5 && b == 0);

    }

    @Test
    public void hinttest2(){
        int[][] board = new int[][]{
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.RED,Board.RED,Board.BLU,Board.BLU}
        };
        int a = Board.hint(board, Board.RED, 3)[0];
        int b = Board.hint(board, Board.RED, 3)[1];
        assertTrue(a == -1 && b == -1);

    }
    @Test
    public void hinttest3(){
        int[][] board = new int[][]{
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.BLU,Board.EMP},
                {Board.RED,Board.BLU,Board.RED,Board.BLU}
        };
        int a = Board.hint(board, Board.RED, 2)[0];
        int b = Board.hint(board, Board.RED, 2)[1];
        assertTrue(a == 5 && b == 1);
    }
    @Test
    public void hinttest4(){
        int[][] board = new int[][]{
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.RED,Board.BLU,Board.RED,Board.EMP}
        };
        int a = Board.hint(board, Board.BLU, 2)[0];
        int b = Board.hint(board, Board.BLU, 2)[1];
        assertTrue(a == -1 && b == -1);

    }
    @Test
    public void hinttest5(){
        int[][] board = new int[][]{
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.RED,Board.EMP},
                {Board.EMP,Board.RED,Board.RED,Board.EMP},
                {Board.RED,Board.BLU,Board.RED,Board.BLU}
        };
        int a = Board.hint(board, Board.RED, 2)[0];
        int b = Board.hint(board, Board.RED, 2)[1];
        assertTrue(a == 5 && b == 0);

    }

    @Test
    public void hinttest6(){
        int[][] board = new int[][]{
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.EMP,Board.EMP},
                {Board.EMP,Board.EMP,Board.BLU,Board.EMP},
                {Board.RED,Board.EMP,Board.RED,Board.BLU}
        };
        int a = Board.hint(board, Board.BLU, 2)[0];
        int b = Board.hint(board, Board.BLU, 2)[1];
        assertTrue(a == 6 && b == 1);
    }




}


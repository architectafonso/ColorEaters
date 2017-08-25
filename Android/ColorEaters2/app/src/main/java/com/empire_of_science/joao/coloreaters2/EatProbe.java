package com.empire_of_science.joao.coloreaters2;

/**
 * Created by João on 31/10/2016.
 *
 */

class EatProbe {

    /**
     * Probes the surroundings of an eater and changes all the cake that this eater eats
     * to eaten cake, using recursion.
     * @param board Board to test.
     * @param eater Eater that is going to eat.
     * @return True if anything was eaten.
     */
    static boolean ProbeAndSetToDelete(Board board, BoardPiece_Eater eater) {
        boolean hasEaten = false;
        if (testUp(eater.boardX, eater.boardY, board, eater)) hasEaten = true;
        if (testDown(eater.boardX, eater.boardY, board, eater)) hasEaten = true;
        if (testLeft(eater.boardX, eater.boardY, board, eater)) hasEaten = true;
        if (testRight(eater.boardX, eater.boardY, board, eater)) hasEaten = true;
        if (eater instanceof BoardPiece_FlyingFatso) board.setPiece(((BoardPiece_FlyingFatso) eater).boardX, ((BoardPiece_FlyingFatso) eater).boardX, null);
        return hasEaten;
    }

    /**
     * Tests above specified cell, if there is an edible of the right color there, eats it,
     * and might test from there in 3 directions.
     * @param x Cell coordinate above which the test will occur.
     * @param y Cell coordinate above which the test will occur.
     * @param board The Board to test.
     * @param eater The eater responsible for eating the cake if cake is found.
     * @return True if cake was eaten.
     */
    private static boolean testUp(int x, int y, Board board, BoardPiece_Eater eater){
        if (y > 0 && board.getPieceAt(x, y-1) instanceof BoardPiece_Edible) {

            BoardPiece_Edible cake = (BoardPiece_Edible)(board.getPieceAt(x, y - 1));

            if (cake.color == eater.color) {
                if (!cake.getEaten(board, eater)) return true;
                testUp(x, y-1, board, eater);
                testLeft(x, y-1, board, eater);
                testRight(x, y-1, board, eater);
                return true;
            }
        }
        return false;
    }

    /**
     * Tests below specified cell, if there is cake of the right color there, it swaps it for
     * eaten cake and tests from there in 3 directions.
     * @param x Cell coordinate below which the test will occur.
     * @param y Cell coordinate below which the test will occur.
     * @param board The Board to test.
     * @param eater The eater responsible for eating the cake if cake is found.
     * @return True if cake was eaten.
     */
    private static boolean testDown(int x, int y, Board board, BoardPiece_Eater eater){
        if (y < 5 && board.getPieceAt(x, y+1) instanceof BoardPiece_Edible) {
            BoardPiece_Edible cake = (BoardPiece_Edible) board.getPieceAt(x, y + 1);

            if (cake.color == eater.color) {
                if (!cake.getEaten(board, eater)) return true;
                testLeft(x, y + 1, board, eater);
                testRight(x, y + 1, board, eater);
                testDown(x, y + 1, board, eater);
                return true;
            }
        }
        return false;
    }

    /**
     * Tests cell to the left of the specified cell, if there is cake of the right color there, it swaps it for
     * eaten cake and tests from there in 3 directions.
     * @param x Cell coordinate to the right to  the one the test will occur.
     * @param y Cell coordinate to the right to  the one the test will occur.
     * @param board The Board to test.
     * @param eater The eater responsible for eating the cake if cake is found.
     * @return True if cake was eaten.
     */
    private static boolean testLeft(int x, int y, Board board, BoardPiece_Eater eater) {
        if (x > 0 && board.getPieceAt(x-1, y) instanceof BoardPiece_Edible) {
            BoardPiece_Edible cake = (BoardPiece_Edible) board.getPieceAt(x - 1, y);

            if (cake.color == eater.color) {
                if (!cake.getEaten(board, eater)) return true;
                testDown(x - 1, y, board, eater);
                testLeft(x - 1, y, board, eater);
                testUp(x - 1, y, board, eater);
                return true;
            }
        }
        return false;
    }

    /**
     * Tests cell to the right of the specified cell, if there is cake of the right color there, it swaps it for
     * eaten cake and tests from there in 3 directions.
     * @param x Cell coordinate to the left to  the one the test will occur.
     * @param y Cell coordinate to the left to  the one the test will occur.
     * @param board The Board to test.
     * @param eater The eater responsible for eating the cake if cake is found.
     * @return True if cake was eaten.
     */
    private static boolean testRight(int x, int y, Board board, BoardPiece_Eater eater){
        if (x < 5 && board.getPieceAt(x+1, y) instanceof BoardPiece_Edible){
            BoardPiece_Edible cake = (BoardPiece_Edible) board.getPieceAt(x + 1, y);

            if(cake.color == eater.color){
                if (!cake.getEaten(board, eater)) return true;
                testRight(x+1, y, board, eater);
                testDown(x+1, y, board, eater);
                testUp(x+1, y, board, eater);
                return true;
            }
        }
        return false;
    }
}

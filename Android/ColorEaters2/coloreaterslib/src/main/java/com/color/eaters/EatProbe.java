package com.color.eaters;

/**
 * Created by João on 31/10/2016.
 *
 */

class EatProbe {
    
    static boolean ProbeAndSetToDelete(Board board, BoardPiece_Eater eater) {
        boolean hasEaten = false;
        if (testUp(eater.boardX, eater.boardY, board, eater)) hasEaten = true;
        if (testDown(eater.boardX, eater.boardY, board, eater)) hasEaten = true;
        if (testLeft(eater.boardX, eater.boardY, board, eater)) hasEaten = true;
        if (testRight(eater.boardX, eater.boardY, board, eater)) hasEaten = true;
        return hasEaten;
    }

    private static boolean testUp(int x, int y, Board board, BoardPiece_Eater eater){
        if (y > 0 && board.getPieceAt(x, y-1) instanceof BoardPiece_Cake) {

            BoardPiece_Cake cake = (BoardPiece_Cake)(board.getPieceAt(x, y - 1));

            if (cake.color == eater.color) {
                board.eatACake(x, y - 1, eater);
                testUp(x, y-1, board, eater);
                testLeft(x, y-1, board, eater);
                testRight(x, y-1, board, eater);
                return true;
            }
        }
        return false;
    }


    private static boolean testDown(int x, int y, Board board, BoardPiece_Eater eater){
        if (y < 5 && board.getPieceAt(x, y+1) instanceof BoardPiece_Cake) {
            BoardPiece_Cake cake = (BoardPiece_Cake) board.getPieceAt(x, y + 1);

            if (cake.color == eater.color) {
                board.eatACake(x, y + 1, eater);
                testLeft(x, y + 1, board, eater);
                testRight(x, y + 1, board, eater);
                testDown(x, y + 1, board, eater);
                return true;
            }
        }
        return false;
    }


    private static boolean testLeft(int x, int y, Board board, BoardPiece_Eater eater) {
        if (x > 0 && board.getPieceAt(x-1, y) instanceof BoardPiece_Cake) {
            BoardPiece_Cake cake = (BoardPiece_Cake) board.getPieceAt(x - 1, y);

            if (cake.color == eater.color) {
                board.eatACake(x - 1, y, eater);
                testDown(x - 1, y, board, eater);
                testLeft(x - 1, y, board, eater);
                testUp(x - 1, y, board, eater);
                return true;
            }
        }
        return false;
    }


    private static boolean testRight(int x, int y, Board board, BoardPiece_Eater eater){
        if (x < 5 && board.getPieceAt(x+1, y) instanceof BoardPiece_Cake){
            BoardPiece_Cake cake = (BoardPiece_Cake)board.getPieceAt(x + 1, y);

            if(cake.color == eater.color){
                board.eatACake(x + 1, y, eater);
                testRight(x+1, y, board, eater);
                testDown(x+1, y, board, eater);
                testUp(x+1, y, board, eater);
                return true;
            }
        }
        return false;
    }
}

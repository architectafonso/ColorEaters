package com.empire_of_science.joao.coloreaters2;

import java.util.List;

/**
 * Created by João on 31/10/2016.
 *
 */

class EatProbe {
    
    static boolean ProbeAndSetToDelete(Board board, Eater eater) {
        boolean hasEaten = false;
        if (testUp(eater.boardX, eater.boardY, board, eater)) hasEaten = true;
        if (testDown(eater.boardX, eater.boardY, board, eater)) hasEaten = true;
        if (testLeft(eater.boardX, eater.boardY, board, eater)) hasEaten = true;
        if (testRight(eater.boardX, eater.boardY, board, eater)) hasEaten = true;
        return hasEaten;
    }

    private static boolean testUp(int x, int y, Board board, Eater eater){
        if (y > 0 && board.pieces[x][y-1] instanceof Cake &&
                ((Cake)board.pieces[x][y-1]).color == eater.color && !(board.pieces[x][y-1].toDelete)) {
            board.pieces[x][y-1].toDelete = true;
            ((Cake)board.pieces[x][y-1]).eater = eater;
            testUp(x, y-1, board, eater);
            testLeft(x, y-1, board, eater);
            testRight(x, y-1, board, eater);
            return true;
        }
        return false;
    }
    private static boolean testDown(int x, int y, Board board, Eater eater){
        if (y < 5 && board.pieces[x][y+1] instanceof Cake &&
                ((Cake)board.pieces[x][y+1]).color == eater.color && !(board.pieces[x][y+1].toDelete)) {
            board.pieces[x][y + 1].toDelete = true;
            ((Cake)board.pieces[x][y + 1]).eater = eater;
            testLeft(x, y+1, board, eater);
            testRight(x, y+1, board, eater);
            testDown(x, y+1, board, eater);
            return true;
        }
        return false;
    }
    private static boolean testLeft(int x, int y, Board board, Eater eater) {
        if (x > 0 && board.pieces[x-1][y] instanceof Cake &&
                ((Cake)board.pieces[x-1][y]).color == eater.color && !(board.pieces[x-1][y].toDelete)) {
            board.pieces[x-1][y].toDelete = true;
            ((Cake)board.pieces[x - 1][y]).eater = eater;
            testDown(x-1, y, board, eater);
            testLeft(x-1, y, board, eater);
            testUp(x-1, y, board, eater);
            return true;
        }
        return false;
    }
    private static boolean testRight(int x, int y, Board board, Eater eater){
        if (x < 5 && board.pieces[x+1][y] instanceof Cake &&
                ((Cake)board.pieces[x+1][y]).color == eater.color && !(board.pieces[x+1][y].toDelete)) {
            board.pieces[x+1][y].toDelete = true;
            ((Cake)board.pieces[x + 1][y]).eater = eater;
            testRight(x+1, y, board, eater);
            testDown(x+1, y, board, eater);
            testUp(x+1, y, board, eater);
            return true;
        }
        return false;
    }
}

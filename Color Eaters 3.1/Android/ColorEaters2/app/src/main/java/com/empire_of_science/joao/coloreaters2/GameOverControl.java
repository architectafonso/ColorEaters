package com.empire_of_science.joao.coloreaters2;

/**
 * Created by João on 01/11/2016.
 */

class GameOverControl {
    /**
     * Sets the state of the provided Board to Win if there is no cake, to Lose if there is cake
     * and no more moves, and Continue in any other case.
     * @param board The Board to test for game over.
     */
    static void setGameOverState(Board board) {
        boolean zeroFood = true;
        for(BoardPiece[] array : board.pieces) for(BoardPiece piece : array){
            if(piece instanceof Cake) zeroFood = false;
        }

        if(zeroFood){
            board.state = GameOverState.Win;
        }
        else if(board.movesLeft < 1){
            board.state = GameOverState.Lose;
        }
        else
        {
            board.state = GameOverState.Continue;
        }
    }
}

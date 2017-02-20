package com.empire_of_science.joao.coloreaters2;

import android.os.Bundle;


/**
 * Created by João on 29/09/2016.
 *
 * If new features are added, like a new piece type, the data that goes in the bundle can be changed
 * only from here.
 */
class RotationController {

    /**
     * Loads the state of teh game to a GameView.
     * Change this method together with save.
     * @param savedInstanceState The bundle with the game state.
     * @param gameView The GameView that will load the state of the game.
     */
    static void load(Bundle savedInstanceState, GameView gameView){
        // If it is getting an ongoing game, sets the pieces from the arrays with their data
        // on the bundle, and also the level, level package and number of moves left.
        char[] typeArray = savedInstanceState.getCharArray("typeArray");
        int[] xArray = savedInstanceState.getIntArray("xArray");
        int[] yArray = savedInstanceState.getIntArray("yArray");
        int[] colorArray = savedInstanceState.getIntArray("colorArray");
        boolean[] isEaterArray = savedInstanceState.getBooleanArray("isEaterArray");

        gameView.board.movesLeft = savedInstanceState.getInt("movesLeft");

        int numberOfPieces = xArray.length;
        for(int index = 0; index < numberOfPieces; index++) {
            if (typeArray[index] == 'C')
                gameView.board.pieces[xArray[index]][yArray[index]] =
                        new Cake(xArray[index], yArray[index], colorArray[index]);
            else if (typeArray[index] == 'E')
                gameView.board.pieces[xArray[index]][yArray[index]] =
                        new Eater(xArray[index], yArray[index], colorArray[index]);
            else if (typeArray[index] == 'B')
                gameView.board.pieces[xArray[index]][yArray[index]] =
                        new BlockBoardPiece(xArray[index], yArray[index]);
        }
        gameView.invalidate();
    }


    /**
     * Step in the process of saving info to bundle, ensures that the end of eating and that
     * the player has won or lost if that is teh case.
     * @param gameView The GameView currently being played.
     */
    private static void ensureAppropriateState(GameView gameView){
        if (gameView.board.state == GameOverState.Continue) {
            // When rotation happens, the state of the game might not be correctly defined.
            // To ensure appropriate state eats now any piece that requires it.
            gameView.board.eat();
            gameView.board.deletePiecesToDelete();
            // Ensure it wins or loses if that is the case.
            GameOverControl.setGameOverState(gameView.board);
            if (gameView.board.state == GameOverState.Win) gameView.activity.win();
            if (gameView.board.state == GameOverState.Lose) gameView.activity.lose();
        }
    }

    /**
     * Sets the game information into a bundle.
     * Change this method together with load.
     * @param outState Bundle to save to.
     * @param gameView GameView that has the info being saved.
     */
    static void save(Bundle outState, GameView gameView){

        // Ensures the game is ready to be saved.
        ensureAppropriateState(gameView);

        // Counts the number of pieces and creates the arrays carrying their info.
        int count = 0;
        for (int x = 0; x < 6; x++) for (int y = 0; y < 6; y++){
            if (gameView.board.pieces[x][y] != null) count ++;
        }
        char[] typeArray = new char[count];
        int[] xArray = new int[count];
        int[] yArray = new int[count];
        int[] colorArray = new int[count];
        boolean[] isEaterArray = new boolean[count];

        // Puts the information on the arrays.
        count = 0;
        for(BoardPiece[] array : gameView.board.pieces) for (BoardPiece piece : array) if (piece != null)   {
            xArray[count] = piece.boardX;
            yArray[count] = piece.boardY;
            if (piece instanceof Cake) {
                typeArray[count] = 'C';
                colorArray[count] = ((Cake) piece). color;
            } else if (piece instanceof Eater) {
                typeArray[count] = 'E';
                colorArray[count] = ((Eater) piece). color;
            } else if (piece instanceof BlockBoardPiece) {
                typeArray[count] = 'B';
                colorArray[count] = 0;
            }
            count++;
        }

        // Puts pieces data on the bundle.
        outState.putCharArray("typeArray", typeArray);
        outState.putIntArray("xArray", xArray);
        outState.putIntArray("yArray", yArray);
        outState.putIntArray("colorArray", colorArray);
    }

}

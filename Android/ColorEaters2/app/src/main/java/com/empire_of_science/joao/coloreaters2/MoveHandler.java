package com.empire_of_science.joao.coloreaters2;

/**
 * Created by João on 22/02/2017.
 *
 */
class MoveHandler {
    static void doTheMove(int toX, int toY, Board board, BoardPiece pieceBeingMoved,
                          TouchHandler touchHandler, GameView gameView, GameSystem gameSystem) {
        BoardPiece p =  board.movePiece_ReturnPieceAtDestinyOrNull(
                pieceBeingMoved.boardX, pieceBeingMoved.boardY, toX, toY);
        boolean haveEaten = board.eat();
        board.movesLeft--;
        board.setGameOverState();
        gameView.activity.changeMoves(board.movesLeft);

        if (p == null) {
            animateMove(toX, toY, pieceBeingMoved);
            board.movePiecesToPlace();
            touchHandler.hasPiece = false;
        }
        else{
            animateSwap(toX, toY, p, pieceBeingMoved);
            board.movePiecesToPlace();
            touchHandler.hasPiece = false;
        }
        if (haveEaten){
            animateEating(board);
            gameView.sounds.playEatSound();
        } else {
            gameView.sounds.playMoveSound();
        }
        board.removeDeadPieces();
        board.movePiecesToPlace();
        gameSystem.endIfNecessary();
    }

    private static void animateEating(Board board){
        for (BoardPiece piece : board){
            if (piece instanceof BoardPiece_EatenCake){
                BoardPiece_EatenCake cake = (BoardPiece_EatenCake)piece;
                cake.deltaX = (cake.eater.graphicsX - cake.graphicsX) / 10;
                cake.deltaY = (cake.eater.graphicsY - cake.graphicsY) / 10;
            }
        }
        for (int index = 0; index < 10; index ++){
            for (BoardPiece piece : board) {
                if (piece instanceof BoardPiece_EatenCake) {
                    BoardPiece_EatenCake cake = (BoardPiece_EatenCake) piece;
                    cake.graphicsX += cake.deltaX;
                    cake.graphicsY += cake.deltaY;
                }
            }
            try{
                Thread.sleep(40);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    private static void animateMove(int toX, int toY, BoardPiece pieceBeingMoved){
        int destinyX = (toX * 1000) / 6;
        int destinyY = (toY * 1000) / 6;
        int deltaX = (destinyX - pieceBeingMoved.graphicsX) / 10;
        int deltaY = (destinyY - pieceBeingMoved.graphicsY) / 10;
        for (int index = 0; index < 10; index ++){
            pieceBeingMoved.graphicsX += deltaX;
            pieceBeingMoved.graphicsY += deltaY;
            try{
                Thread.sleep(40);
            }catch(InterruptedException e ){
                e.printStackTrace();
            }
        }
    }


    private static void animateSwap(int toX, int toY, BoardPiece swapPiece, BoardPiece pieceBeingMoved){


        // Setting the piece being moved so that it goes to the right place.
        // This piece should already be moved in Board to destiny location (toX,toY).
        int graphicsDestinyX = (toX * 1000) / 6;
        int graphicsDestinyY = (toY * 1000) / 6;
        int deltaX = (pieceBeingMoved.graphicsX - graphicsDestinyX) / 10;
        int deltaY = (pieceBeingMoved.graphicsY - graphicsDestinyY) / 10;

        // Setting the piece that will swap so that it goes to the right place.
        // This piece should already be moved to the original location of the piece being moved.
        // It can therefor be obtained as being in
        int swapGraphicsDestinyX = (swapPiece.boardX * 1000) / 6;
        int swapGraphicsDestinyY = (swapPiece.boardY * 1000) / 6;

        int swapDeltaX = (swapPiece.graphicsX - swapGraphicsDestinyX) / 10;
        int swapDeltaY = (swapPiece.graphicsY - swapGraphicsDestinyY) / 10;
        for(int index = 0; index < 10; index ++){
            swapPiece.graphicsX -= swapDeltaX;
            swapPiece.graphicsY -= swapDeltaY;
            pieceBeingMoved.graphicsX -= deltaX;
            pieceBeingMoved.graphicsY -= deltaY;
            try{
                Thread.sleep(40);
            }catch( InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

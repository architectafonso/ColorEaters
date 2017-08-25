package com.empire_of_science.joao.coloreaters2;

/**
 * Created by João on 31/07/2017.
 * Represents cake that has to be unfrozen before it can be eaten, it is unfrozen by being
 * in the situation normal cake would be eaten. That actually transforms this into normal cake,
 * but only once the eating is complete.
 * Also, cannot be moved.
 *
 */

public class BoardPiece_FrozenCake extends BoardPiece_Edible {

    public boolean unfreezing = false;

    public BoardPiece_FrozenCake(int x, int y, Colors color) {
        super(x, y, color);
        this.readyToEat = false;
    }

    @Override
    public boolean getEaten(Board board, BoardPiece_Eater eater) {
        unfreezing = true;
        return false;
    }

    @Override
    boolean canDoMovement(Board board, int goToX, int goToY) {
        return false;
    }

    @Override
    boolean isSelectable(Board board) {
        return false;
    }

    public boolean readyToEat;
}

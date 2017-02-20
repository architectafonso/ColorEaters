package testModule;

import com.color.eaters.BoardPiece;
import com.color.eaters.BoardPiece_Eater;
import com.color.eaters.Colors;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by João on 07/12/2016.
 */

public class BoardPieceTest {
    @Test
    public void CreationTest(){
        BoardPiece b = new BoardPiece_Eater(2, 3, Colors.Red);
        Assert.assertEquals(b.graphicsX, 2*(1000/6));
        Assert.assertEquals(b.graphicsY, 3*(1000/6));

    }

}

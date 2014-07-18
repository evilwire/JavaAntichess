package antichess.piece;

/**
 * Created with IntelliJ IDEA.
 * User: evilwire
 * Date: 7/4/14
 * Time: 6:34 PM
 * To change this template use File | Settings | File Templates.
 */
import java.util.ArrayList;
import java.util.List;

import antichess.Color;
import antichess.Board;

public class Bishop extends Piece {
   public Bishop( Color color ) {
      this.color = color;
      this.name = "Bishop";
   }
}

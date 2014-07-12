package antichess;

/**
 * Created with IntelliJ IDEA.
 * User: evilwire
 * Date: 7/3/14
 * Time: 6:13 PM
 * To change this template use File | Settings | File Templates.
 */
import java.util.List;
import antichess.piece.Piece;

public class Player {
   private Color color;
   private List<Piece> pieces;

   public Player( Color color, List<Piece> pieces ) {
      this.color = color;
      this.pieces = pieces;
   }
}

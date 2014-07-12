package antichess;

/**
 * Created with IntelliJ IDEA.
 * User: evilwire
 * Date: 7/3/14
 * Time: 3:54 PM
 * To change this template use File | Settings | File Templates.
 */
import java.util.List;
import java.util.ArrayList;
import antichess.piece.Piece;

public class Antichess {
   private Player currentPlayer;
   private List<Player> players;

   public Antichess() {
      List<Piece> whitePieces = new ArrayList<Piece>(16);
      Player whitePlayer = new Player( Color.WHITE, whitePieces );

      List<Piece> blackPieces = new ArrayList<Piece>(16);
      Player blackPlayer = new Player( Color.BLACK, blackPieces );
   }
}

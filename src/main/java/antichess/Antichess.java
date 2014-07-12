package antichess;

/**
 * Created with IntelliJ IDEA.
 * User: evilwire
 * Date: 7/3/14
 * Time: 3:54 PM
 * To change this template use File | Settings | File Templates.
 */
import java.util.ArrayList;
import antichess.piece.Piece;

public class Antichess {
   private Player currentPlayer;
   private ArrayList<Player> players;

   public Antichess() {
      ArrayList<Piece> whitePieces = new ArrayList<Piece>(16);
      Player whitePlayer = new Player( Color.WHITE, whitePieces );

      ArrayList<Piece> blackPieces = new ArrayList<Piece>(16);
      Player blackPlayer = new Player( Color.BLACK, blackPieces );
   }
}

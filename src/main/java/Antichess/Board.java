package Antichess;

import java.util.HashMap;
import java.util.List;
import Antichess.Piece.Piece;
import Antichess.Piece.Location;

/**
 * Created with IntelliJ IDEA.
 * User: evilwire
 * Date: 7/4/14
 * Time: 8:14 PM
 * To change this template use File | Settings | File Templates.
 */

public class Board {
   private HashMap<Integer, Piece> pieceConfig;

   /**
    * Initializes an empty board.
    */
   public Board() {
      pieceConfig = new HashMap<Integer, Piece>(1 << 8);
   }

   public Board( List<Piece> pieces ) {
      pieceConfig = new HashMap<Integer, Piece>(1 << 8);
      for(int i = 0; i < pieces.size(); ++i ) {
         Piece piece = pieces.get(i);
         int index = ((piece.getLocation().getY() - 1) << 4) +
                 piece.getLocation().getX() - 1;
         pieceConfig.put( index, piece );
      }
   }

   public boolean isLocationEmpty( Location location ) {
      int index = ((location.getY() - 1) << 4) +
              location.getX() - 1;

      return false;
   }

   public Piece getPieceAt( Location location )
   {
      int index = ((location.getY() - 1) << 4) +
              location.getX() - 1;

      return this.pieceConfig.get( index );
   }
}

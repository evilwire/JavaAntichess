package Antichess;

import java.util.HashMap;
import java.util.List;
import Antichess.Piece.Piece;
import Antichess.Piece.Location;

/**
 * Board - Represents an (anti)chess board.
 *
 * Depends on:
 * - Location.hashCode()
 * - Piece.getLocation()
 *
 * @author Knight W. Fu
 */
public class Board {
   private HashMap<Integer, Piece> pieceConfig;

   /**
    * Initializes an empty board.
    */
   public Board() {
      pieceConfig = new HashMap<Integer, Piece>(1 << 6);
   }

   public Board( List<Piece> pieces ) {
      pieceConfig = new HashMap<Integer, Piece>(1 << 3);
      for(int i = 0; i < pieces.size(); ++i ) {
         Piece piece = pieces.get(i);
         pieceConfig.put
           ( piece.getLocation().hashCode(), piece );
      }
   }

   public void updatePieceLocation( Location oldLocation, Piece piece ){
      this.pieceConfig.remove( oldLocation.hashCode() );
      this.pieceConfig.put( piece.getLocation().hashCode(), piece );
   }

   public boolean isLocationEmpty( Location location ) {
      return this.pieceConfig.containsKey(location.hashCode());
   }

   /**
    * @throws IndexOutOfBoundsException
    * @param location
    * @return
    */
   public Piece getPieceAt( Location location )
   {
      return this.pieceConfig.get( location.hashCode() );
   }
}

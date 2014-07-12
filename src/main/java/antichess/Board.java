package antichess;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import antichess.piece.Piece;
import antichess.piece.Location;

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
   private Map<Location, Piece> pieceConfig;

   /**
    * Initializes an empty board.
    */
   public Board() {
      pieceConfig = new HashMap<Location, Piece>(1 << 6);
   }

   public Board( List<Piece> pieces ) {
      pieceConfig = new HashMap<Location, Piece>(1 << 3);
      for( Piece piece : pieces ) {
         this.pieceConfig.put
           ( piece.getLocation(), piece );
      }
   }

   /**
    *
    * @param oldLocation
    * @param piece
    */
   public void updatePieceLocation( Location oldLocation, Piece piece ){
      this.pieceConfig.remove( oldLocation );
      this.pieceConfig.put
        ( piece.getLocation(), piece );
   }

   /**
    *
    * @param location
    * @return
    */
   public boolean isLocationEmpty( Location location ) {
      return !this.pieceConfig.containsKey( location );
   }

   /**
    * @throws IndexOutOfBoundsException
    * @param location
    * @return
    */
   public Piece getPieceAt( Location location )
   {
      return this.pieceConfig.get( location );
   }
}

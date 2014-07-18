package antichess;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import antichess.piece.Piece;

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
   private int width, height;

   /**
    * Initializes an empty board.
    */
   public Board( int width, int height ) {
      this.pieceConfig = new HashMap<Location, Piece>(1 << 6);
      this.width = width;
      this.height = height;
   }

   public Board() {
      this( 8, 8);
   }

   public int getWidth(){
      return this.width;
   }

   public int getHeight(){
      return this.height;
   }

   public boolean isLocationValid( Location location ){
      return location.getX() >= 0 && location.getY() >= 0 &&
             location.getX() < this.getWidth() &&
             location.getY() < this.getHeight();
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

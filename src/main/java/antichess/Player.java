package Antichess;

/**
 * Created with IntelliJ IDEA.
 * User: evilwire
 * Date: 7/3/14
 * Time: 6:13 PM
 * To change this template use File | Settings | File Templates.
 */
import java.util.List;
import antichess.piece.Piece;
import java.util.ArrayList;
import java.util.List;

/**
 * Player - class for maintaining the pieces in play
 *
 * @author Knight W. Fu
 */
public class Player {
   private Color color;
   private List<Piece> pieces;
   private List<Piece> capturedPieces;
   private List<Piece> activePieces;

   public Player( Color color, List<Piece> pieces ) {
      this.color = color;
      this.pieces = pieces;
      this.capturedPieces = new ArrayList<Piece>();
      this.activePieces = pieces;
   }

   public List<Piece> getActivePieces(){
      return ( List<Piece> )
        ( ( ArrayList<Piece> ) this.activePieces).clone();
   }

   public List<Piece> getCapturedPieces(){
       return ( List<Piece> )
         ( ( ArrayList<Piece> ) this.capturedPieces).clone();
   }

   public List<Piece> getPieces(){
       return ( List<Piece> )
         ( ( ArrayList<Piece> ) this.pieces).clone();
   }

   public void removePiece( Piece piece ){
      int indexOfPiece =
        this.activePieces.indexOf( piece );

      // if the piece is not found, don't do anything
      if( indexOfPiece < 0 ) return;

      this.activePieces.remove( indexOfPiece );
      this.capturedPieces.add( piece );
   }

   public void elevatePawn( Pawn pawn, Piece piece ){
       int indexOfPawn =
        this.activePieces.indexOf( pawn );

      // if the piece is not found, don't do anything
      if( indexOfPawn < 0 ) return;

      this.pieces.add( piece );
      this.activePieces.remove( indexOfPawn );
      this.capturedPieces.add( indexOfPawn, piece );
   }
}

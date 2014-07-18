package antichess.piece;

import antichess.Board;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: grimslock
 * Date: 7/18/14
 * Time: 11:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class DiagonalMoveValidator implements IMoveValidator {
    private List<Location> getValidMovesTo( Piece piece, Location location, Board board ){
              List<Location> validMoves = new ArrayList<Location>();
      Location currentLocation = piece.getLocation();
      if( location == currentLocation || !this.isLocationReachable( piece, location ) ){
         return validMoves;
      }

      int deltaX = location.getX() - currentLocation.getX(),
          deltaY = location.getY() - currentLocation.getY(),
          xStep = ( deltaX > 0 )? 1 : -1,
          yStep = ( deltaY > 0 )? 1 : -1;

      for( int i = 1; i < Math.abs( deltaX); ++i ){
         Location intermediaryLocation =
                 new Location(currentLocation.getX() + xStep * i,
                              currentLocation.getY() + yStep * i);

         if( board.isLocationEmpty( intermediaryLocation ) ) {
            validMoves.add( intermediaryLocation );
            continue;
         }

         if( board.getPieceAt( intermediaryLocation ).getColor() != piece.getColor() ){
            validMoves.add( intermediaryLocation );
         }
         return validMoves;
      }

      return validMoves;
    }

    private boolean isLocationReachable( Piece piece, Location location ){

        Location currentLocation = piece.getLocation();

        return Math.abs(location.getX() - currentLocation.getX()) ==
                Math.abs(location.getY() - currentLocation.getY());
    }

    public List<Location> getValidMoves(Piece piece, Location location, Board board) {
        Location currentLocation = piece.getLocation();
        int distFromTop = board.getHeight() - currentLocation.getY(),
            distFromBottom = currentLocation.getY(),
            distFromLeft = currentLocation.getX(),
            distFromRight = board.getWidth() - currentLocation.getX(),
            boardWidth = board.getWidth(),
            boardHeight = board.getHeight();

        Location NWPoint = ( distFromTop > distFromLeft )?
                new Location( 0, currentLocation.getY() + distFromLeft ) :
                new Location( currentLocation.getX() - distFromTop, boardHeight );

        Location NEPoint = ( distFromTop > distFromRight )?
                new Location( boardWidth, currentLocation.getY() + distFromRight ) :
                new Location( currentLocation.getX() + distFromTop, boardHeight );

        Location SWPoint = ( distFromBottom > distFromLeft )?
                new Location( 0, currentLocation.getY() - distFromLeft ) :
                new Location( currentLocation.getX() - distFromBottom, 0 );

        Location SEPoint = ( distFromBottom > distFromRight )?
                new Location( boardWidth, currentLocation.getY() - distFromRight ) :
                new Location( currentLocation.getX() + distFromBottom, 0 );

        List<Location> validMoves = new ArrayList<Location>
                ( this.getValidMovesTo( piece, NWPoint, board ));

        validMoves.addAll( this.getValidMovesTo( piece, NEPoint, board ));
        validMoves.addAll( this.getValidMovesTo( piece, SWPoint, board ));
        validMoves.addAll( this.getValidMovesTo( piece, SEPoint, board ));

        return validMoves;
    }


    public boolean isMoveValid( Piece piece, Location location, Board board ) {
        if( !this.isLocationReachable( piece, location )) {
            return false;
        }

        Location currentLocation = piece.getLocation();

        if( location == currentLocation){
            return true;
        }

        int deltaX = location.getX() - currentLocation.getX(),
                deltaY = location.getY() - currentLocation.getY(),
                xStep = ( deltaX > 0 )? 1 : -1,
                yStep = ( deltaY > 0 )? 1 : -1;

        for( int i = 1; i < Math.abs(deltaX); i++ ){
            Location intermediateLocation = new Location( xStep * i, yStep * i );
            if( !board.isLocationEmpty( intermediateLocation ) ){
                return false;
            }
        }

        if( !board.isLocationEmpty( location ) &&
                ( board.getPieceAt( location ).getColor() == piece.getColor() ) ){
            return false;
        }

        return true;
    }
}

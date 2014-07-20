package antichess.rules;

import antichess.Board;
import antichess.Location;
import antichess.piece.Piece;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: grimslock
 * Date: 7/18/14
 * Time: 11:53 AM
 * To change this template use File | Settings | File Templates.
 */
public class LinearMoveValidator implements IMoveValidator {
    private List<Location> getValidMovesTo( Piece piece, Location location, Board board ){

        List<Location> validMoves = new ArrayList<Location>();
        Location currentLocation = piece.getLocation();
        if( !this.isLocationReachable( piece, location ) ||
                location == currentLocation ){
            return validMoves;
        }

        int deltaX = location.getX() - currentLocation.getX(),
            deltaY = location.getY() - currentLocation.getY(),
            stepX = (deltaX > 0)? 1 : -1,
            stepY = (deltaY > 0)? 1 : -1;

        deltaX = Math.abs(deltaX);
        deltaY = Math.abs(deltaY);

        if( deltaX != 0 ){
            for( int i = 0; i < deltaX; ++i ){
                Location intermediaryLocation = new
                        Location(currentLocation.getX() + i * stepX,
                                 currentLocation.getY());

                if( board.isLocationEmpty(intermediaryLocation) ){
                    validMoves.add(intermediaryLocation);
                }
                else {
                    if( board.getPieceAt(intermediaryLocation).getColor() !=
                            piece.getColor() ){
                        validMoves.add(intermediaryLocation);
                    }
                    break;
                }
            }
        }
        else {
            for( int i = 0; i < deltaY; ++i ){
                Location intermediaryLocation = new
                        Location(currentLocation.getX(),
                                 currentLocation.getY() + i * stepY );

                if( board.isLocationEmpty( intermediaryLocation ) ){
                    validMoves.add(intermediaryLocation);
                }
                else {
                    if( board.getPieceAt( intermediaryLocation ).getColor() !=
                            piece.getColor() ){
                        validMoves.add(intermediaryLocation);
                    }
                    break;
                }
            }
        }

        return validMoves;
    }

    private boolean isLocationReachable( Piece piece, Location location ){
        return ( location.getX() == piece.getLocation().getX() ) ||
                ( location.getY() == piece.getLocation().getY() );
    }

    public List<Location> getValidMoves( Piece piece, Location location, Board board) {
        Location currentLocation = piece.getLocation(),
                 north = new Location( currentLocation.getX(), board.getHeight() ),
                 south = new Location( currentLocation.getX(), 0 ),
                 west = new Location( 0, currentLocation.getY() ),
                 east = new Location( board.getWidth(), currentLocation.getY() );

        List<Location> validMoves = new ArrayList<Location>
                ( this.getValidMovesTo( piece, north, board ));

        validMoves.addAll( this.getValidMovesTo( piece, south, board ));
        validMoves.addAll( this.getValidMovesTo( piece, west, board ));
        validMoves.addAll(this.getValidMovesTo(piece, east, board));

        return validMoves;
    }

    public boolean isMoveValid( Piece piece, Location location, Board board) {
        List<Location> validMoves = this.getValidMovesTo(piece, location, board);

        if( validMoves.isEmpty() ){
            return false;
        }

        return validMoves.get( validMoves.size() - 1 ).equals( location );
    }
}

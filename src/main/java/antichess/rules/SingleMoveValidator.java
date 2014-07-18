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
 * Time: 4:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class SingleMoveValidator implements IMoveValidator {
    private boolean canPieceMoveTo(Piece piece, Location location, Board board){
        return board.isLocationValid( location ) &&
               ( board.isLocationEmpty( location ) ||
                 board.getPieceAt( location ).getColor() != piece.getColor() );
    }

    private List<Location> getColumn( int columnOffset, Piece piece, Board board ){
        List<Location> columnLocation = new ArrayList<Location>();
        Location currentLocation = piece.getLocation();
        int targetX = currentLocation.getX() + columnOffset,
            currentY = currentLocation.getY();

        Location targetTopLocation = new Location( targetX, currentY + 1);
        if( this.canPieceMoveTo(piece, targetTopLocation, board) ){
            columnLocation.add( targetTopLocation );
        }

        Location targetBottomLocation = new Location( targetX, currentY - 1);
        if( this.canPieceMoveTo(piece, targetBottomLocation, board) ){
            columnLocation.add( targetBottomLocation );
        }

        if( columnOffset != 0 ){
            Location targetMiddleLocation = new Location( targetX, currentY);
            if( this.canPieceMoveTo(piece, targetMiddleLocation, board) ){
                columnLocation.add( targetMiddleLocation );
            }
        }

        return columnLocation;
    }

    public List<Location> getValidMoves(Piece piece, Location location, Board board) {
        List<Location> validMoves = new ArrayList<Location>( this.getColumn(0, piece, board ));
        validMoves.addAll( this.getColumn( 1, piece, board ));
        validMoves.addAll( this.getColumn(-1, piece, board ));

        return validMoves;
    }

    public boolean isMoveValid(Piece piece, Location location, Board board) {
        Location currentLocation = piece.getLocation();
        if( Math.abs( currentLocation.getX() - location.getX() ) > 1 ) {
            return false;
        }

        if( Math.abs( currentLocation.getY() - location.getY() ) > 1 ){
            return false;
        }

        return this.canPieceMoveTo(piece, location, board);
    }
}

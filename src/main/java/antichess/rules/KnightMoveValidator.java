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
 * Time: 5:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class KnightMoveValidator implements IMoveValidator {
    private boolean canPieceMoveTo(Piece piece, Location location, Board board){
        return board.isLocationValid( location ) &&
               ( board.isLocationEmpty( location ) ||
                 board.getPieceAt( location ).getColor() != piece.getColor() );
    }

    public List<Location> getValidMoves(Piece piece, Location location, Board board) {
        List<Location> validMoves = new ArrayList<Location>();
        int currentX = piece.getLocation().getX(),
            currentY = piece.getLocation().getY();

        /**
         * Clockwise from standard "L" wrt the Knight
         *   L1     L8
         * L2         L7
         *       K
         * L3         L6
         *   L4     L5
         */
        Location L1 = new Location( currentX - 1, currentY + 2 );
        if( this.canPieceMoveTo( piece, location, board )){
            validMoves.add( L1 );
        }

        Location L2 = new Location( currentX - 2, currentY + 1 );
        if( this.canPieceMoveTo( piece, location, board )){
            validMoves.add( L2 );
        }

        Location L3 = new Location( currentX - 2, currentY - 1 );
        if( this.canPieceMoveTo( piece, location, board )){
            validMoves.add( L3 );
        }

        Location L4 = new Location( currentX - 1, currentY - 2 );
        if( this.canPieceMoveTo( piece, location, board )){
            validMoves.add( L4 );
        }

        Location L5 = new Location( currentX + 1, currentY - 2 );
        if( this.canPieceMoveTo( piece, location, board )){
            validMoves.add( L5 );
        }

        Location L6 = new Location( currentX + 2, currentY - 1 );
        if( this.canPieceMoveTo( piece, location, board )){
            validMoves.add( L6 );
        }

        Location L7 = new Location( currentX + 2, currentY + 1 );
        if( this.canPieceMoveTo( piece, location, board )){
            validMoves.add( L7 );
        }

        Location L8 = new Location( currentX + 1, currentY + 2 );
        if( this.canPieceMoveTo( piece, location, board )){
            validMoves.add( L8 );
        }

        return validMoves;
    }

    public boolean isMoveValid(Piece piece, Location location, Board board) {
        Location currentLocation = piece.getLocation();

        if( !( Math.abs( currentLocation.getX() - location.getX() ) == 1 &&
               Math.abs( currentLocation.getY() - location.getY() ) == 2 ) &&
            !( Math.abs( currentLocation.getX() - location.getX() ) == 2 &&
               Math.abs( currentLocation.getY() - location.getY() ) == 1 )
          ){
            return false;
        }

        return this.canPieceMoveTo( piece, location, board );
    }
}

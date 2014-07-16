package antichess.piece;

import antichess.Board;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: grimslock
 * Date: 7/15/14
 * Time: 7:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class Rook extends Piece {

    public boolean isMoveValid(Location location, Board board) {
        return false;
    }

    private boolean isLocationReachable( Location location){
        return (location.getX() == this.getLocation().getX()) ||
                (location.getY() == this.getLocation().getY());
    }

    private List<Location> getValidLocationsTo( Location location, Board board){
        List<Location> locations = new ArrayList<Location>();
        Location currentLocation = this.getLocation();
        if( !this.isLocationReachable(location) ||
                location == currentLocation ){
            return locations;
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
                    locations.add(intermediaryLocation);
                }
                else {
                    if( board.getPieceAt(intermediaryLocation).getColor() !=
                            this.getColor() ){
                        locations.add( intermediaryLocation );
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

                if( board.isLocationEmpty(intermediaryLocation) ){
                    locations.add(intermediaryLocation);
                }
                else {
                    if( board.getPieceAt(intermediaryLocation).getColor() !=
                            this.getColor() ){
                        locations.add( intermediaryLocation );
                    }
                    break;
                }
            }
        }

        return locations;
    }

    public List<Location> getValidLocations(Board board) {
        List<Location> locations = new ArrayList<Location>();

        return locations;
    }
}

package peggame;

public class Move {
    private Location from;
    private Location to;

    public Move(Location from, Location to){
        this.from = from;
        this.to = to;
    }
    /**
     * 
     * returns the position the peg is before the move as a location
     */
    public Location getFrom() {
        return from;
    }
    /**
     * 
     * returns the position the peg is after the move as a location
     */
    public Location getTo() {
        return to;
    }
    /**
     * 
     * returns the String representation of the move function
     *      
     */
    @Override
    public String toString(){
        return "Move from "+from+" to " +to;
    }
    /**
     *takes an Object o
     *compares o with an instanceof a Move
     *returns a boolean after comparing their equality 
     */
    @Override
    public boolean equals(Object o){
        if(o instanceof Move){
            Move other = (Move)o;
            return other.getFrom().equals(from) && other.getTo().equals(to);
        }
        return false;
    }
}


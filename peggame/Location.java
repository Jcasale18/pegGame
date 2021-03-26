package peggame;

public class Location {
    private int row;
    private int col;
    public Location(int row, int col){
        this.row = row;
        this.col = col;
    }

    /**
     * Returns the location's row
     * @return The location's row
     */
    public int getRow() {
        return row;
    }

    /**
     * Returns the location's column
     * @return The location's column
     */
    public int getCol() {
        return col;
    }

    /**
     * Checks to see if another location is the same by
     * comparing their row & column
     */
    @Override
    public boolean equals(Object o){
        if(o instanceof Location){
            Location other = (Location)o;
            return(row == other.getRow() && col == other.getCol());
        }
        return false;
    }

    /**
     * In order for each location to be uniquly identifiable, up to 10001 pieces,
     * mulitplies the row by 10k and adds the column
     */
    @Override
    public int hashCode(){
        return row*10000 + col;//10001 column board allowed
    }
    //Methods for retrieving neighbors


    /**
     * Gets the theoretical neighbor of a location by given direction
     * @param dir A keyword to get the direction of neighbor - L, R, T, B , TR, TL, BR, BL
     * @return A new location with the coordinates it should have, given the direction
     */
    public Location getNeighbor(String dir){
        dir = dir.toUpperCase();
        if (dir.equals("L")){
            return new Location(row, col-1);
        } else if (dir.equals("R")){
            return new Location(row, col+1);
        }else if (dir.equals("T")){
            return new Location(row+1, col);
        }else if (dir.equals("B")){
            return new Location(row-1, col);
        }else if (dir.equals("TR")){
            return new Location(row+1, col+1);
        }else if (dir.equals("TL")){
            return new Location(row+1, col-1);
        }else if (dir.equals("BR")){
            return new Location(row-1, col+1);
        }else if (dir.equals("BL")){
            return new Location(row-1, col-1);
        }
        return null;
    }


    /**
     * Returns a string of the coordinates of the location
     */
    @Override
    public String toString(){
        return "("+this.row+", "+this.col+")";
    }   
}
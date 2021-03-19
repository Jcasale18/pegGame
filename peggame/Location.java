package peggame;

public class Location {
    private int row;
    private int col;
    public Location(int row, int col){
        this.row = row;
        this.col = col;
    }
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
    @Override
    public boolean equals(Object o){
        if(o instanceof Location){
            Location other = (Location)o;
            return(row == other.getRow() && col == other.getCol());
        }
        return false;
    }
    @Override
    public int hashCode(){
        return row*10000 + col;//10001 column board allowed
    }
    //Methods for retrieving neighbors

    public Location getLeft(){
        return new Location(row-1, col);
    }
}
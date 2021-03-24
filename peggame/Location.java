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

    @Override
    public String toString(){
        return this.row+", "+this.col;
    }
    
}
package peggame;

public class Move {
    private Location from;
    private Location to;

    public Move(Location from, Location to){
        this.from = from;
        this.to = to;
    }

    public Location getFrom() {
        return from;
    }

    public Location getTo() {
        return to;
    }

    @Override
    public String toString(){
        return "Move{"+from+"->"+to+"}";
    }
    @Override
    public boolean equals(Object o){
        if(o instanceof Move){
            Move other = (Move)o;
            return other.getFrom().equals(from) && other.getTo().equals(to);
        }
        return false;
    }
}


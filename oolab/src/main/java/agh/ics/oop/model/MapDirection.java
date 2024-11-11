package agh.ics.oop.model;

public enum MapDirection {
    NORTH,
    SOUTH,
    EAST,
    WEST;

    public String toString(){
        return switch (this){
            case EAST -> "E";
            case WEST -> "W";
            case NORTH -> "N";
            case SOUTH -> "S";
        };
    }
    public MapDirection next(){
        switch(this){
            case NORTH:
                return EAST;
            case EAST:
                return SOUTH;
            case SOUTH:
                return WEST;
            case WEST:
                return NORTH;
            default:
                return null;
        }
    }
    public MapDirection previous(){
        switch(this){
            case NORTH:
                return WEST;
            case EAST:
                return NORTH;
            case SOUTH:
                return EAST;
            case WEST:
                return SOUTH;
            default: return null;
        }
    }
    public Vector2d toUnitVector(){
        switch(this){
            case NORTH:
                return new Vector2d(0,1);
            case EAST:
                return new Vector2d(1,0);
            case SOUTH:
                return new Vector2d(0,-1);
            case WEST:
                return new Vector2d(-1,0);
            default: return null;
        }
    }


}

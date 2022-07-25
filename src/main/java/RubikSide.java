public class RubikSide {

    PositionMap<RubikSquare> squareMap;
    private final Integer size;
    private final Integer max;

    public RubikSide(Integer size){
        this.size = size;
        this.max = size - 1;
        squareMap = new PositionMap<>();
    }

    public RubikSquare create(Integer value, Position position){
        RubikSquare rubikSquare = squareMap.getOrDefault(position, new RubikSquare(value));
        squareMap.put(position, rubikSquare);
        if(position.getCol() < max) rubikSquare.setRight(create(value, position.getRight()));
        if(position.getRow() < max) rubikSquare.setDown(create(value, position.getDown()));
        return rubikSquare;
    }
}

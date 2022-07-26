public class RubikSide {

    private final PositionMap<RubikSquare> squareMap;
    private final Integer size;
    private final Integer max;

    public RubikSide(Integer size, Integer value){
        this.size = size;
        this.max = size - 1;
        squareMap = new PositionMap<>();
        create(value, new Position(0, 0));
    }

    private RubikSquare create(Integer value, Position position){
        RubikSquare rubikSquare = squareMap.getOrDefault(position, new RubikSquare(value));
        squareMap.put(position, rubikSquare);
        if(position.getCol() < max) rubikSquare.setRight(create(value, position.getRight()));
        if(position.getRow() < max) rubikSquare.setDown(create(value, position.getDown()));
        return rubikSquare;
    }

    public Integer getValue(Integer row, Integer col){
        return squareMap.containsKey(row, col) ? squareMap.get(row, col).getValue() : null;
    }

    public RubikSquare get(Integer row, Integer col){
        return squareMap.get(row, col);
    }

    public int squareCount(){
        return squareMap.size();
    }
}

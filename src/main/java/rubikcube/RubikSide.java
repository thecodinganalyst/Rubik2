package rubikcube;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RubikSide implements Cloneable {

    private final PositionMap<RubikSquare> squareMap;
    private final Integer size;
    private final Integer max;

    public RubikSide(Integer size, Integer value){
        this.size = size;
        this.max = size - 1;
        squareMap = new PositionMap<>();
        create(value, new Position(0, 0));
    }

    public RubikSide(Integer size, PositionMap<RubikSquare> squareMap){
        this.size = size;
        this.max = size - 1;
        this.squareMap = (PositionMap<RubikSquare>) squareMap.clone();
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

    public Stream<Integer> getAllValuesStream(){
        return squareMap.values().stream().map(RubikSquare::getValue);
    }

    public RubikSquare get(Integer row, Integer col){
        return squareMap.get(row, col);
    }

    public int squareCount(){
        return squareMap.size();
    }

    public boolean isComplete(){
        return squareMap.values()
                .stream()
                .map(RubikSquare::getValue)
                .allMatch(value -> Objects.equals(value, getValue(0, 0)));
    }

    public List<Integer> getRow(Integer row){
        return IntStream.range(0, size)
                .boxed()
                .map(i -> getValue(row, i))
                .toList();
    }

    public List<Integer> getCol(Integer col){
        return IntStream.range(0, size)
                .boxed()
                .map(i -> getValue(i, col))
                .toList();
    }

    public static List<String> getEmptyString(int size){
        return IntStream.range(0, size).boxed().map(i -> " ".repeat(2 + size + (2 * (size - 1)))).toList();
    }

    public List<String> getString(){
        return IntStream.range(0, size)
                .boxed()
                .map(i -> getRow(i).toString())
                .toList();
    }

    @Override
    public RubikSide clone() {
        try {
            RubikSide clone = (RubikSide) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

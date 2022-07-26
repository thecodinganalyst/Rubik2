package rubikcube;

import solutioning.Action;
import solutioning.Subject;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RubikCube implements Subject<RubikCube> {

    private final Integer size;
    private RubikSide main;
    private RubikSide right;
    private RubikSide back;
    private RubikSide left;
    private RubikSide top;
    private RubikSide bottom;

    public RubikCube(Integer size){
        this.size = size;
        this.main = new RubikSide(size, 1);
        this.right = new RubikSide(size, 2);
        this.back = new RubikSide(size, 3);
        this.left = new RubikSide(size, 4);
        this.top = new RubikSide(size, 5);
        this.bottom = new RubikSide(size, 6);
    }

    public int getSize() {
        return size;
    }

    public int max() { return size - 1; }

    public RubikSide getMain() {
        return main;
    }

    public RubikSide getRight() {
        return right;
    }

    public RubikSide getBack() {
        return back;
    }

    public RubikSide getLeft() {
        return left;
    }

    public RubikSide getTop() {
        return top;
    }

    public RubikSide getBottom() {
        return bottom;
    }

    @Override
    public void performAction(Action<RubikCube> action) {

    }

    @Override
    public void performActionList(List<Action<RubikCube>> actions) {

    }

    @Override
    public Action<RubikCube>[] getAllActions() {
        return new Action[0];
    }

    @Override
    public boolean check() {
        List<Integer> valueList = getAllSides().stream()
                .flatMap(RubikSide::getAllValuesStream)
                .toList();
        Map<Integer, List<Integer>> valueMap = valueList.stream()
                .collect(Collectors.groupingBy(Integer::intValue));

        System.out.println(Math.pow(size, 2));
        return valueMap.keySet().containsAll(List.of(1, 2, 3, 4, 5, 6)) &&
                valueMap.values().stream().map(List::size).allMatch(i -> i == Math.pow(size, 2));
    }

    @Override
    public boolean isComplete() {
        return getAllSides().stream().allMatch(RubikSide::isComplete);
    }

    public List<RubikSide> getAllSides(){
        return List.of(main, right, back, left, top, bottom);
    }

    private List<String> join(List<String>... sides){
        BinaryOperator<List<String>> reducer = (a, b) ->
                IntStream.range(0, a.size())
                        .boxed()
                        .map(i -> a.get(i).concat(" ").concat(b.get(i)))
                        .toList();
        List<String> result = Arrays.stream(sides).reduce(reducer).orElseThrow();
        return result.stream().map(line -> line.concat(System.lineSeparator())).toList();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        List<String> box = join(RubikSide.getEmptyString(getSize()), getTop().getString());
        box.forEach(builder::append);
        box = join(getLeft().getString(), getMain().getString(), getRight().getString(), getBack().getString());
        box.forEach(builder::append);
        box = join(RubikSide.getEmptyString(getSize()), getBottom().getString());
        box.forEach(builder::append);
        return builder.toString();
    }

    @Override
    public Subject<RubikCube> clone() throws CloneNotSupportedException {
        return null;
    }
}

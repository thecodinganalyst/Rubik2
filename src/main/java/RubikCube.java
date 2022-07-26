import java.util.stream.IntStream;

public class RubikCube {

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
}

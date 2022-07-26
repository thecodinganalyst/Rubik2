package rubikcube;

import solutioning.Action;
import solutioning.Subject;

import java.util.List;

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
        return false;
    }

    @Override
    public boolean isComplete() {
        return false;
    }

    public List<RubikSide> getAllSides(){
        return List.of(main, right, back, left, top, bottom);
    }

    @Override
    public void print() {

    }

    @Override
    public Subject<RubikCube> clone() throws CloneNotSupportedException {
        return null;
    }
}

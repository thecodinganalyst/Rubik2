public class RubikSquare {
    private RubikSquare up;
    private RubikSquare right;
    private RubikSquare down;
    private RubikSquare left;
    private final Integer value;

    public RubikSquare(Integer value){
        this.value = value;
    }

    public void setUp(RubikSquare rubikSquare){
        this.up = rubikSquare;
        rubikSquare.down = this;
    }

    public void setDown(RubikSquare rubikSquare){
        this.down = rubikSquare;
        rubikSquare.up = this;
    }

    public void setRight(RubikSquare rubikSquare){
        this.right = rubikSquare;
        rubikSquare.left = this;
    }

    public void setLeft(RubikSquare rubikSquare){
        this.left = rubikSquare;
        rubikSquare.right = this;
    }

    public RubikSquare getUp() {
        return up;
    }

    public RubikSquare getRight() {
        return right;
    }

    public RubikSquare getDown() {
        return down;
    }

    public RubikSquare getLeft() {
        return left;
    }

    public Integer getValue() {
        return value;
    }
}

package rubikcube;

import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

class RubikSideTest {

    @Test
    void create() {
        RubikSide side = new RubikSide(3, 1);

        assertThat(side.squareCount(), equalTo(9));

        RubikSquare center = side.get(1, 1);
        RubikSquare topLeft = side.get(0, 0);
        RubikSquare topCenter = side.get(0, 1);
        RubikSquare topRight = side.get(0, 2);
        RubikSquare middleLeft = side.get(1, 0);
        RubikSquare middleRight = side.get(1, 2);
        RubikSquare bottomLeft = side.get(2, 0);
        RubikSquare bottomCenter = side.get(2, 1);
        RubikSquare bottomRight = side.get(2, 2);

        assertThat(topLeft.getRight(), equalTo(topCenter));
        assertThat(topLeft.getDown(), equalTo(middleLeft));

        assertThat(topCenter.getLeft(), equalTo(topLeft));
        assertThat(topCenter.getDown(), equalTo(center));
        assertThat(topCenter.getRight(), equalTo(topRight));

        assertThat(topRight.getLeft(), equalTo(topCenter));
        assertThat(topRight.getDown(), equalTo(middleRight));

        assertThat(middleLeft.getUp(), equalTo(topLeft));
        assertThat(middleLeft.getRight(), equalTo(center));
        assertThat(middleLeft.getDown(), equalTo(bottomLeft));

        assertThat(center.getUp(), equalTo(topCenter));
        assertThat(center.getRight(), equalTo(middleRight));
        assertThat(center.getDown(), equalTo(bottomCenter));
        assertThat(center.getLeft(), equalTo(middleLeft));

        assertThat(middleRight.getUp(), equalTo(topRight));
        assertThat(middleRight.getLeft(), equalTo(center));
        assertThat(middleRight.getDown(), equalTo(bottomRight));

        assertThat(bottomLeft.getUp(), equalTo(middleLeft));
        assertThat(bottomLeft.getRight(), equalTo(bottomCenter));

        assertThat(bottomCenter.getLeft(), equalTo(bottomLeft));
        assertThat(bottomCenter.getUp(), equalTo(center));
        assertThat(bottomCenter.getRight(), equalTo(bottomRight));

        assertThat(bottomRight.getUp(), equalTo(middleRight));
        assertThat(bottomRight.getLeft(), equalTo(bottomCenter));

        assertThat(bottomRight.getRight(), equalTo(null));
    }

    @Test
    void isComplete() {
        RubikSide side = new RubikSide(3, 1);
        assertThat(side.isComplete(), is(true));

        //TODO: add test for isComplete() to return false
    }
}
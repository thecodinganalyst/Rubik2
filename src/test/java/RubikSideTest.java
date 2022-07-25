import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

class RubikSideTest {

    @Test
    void create() {
        RubikSide side = new RubikSide(3);
        side.create(1, new Position(0, 0));

        assertThat(side.squareMap.size(), equalTo(9));

        RubikSquare center = side.squareMap.get(1, 1);
        RubikSquare topLeft = side.squareMap.get(0, 0);
        RubikSquare topCenter = side.squareMap.get(0, 1);
        RubikSquare topRight = side.squareMap.get(0, 2);
        RubikSquare middleLeft = side.squareMap.get(1, 0);
        RubikSquare middleRight = side.squareMap.get(1, 2);
        RubikSquare bottomLeft = side.squareMap.get(2, 0);
        RubikSquare bottomCenter = side.squareMap.get(2, 1);
        RubikSquare bottomRight = side.squareMap.get(2, 2);

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
}
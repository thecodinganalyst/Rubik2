package rubikcube;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

class RubikCubeTest {

    @Test
    void RubikCube(){
        RubikCube cube = new RubikCube(3);
        assertThat(cube.getSize(), equalTo(3));
        assertThat(cube.getMain().squareCount(), equalTo(9));
        assertThat(cube.getMain().getValue(0, 0), equalTo(1));
        assertThat(cube.getRight().getValue(0, 0), equalTo(2));
        assertThat(cube.getBack().getValue(0, 0), equalTo(3));
        assertThat(cube.getLeft().getValue(0, 0), equalTo(4));
        assertThat(cube.getTop().getValue(0, 0), equalTo(5));
        assertThat(cube.getBottom().getValue(0, 0), equalTo(6));
    }

    @Test
    void check() {
        RubikCube cube = new RubikCube(3);
        assertThat(cube.check(), is(true));

        //TODO: add check for false scenario
    }

    @Test
    void isComplete() {
        RubikCube cube = new RubikCube(3);
        assertThat(cube.isComplete(), is(true));

        //TODO: add check for false scenario
    }

    @Test
    void Test_ToString(){
        RubikCube cube = new RubikCube(3);
        System.out.println(cube);
    }
}
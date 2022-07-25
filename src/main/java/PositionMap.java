import java.util.HashMap;

public class PositionMap<V> extends HashMap<Position, V> {

    public V put(Integer row, Integer col, V value) {
        return super.put(new Position(row, col), value);
    }

    public V get(Integer row, Integer col) {
        return super.get(new Position(row, col));
    }

    public V getOrDefault(Integer row, Integer col, V defaultValue) {
        return super.getOrDefault(new Position(row, col), defaultValue);
    }
}

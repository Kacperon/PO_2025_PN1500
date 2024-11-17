package agh.ics.oop.model.util;

import agh.ics.oop.model.Vector2d;

import java.util.*;

public class UniqueRandomPositionsGenerator implements Iterable<Vector2d> {
    private final int size;
    private final int count; // Liczba pozycji do wylosowania
    private final List<Vector2d> positions;

    public UniqueRandomPositionsGenerator(int size, int count) {
        this.size = size;
        this.count = count;
        this.positions = new ArrayList<>();
        initializePositions();
    }

    private void initializePositions() {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                positions.add(new Vector2d(x, y));
            }
        }

        // Przetasuj listę pozycji, aby uzyskać losowość
        Collections.shuffle(positions);
    }

    @Override
    public Iterator<Vector2d> iterator() {
        return positions.subList(0, count).iterator();
    }
}

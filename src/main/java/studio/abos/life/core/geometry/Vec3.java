package studio.abos.life.core.geometry;

import lombok.NonNull;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Coordinates in 3-space.
 */
public record Vec3(float x, float y, float z) implements Iterable<Float> {

    public static final Vec3 ZERO = new Vec3(0, 0, 0);

    public enum Vec3Position {
        X, Y, Z
    }

    public float get(final @NonNull Vec3Position pos) {
        return switch (pos) {
            case X -> x;
            case Y -> y;
            case Z -> z;
        };
    }

    public Vec3 add(final Vec3 other) {
        return new Vec3(x + other.x, y + other.y, z + other.z);
    }

    public Vec3 add(final float x, final float y, final float z) {
        return new Vec3(this.x + x, this.y + y, this.z + z);
    }

    public Vec3 add(final Measure3 measure) {
        return new Vec3(x + measure.width(), y + measure.height(), z + measure.depth());
    }

    @Override
    public Iterator<Float> iterator() {
        return new Vec3Iterator(this);
    }

    private static final class Vec3Iterator implements Iterator<Float> {

        private Vec3Position pos;

        private final Vec3 vec;

        public Vec3Iterator(final @NonNull Vec3 vec) {
            this.vec = vec;
        }

        @Override
        public boolean hasNext() {
            return pos != Vec3Position.Z;
        }

        @Override
        public Float next() {
            switch (pos) {
                case null -> pos = Vec3Position.X;
                case X -> pos = Vec3Position.Y;
                case Y -> pos = Vec3Position.Z;
                case Z -> throw new NoSuchElementException("Only 3 coordinates in 3-space!");
            }
            return vec.get(pos);
        }
    }
}

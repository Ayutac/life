package studio.abos.life.core.geometry;

import lombok.NonNull;
import lombok.experimental.UtilityClass;

@UtilityClass
public class GeometryUtils {

    public static final float EPS = 0.001f;

    public boolean directlyAbove(final @NonNull Shape shape, final @NonNull Shape other) {
        return true; // TODO implement
    }

    public boolean directlyBelow(final @NonNull Shape shape, final @NonNull Shape other) {
        return true; // TODO implement
    }

    public boolean posIsBelow(final @NonNull Vec3 position, final @NonNull Shape shape) {
        return false; // TODO implement
    }

    public boolean intersect(final @NonNull Cuboid a, final @NonNull Cuboid b) {
        return false; // TODO implement
    }

}

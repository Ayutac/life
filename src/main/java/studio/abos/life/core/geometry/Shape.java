package studio.abos.life.core.geometry;

import lombok.NonNull;

/**
 * A {@link FreeShape} with a {@link Vec3 position}.
 */
public interface Shape extends FreeShape {

    Vec3 getMinimalPosition();

    Cuboid getBoundingBox();

    default Vec3 getMaximalPosition() {
        return getMinimalPosition().add(getMeasure());
    }

    default boolean collidesWith(final @NonNull Shape shape) {
        return GeometryUtils.intersect(getBoundingBox(), getBoundingBox());
    }

}

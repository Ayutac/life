package studio.abos.life.core.physics;

import lombok.NonNull;
import studio.abos.life.core.geometry.MovingShape;
import studio.abos.life.core.geometry.Shape;
import studio.abos.life.core.geometry.Vec3;

import java.util.Collection;

/**
 * A {@link MovingShape} with a mass and a {@link Universe} to be in.
 */
public interface MassShape extends MovingShape {

    float getMass();

    default Vec3 getCenterOfMass() {
        return getBoundingBox().getCenter();
    }

    Universe getUniverse();

    void setUniverse(final @NonNull Universe universe);

    void checkFalling(final @NonNull Collection<? extends Shape> possibleCollisions);

    default boolean isFalling() {
        return affectedByGravity();
    }

    default boolean affectedByGravity() {
        return true;
    }

    void move(final @NonNull Collection<? extends Shape> possibleCollisions);

}

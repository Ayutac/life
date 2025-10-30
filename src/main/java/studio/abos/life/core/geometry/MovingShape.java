package studio.abos.life.core.geometry;

import lombok.NonNull;

/**
 * A {@link Shape} that moves in 3-space.
 */
public interface MovingShape extends Shape {

    /**
     * Sets the position of this {@link MovingShape}.
     */
    void setMinimalPosition(final @NonNull Vec3 position);

    /**
     * The velocity of the {@link MovingShape}, in float/tick.
     */
    Vec3 getVelocity();

    void setVelocity(final @NonNull Vec3 velocity);

    /**
     * Move regardless of collisions.
     */
    default void move() {
        setMinimalPosition(getMinimalPosition().add(getVelocity()));
    }

}

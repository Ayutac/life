package studio.abos.life.core.physics;

import studio.abos.life.core.geometry.MovingShape;
import studio.abos.life.core.geometry.Vec3;

public interface MassShape extends MovingShape {

    float getMass();

    default Vec3 getCenterOfMass() {
        return getBoundingBox().getCenter();
    }

    default boolean affectedByGravity() {
        return true;
    }

}

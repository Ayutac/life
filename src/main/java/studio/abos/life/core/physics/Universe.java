package studio.abos.life.core.physics;

import lombok.NonNull;
import studio.abos.life.core.geometry.FreeShape;
import studio.abos.life.core.geometry.Shape;
import studio.abos.life.core.geometry.Vec3;

import java.util.Collection;

public interface Universe extends FreeShape, Ageable {

    void applyGravityTo(final @NonNull MassShape massShape);

    default boolean isOutside(final @NonNull Shape shape) {
        final float width = getMeasure().width() / 2;
        final float height = getMeasure().height() / 2;
        final float depth = getMeasure().depth() / 2;
        final Vec3 boxCenter = shape.getBoundingBox().getCenter();
        return boxCenter.x() < -width || boxCenter.x() > width || boxCenter.y() < -height || boxCenter.y() > height || boxCenter.z() < -depth || boxCenter.z() > depth;
    }

    float skyLightAt(final @NonNull Vec3 position, final @NonNull Collection<? extends Shape> possibleCovers);

}

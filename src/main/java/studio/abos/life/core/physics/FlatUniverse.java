package studio.abos.life.core.physics;

import lombok.NonNull;
import studio.abos.life.core.geometry.Measure3;

public record FlatUniverse(@NonNull Measure3 measure, float gravity, float gravityOrigin) implements Universe {

    public FlatUniverse {
        if (gravity < 0) {
            throw new IllegalArgumentException("Gravity cannot be negative!");
        }
    }

    public FlatUniverse(final @NonNull Measure3 measure, final float gravity) {
        this(measure, gravity, 0f);
    }

    @Override
    public void applyGravityTo(@NonNull MassShape massShape) {
        if (massShape.getCenterOfMass().y() >= gravityOrigin) {
            massShape.setVelocity(massShape.getVelocity().add(0f, -gravity, 0f));
        }
        else {
            massShape.setVelocity(massShape.getVelocity().add(0f, gravity, 0f));
        }
    }

    @Override
    public Measure3 getMeasure() {
        return measure;
    }
}

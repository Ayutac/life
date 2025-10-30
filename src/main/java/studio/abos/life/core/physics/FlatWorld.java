package studio.abos.life.core.physics;

import lombok.NonNull;
import studio.abos.life.core.geometry.Measure3;

public record FlatWorld(@NonNull Measure3 measure, float gravity) implements Reality {

    public FlatWorld {
        if (gravity < 0) {
            throw new IllegalArgumentException("Gravity cannot be negative!");
        }
    }

    @Override
    public void applyGravityTo(@NonNull MassShape massShape) {
        massShape.setVelocity(massShape.getVelocity().add(0f, -gravity, 0f));
    }

    @Override
    public Measure3 getMeasure() {
        return measure;
    }
}

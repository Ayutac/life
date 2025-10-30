package studio.abos.life.core.physics;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import studio.abos.life.core.geometry.GeometryUtils;
import studio.abos.life.core.geometry.Measure3;
import studio.abos.life.core.geometry.Shape;
import studio.abos.life.core.geometry.Vec3;

import java.util.Collection;

public class FlatUniverse implements Universe {

    public static final long DEFAULT_DAY_LENGTH = 3600;

    @Getter
    protected @NonNull Measure3 measure;
    @Getter
    @Setter
    protected float gravity;
    @Getter
    @Setter
    protected float gravityOrigin;
    @Getter
    @Setter
    protected long age; // = 0L;
    @Getter
    @Setter
    protected long dayLength = DEFAULT_DAY_LENGTH;
    @Getter
    @Setter
    protected long nightLength = DEFAULT_DAY_LENGTH;

    public FlatUniverse(final @NonNull Measure3 measure, final float gravity, final float gravityOrigin) {
        if (gravity < 0) {
            throw new IllegalArgumentException("Gravity cannot be negative!");
        }
        this.measure = measure;
        this.gravity = gravity;
        this.gravityOrigin = gravityOrigin;
    }

    public FlatUniverse(final @NonNull Measure3 measure, final float gravity) {
        this(measure, gravity, 0f);
    }

    @Override
    public void applyGravityTo(final @NonNull MassShape massShape) {
        if (massShape.getCenterOfMass().y() >= gravityOrigin) {
            massShape.setVelocity(massShape.getVelocity().add(0f, -gravity, 0f));
        } else {
            massShape.setVelocity(massShape.getVelocity().add(0f, gravity, 0f));
        }
    }

    @Override
    public void ageOneTick() {
        age++;
    }

    public long timeOfDay() {
        return age % (dayLength + nightLength);
    }

    @Override
    public float skyLightAt(final @NonNull Vec3 position, final @NonNull Collection<? extends Shape> possibleCovers) {
        for (final Shape shape : possibleCovers) {
            if (GeometryUtils.posIsBelow(position, shape)) {
                return 0f;
            }
        }
        long timeOfDay = timeOfDay();
        // linear light increase till noon, then linear decrease till dawn, then night
        return timeOfDay <= dayLength ? (timeOfDay <= dayLength / 2 ? 30f * timeOfDay / dayLength : 30f * (dayLength - timeOfDay) / dayLength ) : 0;
    }

}

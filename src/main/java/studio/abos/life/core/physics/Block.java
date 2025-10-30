package studio.abos.life.core.physics;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import studio.abos.life.core.geometry.Cuboid;
import studio.abos.life.core.geometry.Measure3;
import studio.abos.life.core.geometry.Vec3;

public class Block implements MassShape {

    @Getter
    @Setter
    protected @NonNull Universe universe;
    @Getter
    @Setter
    protected @NonNull Vec3 minimalPosition;
    @Getter
    @Setter
    protected @NonNull Measure3 measure;
    @Getter
    @Setter
    protected float mass;
    @Getter
    @Setter
    protected @NonNull Vec3 velocity;

    public Block(final @NonNull Universe universe, final @NonNull Vec3 minimalPosition, final @NonNull Measure3 measure, final float mass, final @NonNull Vec3 velocity) {
        this.universe = universe;
        this.minimalPosition = minimalPosition;
        this.measure = measure;
        this.mass = mass;
        this.velocity = velocity;
    }

    public Block(final @NonNull Universe universe, final @NonNull Vec3 minimalPosition, final @NonNull Measure3 measure, final float mass) {
        this(universe, minimalPosition, measure, mass, Vec3.ZERO);
    }

    @Override
    public Cuboid getBoundingBox() {
        return new Cuboid(minimalPosition, measure);
    }

}

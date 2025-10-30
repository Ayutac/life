package studio.abos.life.core.physics;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import studio.abos.life.core.geometry.Cuboid;
import studio.abos.life.core.geometry.GeometryUtils;
import studio.abos.life.core.geometry.Measure3;
import studio.abos.life.core.geometry.Shape;
import studio.abos.life.core.geometry.Vec3;

import java.util.Collection;

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
    @Getter
    @Setter
    protected boolean falling;
    @Getter
    @Setter
    protected boolean affectedByGravity;

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

    @Override
    public void checkFalling(final @NonNull Collection<? extends Shape> possibleCollisions) {
        boolean checkAbove = universe instanceof FlatUniverse && ((FlatUniverse) universe).gravityOrigin() > getCenterOfMass().y();
        for (final Shape object : possibleCollisions) {
            if (object == this) {
                continue;
            }
            if ((checkAbove && GeometryUtils.directlyAbove(this, object)) ||
                    (!checkAbove && GeometryUtils.directlyBelow(this, object))) {
                falling = false;
                return;
            }
        }
        falling = true;
    }

    /**
     * Move with respect to collisions.
     */
    @Override
    public void move(final @NonNull Collection<? extends Shape> possibleCollisions) {
        // TODO implement
        move();
    }

    public static Block layer(final @NonNull Universe universe, final int y) {
        final float width = universe.getMeasure().width();
        final float depth = universe.getMeasure().depth();
        final Block layer = new Block(universe, new Vec3(-(width / 2), y - 0.5f, -(depth / 2)),
                new Measure3(width, 1f, depth), 0);
        layer.affectedByGravity = false;
        return layer;
    }

}

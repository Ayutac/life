package studio.abos.life.core.geometry;

import lombok.NonNull;

public record Cuboid(@NonNull Vec3 position, @NonNull Measure3 measure) implements Shape {

    public static Cuboid of(final Vec3 position, final Measure3 measure) {
        return new Cuboid(position, measure);
    }

    public static Cuboid of(final float x, final float y, final float z, final Measure3 measure) {
        return new Cuboid(new Vec3(x, y, z), measure);
    }

    public static Cuboid of(final Vec3 position, final float width, final float height, final float depth) {
        return new Cuboid(position, new Measure3(width, height, depth));
    }

    public static Cuboid of(final float x, final float y, final float z, final float width, final float height, final float depth) {
        return new Cuboid(new Vec3(x, y, z), new Measure3(width, height, depth));
    }

    @Override
    public Measure3 getMeasure() {
        return measure;
    }

    @Override
    public Vec3 getMinimalPosition() {
        return position;
    }

    @Override
    public Cuboid getBoundingBox() {
        return this;
    }

}

package studio.abos.life.core;

/**
 * Measurements in 3-space. Zero values are allowed, negative values are not.
 */
public record Measure3(float width, float height, float depth) implements FreeShape {

    public Measure3 {
        if (width < 0f || height < 0f || depth < 0f) {
            throw new IllegalArgumentException("Measurements cannot be negative!");
        }
    }

    @Override
    public Measure3 getMeasure() {
        return this;
    }

    public Measure3 add(final Measure3 other) {
        return new Measure3(width + other.width, height + other.height, depth + other.depth);
    }

}
